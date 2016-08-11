package com.example.vinoth.activitynavigator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler=new Handler();

        handler.postDelayed(new Runnable(){
            public void run(){

                finish();
                Intent intent=new Intent(getBaseContext(), Googlemap.class);
                startActivity(intent);
            }

        },3000);
    }
}
