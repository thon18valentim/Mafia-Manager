package br.com.up.mafia.models;

public class Mafia {

    public String name;

    // Attributes
    public int wantedLvl;
    public int fearLvl;
    public int respectLvl;
    public int cashLvl;
    public int gunsLvl;
    public int henchmanLvl;

    public Mafia(String name){
        this.name = name;
        this.wantedLvl = 1;
        this.fearLvl = 1;
        this.respectLvl = 1;
        this.cashLvl = 1;
        this.gunsLvl = 1;
        this.henchmanLvl = 1;
    }

    public int getCashLvl(){
        return cashLvl;
    }

    public int getInfluenceLvl(){
        return (fearLvl + respectLvl) / 2;
    }

    public int getForceLvl(){
        return (gunsLvl + henchmanLvl) / 2;
    }

    public int getWantedLvl() { return wantedLvl; }

    public void sumAction(int wanted, int fear, int respect, int cash, int guns, int henchman){
        wantedLvl += wanted;
        fearLvl += fear;
        respectLvl += respect;
        cashLvl += cash;
        gunsLvl += guns;
        henchmanLvl += henchman;
    }

}
