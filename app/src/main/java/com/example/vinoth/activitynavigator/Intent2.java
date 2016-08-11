package com.example.vinoth.activitynavigator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Intent2 extends AppCompatActivity {

    public  static String KEY_News="News";
public void news(View view){

    switch(view.getId()){

        case R.id.btnGoogle:
            Intent intent=new Intent(getBaseContext(),Intentlayout.class);
            intent.putExtra(KEY_News,"google new");
            startActivity(intent);

            break;
        case R.id.btnYahoo:
            Intent intent1=new Intent(getBaseContext(),Intentlayout.class);
            //sent data
            intent1.putExtra(KEY_News,"yahoo new");
            startActivity(intent1);

            break;

    }

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);
    }
}
