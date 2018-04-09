package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ListeDisciplines extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_disciplines);

        final int userID = getIntent().getExtras().getInt(MainActivity.MAIN_ACTIVITY_USERID);

        final Button mathsBtn = (Button) findViewById(R.id.activity_liste_disciplines_mathsBtn);

        mathsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mathExAct = new Intent(ListeDisciplines.this, ExercicesMaths.class);
                mathExAct.putExtra(MainActivity.MAIN_ACTIVITY_USERID, userID);

                startActivity(mathExAct);
            }
        });

        final Button cultGBtn = (Button) findViewById(R.id.activity_liste_disciplines_cultGBtn);
        cultGBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cultGExAct = new Intent(ListeDisciplines.this, ExercicesCultureG.class);
                cultGExAct.putExtra(MainActivity.MAIN_ACTIVITY_USERID, userID);

                startActivity(cultGExAct);
            }
        });

        final Button scoreBtn = (Button) findViewById(R.id.activity_liste_disciplines_showScores);
        scoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userID != User.ID_INVITE) {
                    Intent scoreAct = new Intent(ListeDisciplines.this, Scores.class);
                    scoreAct.putExtra(MainActivity.MAIN_ACTIVITY_USERID, userID);

                    startActivity(scoreAct);
                } else {
                    String s = "En connexion invité, les scores ne sont pas enregistrés";
                    Toast t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }
}
