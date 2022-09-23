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
        this.wantedLvl = 0;
        this.fearLvl = 0;
        this.respectLvl = 0;
        this.cashLvl = 0;
        this.gunsLvl = 0;
        this.henchmanLvl = 0;
    }

}
