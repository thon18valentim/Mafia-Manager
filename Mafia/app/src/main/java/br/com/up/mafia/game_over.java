package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import br.com.up.mafia.models.Mafia;
import br.com.up.mafia.models.Status;
import br.com.up.mafia.repositories.Game;

public class game_over extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        textView = findViewById(R.id.textView_description);

        if (Game.week > 30){
            textView.setText("Parabéns! A vida é uma dadíva e você foi um vencedor por ser um ótimo GodFather.");
        }
        else{
            Mafia mafia = Game.getMafia();
            if (mafia.status == Status.Prisoner){
                textView.setText("Você é uma vergonha para a família mafiosa, terminar na prisão é a maior humilhação para uma mafioso de respeito.");
            }
            else if (mafia.status == Status.Dead){
                textView.setText("Você está morto. Descanse em paz irmão! A história nunca te esquecerá.");
            }
        }
    }
}