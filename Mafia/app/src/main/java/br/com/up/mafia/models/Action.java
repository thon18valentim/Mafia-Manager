package br.com.up.mafia.models;

public class Action {

    public int id;
    public String name;
    public String description;
    public ActionCategory category;

    public Action(int id, String name, String description, ActionCategory category){
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
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

}
