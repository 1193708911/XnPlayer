package com.example.xnplayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                break;
            case R.id.pause:
                break;
            case R.id.stop:
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