package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExercicesMaths extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices_maths);

        final String pseudo = getIntent().getStringExtra(MainActivity.MAIN_ACTIVITY_PSEUDO);

        final Button multBtn = (Button) findViewById(R.id.activity_exercices_maths_multBtn);
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent multAct = new Intent(ExercicesMaths.this, MathsMultiplicationOpt.class);
                multAct.putExtra(MainActivity.MAIN_ACTIVITY_PSEUDO, pseudo);

                startActivity(multAct);
            }
        });


        ///// INFO BULLE BOUTONS D'AIDE /////

        Button multHelp = (Button) findViewById(R.id.activity_exercices_maths_multHelp);
        multHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t;
                String s = "Répondre correctement aux multiplications de la table sélectionnée";
                t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
                t.show();
            }
        });

        Button addHelp = (Button) findViewById(R.id.activity_exercices_maths_addHelp);
        addHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t;
                String s = "Répondre correctement aux 10 additions";
                t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
                t.show();
            }
        });
    }
}
