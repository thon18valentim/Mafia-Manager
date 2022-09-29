package br.com.up.mafia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.up.mafia.models.Action;
import br.com.up.mafia.models.Mafia;
import br.com.up.mafia.repositories.Game;

public class action_list extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    ListView listViewData_cash;
    ListView listViewData_influence;
    ListView listViewData_strength;

    ArrayList<Action> actions_cash;
    ArrayList<Action> actions_influence;
    ArrayList<Action> actions_strength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_list);

        actions_cash = new ArrayList<>();
        actions_influence = new ArrayList<>();
        actions_strength = new ArrayList<>();

        actions_cash = Game.getCashActions();
        actions_influence = Game.getInfluenceActions();
        actions_strength = Game.getStrengthActions();

        listViewData_cash = findViewById(R.id.listview_actions_data_cash);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                Game.getCashActionsName());
        listViewData_cash.setAdapter(adapter);

        listViewData_influence = findViewById(R.id.listview_actions_data_influence);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                Game.getInfluenceActionsName());
        listViewData_influence.setAdapter(adapter);

        listViewData_strength = findViewById(R.id.listview_actions_data_strength);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                Game.getStrengthActionsName());
        listViewData_strength.setAdapter(adapter);
    }

    public boolean CheckItemsSelectionLimit(int id, MenuItem item){
        int count = 0;
        if (id == R.id.action_list_done){
            for (int i=0; i<listViewData_cash.getCount(); i++){
                if (listViewData_cash.isItemChecked(i)){
                    count++;
                }
            }
            for (int i=0; i<listViewData_influence.getCount(); i++){
                if (listViewData_influence.isItemChecked(i)){
                    count++;
                }
            }
            for (int i=0; i<listViewData_strength.getCount(); i++){
                if (listViewData_strength.isItemChecked(i)){
                    count++;
                }
            }
            if (count > 3 || count < 3){
                Toast.makeText(this, "3 ações devem ser selecionadas", Toast.LENGTH_SHORT).show();
                return false;
            }
            else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actions_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_list_done){
            String itemSelected = "Selected items: \n";
            Game.actionsChosen = new ArrayList<>();
            Game.actionCount = 0;
            if (!CheckItemsSelectionLimit(id, item)) return false;

            for (int i=0; i<listViewData_cash.getCount(); i++){
                if (listViewData_cash.isItemChecked(i)){
                    itemSelected += listViewData_cash.getItemAtPosition(i) + "\n";
                    Game.actionsChosen.add(actions_cash.get(i).id);
                    Game.actionCount++;
                }
            }
            for (int i=0; i<listViewData_influence.getCount(); i++){
                if (listViewData_influence.isItemChecked(i)){
                    itemSelected += listViewData_influence.getItemAtPosition(i) + "\n";
                    Game.actionsChosen.add(actions_influence.get(i).id);
                    Game.actionCount++;
                }
            }
            for (int i=0; i<listViewData_strength.getCount(); i++){
                if (listViewData_strength.isItemChecked(i)){
                    itemSelected += listViewData_strength.getItemAtPosition(i) + "\n";
                    Game.actionsChosen.add(actions_strength.get(i).id);
                    Game.actionCount++;
                }
            }

            Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(
                    getApplicationContext(),
                    gameplay_main.class
            );
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}