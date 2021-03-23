package com.tanvircodder.myreminder.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.inspector.StaticInspectionCompanionProvider;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.tanvircodder.myreminder.R;
import com.tanvircodder.myreminder.model.ImageConverter;
import com.tanvircodder.myreminder.model.TimeConverter;

public class NotificationUtil {
    /*
    *now i am going to ocreate a mathod
    * that will hold the cratiiong of the
    * inotification
    */
    public static void remiderTheTask(Context context){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel mChannel = new NotificationChannel("reminder_water","Primary",NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(mChannel);
        }
//        now i am going to build the notiifcation...//
//        nwo  I have created the instance of the notification builder and
//        store it inside the Builder object..///
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.glass_of_water) ///this is for the icon of the notification...
                .setLargeIcon(ImageConverter.largerIconConvert(context))
                .setContentTitle(context.getString(R.string.message_title))
                .setContentText(context.getString(R.string.my_massage_content))
                .setColor(ContextCompat.getColor(context,R.color.design_default_color_error))
                .setAutoCancel(true);
        /*nwo i am going to check if the android app is grater then gelly been
        * then it will send the */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            builder.setPriority(Notification.PRIORITY_HIGH);
        }
        notificationManager.notify(1,builder.build());
    }
}
