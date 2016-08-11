package com.example.vinoth.activitynavigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityLifecycle extends AppCompatActivity {


   public static final String Tag=ActivityLifecycle.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

    }
    protected void onStart(){
        super.onStart();

        Log.i(Tag,"onStart");
    }
    protected void onPause(){
        super.onPause();

        Log.i(Tag,"onPause");
    }
    protected void onStop(){
        super.onStop();

        Log.i(Tag,"onStop");
    }protected void onRestart(){
        super.onRestart();

        Log.i(Tag,"onRestart");
    }
    protected void onResume(){
        super.onResume();

        Log.i(Tag,"onResume");
    }protected void onDestroy(){
        super.onDestroy();

        Log.i(Tag,"onDestroy");
    }


}
