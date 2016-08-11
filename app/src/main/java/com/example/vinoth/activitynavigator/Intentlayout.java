package com.example.vinoth.activitynavigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Intentlayout extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentlayout);

        TextView tvresult=(TextView)findViewById(R.id.tvIntentResult);
        Bundle bundle=getIntent().getExtras();
        String op=bundle.getString(Intent2.KEY_News);
       tvresult.setText(op);
        //or use is

       // tvresult.setText(getIntent().getExtras().getString(Intent2.KEY_News));

    }
}
