package com.example.ball_animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ball = findViewById(R.id.ball);
        ObjectAnimator animation = ObjectAnimator.ofFloat(ball, "translationY",0,1000);
        animation.setDuration(1000);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setRepeatMode(ObjectAnimator.REVERSE);
        animation.setInterpolator(new LinearInterpolator());
        animation.start();
    }
}
