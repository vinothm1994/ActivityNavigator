package com.example.vinoth.activitynavigator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by vinoth on 10/8/16.
 */
public  class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("vinothh","ddddddd on");
        if (intent.getAction().intern() == Intent.ACTION_AIRPLANE_MODE_CHANGED) {

            Log.i("vinothh","ddddddd on");
            Toast.makeText(context,"onnnn",Toast.LENGTH_SHORT).show();

        }

    }
}
