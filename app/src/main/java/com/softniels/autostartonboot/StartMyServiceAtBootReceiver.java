package com.softniels.autostartonboot;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {
    private String TAG = "StartServiceAtBootReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "call onReceive ACTION_BOOT_COMPLETED");
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Log.d(TAG, "call onReceive ACTION_BOOT_COMPLETED");
            //****************************************************
            Intent serviceIntent = new Intent(context, ForegroundService.class);
            serviceIntent.putExtra("inputExtra", "Serviço executando");
            ContextCompat.startForegroundService(context, serviceIntent);
            //****************************************************
            Log.d(TAG, "PASSOU");
        }
    }
}
