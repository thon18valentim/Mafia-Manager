package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import br.com.up.mafia.repositories.Game;

public class MainActivity extends AppCompatActivity {

    private EditText inputLayoutName;
    private Button button;
    private MediaPlayer mediaPlayer;
    private MediaPlayer buttonSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.musica);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        inputLayoutName = findViewById(R.id.editText_mafiaName);
        button = findViewById(R.id.button_start);

        button.setOnClickListener(
                view -> {
                    buttonSound = MediaPlayer.create(MainActivity.this,R.raw.cavalo);
                    buttonSound.start();
                    String mafia_name = inputLayoutName.getText().toString();
                    if(!mafia_name.isEmpty()){
                        Game game = Game.createGame(mafia_name);
                        Intent intent = new Intent(
                                getApplicationContext(),
                                gameplay_main.class
                        );
                        startActivity(intent);
                    }
                    else{
                        inputLayoutName.setError("Favor inserir o nome!!");
                    }
                });

    }
}
