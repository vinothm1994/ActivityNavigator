package com.example.vinoth.activitynavigator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinoth.activitynavigator.ultipro.ProductDbAdapter;

public class ProductNewActivity extends AppCompatActivity {

    private EditText etProducName;
    private EditText etProductDesc;
    private EditText etProductPrice;
    private EditText etProducrStockQty;

    public static String proName=null;
    public static String proDesc=null;
    public static double proPrice=0;
    public static double proStock=0;


    public void addnewproduct(View view) {

        try {
            proName = etProducName.getText().toString();
            proDesc = etProductDesc.getText().toString();
            proPrice = Double.parseDouble(etProductPrice.getText().toString());
            proStock = Double.parseDouble(etProducrStockQty.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ((!proName.isEmpty())&&(!proDesc.isEmpty())&&(proPrice!=0)&&(proStock!=0)) {
            ProductDbAdapter productDbAdapter = new ProductDbAdapter(getBaseContext());
            productDbAdapter.open();
            productDbAdapter.saveProduct(proName, proDesc, proStock, proPrice);
            productDbAdapter.close();
            Toast.makeText(getBaseContext()," product added " , Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(this,"Enter detail",Toast.LENGTH_LONG).show();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_new);
        etProducName=(EditText)findViewById(R.id.etProducName);
        etProductDesc=(EditText)findViewById(R.id.etProductDesc);
        etProductPrice=(EditText)findViewById(R.id.etProductPrice);
        etProducrStockQty=(EditText)findViewById(R.id.etProducrStockQty);


    }
}
