package com.example.vinoth.activitynavigator.ultipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vinoth on 13/7/16.
 */

public class DbAdapter {

    private static final String DB_NAME = "MyDb";
    private static final int DB_VERSION = 1;
    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private static final String TABLE_NAME = "users";
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String TABLE_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS " +TABLE_NAME + " ( "+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT,  " + EMAIL + " TEXT)";



    public DbAdapter(Context context){
        this.context = context;
        dbHelper = new DbHelper();
    }

    public boolean saveContact(String name, String email) {

        ContentValues contentValue = new ContentValues();
        contentValue.put(NAME, name);
        contentValue.put(EMAIL, email);

        return db.insert(TABLE_NAME,null,contentValue) >0 ? true:false;
    }


    public Cursor getAllContacts(){
        return db.query(TABLE_NAME,new String[]{ID,NAME,EMAIL},null,null,null,null,null);
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
/*
//In Greetuser activity :</pre>
<pre>public void doGreetings(View view){

    etUserName.setTextColor(Color.BLUE);
    String name = etUserName.getText().toString();

    //persisting the data
    DbAdapter dbAdapter = new DbAdapter(getBaseContext());

    dbAdapter.open();

    dbAdapter.saveContact(name, "vinay@felight.com");

    dbAdapter.close();
    dbAdapter.open();

    Cursor cursor = dbAdapter.getAllContacts();

    cursor.moveToFirst();
    do{
        String row = cursor.getString(0) + "   " + cursor.getString(1) + "   " + cursor.getString(2);
        Utils.toastIt(getBaseContext(), row);
    }while(cursor.moveToNext());

    dbAdapter.close();

   // Utils.toastIt(getBaseContext(), "Namaste  "+ name);


    TextView tvResult = (TextView) findViewById(R.id.tvResult);
    tvResult.setTextSize(50F);
    tvResult.setText("Namaskara " + name);


    Log.i(TAG,"do greetings called");


    //Shared Preference
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(NAME,name);
    editor.commit();

}
 */