package app.projet;


import android.content.Intent;
import android.icu.util.TimeUnit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MathsAdditions extends AppCompatActivity {

    public int numAddition = 1;
    public int[] reponses = new int[11];
    public EditText[] reponsesDonnees = new EditText[11];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_additions);

        genererAddition(numAddition);
        numAddition++;



        final Button valider = (Button) findViewById(R.id.mathsAdd_validerBtn);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (numAddition < 10) {
                    genererAddition(numAddition);
                    numAddition++;
                } else if (numAddition == 10) {
                    genererAddition(numAddition);
                    Button valider = (Button) findViewById(R.id.mathsAdd_validerBtn);
                    valider.setText("Valider");
                    numAddition++;
                } else {
                    verifierReponses();
                    // Sortie act
                }
            }
        });


    }

    public void genererAddition(int numAddition){
        TableLayout table = (TableLayout) findViewById(R.id.mathsAdd_table_layout);

        TableRow r = new TableRow(this);
        TextView v = new TextView(this);

        int a = (int) (Math.random()*19+1);
        int b = (int) (Math.random()*19+1);

        reponses[numAddition] = a+b;

        v.setText(a + " + " + b + " = ");

        reponsesDonnees[numAddition]  = new EditText(this);
        r.addView(v);
        r.addView(reponsesDonnees[numAddition]);

        table.addView(r);

    }

    public void verifierReponses(){
        TableLayout table = (TableLayout) findViewById(R.id.mathsAdd_table_layout);

        TableRow r = new TableRow(this);
        TextView v = new TextView(this);

        int score = 0;
        for (int i = 1; i <= 10; i++){

            if (! reponsesDonnees[i].getText().toString().isEmpty()) { // Si mon string n'est pas vide ...
                if (reponses[i] == Integer.parseInt(reponsesDonnees[i].getText().toString()));
                    score++;
            }
        }

        v.setText("Score : " + score + "/10");
        r.addView(v);
        table.addView(r);


        try{
            java.util.concurrent.TimeUnit.SECONDS.sleep(1);

        } catch (Exception e){

        }

    }


}