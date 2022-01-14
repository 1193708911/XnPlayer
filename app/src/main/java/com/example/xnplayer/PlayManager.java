package com.example.xnplayer;

import android.os.Looper;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlayManager {

    private Player.Listener eventListener = null;

    private PlayManager() {
        initPlayer();
    }

    private void initPlayer() {
        // 创建带宽
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(App.context).build();
        // 创建轨道选择工厂 视频每一这的画面如何渲染,实现默认的实现类
        RenderersFactory videoTrackSelectionFactory = new DefaultRenderersFactory(App.context);
        // 创建轨道选择实例 视频的音视频轨道如何加载,使用默认的轨道选择器
        TrackSelector trackSelector = new DefaultTrackSelector(App.context);
        // 创建播放器实例
        player = new SimpleExoPlayer.Builder(App.context, videoTrackSelectionFactory)
                .setBandwidthMeter(bandwidthMeter)
                .setTrackSelector(trackSelector)
                .build();

        // 添加一个监听器来接收来自播放器的事件.
        if (eventListener != null) {
            player.addListener(eventListener);
        }
    }

    public static PlayManager get() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static PlayManager INSTANCE = new PlayManager();
    }

    // 创建播放器实例
    private static SimpleExoPlayer player;
    private List<MediaItem> mediaItems = new ArrayList<>();
    private int playCurrPos = -1;

    public void play(MediaItem mediaItem) {
        mediaItems = Collections.singletonList(mediaItem);
        play();
    }

    public void play(String uri) {
        if (!player.getPlayWhenReady()) {
            player.play();
        }
        MediaItem mediaItem = new MediaItem.Builder().setUri(uri).build();
        mediaItems = Collections.singletonList(mediaItem);
        play();
    }

    public void play() {
        if (player.isPlaying()) {
            return;
        }

        if (mediaItems.isEmpty()) {
            throw new NullPointerException("mediaItems is empty");
        }
        if (playCurrPos == -1) {
            playCurrPos = 0;
        }

        player.setMediaItems(mediaItems);
        player.prepare();
        player.play();

    }

    public void pause() {
        if (player.isPlaying()) {
            player.pause();
        }
    }

    public void stop() {
        player.stop();
    }


    private void checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Player is accessed on the wrong thread");
        }
    }

    public void setListener(Player.Listener eventListener) {
        this.eventListener = eventListener;
        player.addListener(eventListener);
    }

    public void destory() {
        if (player != null) {
            player.release();
        }
    }
}
