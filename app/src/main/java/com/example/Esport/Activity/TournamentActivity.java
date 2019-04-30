package com.example.Esport.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.Esport.R;

import java.lang.reflect.Array;

public class TournamentActivity extends AppCompatActivity
{

    WebView webView;
    Button SCButton, CartButton, R6SButton, OWButton, LOLButton;
    String[] gameList = {"https://challonge.com/ko/mxxnn8le",
            "https://challonge.com/ko/pseh8usy", "https://challonge.com/ko/uqfh4rme",
            "https://challonge.com/ko/d6n5mh5", "https://challonge.com/ko/16rj7doo"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

        webView = findViewById(R.id.tournamentWV);
        SCButton = findViewById(R.id.button);
        CartButton = findViewById(R.id.button3);
        R6SButton = findViewById(R.id.button4);
        OWButton = findViewById(R.id.button5);
        LOLButton = findViewById(R.id.button6);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://challonge.com/ko/mxxnn8le");
        webView.setWebViewClient(new WebViewClient());

        SCButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                webView.loadUrl(gameList[0]);
            }
        });

        CartButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                webView.loadUrl(gameList[1]);
            }
        });

        R6SButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                webView.loadUrl(gameList[2]);
            }
        });

        OWButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                webView.loadUrl(gameList[3]);
            }
        });

        LOLButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                webView.loadUrl(gameList[4]);
            }
        });

    }
}
