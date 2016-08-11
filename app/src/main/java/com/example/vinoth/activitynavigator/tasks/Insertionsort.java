package com.example.vinoth.activitynavigator.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.vinoth.activitynavigator.R;

/**
 * Created by vinoth on 7/8/16.
 */
public class Insertionsort extends AsyncTask<Integer[],Integer,int[]> {

    private Activity activity;
    private long start;
    private long stop;
    private TextView tvinsertion;

    public Insertionsort(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected int[] doInBackground(Integer[]... arrays1) {

        Integer[]arr = arrays1[0];
        Log.i("size", String.valueOf(arr.length));
        start = System.currentTimeMillis();
        int temp;


        for (int i = 0; i < arr.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                }
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvinsertion=(TextView)activity.findViewById(R.id.tvinsertion);


    }

    @Override
    protected void onPostExecute(int[] ints) {
        super.onPostExecute(ints);
        stop = System.currentTimeMillis();
        tvinsertion.setText(stop - start + "ms");
    }


}
