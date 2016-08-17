package com.example.vinoth.activitynavigator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.example.vinoth.activitynavigator.ultipro.ServiceTest;

/**
 * Created by vinoth on 10/8/16.
 */
public  class SmsReceiver extends BroadcastReceiver {
    private String TAG="SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        context.startService(new Intent(context, ServiceTest.class));

        if (intent.getAction().intern() == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            Log.i("vinothh","Air plane mode activated");
            Toast.makeText(context,"Air plane mode activated",Toast.LENGTH_SHORT).show();
        }else
        {

            Log.i(TAG,"OnReceive ++>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            Bundle bndl = intent.getExtras();
            SmsMessage[] msg = null;
            String str = "";
            if (null != bndl)
            {
                //---retrieve the SMS message received---
                Object[] pdus = (Object[]) bndl.get("pdus");
                msg = new SmsMessage[pdus.length];
                for (int i=0; i<msg.length; i++){
                    msg[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                    str += "SMS From " + msg[i].getOriginatingAddress();
                    str += " :\r\n";
                    str += msg[i].getMessageBody().toString();
                    str += "\n";
                }
                //---display incoming SMS as a Android Toast---
                Toast.makeText(context, str, Toast.LENGTH_LONG).show();
                context.startService(new Intent(context, ServiceTest.class));;
            }
        }

    }
}
