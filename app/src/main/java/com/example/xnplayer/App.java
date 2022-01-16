package com.example.xnplayer;

import android.app.Application;

import com.noboauto.library_player.PlayManager;


public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init() {
        PlayManager.initPlayer(this);
    }
}
