package com.example.vinoth.activitynavigator;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {
    private static ImageView ivcar;

   public void animation(View view){
       ObjectAnimator rotation=ObjectAnimator.ofFloat(ivcar,"rotation",360,0,0,-320,43,12,45,50360,0,0,-320,98,0);
       ObjectAnimator alpha=ObjectAnimator.ofFloat(ivcar,"alpha",360,0,67,-320,43,12,45,50360,0,0,-320,98,320);
       ObjectAnimator tranx=ObjectAnimator.ofFloat(ivcar,"translationX",360,0,0,-320,43,12,45,50360,0,0,-320,98);
       ObjectAnimator trany=ObjectAnimator.ofFloat(ivcar,"translationY",360,0,0,-320,43,12,45,50360,0,0,-320,98,1000);


       switch (view.getId()){

           case R.id.btnRotation:
               rotation.setDuration(3000);
               rotation.start();
               break;
           case R.id.btnAlpha:
               alpha.setDuration(3000);
               alpha.start();
               break;
           case R.id.btnTranslationX:
               tranx.setDuration(3000);
               tranx.start();
               break;
           case R.id.btnTranstionY:
               trany.setDuration(3000);
               trany.start();
               break;
           case R.id.btnAll:
               rotation.setDuration(3000);
               rotation.start();
               alpha.setDuration(3000);
               alpha.start();
               tranx.setDuration(3000);
               tranx.start();
               trany.setDuration(3000);
               trany.start();
               break;


       }

   }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ivcar= (ImageView)findViewById(R.id.imCar);
    }
}

