package com.example.vinoth.activitynavigator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class BackColourActivity extends AppCompatActivity {
    public void changecolour(View view){
        RadioGroup rbcaseGroup = (RadioGroup) findViewById(R.id.rgcolour);
        Intent intent=new Intent(this,MainAllActivity.class);
        switch (rbcaseGroup.getCheckedRadioButtonId()){
            case R.id.rbred:
                setResult(0,intent);
                break;
            case R.id.rbblue:
                setResult(1,intent);
                break;
            case R.id.rbyellow:
                setResult(2,intent);
                break;
            case R.id.rbteen:
                setResult(3,intent);
                break;
            case R.id.rbwhite:
                setResult(4,intent);
                break;
        }
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_colour);
    }
}
