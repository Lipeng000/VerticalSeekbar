package com.example.verticalseekbar.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.verticalseekbar.R;


/**
 * Created by MrLi on 2018/7/18.
 */

public class MySeekBar extends RelativeLayout {

    private Context mContext;
    private VerticalSeekBar mSeekBar;
    private TextView mTv_progress;
    private LayoutParams mTv_params;
    private int max_y = 277;
    private int mar_top = 54;
    private int mCurrentMax_values = 100;   //最大值

    public MySeekBar(Context context) {
        super(context);
    }

    public MySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setInit(Context context){
        mContext = context;
        initView();
    }
    @SuppressLint("ResourceAsColor")
    public void initView(){
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.seekbar, null);

        mSeekBar = inflate.findViewById(R.id.myseekbar);
        mTv_params = new LayoutParams(LayoutParams.WRAP_CONTENT,36);
        mTv_progress = new TextView(mContext);
        mTv_progress.setText("12");
        mTv_progress.setTextSize(10);
//        mTv_params.setMargins(15,0,125,0);
        mTv_params.setMarginEnd(125);
        mTv_params.setMarginStart(15);
        mTv_progress.setMinWidth(36);
        mTv_progress.setGravity(Gravity.CENTER);
        mTv_progress.setTextColor(Color.parseColor("#FF0680F9"));
        mTv_progress.setLayoutParams(mTv_params);
        this.addView(mTv_progress);
        this.addView(inflate);

    }

    public void setProgress(int progress){
        setPosition(progress);
        mSeekBar.setProgress(progress);
    }

    /**
     * 滑动时候进度显示位置
     * @param progress  当前进度值
     */
    public void setPosition(int progress){
        setBarStyle(progress);
    }

    /**
     * 返回seekbar用于做滑动监听处理
     * @return
     */
    public VerticalSeekBar getmSeekBar(){
        return mSeekBar;
    }

    /**
     * 设置seekbar显示样式
     * @param progress
     */
    public void setBarStyle(int progress){
        if (progress == 50){
            mTv_progress.setBackground(mContext.getDrawable(R.mipmap.seekbar_star));
            mTv_progress.setText("");
        }else {
            mTv_progress.setBackground(null);
            mTv_progress.setText(progress+"");
        }
        mTv_progress.setY(max_y - max_y *progress/mCurrentMax_values+ mar_top);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
