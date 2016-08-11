package com.example.vinoth.activitynavigator.ultipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vinoth on 13/7/16.
 */

public class ProductDbAdapter {

    private static final String DB_NAME = "product_database.db";
    private static final int DB_VERSION = 1;
    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private static final String TABLE_NAME = "product";
    public static final String ID = "_id";
    public static final String NAME = "product_name";
    public static final String DESC = "description";
    public static final String QTY = "quantity";
    public static final String PRICE = "price";
    public static final String TABLE_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS " +TABLE_NAME + " ( "+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT UNIQUE ," +
            DESC + " TEXT , " +
            QTY +" TEXT , "+
            PRICE +" TEXT )";

    public ProductDbAdapter(Context context){
        this.context = context;
        dbHelper = new DbHelper();
    }
// to save product in database
    public boolean saveProduct(String name, String desc,double qty,double price ){

        ContentValues contentValue = new ContentValues();
        contentValue.put(NAME, name);
        contentValue.put(DESC, desc);
        contentValue.put(QTY,qty);
        contentValue.put(PRICE,price);
        return db.insert(TABLE_NAME, null, contentValue) > 0;
    }
    public boolean updateProduct(String ID,String name, String desc,double qty,double price ){
        ContentValues contentValue = new ContentValues();
        contentValue.put(NAME, name);
        contentValue.put(DESC, desc);
        contentValue.put(QTY,qty);
        contentValue.put(PRICE,price);



        return  db.update(TABLE_NAME, contentValue, ID, null)>0;
    }
    public Cursor ProductAllDetail(){
        return db.query(TABLE_NAME,new String[]{ID,NAME,DESC,QTY,PRICE},null,null,null,null,null,null);
    }
    public Cursor searchByName(String inputText) throws SQLException {

        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = db.query(TABLE_NAME, new String[] {ID,
                            NAME, DESC, QTY, PRICE},
                    null, null, null, null, null);

        }
        else {
            mCursor = db.query(true, TABLE_NAME, new String[] {ID,
                            NAME, DESC, QTY, PRICE},
                    NAME + " like '%" + inputText + "%'", null,
                    null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public Cursor searchByID(String inputText) throws SQLException {

        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = db.query(TABLE_NAME, new String[] {ID,
                            NAME, DESC, QTY, PRICE},
                    null, null, null, null, null);

        }
        else {
            mCursor = db.query(true, TABLE_NAME, new String[] {ID,
                            NAME, DESC, QTY, PRICE},
                    ID + " like '%" + inputText + "%'", null,
                    null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public boolean deleteRowByID(String Id) {
        return db.delete(TABLE_NAME, ID + "=" + Id, null) > 0;

    }





    private class DbHelper extends SQLiteOpenHelper {


        public DbHelper() {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }


    public void open(){

        db = dbHelper.getWritableDatabase();
    }

    public void close(){

        db.close();
    }
}