package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.projet.Question.Domaine;

public class CultGQCMOpt extends AppCompatActivity {

    public static final String DOMAINE = "domaine";
    public static final int FIN_EXERCICE = 1;

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

        final int userID = getIntent().getExtras().getInt(MainActivity.MAIN_ACTIVITY_USERID);

        Intent qcmAct = new Intent(CultGQCMOpt.this, CultGQcm.class);
        qcmAct.putExtra(DOMAINE, d);
        qcmAct.putExtra(MainActivity.MAIN_ACTIVITY_USERID, userID);

        startActivityForResult(qcmAct, FIN_EXERCICE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){

//        if (requestCode == FIN_EXERCICE){
//            String s = "Username "+ u.getPrenom() + ", Score fr = " + u.getScoreCGFr();
//            Toast t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
//            t.show();
//        }

    }

}
