package com.example.xnplayer;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init() {
        ExoPlayer player = new ExoPlayer.Builder(context).build();
    }
}
