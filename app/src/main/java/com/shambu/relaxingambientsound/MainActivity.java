package com.shambu.relaxingambientsound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer fire_mp3, jazz_mp3, rain_mp3;
    private Button play_button, stop_button;
    private TextView fire_vol_val, jazz_vol_val, rain_vol_val;
    private SeekBar fire_vol, jazz_vol, rain_vol;
    private boolean soundState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        play_button = findViewById(R.id.play_pause);
        stop_button = findViewById(R.id.stop);
        fire_vol = findViewById(R.id.fire_seek);
        jazz_vol = findViewById(R.id.jazz_seek);
        rain_vol = findViewById(R.id.rain_seek);
        fire_vol_val = findViewById(R.id.fire_volval);
        jazz_vol_val = findViewById(R.id.jazz_volval);
        rain_vol_val = findViewById(R.id.rain_volval);
        fire_vol.setProgress(100);
        jazz_vol.setProgress(100);
        rain_vol.setProgress(100);
        fire_vol_val.setText("100");
        jazz_vol_val.setText("100");
        rain_vol_val.setText("100");
        soundState = false;

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!soundState){
                    play_button.setText("Pause");
                    play_sounds();
                    soundState=true;
                }
                else if(soundState){
                    play_button.setText("Play");
                    pause_sounds();
                    soundState=false;
                }
            }
        });

        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop_sounds();
            }
        });

        fire_vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fire_mp3!=null) fire_mp3.setVolume((float) progress/100, (float) progress/100);
                fire_vol_val.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        jazz_vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(jazz_mp3!=null) jazz_mp3.setVolume((float) progress/100, (float) progress/100);
                jazz_vol_val.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rain_vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(rain_mp3!=null) rain_mp3.setVolume((float) progress/100, (float) progress/100);
                rain_vol_val.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void play_sounds() {
        if(fire_mp3 == null){
            fire_mp3 = MediaPlayer.create(this, R.raw.fireplace);
        }
        if(jazz_mp3 == null){
            jazz_mp3 = MediaPlayer.create(this, R.raw.jazz);
        }
        if(rain_mp3 == null){
            rain_mp3 = MediaPlayer.create(this, R.raw.rain);
        }
        fire_mp3.start();
        jazz_mp3.start();
        rain_mp3.start();
        fire_mp3.setVolume((float) fire_vol.getProgress()/100, (float) fire_vol.getProgress()/100);
        jazz_mp3.setVolume((float) jazz_vol.getProgress()/100, (float) jazz_vol.getProgress()/100);
        rain_mp3.setVolume((float) rain_vol.getProgress()/100, (float) rain_vol.getProgress()/100);
        fire_mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                fire_mp3.start();
            }
        });
        jazz_mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                jazz_mp3.start();
            }
        });
        rain_mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                rain_mp3.start();
            }
        });

        fire_vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fire_mp3!=null) fire_mp3.setVolume((float) progress/100, (float) progress/100);
                fire_vol_val.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        jazz_vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(jazz_mp3!=null) jazz_mp3.setVolume((float) progress/100, (float) progress/100);
                jazz_vol_val.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rain_vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(rain_mp3!=null) rain_mp3.setVolume((float) progress/100, (float) progress/100);
                rain_vol_val.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void pause_sounds(){
        if(fire_mp3!=null){
            fire_mp3.pause();
        }
        if(jazz_mp3!=null){
            jazz_mp3.pause();
        }
        if(rain_mp3!=null){
            rain_mp3.pause();
        }
    }

    private void stop_sounds(){
        play_button.setText("Play");
        soundState = false;
        if(fire_mp3!=null){
            fire_mp3.release();
            fire_mp3 = null;
        }
        if(jazz_mp3!=null){
            jazz_mp3.release();
            jazz_mp3 = null;
        }
        if(rain_mp3!=null){
            rain_mp3.release();
            rain_mp3 = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop_sounds();
    }
}
