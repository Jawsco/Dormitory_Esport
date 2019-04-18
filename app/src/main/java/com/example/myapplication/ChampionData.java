package com.example.myapplication;

public class ChampionData
{
    private String name;
    private String line;
    private String image;

    public ChampionData(String name, String line, String image)
    {
        this.name = name;
        this.line = line;
        this.image = image;
    }

    public String getName()
    {
        return this.name;
    }

    public String getLine()
    {
        return this.line;
    }

    public String getImage1()
    {
        return "https://ddragon.leagueoflegends.com/cdn/9.7.2/img/champion/" + this.image;
    }
}
