package com.example.animation_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private ImageView icon;
    private Animation iconAnim;
    private TextView textView;
    ObjectAnimator objectAnimator;
    ConstraintLayout constraintLayout;
    TransitionDrawable transitionDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        icon = findViewById(R.id.wow);
        constraintLayout = findViewById(R.id.layout_main);

        iconAnim = AnimationUtils.loadAnimation(this, R.anim.hardanim);
        iconAnim.setAnimationListener(this);

        objectAnimator = ObjectAnimator.ofArgb(textView, "TextColor", Color.BLACK, Color.RED);
        objectAnimator.setDuration(500);

        ColorDrawable[] colorDrawables = {new ColorDrawable(Color.WHITE), new ColorDrawable(Color.BLUE)};
        transitionDrawable = new TransitionDrawable(colorDrawables);
        constraintLayout.setBackground(transitionDrawable);
    }

    public void btnClick(View view) {
        icon.startAnimation(iconAnim);
        transitionDrawable.startTransition(2000);
        objectAnimator.start();
    }


    @Override
    public void onAnimationStart(Animation animation) {
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}