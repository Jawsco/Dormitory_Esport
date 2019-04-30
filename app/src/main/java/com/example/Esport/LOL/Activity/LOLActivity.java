package com.example.Esport.LOL.Activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.Esport.Dialog.LoadingDialog;
import com.example.Esport.LOL.Data.ChampionData;
import com.example.Esport.LOL.Thread.LOLNetwork;
import com.example.Esport.LOL.Thread.LOLNetworkThread;
import com.example.Esport.LOL.Thread.LOLPickThread;
import com.example.Esport.R;

import java.util.ArrayList;

public class LOLActivity extends AppCompatActivity
{
    class ImageViewOnClickListener implements ImageView.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.top1 :
                    new LOLPickThread(0, team1, team2).start();
                    break;
                case R.id.top2 :
                    new LOLPickThread(1, team1, team2).start();
                    break;
                case R.id.top3 :
                    new LOLPickThread(2, team1, team2).start();
                    break;
                case R.id.top4 :
                    new LOLPickThread(3, team1, team2).start();
                    break;
                case R.id.jungle1 :
                    new LOLPickThread(4, team1, team2).start();
                    break;
                case R.id.jungle2 :
                    new LOLPickThread(5, team1, team2).start();
                    break;
                case R.id.jungle3 :
                    new LOLPickThread(6, team1, team2).start();
                    break;
                case R.id.jungle4 :
                    new LOLPickThread(7, team1, team2).start();
                    break;
                case R.id.mid1 :
                    new LOLPickThread(8, team1, team2).start();
                    break;
                case R.id.mid2 :
                    new LOLPickThread(9, team1, team2).start();
                    break;
                case R.id.mid3 :
                    new LOLPickThread(10, team1, team2).start();
                    break;
                case R.id.mid4 :
                    new LOLPickThread(11, team1, team2).start();
                    break;
                case R.id.bottom1 :
                    new LOLPickThread(12, team1, team2).start();
                    break;
                case R.id.bottom2 :
                    new LOLPickThread(13, team1, team2).start();
                    break;
                case R.id.bottom3 :
                    new LOLPickThread(14, team1, team2).start();
                    break;
                case R.id.bottom4 :
                    new LOLPickThread(15, team1, team2).start();
                    break;
                case R.id.support1 :
                    new LOLPickThread(16, team1, team2).start();
                    break;
                case R.id.support2 :
                    new LOLPickThread(17, team1, team2).start();
                    break;
                case R.id.support3 :
                    new LOLPickThread(18, team1, team2).start();
                    break;
                case R.id.support4 :
                    new LOLPickThread(19, team1, team2).start();
                    break;
            }
        }
    }

    public static ImageView[] championImageView = new ImageView[20];

    Spinner spinner_1, spinner_2;

    Button button;

    public static ArrayList<ChampionData> championList = new ArrayList<>();

    public static Bitmap[] bitmap = new Bitmap[20];

    String team1, team2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lol);

        championImageView[0] = findViewById(R.id.top1);
        championImageView[1] = findViewById(R.id.top2);
        championImageView[2] = findViewById(R.id.top3);
        championImageView[3] = findViewById(R.id.top4);
        championImageView[4] = findViewById(R.id.jungle1);
        championImageView[5] = findViewById(R.id.jungle2);
        championImageView[6] = findViewById(R.id.jungle3);
        championImageView[7] = findViewById(R.id.jungle4);
        championImageView[8] = findViewById(R.id.mid1);
        championImageView[9] = findViewById(R.id.mid2);
        championImageView[10] = findViewById(R.id.mid3);
        championImageView[11] = findViewById(R.id.mid4);
        championImageView[12] = findViewById(R.id.bottom1);
        championImageView[13] = findViewById(R.id.bottom2);
        championImageView[14] = findViewById(R.id.bottom3);
        championImageView[15] = findViewById(R.id.bottom4);
        championImageView[16] = findViewById(R.id.support1);
        championImageView[17] = findViewById(R.id.support2);
        championImageView[18] = findViewById(R.id.support3);
        championImageView[19] = findViewById(R.id.support4);

        for(int i = 0; i < 20; i++)
        {
            championImageView[i].setOnClickListener(new ImageViewOnClickListener());
        }

        spinner_1 = findViewById(R.id.spinner);
        spinner_2 = findViewById(R.id.spinner2);

        spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                team1 = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        spinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                team2 = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) //Network 쓰레드 중복 실행 방지
            {
                LoadingDialog dialog = new LoadingDialog(LOLActivity.this);
                button.setEnabled(false);
                dialog.show();
                if(team1.equals(team2))
                {
                    Toast.makeText(getApplicationContext(), "팀을 다르게 설정해주세요", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    LOLNetworkThread networkThread = new LOLNetworkThread(team1, team2);
                    networkThread.start();
                }
                dialog.dismiss();
                button.setEnabled(true);
            }
        });
    }
}

