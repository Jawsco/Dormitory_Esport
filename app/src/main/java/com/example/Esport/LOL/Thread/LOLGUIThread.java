package com.example.Esport.LOL.Thread;

import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Handler;
import android.os.Message;

import com.example.Esport.Dialog.LoadingDialog;
import com.example.Esport.LOL.Activity.LOLActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.Esport.LOL.Activity.LOLActivity.bitmap;
import static com.example.Esport.LOL.Activity.LOLActivity.championImageView;
import static com.example.Esport.LOL.Activity.LOLActivity.championList;
import static com.google.android.gms.internal.zzir.runOnUiThread;

class LOLGUIThread extends Thread
{
    int idx = 0;

    @Override
    public void run()
    {
        for (int i = 0; i < championList.size(); i++)
        {
            try
            {
                URL url = new URL(championList.get(i).getImgPath());
                InputStream is = url.openStream();
                bitmap[i] = BitmapFactory.decodeStream(is);
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                idx = 0;
                ColorMatrix greyMatrix = new ColorMatrix();
                greyMatrix.setSaturation(0);

                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(1);

                ColorMatrixColorFilter greyFilter = new ColorMatrixColorFilter(greyMatrix);
                ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);

                while (idx < bitmap.length)
                {
                    if(championList.get(idx).getPicked() == 1)
                    {
                        championImageView[idx].setColorFilter(greyFilter);
                    }
                    else
                    {
                        championImageView[idx].setColorFilter(colorFilter);
                    }
                    championImageView[idx].setImageBitmap(bitmap[idx++]);
                }
            }
        });
    }
}
