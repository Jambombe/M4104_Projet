package app.projet;


import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TableLayout;
        import android.widget.TableRow;
        import android.widget.TextView;

public class MathsMultiplications extends AppCompatActivity {

    boolean exerciceTermine = false;
    final EditText[] tabEditText = new EditText[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_multiplications);

        // Récupération du numéro de table choisi
        final int numTable = Integer.parseInt(getIntent().getStringExtra(MathsMultiplicationOpt.MATHS_MULT_NUM_TABLE));

        TableLayout table = (TableLayout) findViewById(R.id.mathsMult_table_layout);

        // Creation des lignes
        for (int i = 1; i <= 10; i++){

            // Creation d'une nouvelle ligne
            TableRow r = new TableRow(this);

            // Creation d'une nouvelle TextView
            TextView v = new TextView(this);
            v.setTextAppearance(this, android.R.style.TextAppearance_DeviceDefault_Large); // Changer style police
            v.setText(numTable + " x " + i + " = "); // Changer texte affiché
            r.addView(v); // Ajouter la nouvelle vue à sa ligne

            tabEditText[i] = new EditText(this); // Nouveau EditText
            //tabEditText[i].setId(new Integer(i)); // Assignation d'un id
            r.addView(tabEditText[i]); // Ajouter un TextEdit

            table.addView(r);// Ajouter la ligne à la TableRow
        }

        Button valider = (Button) findViewById(R.id.mathsMult_validerBtn);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (! exerciceTermine){
                    verifierReponses(numTable);
                    Button valider = (Button) findViewById(R.id.mathsMult_validerBtn);
                    valider.setText("Terminer");
                    exerciceTermine = true;
                } else {
                    setResult(RESULT_OK);
                    MathsMultiplications.super.finish();
                }

            }
        });


    }

    /**
     * Vérifie les réponses données et renvoie le score effectué
     * @return score : nombre de réponses correctes
     */
    public void verifierReponses(int numTable){

        int score = 0;

        for (int i = 1; i <= 10; i++) {
            if (numTable * i == Integer.parseInt(tabEditText[i].getText().toString())){
                score++;
            }
        }

        final int userID = getIntent().getExtras().getInt(MainActivity.MAIN_ACTIVITY_USERID);
        if (userID != User.ID_INVITE){
            UserDAO.getUserFromId(userID).setBestScore(Question.ID_MATH_MULT, score); // Sauvegarde du score
        }

        TextView v = new TextView(this);
        v.setText("Score : " + score + "/10");
        TableLayout table = (TableLayout) findViewById(R.id.mathsMult_table_layout);
        table.addView(v);
    }
}