package app.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.projet.Question.Domaine;

import static java.util.Collections.shuffle;

public class CultGQcm extends AppCompatActivity {

    public int numQuestion = 0;
    public List<Question> q;
    public int reponsesCorrectes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultutre_gqcm);

        final Domaine d = (Domaine) getIntent().getSerializableExtra(CultGQCMOpt.DOMAINE);
        setTitle(d.toString() + " - QCM");

        TableLayout table = (TableLayout) findViewById(R.id.cultG_qcm_table_layout);

        q = QuestionDAO.questionsFromDomaine(d, 5); // 5 questions aléatoires

        afficherQuestion(0);

        final Button nextValider = (Button) findViewById(R.id.cultG_qcm_btn);
        nextValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numQuestion < 3){
                    corrigerQuestion(numQuestion); // Correction de la question
                    numQuestion++; // Question suivante
                    afficherQuestion(numQuestion); // Afficher la question
                } else if (numQuestion == 3){
                    corrigerQuestion(numQuestion);
                    numQuestion++;
                    afficherQuestion(numQuestion);
                    nextValider.setText("Terminer");
                } else {
                    corrigerQuestion(numQuestion);
                    TextView ennonce = (TextView) findViewById(R.id.cultG_qcm_ennonce);
                    ennonce.setText("Score final : " + reponsesCorrectes + "/5");
                    RadioGroup rg = (RadioGroup) findViewById(R.id.cultG_qcm_radioGroup);
                    rg.removeAllViews();
                }


            }
        });

//        for (int i = 0; i < q.size(); i++){
//            // Creation d'une nouvelle ligne
//            TableRow r = new TableRow(this);
//
//            // Creation d'une nouvelle TextView
//            TextView v = new TextView(this);
//            v.setText(q.size() + q.get(i).getEnnonce());
//
//            r.addView(v);
//            table.addView(r);
//        }

    }

    public void afficherQuestion(int numQuestion){

        resetRadioButtons();

        TextView ennonce = (TextView) findViewById(R.id.cultG_qcm_ennonce);
        RadioButton r1 = (RadioButton) findViewById(R.id.cultG_qcm_radioBtn1);
        RadioButton r2 = (RadioButton) findViewById(R.id.cultG_qcm_radioBtn2);
        RadioButton r3 = (RadioButton) findViewById(R.id.cultG_qcm_radioBtn3);

        // Affichage ennoncé
        ennonce.setText(q.get(numQuestion).getEnnonce());

        // Récupératon des reponses
        List<String> reponses = new ArrayList<>();
        reponses.add(q.get(numQuestion).getReponseCorrecte());
        reponses.add(q.get(numQuestion).getReponseIncorrecte1());
        reponses.add(q.get(numQuestion).getReponseIncorrecte2());
        shuffle(reponses);

        // Affichage des réponses
        r1.setText(reponses.get(0));
        r2.setText(reponses.get(1));
        r3.setText(reponses.get(2));

    }

    public void corrigerQuestion(int numQuestion){

        RadioGroup rg = (RadioGroup) findViewById(R.id.cultG_qcm_radioGroup);
        int id = rg.getCheckedRadioButtonId();

        if (id != -1){ // le radio bouton recherché existe
            RadioButton rb = (RadioButton) findViewById(id);
            String reponseDonnee = rb.getText().toString();

            if (reponseDonnee == q.get(numQuestion).getReponseCorrecte()){ // Si la reponse est correcte, score++
                reponsesCorrectes++;
            }
        }

    }

    /**
     * Permet de déselectionner tout les boutons radio
     */
    public void resetRadioButtons(){
        RadioGroup rg = (RadioGroup) findViewById(R.id.cultG_qcm_radioGroup);

        rg.clearCheck();
    }
}
