package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.DataSetObserver;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.up.mafia.models.Mafia;
import br.com.up.mafia.repositories.Game;

public class gameplay_main extends AppCompatActivity {

    private Mafia mafia;
    private TextView mafiaNameTextView;
    private TextView actionCountTextView;
    private ProgressBar cashProgressBar;
    private ProgressBar influenceProgressBar;
    private ProgressBar forceProgressBar;
    private ProgressBar wantedProgressBar;

    private Button statusBtn;
    private Button advWeekBtn;
    private Button actionsBtn;
    private MediaPlayer buttonSound;

    private RecyclerView historyView;

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
        wantedProgressBar = findViewById(R.id.progress_bar_wanted);

        statusBtn = findViewById(R.id.button_status);
        advWeekBtn = findViewById(R.id.button_time);
        actionsBtn = findViewById(R.id.button_actions);

        mafiaNameTextView.setText(mafia.name);
        actionCountTextView.setText(Game.actionCount + "/3");
        cashProgressBar.setProgress(mafia.getCashLvl());
        influenceProgressBar.setProgress(mafia.getInfluenceLvl());
        forceProgressBar.setProgress(mafia.getForceLvl());
        wantedProgressBar.setProgress(mafia.getWantedLvl());

        historyView = findViewById(R.id.recyclerView);
        historyView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        historyView.setHasFixedSize(true);

        statusBtn.setOnClickListener(
                view -> {
                    buttonSound = MediaPlayer.create(gameplay_main.this,R.raw.cavalo);
                    buttonSound.start();
                    Intent intent = new Intent(
                            getApplicationContext(),
                            status_gameplay.class
                    );
                    startActivity(intent);
                });

        advWeekBtn.setOnClickListener(
                view -> {
                    buttonSound = MediaPlayer.create(gameplay_main.this,R.raw.cavalo);
                    buttonSound.start();
                    if (Game.actionCount == 3){
                        Intent intent = new Intent(
                                getApplicationContext(),
                                actions_result.class
                        );
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(this, "Ações não selecionadas", Toast.LENGTH_SHORT).show();
                    }
                });

        actionsBtn.setOnClickListener(
                view -> {
                    buttonSound = MediaPlayer.create(gameplay_main.this,R.raw.cavalo);
                    buttonSound.start();
                    Intent intent = new Intent(
                            getApplicationContext(),
                            action_list.class
                    );
                    startActivity(intent);
                });
    }

    @Override
    protected void onResume(){
        super.onResume();

        historyView.setAdapter(new HistoryAdapter(Game.history));
    }
}