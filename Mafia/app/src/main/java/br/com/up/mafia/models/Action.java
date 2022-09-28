package br.com.up.mafia.models;

import java.util.Random;

public class Action {

    public int id;
    public String name;
    public String description;
    public ActionCategory category;
    public ActionSubCategory subCategory;
    public ActionDiscover actionDiscover;

    public Action(int id, String name, String description, ActionCategory category, ActionSubCategory subCategory){
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.subCategory = subCategory;
        this.actionDiscover = ActionDiscover.Unknown;
    }

    // Attributes
    public int wanted;
    public int fear;
    public int respect;
    public int cash;
    public int guns;
    public int henchman;

    public void SetAttributes(int wanted, int fear, int respect, int cash, int guns, int henchman){
        this.wanted = wanted;
        this.fear = fear;
        this.respect = respect;
        this.cash = cash;
        this.guns = guns;
        this.henchman = henchman;
    }

    public boolean ExecuteAction(Mafia mafia)
    {
        double chances = 60 - (mafia.wantedLvl / 5);

        if(this.category == ActionCategory.Cash)
        {
            //arma e medo
            chances += (mafia.gunsLvl / 5) + (mafia.fearLvl / 5);

        }
        else if(this.category == ActionCategory.Influence)
        {
            //respeito e medo
            chances += (mafia.respectLvl / 5) + (mafia.fearLvl / 5);

        }
        else if(this.category == ActionCategory.Strength)
        {
            //capanga e arma
            chances += (mafia.henchmanLvl / 5) + (mafia.gunsLvl / 5);

        }

        if(chances >= new Random().nextInt(101))
        {
            return true;
        }

        return false;

    }

}
