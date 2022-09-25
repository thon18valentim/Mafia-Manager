package br.com.up.mafia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.up.mafia.repositories.Game;

public class MainActivity extends AppCompatActivity {

    private EditText inputLayoutName;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutName = findViewById(R.id.editText_mafiaName);
        button = findViewById(R.id.button_start);

        String mafia_name = inputLayoutName.getText().toString();

        if(!mafia_name.isEmpty()){
            button.setOnClickListener(
                    view -> {
                        Game game = Game.createGame(mafia_name);
                    });
        }
        else{
            inputLayoutName.setError("Favor inserir o nome!!");
        }
    }
}
