package com.example.vinoth.activitynavigator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

public class ListViewResultSuperHero extends AppCompatActivity {

    private ImageView iv;
    private Bitmap bitmapOriginal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_result_super_hero);
        String s=getIntent().getExtras().getString("HeroName");
        Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
        iv=(ImageView)findViewById(R.id.ivSuperHero);
        if(s.equals("batman")){
            //iv.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.batman) );
           iv.setImageResource(R.drawable.batman);
        }
        else if(s.equals("superman")){
            iv.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.superman) );


        }
        else if(s.equals("captainamerica")){
            iv.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.captainamerica) );

        }
        else if(s.equals("ironman")){
            iv.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.ironman) );

        } else if(s.equals("hulk")){
            iv.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.hulk) );

        }



    }
}
