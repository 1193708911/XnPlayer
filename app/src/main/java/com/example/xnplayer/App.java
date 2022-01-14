package com.example.xnplayer;

import android.app.Application;
import android.content.Context;

import com.google.android.exoplayer2.SimpleExoPlayer;

public class App extends Application {

    static Context context;
    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        init();
    }

    private void init() {

    }
}
