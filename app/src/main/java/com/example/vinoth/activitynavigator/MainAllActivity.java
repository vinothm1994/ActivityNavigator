package com.example.vinoth.activitynavigator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainAllActivity extends AppCompatActivity {


    private LinearLayout linerlayoutmain;

    public void benchmark(View view){

    Intent intent=new Intent(getBaseContext(),MainActivity.class);
    startActivity(intent);
}
    public void calcula(View view){

        Intent intent=new Intent(getBaseContext(),SimpleCalculator.class);
        startActivity(intent);
    }
    public void GreetUser1(View view){

        Intent intent1=new Intent(getBaseContext(),Greetuser.class);
        startActivity(intent1);
    }
    public void intent(View view){

        Intent intent=new Intent(getBaseContext(),Intent2.class);
        startActivity(intent);
    }

    public void ActivityLifecycle(View view){

        Intent intent=new Intent(getBaseContext(),ActivityLifecycle.class);
        startActivity(intent);
    }
    public void Animation(View view){
        Intent intent=new Intent(getBaseContext(),Animation.class);
        startActivity(intent);
    }
    public void ProductActivity(View view){

        Intent intent=new Intent(getBaseContext(),ProductMainActivity.class);
        startActivity(intent);
    }
    public void InstangramClone (View view){
        Intent intent=new Intent(getBaseContext(),InstantgramActivity.class);
        startActivity(intent);
    }
    public void shakeplay (View view){
        Intent intent=new Intent(getBaseContext(),ShakePlayMusic.class);
        startActivity(intent);
    }

    public void gpsdata (View view){
        Intent intent=new Intent(getBaseContext(),GpsActivity.class);
        startActivity(intent);
    }
    public void sensordetail (View view){
        Intent intent=new Intent(getBaseContext(),SensorListActivity.class);
        startActivity(intent);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuColour:
                Intent intent=new Intent(getBaseContext(),BackColourActivity.class);
                startActivityForResult(intent,0);
                Toast.makeText(this, "menu is selcted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 0:
                linerlayoutmain.setBackgroundColor(Color.rgb(238,17,17));
                break;
            case 1:
                linerlayoutmain.setBackgroundColor(Color.rgb(45,137,239));
                break;
            case 2:
                linerlayoutmain.setBackgroundColor(Color.rgb(255,196,13));
                break;
            case 4:
                linerlayoutmain.setBackgroundColor(Color.WHITE);
                break;
            case 3:
                linerlayoutmain.setBackgroundColor(Color.rgb(0,171,169));
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_all);
        linerlayoutmain=(LinearLayout)findViewById(R.id.llmainlayout);
    }
    public void movielist(View view) {
        Intent intent=new Intent(getBaseContext(),Movielist.class);
        startActivity(intent);
    }
    public void googlemap(View view) {
        Intent intent=new Intent(getBaseContext(),Googlemap.class);
        startActivity(intent);
    }

    public void superhero(View view) {
        Intent intent=new Intent(getBaseContext(),SuperHeroListView.class);
        startActivity(intent);
    }

    public void webbrowser(View view) {
        Intent intent=new Intent(getBaseContext(),WebBrowser.class);
        startActivity(intent);

    }

    public void splash(View view) {
        Intent intent=new Intent(getBaseContext(),SplashActivity.class);
        startActivity(intent);
    }
}
