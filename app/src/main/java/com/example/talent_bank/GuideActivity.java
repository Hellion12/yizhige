package com.example.talent_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class GuideActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private ViewFlipper mVFActivity;
    private GestureDetector mGestureDetector;
    private TextView tvInNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mVFActivity=findViewById(R.id.vf_activity);
        tvInNew=findViewById(R.id.tvInNew);
        initView();
    }

    @SuppressWarnings("deprecation")
    private void initView() {
        mGestureDetector = new GestureDetector(this);
        //界面跳转
        tvInNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,LoginActivity.class), ActivityOptions.makeSceneTransitionAnimation(GuideActivity.this).toBundle());
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX()-e2.getX()>120) {
            mVFActivity.setInAnimation(this, R.anim.in_leftright);
            mVFActivity.setOutAnimation(this, R.anim.out_leftright);
            mVFActivity.showNext();
        } else if (e1.getX()-e2.getY()<-120) {
            mVFActivity.setInAnimation(this, R.anim.in_rightleft);
            mVFActivity.setOutAnimation(this, R.anim.out_rightleft);
            mVFActivity.showPrevious();
        } else {
            return false;
        }
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

}
