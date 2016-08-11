package com.example.vinoth.activitynavigator;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebBrowser extends AppCompatActivity {

    private WebView webView;
    private ProgressBar pbWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);
         webView=(WebView)findViewById(R.id.webView);
        pbWeb=(ProgressBar)findViewById(R.id.pbWeb);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pbWeb.setVisibility(View.INVISIBLE);

            }
        });
        webView.loadUrl("http://www.google.com");
        Intent intent = new Intent(this, WebBrowser.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        // Build notification
        // Actions are just fake
        Notification noti = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            noti = new Notification.Builder(this)
                    .setContentTitle("WebBrowser Started")
                    .setContentText("Subject").setSmallIcon(R.drawable.car)
                    .setContentIntent(pIntent)
                    .addAction(R.drawable.superman, "Call", pIntent)
                    .addAction(R.drawable.batman, "More", pIntent)
                    .addAction(R.drawable.captainamerica, "And more", pIntent).build();
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);




    }
}
