package com.apkglobal.handycraft;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    int time=7000;
    ImageView iv_icon;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iv_icon=(ImageView)findViewById(R.id.iv_icon);

        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

        iv_icon.startAnimation(animation);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                //to start next activity
                Intent next =new Intent(SplashActivity.this,MainActivity.class);
                startActivity(next);
                finish();
            }
        },time);
    }
    }

