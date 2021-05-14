package com.example.closeactivitieswithbroadcast.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.example.closeactivitieswithbroadcast.activities.AuthorizationActivity;
import java.util.TimerTask;

public class BroadcastReceiverWorker extends BroadcastReceiver {

    public static final long USER_INACTIVE_INTERVAL = 15000; //15 c

    private IntentFilter intentFilter;

    /**Регистрация ресивера и установка отслеживаемых системных событий*/
    public BroadcastReceiverWorker(Context context) {
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        context.registerReceiver(this, intentFilter);
    }

    /**Оброаботка действий для системных событий*/
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            new java.util.Timer().schedule(new TimerTask() {
                public void run() {
                if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(new Intent(context, AuthorizationActivity.class));
                }
            }
                }, USER_INACTIVE_INTERVAL);
        }
    }
}