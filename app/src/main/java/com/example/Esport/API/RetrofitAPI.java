package com.example.Esport.API;

import com.example.Esport.LOL.Data.ChampionData;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI
{
    @FormUrlEncoded
    @POST("api/lol/random")
    Call<ArrayList<ChampionData>> postData(@FieldMap HashMap<String, String> param);

    @FormUrlEncoded
    @POST("api/lol/characterPick")
    Call<Integer> postPick(@FieldMap HashMap<String, String> param);
}
