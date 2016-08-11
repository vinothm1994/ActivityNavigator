package com.example.vinoth.activitynavigator;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinoth.activitynavigator.ultipro.ProductDbAdapter;

public class ProductUpdateActivity extends AppCompatActivity {

    private static  String searchID;
    private static  String ID =null;
    private static  String NAME=null;
    private static  String DESC=null;
    private static  String QTY =null;
    private static  String PRICE=null;
    private EditText etUpProductName;
    private EditText etUProductDesc;
    private EditText etUProdutPrice;
    private EditText etUProductStock;
    private ProductDbAdapter productDbAdapter;
    private double doupleConvPRICE;
    private double doubleConvQTY;

    public void deleteproduct(View view){
        productDbAdapter.open();
        Toast.makeText(this,"delete sucess",Toast.LENGTH_LONG).show();
        if(productDbAdapter.deleteRowByID(ID)){

            Toast.makeText(this,"delete sucess",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"delete not sucess",Toast.LENGTH_LONG).show();

        }
       productDbAdapter.close();
    }
    public void updateProduct(View view){
        try {
            NAME=etUpProductName.getText().toString();
            DESC=etUProductDesc.getText().toString();
            PRICE=etUProdutPrice.getText().toString();
            QTY=etUProductStock.getText().toString();
            doupleConvPRICE=Double.parseDouble(PRICE);
            doubleConvQTY=Double.parseDouble(QTY);

        }
        catch (Exception e){
            e.printStackTrace();

        }
        try {
            if ( (!NAME.isEmpty())&&(!DESC.isEmpty())&&(!PRICE.isEmpty())&&(!QTY.isEmpty()) )
            {
                productDbAdapter.open();
                if (productDbAdapter.updateProduct(ID,NAME,DESC,doubleConvQTY,doupleConvPRICE)){
                    Toast.makeText(this," updates  sucess",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(this," updates  fetailed ",Toast.LENGTH_LONG).show();
                }
                productDbAdapter.close();
            }
            else {
                Toast.makeText(this,"Enter the Detail",Toast.LENGTH_LONG).show();
            }


        }
        catch (Exception e){
            e.printStackTrace();
            productDbAdapter.close();
        }




    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_update);
        searchID= getIntent().getExtras().getString("ID");

        etUpProductName=(EditText)findViewById(R.id.etUpProductName);
        etUProductDesc=(EditText)findViewById(R.id.etUProductDesc);
        etUProdutPrice=(EditText)findViewById(R.id.etUProdutPrice);
        etUProductStock=(EditText)findViewById(R.id.etUProductStock);

         productDbAdapter=new ProductDbAdapter(getBaseContext());
        try{
            productDbAdapter.open();
            Cursor cursor= productDbAdapter.searchByID(searchID);
            ID=cursor.getString(0);
            NAME=cursor.getString(1);
            DESC=cursor.getString(2) ;
            QTY=cursor.getString(3);
            PRICE=cursor.getString(4);
            productDbAdapter.close();
            etUpProductName.setText(NAME);
            etUProductDesc.setText(DESC);
            etUProdutPrice.setText(PRICE);
            etUProductStock.setText(QTY);
        }
        catch (Exception e){
            e.printStackTrace();

        }












    }
}
