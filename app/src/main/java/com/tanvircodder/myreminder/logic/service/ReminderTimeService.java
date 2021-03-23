package com.tanvircodder.myreminder.logic.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.tanvircodder.myreminder.MainActivity;
import com.tanvircodder.myreminder.model.TimeConverter;

import java.util.Timer;
import java.util.TimerTask;

public class ReminderTimeService extends Service {
    Timer timer;
    TimerTask timerTask;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        TimeConverter.startTimer(timer,timerTask, getBaseContext());
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        TimeConverter.stopTimer(timer);
        super.onDestroy();
    }
}
