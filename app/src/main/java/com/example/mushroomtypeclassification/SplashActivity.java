package com.example.mushroomtypeclassification;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    Runnable run;
    long delay;
    long time = 2500L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainPageActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }

    public void onResume() {
        super.onResume();
        delay = time;
        handler.postDelayed(run, delay);
        time = System.currentTimeMillis();
    }

    public void onPause() {
        super.onPause();
        handler.removeCallbacks(run);
        time = delay- (System.currentTimeMillis() - time);
    }
}