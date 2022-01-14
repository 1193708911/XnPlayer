package com.example.xnplayer;

public class PlayManager {

    private PlayManager(){}

    /**
     * 返回单例对象
     *
     * @return
     */
    public static PlayManager get() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static PlayManager INSTANCE = new PlayManager();
    }
    public void play(){
//        ExoPlayer player = new ExoPlayer.Builder(context).build();
    }
}
