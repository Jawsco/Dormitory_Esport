package com.example.Esport.LOL.Data;

public class ChampionData
{
    private String name;
    private String imgPath;
    private int picked;

    public ChampionData(String name, String imgPath, int picked)
    {
        this.name = name;
        this.imgPath = imgPath;
        this.picked = picked;
    }

    public String getName()
    {
        return this.name;
    }

    public String getOriginalImg()
    {
        return this.imgPath;
    }

    public String getImgPath()
    {
        return "https://ddragon.leagueoflegends.com/cdn/9.7.2/img/champion/" + this.imgPath;
    }

    public int getPicked() { return this.picked; }

    public int setPicked()
    {
        if(this.picked == 0)
        {
            this.picked = 1;
            return picked;
        }
        else
        {
            this.picked = 0;
            return picked;
        }
    }
}
