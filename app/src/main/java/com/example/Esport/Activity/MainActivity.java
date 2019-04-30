package com.example.Esport.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.Esport.LOL.Activity.LOLActivity;
import com.example.Esport.R;


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
    ImageButton TournamentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LOLButton = findViewById(R.id.LOLButton);
        OverwatchButton = findViewById(R.id.OverwatchButton);
        RSButton = findViewById(R.id.RSButton);
        TournamentButton = findViewById(R.id.TournamentButton);

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

        TournamentButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, TournamentActivity.class);
                startActivity(intent);
            }
        });
    }
}
