package br.com.up.mafia.models;

public class Mafia {

    public String name;
    public Status status;

    // Attributes
    public int wantedLvl;
    public int fearLvl;
    public int respectLvl;
    public int cashLvl;
    public int gunsLvl;
    public int henchmanLvl;

    public Mafia(String name){
        this.name = name;
        this.wantedLvl = 5;
        this.fearLvl = 10;
        this.respectLvl = 15;
        this.cashLvl = 30;
        this.gunsLvl = 10;
        this.henchmanLvl = 10;
        this.status = Status.Alive;
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

        if (wantedLvl > 100){
            wantedLvl = 100;
        }
        if (fearLvl > 100){
            fearLvl = 100;
        }
        if (respectLvl > 100){
            respectLvl = 100;
        }
        if (cashLvl > 100){
            cashLvl = 100;
        }
        if (gunsLvl > 100){
            gunsLvl = 100;
        }
        if (henchmanLvl > 100){
            henchmanLvl = 100;
        }

        if (wantedLvl < 0){
            wantedLvl = 1;
        }
        if (fearLvl < 0){
            fearLvl = 1;
        }
        if (respectLvl < 0){
            respectLvl = 1;
        }
        if (cashLvl < 0){
            cashLvl = 1;
        }
        if (gunsLvl < 0){
            gunsLvl = 1;
        }
        if (henchmanLvl < 0){
            henchmanLvl = 1;
        }
    }

}
