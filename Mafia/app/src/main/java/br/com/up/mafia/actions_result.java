package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

import br.com.up.mafia.models.Action;
import br.com.up.mafia.models.Status;
import br.com.up.mafia.repositories.Game;

public class actions_result extends AppCompatActivity {

    TextView action_name_1;
    TextView action_name_2;
    TextView action_name_3;
    ArrayList<TextView> textViews;

    ArrayList<Action> actionsChosen;

    Button close_button;

    private Status status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions_result);

        action_name_1 = findViewById(R.id.action_name_1);
        action_name_2 = findViewById(R.id.action_name_2);
        action_name_3 = findViewById(R.id.action_name_3);

        close_button = findViewById(R.id.button_close_results);

        actionsChosen = new ArrayList<>();
        actionsChosen.add(Game.getActionsById(Game.actionsChosen.get(0)));
        actionsChosen.add(Game.getActionsById(Game.actionsChosen.get(1)));
        actionsChosen.add(Game.getActionsById(Game.actionsChosen.get(2)));

        action_name_1.setText(actionsChosen.get(0).name);
        action_name_2.setText(actionsChosen.get(1).name);
        action_name_3.setText(actionsChosen.get(2).name);

        PopulateItemsText();

        int contador = 0;
        for (int i = 0; i < 3; i++)
        {
            if(actionsChosen.get(i).ExecuteAction(Game.getMafia()))
            {
                Game.getMafia().sumAction(
                        actionsChosen.get(i).wanted,
                        actionsChosen.get(i).fear,
                        actionsChosen.get(i).respect,
                        actionsChosen.get(i).cash,
                        actionsChosen.get(i).guns,
                        actionsChosen.get(i).henchman);

                textViews.get(contador).setText("" + actionsChosen.get(i).wanted);
                textViews.get(contador+1).setText("" + actionsChosen.get(i).fear);
                textViews.get(contador+2).setText("" + actionsChosen.get(i).respect);
                textViews.get(contador+3).setText("" + actionsChosen.get(i).cash);
                textViews.get(contador+4).setText("" + actionsChosen.get(i).guns);
                textViews.get(contador+5).setText("" + actionsChosen.get(i).henchman);
                status = Status.Alive;
            }
            else
            {
                Game.getMafia().sumAction(
                        actionsChosen.get(i).wanted_negative,
                        actionsChosen.get(i).fear_negative,
                        actionsChosen.get(i).respect_negative,
                        actionsChosen.get(i).cash_negative,
                        actionsChosen.get(i).guns_negative,
                        actionsChosen.get(i).henchman_negative);

                textViews.get(contador).setText("" + actionsChosen.get(i).wanted_negative);
                textViews.get(contador+1).setText("" + actionsChosen.get(i).fear_negative);
                textViews.get(contador+2).setText("" + actionsChosen.get(i).respect_negative);
                textViews.get(contador+3).setText("" + actionsChosen.get(i).cash_negative);
                textViews.get(contador+4).setText("" + actionsChosen.get(i).guns_negative);
                textViews.get(contador+5).setText("" + actionsChosen.get(i).henchman_negative);

                if (Game.getMafia().wantedLvl > 90){
                    int rnd = new Random().nextInt(400);
                    if (rnd > 395){
                        status = Status.Prisoner;
                    }
                }
                else if (Game.getMafia().wantedLvl > 70){
                    int rnd = new Random().nextInt(300);
                    if (rnd > 295){
                        status = Status.Dead;
                    }
                }
            }

            Game.history.add("Semana " + Game.week + " - " +  Game.getMafia().name + " cometeu a a????o " + actionsChosen.get(i).name);

            contador += 6;
        }

        close_button.setOnClickListener(
                view -> {
                    Intent intent;
                    if (Game.week > 30 || status != Status.Alive){
                        intent = new Intent(
                                getApplicationContext(),
                                game_over.class
                        );
                    }
                    else{
                        intent = new Intent(
                                getApplicationContext(),
                                gameplay_main.class
                        );
                    }
                    Game.week++;
                    Game.actionsChosen = new ArrayList<>();
                    Game.actionCount = 0;
                    startActivity(intent);
                });
    }

    void PopulateItemsText(){
        textViews = new ArrayList<>();
        // Action 1
        textViews.add(findViewById(R.id.procurado_valor));
        textViews.add(findViewById(R.id.medo_valor));
        textViews.add(findViewById(R.id.respeito_valor));
        textViews.add(findViewById(R.id.dinheiro_valor));
        textViews.add(findViewById(R.id.armamento_valor));
        textViews.add(findViewById(R.id.capangas_valor));

        // Action 2
        textViews.add(findViewById(R.id.procurado_valor_2));
        textViews.add(findViewById(R.id.medo_valor_2));
        textViews.add(findViewById(R.id.respeito_valor_2));
        textViews.add(findViewById(R.id.dinheiro_valor_2));
        textViews.add(findViewById(R.id.armamento_valor_2));
        textViews.add(findViewById(R.id.capangas_valor_2));

        // Action 3
        textViews.add(findViewById(R.id.procurado_valor_3));
        textViews.add(findViewById(R.id.medo_valor_3));
        textViews.add(findViewById(R.id.respeito_valor_3));
        textViews.add(findViewById(R.id.dinheiro_valor_3));
        textViews.add(findViewById(R.id.armamento_valor_3));
        textViews.add(findViewById(R.id.capangas_valor_3));
    }

}