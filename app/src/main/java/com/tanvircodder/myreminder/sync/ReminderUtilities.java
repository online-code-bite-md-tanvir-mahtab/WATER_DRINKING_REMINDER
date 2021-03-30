package com.tanvircodder.myreminder.sync;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.Driver;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;
import com.tanvircodder.myreminder.MainActivity;

public class ReminderUtilities {

private static final String REMINDER_JOB_TAG = "hydration_reminder_tag";

    private static boolean sInitialized;

    // COMPLETED (16) Create a synchronized, public static method called scheduleChargingReminder that takes
    // in a context. This method will use FirebaseJobDispatcher to schedule a job that repeats roughly
    // every REMINDER_INTERVAL_SECONDS when the phone is charging. It will trigger WaterReminderFirebaseJobService
    // Checkout https://github.com/firebase/firebase-jobdispatcher-android for an example
    public static void scheduleChargingReminder(@NonNull final Context context) {
        Toast.makeText(context,"the scedul is called",Toast.LENGTH_SHORT).show();
        // COMPLETED (17) If the job has already been initialized, return


        // COMPLETED (18) Create a new GooglePlayDriver
        Driver driver = new GooglePlayDriver(context);
        // COMPLETED (19) Create a new FirebaseJobDispatcher with the driver
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(driver);
        Job constraintReminderJob = dispatcher.newJobBuilder()
                .setService(WaterReminderFirebaseJobService.class)
                .setTag(REMINDER_JOB_TAG)
                .setConstraints(Constraint.ON_ANY_NETWORK)
                .setLifetime(Lifetime.FOREVER)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(0,10))
                .setReplaceCurrent(true)
                /* Once the Job is ready, call the builder's build method to return the Job */
                .build();

        // COMPLETED (21) Use dispatcher's schedule method to schedule the job
        /* Schedule the Job with the dispatcher */
        dispatcher.mustSchedule(constraintReminderJob);

    }
}
