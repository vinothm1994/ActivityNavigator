package com.example.vinoth.activitynavigator.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.vinoth.activitynavigator.R;
import com.example.vinoth.activitynavigator.ultipro.MergeSort;

/**
 * Created by vinoth on 7/8/16.
 */
public class Mergesort extends AsyncTask<Integer[],Integer,int[]> {

    private Activity activity;
    private long start;
    private long stop;
    private TextView tvMergesort;

    public Mergesort(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected int[] doInBackground(Integer[]... inputArr) {

        Integer[]array = inputArr[0];

        Log.i("size", String.valueOf(inputArr.length));

        Log.i("vinoth","merrr");

        start = System.currentTimeMillis();


        MergeSort.MSort(array);

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvMergesort=(TextView)activity.findViewById(R.id.tvMergesort);

    }

    @Override
    protected void onPostExecute(int[] ints) {
        super.onPostExecute(ints);
        stop = System.currentTimeMillis();
        tvMergesort.setText(stop - start + "ms");
    }


}
