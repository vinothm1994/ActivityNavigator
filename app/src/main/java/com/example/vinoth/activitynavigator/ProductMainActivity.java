package com.example.vinoth.activitynavigator;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.vinoth.activitynavigator.ultipro.ProductDbAdapter;

public class ProductMainActivity extends AppCompatActivity {


    private EditText etProductName;
    private static String productSearch=null;
    private static String sesrchID=null;
    private static String productDetail=null;
    private String s1[];
    ArrayAdapter<String> listAdapter;
    private SimpleCursorAdapter dataAdapter;


    public void doproduct(View view){

        ProductDbAdapter productDbAdapter=new ProductDbAdapter(getBaseContext());


        switch (view.getId()){
            case R.id.btnProductNew:
                Intent intentpronew =new Intent(getBaseContext(),ProductNewActivity.class);
                startActivity(intentpronew);
                break;
            case R.id.btnProductSearch:

                try {
                    productSearch=etProductName.getText().toString();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    productDbAdapter.open();

                    Cursor cursor= productDbAdapter.searchByName(productSearch);
                    //Cursor cursor=productDbAdapter.ProductAllDetail();
                     productDbAdapter.close();
                    String[] columns = new String[] {
                            //ProductDbAdapter.ID,
                            ProductDbAdapter.NAME,
                            ProductDbAdapter.DESC,
                            ProductDbAdapter.PRICE,
                            ProductDbAdapter.QTY

                    };

                    // the XML defined views which the data will be bound to
                    int[] to = new int[] {
                           // R.id.Pid,
                            R.id.PName,
                            R.id.PDESC,
                            R.id.PPRICE,
                            R.id.PQTY
                    };

                    // create the adapter using the cursor pointing to the desired data
                    //as well as the layout information
                    dataAdapter = new SimpleCursorAdapter(
                            this,R.layout.product_listview,
                            cursor,
                            columns,
                            to,
                            0);

                    ListView listView = (ListView) findViewById(R.id.lvproduct);
                    // Assign adapter to ListView
                    listView.setAdapter(dataAdapter);




                }catch (Exception e){
                    e.printStackTrace();
                    productDbAdapter.close();

                }

                break;
            case R.id.btnProductUpdate:
                Intent intentproupdate =new Intent(getBaseContext(),ProductUpdateActivity.class);
                intentproupdate.putExtra("ID",sesrchID);
                startActivity(intentproupdate);
                break;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producy_main);
        etProductName=(EditText)findViewById(R.id.etProductName);

    }
}
