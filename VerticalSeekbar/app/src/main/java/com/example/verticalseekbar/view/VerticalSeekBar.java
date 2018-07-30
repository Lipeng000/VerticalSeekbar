package com.example.verticalseekbar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by WangJinyong on 2017/11/6.
 */

public class VerticalSeekBar extends android.support.v7.widget.AppCompatSeekBar {

    //每个进度代表的值
    private float greed = 1;
    //开始进度
    private float min = 1;
    private int mProgress;

    public VerticalSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalSeekBar(Context context) {
        super(context);
    }

    public void setGreed(float greed) {
        this.greed = greed;
    }

    public float getMProgress() {
        return min + getProgress() * greed;
    }

    public void setMin(float min) {
        this.min = min;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec,
                                          int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        setProgress(mProgress);
    }

    public void setBarProgress(int progress){
        this.mProgress = progress;
    }
    @Override
    public void setProgress(int progress, boolean animate) {
        super.setProgress(progress, animate);
    }

    @Override
    protected void onDraw(Canvas c) {
        c.rotate(-90);
        c.translate(-getHeight(), 0);
        super.onDraw(c);
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                setProgress(getMax()-(int) (getMax()*( (event.getY()-getPaddingLeft()-getThumb().getMinimumWidth()/2)) / (getHeight()-getPaddingLeft()*2-getThumb().getMinimumWidth())));
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                break;

            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isEnabled()) {
            int progress = getProgress();
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_UP:
                    if (progress <= 0) break;
                    setProgress(progress - 1);
                    return true;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    if (progress >= getMax()) break;
                    setProgress(progress + 1);
                    return true;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    break;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}