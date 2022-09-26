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
import br.com.up.mafia.repositories.Game;

public class action_list extends AppCompatActivity {

    ListView listViewData;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_list);

        arrayData = new ArrayList<>();
        ArrayList<Action> actions = Game.getActions();
        for(int i=0; i<actions.size(); i++){
            arrayData.add(actions.get(i).name);
        }

        listViewData = findViewById(R.id.listview_actions_data);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                arrayData);
        listViewData.setAdapter(adapter);
    }

    public boolean CheckItemsSelectionLimit(int id, MenuItem item){
        int count = 0;
        if (id == R.id.action_list_done){
            for (int i=0; i<listViewData.getCount(); i++){
                if (listViewData.isItemChecked(i)){
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
            for (int i=0; i<listViewData.getCount(); i++){
                if (listViewData.isItemChecked(i)){
                    itemSelected += listViewData.getItemAtPosition(i) + "\n";
                    Game.actionsChosen.add(i + 1);
                    Game.actionCount++;
                }
            }
            //Toast.makeText(this, "Ações selecionadas", Toast.LENGTH_SHORT).show();
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