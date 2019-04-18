package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


/*
클래스는 단어마다 대문자
변수는 낙타 방식
xml id이름 낙타형식, 단 고유명사는 대문자
 */


public class MainActivity extends AppCompatActivity
{
    ImageButton LOLButton;
    ImageButton OverwatchButton;
    ImageButton RSButton;
    ImageButton SCButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LOLButton = findViewById(R.id.LOLButton);
        OverwatchButton = findViewById(R.id.OverwatchButton);
        RSButton = findViewById(R.id.RSButton);
        SCButton = findViewById(R.id.SCButton);

        LOLButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, LOLActivity.class);
                startActivity(intent);
            }
        });

        OverwatchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, OverwatchActivity.class);
                startActivity(intent);
            }
        });

        RSButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, RSActivity.class);
                startActivity(intent);
            }
        });

        SCButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SCActivity.class);
                startActivity(intent);
            }
        });
    }
}
