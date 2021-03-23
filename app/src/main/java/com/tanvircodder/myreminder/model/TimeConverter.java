package com.tanvircodder.myreminder.model;

import android.content.Context;

import com.tanvircodder.myreminder.MainActivity;
import com.tanvircodder.myreminder.util.NotificationUtil;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimeConverter {
/*//    nwo i  am going to crate the instance of the timer object..//
    Timer timer;
    TimerTask mTimerTask;*/
//    now i am going to create the constant variable that will hold the 5 vlue..//
    private static int timeInMinute = 1;
    public static void startTimer(Timer timer,TimerTask timerTask,Context context){
        timer = new Timer();
//        now i am going to insialize the timerTak..//
        timerTask = new TimerTask() {
            @Override
            public void run() {
                NotificationUtil.remiderTheTask(context);
            }
        };
        timer.schedule(timerTask,100000,timeInMinute * 1000);
    }
    public static void stopTimer(Timer timer){
        timer = new Timer();
        timer.cancel();
        timer = null;
    }
}
