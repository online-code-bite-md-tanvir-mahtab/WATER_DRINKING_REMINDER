package com.tanvircodder.myreminder.sync;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.tanvircodder.myreminder.util.NotificationUtil;
import com.tanvircodder.myreminder.util.WaterUtil;

public class ReminderTask {
//    nwo i am going to create some constant string variable as a key..//
    public static final String REMINDER_WATER_INCREMENT_COUNT = "increment-water-reminder";
    public static final String REMINDER_NOTIFICATION_CANCLE_OUT = "cancle-notification";
    public static final String ACTION_CHARGING_REMINDER = "charging-reminder";
    public static void executeTask(Context context, String action){
        // TODO: 3/28/2021 next I will do something heir
//        nwo i am going to create the condition statement..//
        if (REMINDER_WATER_INCREMENT_COUNT.equals(action)){
            incrementWaterCount(context);
        }else if (REMINDER_NOTIFICATION_CANCLE_OUT.equals(action)){
            NotificationUtil.clearAllNotification(context);
        }else if (ACTION_CHARGING_REMINDER.equals(action)){
            NotificationUtil.reminderWater(context);
        }
    }
    public static void incrementWaterCount(Context context){
        WaterUtil.incrementWater(context);
        NotificationUtil.clearAllNotification(context);
    }

}
