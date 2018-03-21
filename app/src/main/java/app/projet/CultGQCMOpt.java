package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import app.projet.Question.Domaine;

public class CultGQCMOpt extends AppCompatActivity {

    public static final String DOMAINE = "domaine";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cult_gqcmopt);


        Button francaisBtn = (Button) findViewById(R.id.CultGOpt_francaisBtn);
        francaisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demarrerQCM(Domaine.FRANCAIS);
            }
        });

        Button histoireBtn = (Button) findViewById(R.id.CultGOpt_histoireBtn);
        histoireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demarrerQCM(Domaine.HISTOIRE);
            }
        });

        Button geoBtn = (Button) findViewById(R.id.CultGOpt_geoBtn);
        geoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demarrerQCM(Domaine.GEO);
            }
        });




    }

    public void demarrerQCM(Domaine d){
        Intent qcmAct = new Intent(CultGQCMOpt.this, CultGQcm.class);
        qcmAct.putExtra(DOMAINE, d);

        startActivity(qcmAct);
    }

}
