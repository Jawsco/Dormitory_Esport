package com.example.Esport.LOL.Thread;

import android.util.Log;

import com.example.Esport.API.RetrofitAPI;
import com.example.Esport.LOL.Data.ChampionData;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.Esport.LOL.Activity.LOLActivity.championList;

public class LOLPickThread extends Thread
{
    int idx;
    String team1, team2;
    public LOLPickThread(int idx, String team1, String team2)
    {
        this.idx = idx;
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public void run()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.80.161.98:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        HashMap<String, String> input = new HashMap<>();
        input.put("team1", team1);
        input.put("team2", team2);
        input.put("name", championList.get(idx).getName());
        Log.d("test", championList.get(idx).getName());

        retrofitAPI.postPick(input).enqueue(new Callback<Integer>()
        {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response)
            {
                if(response.isSuccessful())
                {
                    championList.set(idx, new ChampionData(championList.get(idx).getName(),
                            championList.get(idx).getOriginalImg(),
                            championList.get(idx).setPicked()));
                }

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t)
            {

            }
        });
        new LOLNetworkThread(team1, team2).start();
    }
}
