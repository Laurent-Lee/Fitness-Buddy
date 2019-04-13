package com.example.android.workout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Laurent Lee on 8/9/2017.
 */

public class WeekFiveActivity extends AppCompatActivity {
    private ArrayList<Integer> sessionOneList, sessionTwoList, sessionThreeList, sessionFourList, sessionFiveList;
    private Button btn30, btn60, btnReset;
    private TextView timer;
    private CountDownTimer countDownTimer;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_holder);

        mCompletionListener = new MediaPlayer.OnCompletionListener(){

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                releaseMediaPlayer();
            }
        };

        sessionOneList = new ArrayList<Integer>();
        sessionOneList.add(R.string.warm_up_a);
        sessionOneList.add(R.string.w5_s1_0);
        sessionOneList.add(R.string.w5_s1_1);
        sessionOneList.add(R.string.w5_s1_2);
        sessionOneList.add(R.string.w5_s1_3);
        sessionOneList.add(R.string.w5_s1_4);
        sessionOneList.add(R.string.w5_s1_5);
        sessionOneList.add(R.string.w5_s1_6);
        sessionOneList.add(R.string.empty);
        sessionOneList.add(R.string.empty);
        sessionOneList.add(R.string.empty);
        sessionOneList.add(R.string.w5_s1_first_darkinfo);
        sessionOneList.add(R.string.empty);
        sessionOneList.add(R.string.empty);
        sessionOneList.add(R.string.w5_s1_second_darkinfo);
        sessionOneList.add(R.string.w5_s1_third_darkinfo);


        sessionTwoList = new ArrayList<Integer>();
        sessionTwoList.add(R.string.warm_up_b);
        sessionTwoList.add(R.string.w5_s2_0);
        sessionTwoList.add(R.string.w5_s2_1);
        sessionTwoList.add(R.string.w5_s2_2);
        sessionTwoList.add(R.string.w5_s2_3);
        sessionTwoList.add(R.string.w5_s2_4);
        sessionTwoList.add(R.string.w5_s2_5);
        sessionTwoList.add(R.string.w5_s2_6);

        sessionThreeList = new ArrayList<Integer>();
        sessionThreeList.add(R.string.warm_up_b);
        sessionThreeList.add(R.string.w5_s3_0);
        sessionThreeList.add(R.string.w5_s3_1);
        sessionThreeList.add(R.string.w5_s3_2);
        sessionThreeList.add(R.string.w5_s3_3);
        sessionThreeList.add(R.string.w5_s3_4);

        sessionFourList = new ArrayList<Integer>();
        sessionFourList.add(R.string.warm_up_a);
        sessionFourList.add(R.string.w5_s4_0);
        sessionFourList.add(R.string.w5_s4_1);
        sessionFourList.add(R.string.w5_s4_2);
        sessionFourList.add(R.string.w5_s4_3);
        sessionFourList.add(R.string.w5_s4_4);

        sessionFiveList = new ArrayList<Integer>();
        sessionFiveList.add(R.string.warm_up_c);
        sessionFiveList.add(R.string.w5_s5_0);

        btn30 = (Button) findViewById(R.id.timer_30);
        btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start30Timer();
            }
        });
        btn60 = (Button) findViewById(R.id.timer_60);
        btn60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start60Timer();
            }
        });
        btnReset = (Button) findViewById(R.id.timer_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
        timer = (TextView) findViewById(R.id.timer_value);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        SwipeExtraSessionAdapter adapter = new SwipeExtraSessionAdapter(getSupportFragmentManager(), sessionOneList, sessionTwoList, sessionThreeList, sessionFourList,sessionFiveList);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void start60Timer() {
        reset();
        timer.setText("60");
        countDownTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                timer.setText("00");
                Toast.makeText(WeekFiveActivity.this, "Timer has finished", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(WeekFiveActivity.this,R.raw.timer_alarm);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        };
        countDownTimer.start();
    }

    private void start30Timer() {
        reset();
        timer.setText("30");
        countDownTimer = new CountDownTimer(30 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                timer.setText("00");
                Toast.makeText(WeekFiveActivity.this, "Timer has finished", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(WeekFiveActivity.this,R.raw.timer_alarm);
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        };
        countDownTimer.start();
    }

    private void reset() {
        releaseMediaPlayer();
        if (countDownTimer != null) {
            timer.setText("00");
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

    private void releaseMediaPlayer(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        reset();
    }
}
