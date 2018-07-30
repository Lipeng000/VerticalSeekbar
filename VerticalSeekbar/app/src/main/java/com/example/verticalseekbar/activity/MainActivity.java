package com.example.verticalseekbar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.example.verticalseekbar.R;
import com.example.verticalseekbar.view.MySeekBar;
import com.example.verticalseekbar.view.VerticalSeekBar;

public class MainActivity extends AppCompatActivity {

    private MySeekBar mySeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySeekBar = (MySeekBar) findViewById(R.id.myseekbar);
        mySeekBar.setInit(this);
        mySeekBar.setProgress(50);
        VerticalSeekBar seekBar = mySeekBar.getmSeekBar();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mySeekBar.setPosition(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
