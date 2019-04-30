package com.example.Esport.LOL.Thread;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.Esport.API.RetrofitAPI;
import com.example.Esport.Dialog.LoadingDialog;
import com.example.Esport.LOL.Activity.LOLActivity;
import com.example.Esport.LOL.Data.ChampionData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.Esport.LOL.Activity.LOLActivity.championList;


public class LOLNetworkThread extends Thread
{
    String team1;
    String team2;

    public LOLNetworkThread(String team1, String team2)
    {
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public void run()
    {
        championList.clear();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.80.161.98:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        HashMap<String, String> input = new HashMap<>();
        input.put("team1", team1);
        input.put("team2", team2);


        retrofitAPI.postData(input).enqueue(new Callback<ArrayList<ChampionData>>()
        {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ChampionData>> call, @NonNull Response<ArrayList<ChampionData>> response)
            {
                if (response.isSuccessful())
                {
                    championList = response.body();
                    if (championList != null)
                    {
                        for(int i = 0; i < 20; i++)
                        {
                            Log.d("data.getName", championList.get(i).getName() + "");
                            Log.d("data.getImgPath", championList.get(i).getImgPath() + "");
                            Log.d("data.getPicked", String.valueOf(championList.get(i).getPicked()) + "");
                            Log.d("postData end", "=================================");
                        }
                        new LOLGUIThread().start();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ChampionData>> call, Throwable t)
            {

            }
        });
    }
}