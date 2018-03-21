package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ACTIVITY_PSEUDO = "pseudo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText pseudo = (EditText) findViewById(R.id.activity_main_login);

        final Button connexion = (Button) findViewById(R.id.activity_main_connectBtn);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listeDisciplinesAct = new Intent(MainActivity.this, ListeDisciplines.class);

                listeDisciplinesAct.putExtra(MAIN_ACTIVITY_PSEUDO, pseudo.getText().toString());

                startActivity(listeDisciplinesAct);
            }
        });


        QuestionDAO.updateDB();

    }
}
