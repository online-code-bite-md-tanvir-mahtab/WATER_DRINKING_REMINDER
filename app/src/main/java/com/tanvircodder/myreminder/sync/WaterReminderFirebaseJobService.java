package com.tanvircodder.myreminder.sync;

import android.content.Context;
import android.os.AsyncTask;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.tanvircodder.myreminder.MainActivity;

public class WaterReminderFirebaseJobService extends JobService {
    private AsyncTask mBackGroundTask;
    @Override
    public boolean onStartJob(final JobParameters job) {
        mBackGroundTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Context context = WaterReminderFirebaseJobService.this;
                ReminderTask.executeTask(context,ReminderTask.ACTION_CHARGING_REMINDER);
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                jobFinished(job,false);
            }
        };
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        if (mBackGroundTask != null) mBackGroundTask.cancel(true);
        return true;
    }
}
