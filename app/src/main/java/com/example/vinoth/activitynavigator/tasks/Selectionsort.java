package com.example.vinoth.activitynavigator.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.vinoth.activitynavigator.R;

/**
 * Created by vinoth on 7/8/16.
 */
public class Selectionsort extends AsyncTask<Integer[],Integer,int[]> {

    private Activity activity;
    private long start;
    private long stop;
    private TextView tvSelectionsort;

    public Selectionsort(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected int[] doInBackground(Integer[]... params) {
        Log.i("vinoth","Selectionsort");
        Integer[] arr = params[0];
        Log.i("size", String.valueOf(arr.length));
        start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvSelectionsort=(TextView)activity.findViewById(R.id.tvSelectionsort);

    }

    @Override
    protected void onPostExecute(int[] ints) {
        super.onPostExecute(ints);
        stop = System.currentTimeMillis();
        tvSelectionsort.setText(stop - start + "ms");
    }


}
