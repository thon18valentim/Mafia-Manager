package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import br.com.up.mafia.models.Action;
import br.com.up.mafia.repositories.Game;

public class actions_result extends AppCompatActivity {

    TextView action_name_1;
    TextView action_name_2;
    TextView action_name_3;
    ArrayList<TextView> textViews;

    ArrayList<Action> actionsChosen;

    Button close_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions_result);

        action_name_1 = findViewById(R.id.action_name_1);
        action_name_2 = findViewById(R.id.action_name_2);
        action_name_3 = findViewById(R.id.action_name_3);

        close_button = findViewById(R.id.button_close_results);

        actionsChosen = new ArrayList<>();
        actionsChosen.add(Game.getActionAtPosition(Game.actionsChosen.get(0)));
        actionsChosen.add(Game.getActionAtPosition(Game.actionsChosen.get(1)));
        actionsChosen.add(Game.getActionAtPosition(Game.actionsChosen.get(2)));

        action_name_1.setText(actionsChosen.get(0).name);
        action_name_2.setText(actionsChosen.get(1).name);
        action_name_3.setText(actionsChosen.get(2).name);

        PopulateItemsText();
        PopulateValuesText();
        SumValues();

        close_button.setOnClickListener(
                view -> {
                    Intent intent = new Intent(
                            getApplicationContext(),
                            gameplay_main.class
                    );
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

    void PopulateValuesText(){
        // Action 1
        textViews.get(0).setText("+" + actionsChosen.get(0).wanted);
        textViews.get(1).setText("+" + actionsChosen.get(0).fear);
        textViews.get(2).setText("+" + actionsChosen.get(0).respect);
        textViews.get(3).setText("+" + actionsChosen.get(0).cash);
        textViews.get(4).setText("+" + actionsChosen.get(0).guns);
        textViews.get(5).setText("+" + actionsChosen.get(0).henchman);

        // Action 2
        textViews.get(6).setText("+" + actionsChosen.get(1).wanted);
        textViews.get(7).setText("+" + actionsChosen.get(1).fear);
        textViews.get(8).setText("+" + actionsChosen.get(1).respect);
        textViews.get(9).setText("+" + actionsChosen.get(1).cash);
        textViews.get(10).setText("+" + actionsChosen.get(1).guns);
        textViews.get(11).setText("+" + actionsChosen.get(1).henchman);

        // Action 3
        textViews.get(12).setText("+" + actionsChosen.get(2).wanted);
        textViews.get(13).setText("+" + actionsChosen.get(2).fear);
        textViews.get(14).setText("+" + actionsChosen.get(2).respect);
        textViews.get(15).setText("+" + actionsChosen.get(2).cash);
        textViews.get(16).setText("+" + actionsChosen.get(2).guns);
        textViews.get(17).setText("+" + actionsChosen.get(2).henchman);
    }

    void SumValues(){
        Game.getMafia().sumAction(
                actionsChosen.get(0).wanted,
                actionsChosen.get(0).fear,
                actionsChosen.get(0).respect,
                actionsChosen.get(0).cash,
                actionsChosen.get(0).guns,
                actionsChosen.get(0).henchman);
        Game.getMafia().sumAction(
                actionsChosen.get(1).wanted,
                actionsChosen.get(1).fear,
                actionsChosen.get(1).respect,
                actionsChosen.get(1).cash,
                actionsChosen.get(1).guns,
                actionsChosen.get(1).henchman);
        Game.getMafia().sumAction(
                actionsChosen.get(2).wanted,
                actionsChosen.get(2).fear,
                actionsChosen.get(2).respect,
                actionsChosen.get(2).cash,
                actionsChosen.get(2).guns,
                actionsChosen.get(2).henchman);
    }
}