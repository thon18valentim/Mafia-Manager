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

        int contador = 0;
        String sinal = "+";

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

                sinal = "+";
                textViews.get(contador).setText("+" + Math.abs(actionsChosen.get(i).wanted));
            }
            else
            {
                Game.getMafia().subAction(
                        actionsChosen.get(i).wanted,
                        actionsChosen.get(i).fear,
                        actionsChosen.get(i).respect,
                        actionsChosen.get(i).cash,
                        actionsChosen.get(i).guns,
                        actionsChosen.get(i).henchman);

                sinal = "-";
                textViews.get(contador).setText("+" + Math.abs(actionsChosen.get(i).wanted * 2));
            }

            textViews.get(contador+1).setText(sinal + Math.abs(actionsChosen.get(i).fear));
            textViews.get(contador+2).setText(sinal + Math.abs(actionsChosen.get(i).respect));
            textViews.get(contador+3).setText(sinal + Math.abs(actionsChosen.get(i).cash));
            textViews.get(contador+4).setText(sinal + Math.abs(actionsChosen.get(i).guns));
            textViews.get(contador+5).setText(sinal + Math.abs(actionsChosen.get(i).henchman));

            contador += 6;
        }

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

}