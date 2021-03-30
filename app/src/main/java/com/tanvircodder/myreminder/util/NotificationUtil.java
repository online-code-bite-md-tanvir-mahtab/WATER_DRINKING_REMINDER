package com.tanvircodder.myreminder.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.ActionMenuView;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.tanvircodder.myreminder.MainActivity;
import com.tanvircodder.myreminder.R;
import com.tanvircodder.myreminder.sync.ReminderTask;
import com.tanvircodder.myreminder.sync.WaterReminderIntentService;

public class NotificationUtil {
    private static final int WATER_REMINDER_NOTIFICATION_ID = 1138;
    private static final int WATER_REMINDER_PENDING_INTENT_ID = 3417;
    private static final int ACTION_WATER_PENDING_INTENT_ID = 1;
    private static final String WATER_REMINDER_CHANNEL_ID = "reminder_notification_channel";
    public static void clearAllNotification(Context context){
        NotificationManager notificationManager =(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }
    public static void reminderWater(Context context){
        NotificationManager notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(WATER_REMINDER_CHANNEL_ID,
                    "Primary",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder notificatioBuilder = new NotificationCompat.Builder(context,WATER_REMINDER_CHANNEL_ID)
                .setColor(ContextCompat.getColor(context, R.color.design_default_color_primary))
                .setSmallIcon(R.drawable.glass_of_water)
                .setLargeIcon(WaterUtil.largeIcon(context))
                .setContentText(context.getString(R.string.message_title))
                .setContentText(context.getString(R.string.my_massage_content))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(cntentIntent(context))
                .addAction(drinkWaterAction(context))
                .addAction(ingnoreWaterACtion(context))
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            //        now i am going to set the pririty base on the version..//
            notificatioBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }
        notificationManager.notify(WATER_REMINDER_NOTIFICATION_ID,notificatioBuilder.build());
    }
    private static NotificationCompat.Action  drinkWaterAction(Context context){
        Intent intent = new Intent(context, WaterReminderIntentService.class);
        intent.setAction(ReminderTask.REMINDER_WATER_INCREMENT_COUNT);
        PendingIntent pendingIntent = PendingIntent.getService(
                context,
                ACTION_WATER_PENDING_INTENT_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        NotificationCompat.Action action = new NotificationCompat.Action(R.drawable.right,
                "Yes, I did it.",
                pendingIntent);
        return action;
    }
    private static NotificationCompat.Action ingnoreWaterACtion(Context context){
        Intent intent = new Intent(context,WaterReminderIntentService.class);
        intent.setAction(ReminderTask.REMINDER_NOTIFICATION_CANCLE_OUT);
        PendingIntent pendingIntent= PendingIntent.getService(
                context,
                14,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Action action = new NotificationCompat.Action(R.drawable.cross,
                "No , Thanks.",
                pendingIntent);
        return action;
    }
    private static PendingIntent cntentIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                WATER_REMINDER_PENDING_INTENT_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }
}
