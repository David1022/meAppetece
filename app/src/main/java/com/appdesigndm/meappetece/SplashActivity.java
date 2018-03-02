package com.appdesigndm.meappetece;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private Context mContext;
    private ImageView imageSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;

        init();
        animateOnCreateViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void init() {
        imageSplash = (ImageView) findViewById(R.id.imagen_splash);
    }

    private void animateOnCreateViews() {
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.animation_splash_icon);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splashScrennDelay();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageSplash.startAnimation(animation);
    }

    private void splashScrennDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 300);

    }
}
