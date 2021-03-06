package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExercicesCultureG extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices_culture_g);

        final int userID = getIntent().getExtras().getInt(MainActivity.MAIN_ACTIVITY_USERID);


        Button qcmBtn = (Button) findViewById(R.id.activity_exercices_cultureG_QCM);
        qcmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qcmAct = new Intent(ExercicesCultureG.this, CultGQCMOpt.class);
                qcmAct.putExtra(MainActivity.MAIN_ACTIVITY_USERID, userID);

                startActivity(qcmAct);
            }
        });


        ///// INFO BULLE BOUTONS D'AIDE /////

        Button qcmHelp = (Button) findViewById(R.id.activity_exercices_cultureG_qcmHelp);
        qcmHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "Répondre correctement aux 10 questions proposées du domaine choisi.\nUne seule réponse correcte par question.";
                Toast t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
                t.show();
            }
        });
    }
}
