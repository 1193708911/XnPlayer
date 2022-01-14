package com.example.xnplayer;

import static com.google.android.exoplayer2.Player.STATE_BUFFERING;
import static com.google.android.exoplayer2.Player.STATE_ENDED;
import static com.google.android.exoplayer2.Player.STATE_IDLE;
import static com.google.android.exoplayer2.Player.STATE_READY;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTimer;
    private SeekBar mSeekbar;
    private TextView mEndTime;
    private Button mPlay;
    private Button mPause;
    private Button mStop;
    private Button mNext;
    private Button mPrevious;
    private Button mFastforward;
    private Button mRewind;
    private TextView mStatus;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        PlayManager.get().setListener(new Player.Listener() {
            @Override
            public void onTimelineChanged(Timeline timeline, int reason) {
                Log.d(TAG, "onTimelineChanged: ");
            }

            @Override
            public void onIsLoadingChanged(boolean isLoading) {
                Log.d(TAG, "onIsLoadingChanged: "+isLoading);
            }

            @Override
            public void onPlaybackStateChanged(int state) {
                Log.d(TAG, "onPlaybackStateChanged: ");

                switch (state) {
                    case STATE_IDLE:
                        Log.d(TAG, "STATE_IDLE: ");
                        break;
                    case STATE_BUFFERING:
                        Log.d(TAG, "STATE_BUFFERING: ");
                        break;
                    case STATE_READY:
                        Log.d(TAG, "STATE_READY: ");
                        break;
                    case STATE_ENDED:
                        Log.d(TAG, "STATE_ENDED: ");
                        break;
                }


            }

            @Override
            public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
                Log.d(TAG, "onPlayWhenReadyChanged: " + playWhenReady);
            }

            @Override
            public void onIsPlayingChanged(boolean isPlaying) {

                Log.d(TAG, "onIsPlayingChanged: " + isPlaying);
            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {
                Log.d(TAG, "onPlayerError: ");
            }

            @Override
            public void onEvents(Player player, Player.Events events) {
                Log.d(TAG, "onEvents: ");
            }

            @Override
            public void onAudioSessionIdChanged(int audioSessionId) {
                Log.d(TAG, "onAudioSessionIdChanged: ");
            }

            @Override
            public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                Log.d(TAG, "onAudioAttributesChanged: ");
            }

            @Override
            public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
                Log.d(TAG, "onSkipSilenceEnabledChanged: ");
            }
        });
    }

    private void initView() {
        mTimer = (TextView) findViewById(R.id.timer);
        mSeekbar = (SeekBar) findViewById(R.id.seekbar);
        mEndTime = (TextView) findViewById(R.id.endTime);
        mStatus = (TextView) findViewById(R.id.status);

        mPlay = (Button) findViewById(R.id.play);
        mPause = (Button) findViewById(R.id.pause);
        mStop = (Button) findViewById(R.id.stop);
        mNext = (Button) findViewById(R.id.next);
        mPrevious = (Button) findViewById(R.id.previous);
        mFastforward = (Button) findViewById(R.id.fastforward);
        mRewind = (Button) findViewById(R.id.rewind);

        mPlay.setOnClickListener(this);
        mPause.setOnClickListener(this);
        mStop.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mPrevious.setOnClickListener(this);
        mFastforward.setOnClickListener(this);
        mRewind.setOnClickListener(this);
    }

    //    String mp3Url = "http://webfs.ali.kugou.com/202201141523/6e7a9690422ca22d7f79f82f40fd082e/part/0/960163/KGTX/CLTX001/147269665a824f81cde8d7bb657683ea.mp3";
    private static String mp3Url = "https://api.frdic.com/api/v3/media/mp3/ebc3fc81-fa2f-4aa1" +
            "-b1cd-042f7dde8377?mediatype=audio&agent=%2Feusoft_ting_en_android%2F9.2.1%2F%2Fcar%2F%2F&token=QYN%20mp3_db6aeb75d9e31b9a916b223323a154c0da1c5d144fdc2c42fd810254a256951a";

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                PlayManager.get().play(mp3Url);
                break;
            case R.id.pause:
                PlayManager.get().pause();
                break;
            case R.id.stop:
                PlayManager.get().stop();
                break;
            case R.id.next:
                break;
            case R.id.previous:
                break;
            case R.id.fastforward:
                break;
            case R.id.rewind:
                break;
        }
    }
}