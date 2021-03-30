package com.tanvircodder.myreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tanvircodder.myreminder.sync.ReminderUtilities;
import com.tanvircodder.myreminder.sync.ReminderTask;
import com.tanvircodder.myreminder.sync.WaterReminderIntentService;
import com.tanvircodder.myreminder.util.WaterUtil;


public class MainActivity extends AppCompatActivity implements
        SharedPreferences.OnSharedPreferenceChangeListener {
//    creating the log tag..///
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
//    nwo ia m going to instansiate the view..//
    private TextView mTextView;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView= (TextView) findViewById(R.id.progress_text);
        mProgressBar = (ProgressBar) findViewById(R.id.increment_progress);
        incrementWaterCount();
        ReminderUtilities.scheduleChargingReminder(this);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }
    public void updateWaterCount(View view){
       Intent intent = new Intent(this, WaterReminderIntentService.class);
       intent.setAction(ReminderTask.REMINDER_WATER_INCREMENT_COUNT);
       startService(intent);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (WaterUtil.INCREMENT_WATER_KEY.equals(key)){
            incrementWaterCount();
        }
    }

    private void incrementWaterCount() {
        int waterCount = WaterUtil.getWaterCount(this);
        Toast.makeText(this,"the count : " + waterCount,Toast.LENGTH_SHORT).show();
        mTextView.setText(waterCount + "%");
        mProgressBar.setProgress(waterCount);
    }
}