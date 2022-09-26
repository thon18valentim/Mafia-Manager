package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.up.mafia.models.Mafia;
import br.com.up.mafia.repositories.Game;

public class gameplay_main extends AppCompatActivity {

    private Mafia mafia;
    private TextView mafiaNameTextView;
    private TextView actionCountTextView;
    private ProgressBar cashProgressBar;
    private ProgressBar influenceProgressBar;
    private ProgressBar forceProgressBar;

    private Button statusBtn;
    private Button actionsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay_main);

        mafia = Game.getMafia();

        mafiaNameTextView = findViewById(R.id.text_view_mafiaName);
        actionCountTextView = findViewById(R.id.text_view_action_counter);
        cashProgressBar = findViewById(R.id.progress_bar_money);
        influenceProgressBar = findViewById(R.id.progress_bar_influency);
        forceProgressBar = findViewById(R.id.progress_bar_strength);

        statusBtn = findViewById(R.id.button_status);
        actionsBtn = findViewById(R.id.button_actions);

        mafiaNameTextView.setText(mafia.name);
        actionCountTextView.setText(Game.actionCount + "/3");
        cashProgressBar.setProgress(mafia.getCashLvl());
        influenceProgressBar.setProgress(mafia.getInfluenceLvl());
        forceProgressBar.setProgress(mafia.getForceLvl());

        statusBtn.setOnClickListener(
                view -> {
                    Intent intent = new Intent(
                            getApplicationContext(),
                            status_gameplay.class
                    );
                    startActivity(intent);
                });

        actionsBtn.setOnClickListener(
                view -> {
                    Intent intent = new Intent(
                            getApplicationContext(),
                            action_list.class
                    );
                    startActivity(intent);
                });
    }
}