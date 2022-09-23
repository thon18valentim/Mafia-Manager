package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.up.mafia.repositories.Game;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Game game = Game.createGame("Unknown Game");
    }
}