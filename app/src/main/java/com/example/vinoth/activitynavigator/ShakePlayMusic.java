package com.example.vinoth.activitynavigator;

import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


    public class  ShakePlayMusic extends AppCompatActivity implements SensorListener {
        // For shake motion detection.
        private SensorManager sensorMgr;
        private long lastUpdate = -1;
        private float x, y, z;
        private float last_x, last_y, last_z;
        private static final int SHAKE_THRESHOLD = 800;
        private MediaPlayer player1;
        private MediaPlayer player2;
        private MediaPlayer player3;
        private MediaPlayer player4;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_shake_play_music);
            // start motion detection
            sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
            player4 = MediaPlayer.create(this, R.raw.thali);
            player1 = MediaPlayer.create(this, R.raw.anal);
            player2 = MediaPlayer.create(this, R.raw.kabali);
            player3 = MediaPlayer.create(this, R.raw.remo);



            boolean accelSupported = sensorMgr.registerListener(this,
                    SensorManager.SENSOR_ACCELEROMETER,
                    SensorManager.SENSOR_DELAY_GAME);

            if (!accelSupported) {
                // on accelerometer on this device
                sensorMgr.unregisterListener(this,
                        SensorManager.SENSOR_ACCELEROMETER);
            }
        }
        private void anal() {

                player1.start();



        }
        private void kabali() {


                player2.start();

        }
        private void remo() {


                player3.start();

            }


        private void thali() {

                player4.start();

            }



        protected void onPause() {
                sensorMgr.unregisterListener(this,SensorManager.SENSOR_ACCELEROMETER);

            super.onPause();
        }

        @Override
        protected void onStart() {
            sensorMgr.registerListener(this,SensorManager.SENSOR_ACCELEROMETER);
            super.onStart();
        }

        @Override
        protected void onResume() {
            sensorMgr.registerListener(this,SensorManager.SENSOR_ACCELEROMETER);
            super.onResume();
        }

        @Override
        protected void onStop() {

                sensorMgr.unregisterListener(this,SensorManager.SENSOR_ACCELEROMETER);
            super.onStop();
        }

        public void onAccuracyChanged(int arg0, int arg1) {
            // TODO Auto-generated method stub
        }

        public void onSensorChanged(int sensor, float[] values) {
            if (sensor == SensorManager.SENSOR_ACCELEROMETER) {
                long curTime = System.currentTimeMillis();
                // only allow one update every 100ms.
                if ((curTime - lastUpdate) > 500) {
                    long diffTime = (curTime - lastUpdate);
                    lastUpdate = curTime;

                    x = values[SensorManager.DATA_X];
                    y = values[SensorManager.DATA_Y];
                    z = values[SensorManager.DATA_Z];


                    Log.d("sensor", "X Right axis:" +Round(x,4));
                    Log.d("sensor", "y Right axis:" +Round(y,4));
                    Log.d("sensor", "z Right axis:" +Round(z,4));




                    if(Round(x,4)>10.00){
                        //Log.d("sensor", "X Right axis: " + x);
                        anal();
                        //Toast.makeText(this, "Right shake detected", Toast.LENGTH_SHORT).show();

                    }
                    else if(Round(x,4)<-10.00){
                        //Log.d("sensor", "X Left axis: " + x);
                        thali();

                        //Toast.makeText(this, "Left shake detected", Toast.LENGTH_SHORT).show();
                    }else if(Round(z,4)>10.00){
                        //Log.d("sensor", "y Right axis: " + y);
                        remo();
                        //Toast.makeText(this, " top shake detected", Toast.LENGTH_SHORT).show();
                    }
                    else if(Round(z,4)<-10.00){
                       // Log.d("sensor", "Y Left axis: " + y);
                        kabali();
                        //Toast.makeText(this, "boottom shake detected", Toast.LENGTH_SHORT).show();
                    }

                    float speed = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;

                    // Log.d("sensor", "diff: " + diffTime + " - speed: " + speed);
                    if (speed > SHAKE_THRESHOLD) {
                        Log.d("sensor", "shake detected w/ speed: " + speed);
                        Toast.makeText(this, "shake detected w/ speed: " + speed, Toast.LENGTH_SHORT).show();
                    }
                    last_x = x;
                    last_y = y;
                    last_z = z;
                }
            }
        }

        public static float Round(float Rval, int Rpl) {
            float p = (float)Math.pow(10,Rpl);
            Rval = Rval * p;
            float tmp = Math.round(Rval);
            return (float)tmp/p;
        }
    }

