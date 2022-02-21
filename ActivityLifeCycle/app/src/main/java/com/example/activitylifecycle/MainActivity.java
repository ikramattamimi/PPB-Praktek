package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    ImageView imageView;
    ObjectAnimator rotateAnimator;
    Switch switchButton;
    SeekBar seekBar;
    final int SPEED[] = {0, 5000, 3000, 1000};
    GradientDrawable gd = new GradientDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onCreate invoked");
        Toast.makeText(this, "onCreate invoked", Toast.LENGTH_SHORT).show();

        toggleButton = findViewById(R.id.toggleButton);
        imageView = findViewById(R.id.imageView);
        switchButton = findViewById(R.id.switchButton);
        seekBar = findViewById(R.id.seekBar);

        rotateAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
        rotateAnimator.setDuration(1000);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.setInterpolator(new LinearInterpolator());

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    rotateAnimator.setDuration(SPEED[seekBar.getProgress()]);
                    rotateAnimator.start();
                }else{
                    rotateAnimator.end();
                }
            }
        });

        //light
        gd.setShape(GradientDrawable.OVAL);
        gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        gd.setGradientRadius(330);

        //turn on light
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    gd.setColors(new int []{Color.YELLOW, Color.TRANSPARENT});
                    imageView.setBackground(gd);
                }else{
                    imageView.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rotateAnimator.setDuration(SPEED[seekBar.getProgress()]);
                rotateAnimator.start();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart invoked");
        Toast.makeText(this, "onStart invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
        Toast.makeText(this, "onResume invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause invoked");
        Toast.makeText(this, "onPause invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop invoked");
        Toast.makeText(this, "onStop invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestart invoked");
        Toast.makeText(this, "onRestart invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy invoked");
        Toast.makeText(this, "onDestroy invoked", Toast.LENGTH_SHORT).show();
    }
}