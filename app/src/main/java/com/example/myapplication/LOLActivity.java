package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LOLActivity extends AppCompatActivity
{
    ImageView[] topImageView = new ImageView[4];
    ImageView[] jungleImageView = new ImageView[4];
    ImageView[] midImageView = new ImageView[4];
    ImageView[] bottomImageView = new ImageView[4];
    ImageView[] supportImageView = new ImageView[4];

    Button button;

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lol);

        topImageView[0] = findViewById(R.id.top1);
        topImageView[1] = findViewById(R.id.top2);
        topImageView[2] = findViewById(R.id.top3);
        topImageView[3] = findViewById(R.id.top4);

        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            URL url = new URL("https://ddragon.leagueoflegends.com/cdn/9.7.2/img/champion/Aatrox.png");
//                           URL url = new URL("https://cdn.pixabay.com/photo/2017/09/14/11/13/water-2748657_960_720.png");
//                            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//                            connection.setDoInput(true);
//                            connection.connect();

                            InputStream is = url.openStream();
                            bitmap = BitmapFactory.decodeStream(is);

                            runOnUiThread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    topImageView[0].setImageBitmap(bitmap);
                                    topImageView[1].setImageBitmap(bitmap);
                                    topImageView[2].setImageBitmap(bitmap);
                                    topImageView[3].setImageBitmap(bitmap);
                                }
                            });
                        }
                        catch (MalformedURLException e)
                        {
                            e.printStackTrace();
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}
