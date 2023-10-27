package com.example.android.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class HomeApplication extends Application {
    private static Context appContext; // context самого додатку який у нас на даний момент працює

    @Override
    public void onCreate() { // створюємо context
        super.onCreate();
        appContext = getApplicationContext();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static Context getAppContext() { // return context
        return appContext;
    }
}
