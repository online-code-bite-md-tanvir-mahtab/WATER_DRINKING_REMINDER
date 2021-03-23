package com.tanvircodder.myreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tanvircodder.myreminder.logic.service.ReminderTimeService;
import com.tanvircodder.myreminder.util.NotificationUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, ReminderTimeService.class);
        // TODO: 3/22/2021 now i am going to crate the basic notification..  with button click...//
        startService(intent);

    }
/*
    public void onNotificationClick(View view){
        NotificationUtil.remiderTheTask(this);
    }
*/
}