package com.tanvircodder.myreminder.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;

import com.tanvircodder.myreminder.R;

public class WaterUtil {
    private static int DEFAULT_WATER_COUNT = 0;
    public static final String INCREMENT_WATER_KEY = "water-count";
    synchronized public static void setWaterCount(Context context,int glassOfWater){
        SharedPreferences  preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(INCREMENT_WATER_KEY,glassOfWater);
        editor.apply();
    }
    public static int getWaterCount(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int waterCount = preferences.getInt(INCREMENT_WATER_KEY,DEFAULT_WATER_COUNT);
        return waterCount;
    }
    synchronized public static void incrementWater(Context context){
        int watercount = WaterUtil.getWaterCount(context);
        WaterUtil.setWaterCount(context,++watercount);
    }
    public static Bitmap largeIcon(Context context) {
        Resources resources = context.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, R.drawable.messauring_cup);
        return bitmap;
    }
}
