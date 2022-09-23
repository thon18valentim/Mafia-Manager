package br.com.up.mafia.repositories;

import java.util.ArrayList;
import br.com.up.mafia.models.Action;
import br.com.up.mafia.models.Mafia;

public class Game {

    public static Game game;
    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }

    public Mafia mafia;
    public ArrayList<Action> actions;

}
