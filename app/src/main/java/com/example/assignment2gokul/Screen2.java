package com.example.assignment2gokul;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;


public class Screen2 extends AppCompatActivity {
    public static String newString;
    public Button practice;
    public Button replay;
    public int counter = 0;
    private String rootPath = Environment.getExternalStorageDirectory().getPath();
    static String userSelectedGesture = "null";
    public int gestureInt=0;
    String videoPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        int val = b.getInt("getid");
        setContentView(R.layout.activity_screen2);


        if(val == 1)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.lighton;
        if(val == 2)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.lightoff;
        if(val == 3)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.fanon;
        if(val == 4)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.fanoff;
        if(val == 5)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.increasefanspeed;
        if(val == 6)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.decrease;
        if(val == 7)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.setthermo;
        if(val == 8)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h0;
        if(val == 9)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h1;
        if(val == 10)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h2;
        if(val == 11)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h3;
        if(val == 12)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h4;
        if(val == 13)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h5;
        if(val == 14)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h6;
        if(val == 15)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h7;
        if(val == 16)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h8;
        if(val == 17)
            videoPath = "android.resource://" + "com.example.assignment2try/" + R.raw.h9;


        userSelectedGesture=getIntent().getStringExtra("getid");
        Toast.makeText(getApplicationContext(), "Selected : " + val, Toast.LENGTH_SHORT).show();


        VideoView video = (VideoView) findViewById(R.id.player);
        //String videoPath="android.resource://" + "com.example.assignment2try/" + gestureInt;
        //String videoPath= rootPath+ "/Gestures/" + val +".mp4";
        //Toast.makeText(getApplicationContext(), "Path : " + videoPath, Toast.LENGTH_SHORT).show();

        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);
        video.start();

        Button practice = (Button) findViewById(R.id.practice);
        Button replay = (Button) findViewById(R.id.replay);

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                video.start();
            }
        });
    }

    public void click() {
        if (counter >= 2) {
            Intent i2 = new Intent(Screen2.this, screen3recording.class);
            startActivity(i2);
            counter = 0;
        } else
            Toast.makeText(getApplicationContext(), "Play the video atleast 3 times ", Toast.LENGTH_SHORT).show();
    }
}

