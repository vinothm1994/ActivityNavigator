package com.example.vinoth.activitynavigator.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.vinoth.activitynavigator.R;
import com.example.vinoth.activitynavigator.ultipro.QuickSort;

/**
 * Created by vinoth on 7/8/16.
 */
public class Quicksort extends AsyncTask<Integer[],Integer,int[]> {

    private Activity activity;
    private long start;
    private long stop;
    private TextView tvQuickssort;

    public Quicksort(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected int[] doInBackground(Integer[]... inputArr) {

        Log.i("vinoth","quick");

        Integer[]array = inputArr[0];
        Log.i("size", String.valueOf(array.length));
        start = System.currentTimeMillis();

        QuickSort.sorting(array);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvQuickssort=(TextView)activity.findViewById(R.id.tvQuickssort);

    }

    @Override
    protected void onPostExecute(int[] ints) {
        super.onPostExecute(ints);
        stop = System.currentTimeMillis();
        tvQuickssort.setText(stop - start + "ms");
    }


}
