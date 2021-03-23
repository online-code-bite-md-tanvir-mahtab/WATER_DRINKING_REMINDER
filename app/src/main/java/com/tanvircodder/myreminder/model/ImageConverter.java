package com.tanvircodder.myreminder.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tanvircodder.myreminder.R;

public class ImageConverter {
//    now i am going to crate an static mathod that will conver the large icon into
    /*the sizable resources*/
    public static Bitmap largerIconConvert(Context context){
//        nwo i am going to get the resource from the activity..//
        Resources resources = context.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, R.drawable.messauring_cup);
        return bitmap;
    }
}
