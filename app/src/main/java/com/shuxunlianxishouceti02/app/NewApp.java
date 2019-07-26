package com.shuxunlianxishouceti02.app;

import android.app.Application;

public class NewApp extends Application {
    private static NewApp newApp;
    @Override
    public void onCreate() {
        super.onCreate();
        newApp=this;
    }

    public static NewApp getNewApp() {
        return newApp;
    }
}
