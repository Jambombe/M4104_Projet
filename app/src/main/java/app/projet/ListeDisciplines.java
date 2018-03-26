package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListeDisciplines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_disciplines);

        final String pseudo = getIntent().getStringExtra(MainActivity.MAIN_ACTIVITY_PRENOM);


        final Button mathsBtn = (Button) findViewById(R.id.activity_liste_disciplines_mathsBtn);

        mathsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mathExAct = new Intent(ListeDisciplines.this, ExercicesMaths.class);
                mathExAct.putExtra(MainActivity.MAIN_ACTIVITY_PRENOM, pseudo);

                startActivity(mathExAct);
            }
        });

        final Button cultGBtn = (Button) findViewById(R.id.activity_liste_disciplines_cultGBtn);
        cultGBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cultGExAct = new Intent(ListeDisciplines.this, ExercicesCultureG.class);
                cultGExAct.putExtra(MainActivity.MAIN_ACTIVITY_PRENOM, pseudo);

                startActivity(cultGExAct);
            }
        });
    }
}
