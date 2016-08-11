package com.example.vinoth.activitynavigator;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class SensorListActivity extends AppCompatActivity {

    private TextView tvSensorList;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        tvSensorList = (TextView) findViewById(R.id.tvSensorList);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        }
    protected void onStart() {
        super.onStart();
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

       StringBuffer data = new StringBuffer();
        for(Sensor sensor: sensorList){
            data.append("Name : " + sensor.getName() + "\n"
                    + "Vendor :  " + sensor.getVendor() +"\n"
                    + "Power :  " + sensor.getPower() + "\n\n");
        }
        tvSensorList.setText(tvSensorList.getText() + " \n\n" + data.toString());

    }
}
