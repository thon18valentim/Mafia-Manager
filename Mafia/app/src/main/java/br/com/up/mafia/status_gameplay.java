package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import br.com.up.mafia.models.Mafia;
import br.com.up.mafia.repositories.Game;

public class status_gameplay extends AppCompatActivity {

    private Mafia mafia;
    private ProgressBar roundProgressBar_cash;
    private ProgressBar roundProgressBar_influence;
    private ProgressBar roundProgressBar_force;
    private ProgressBar fearProgressBar;
    private ProgressBar respectProgressBar;
    private ProgressBar gunsProgressBar;
    private ProgressBar henchmanProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_gameplay);

        Mafia mafia = Game.getMafia();

        roundProgressBar_cash = findViewById(R.id.roundProgressBar_cash);
        roundProgressBar_influence = findViewById(R.id.roundProgressBar_influence);
        roundProgressBar_force = findViewById(R.id.roundProgressBar_force);

        fearProgressBar = findViewById(R.id.progressBar_fear_full);
        respectProgressBar = findViewById(R.id.progressBar_respect_full);
        gunsProgressBar = findViewById(R.id.progressBar_guns_full);
        henchmanProgressBar = findViewById(R.id.progressBar_henchman_full);

        roundProgressBar_cash.setProgress(mafia.getCashLvl());
        roundProgressBar_influence.setProgress(mafia.getInfluenceLvl());
        roundProgressBar_force.setProgress(mafia.getForceLvl());

        fearProgressBar.setProgress(mafia.fearLvl);
        respectProgressBar.setProgress(mafia.respectLvl);
        gunsProgressBar.setProgress(mafia.gunsLvl);
        henchmanProgressBar.setProgress(mafia.henchmanLvl);
    }
}