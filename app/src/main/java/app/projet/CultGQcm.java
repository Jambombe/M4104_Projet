package app.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.projet.Question.Domaine;

import static java.util.Collections.shuffle;

public class CultGQcm extends AppCompatActivity {

    public int numQuestion = 0;
    public List<Question> q;
    public int reponsesCorrectes = 0; // Nb réponses correctes (qui correspond au score)
    public boolean exerciceTermine = false; // True si l'exercice est tertminé, faux sinon

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultutre_gqcm);

        final int userID = getIntent().getExtras().getInt(MainActivity.MAIN_ACTIVITY_USERID);

        final Domaine d = (Domaine) getIntent().getSerializableExtra(CultGQCMOpt.DOMAINE);
        setTitle(d.toString() + " - QCM");

        TableLayout table = (TableLayout) findViewById(R.id.cultG_qcm_table_layout);

        q = QuestionDAO.questionsFromDomaine(d, 10); // 5 questions aléatoires du domaine d

        afficherQuestion(0); // Affichage de la 1re question

        final Button nextValider = (Button) findViewById(R.id.cultG_qcm_btn);
        nextValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numQuestion < 3){ // Les 3 premières questions
                    corrigerQuestion(numQuestion); // Correction de la question
                    numQuestion++; // Question suivante
                    afficherQuestion(numQuestion); // Afficher la question
                } else if (numQuestion == 3){ // 4e question
                    corrigerQuestion(numQuestion);
                    numQuestion++;
                    afficherQuestion(numQuestion);
                    nextValider.setText("Terminer");
                } else { // dernière question et +
                    if (! exerciceTermine) { // L'exercice n'ets pas encore terminé
                        corrigerQuestion(numQuestion);
                        TextView ennonce = (TextView) findViewById(R.id.cultG_qcm_ennonce);
                        ennonce.setText("Score final : " + reponsesCorrectes + "/5");
                        RadioGroup rg = (RadioGroup) findViewById(R.id.cultG_qcm_radioGroup);
                        rg.removeAllViews();

                        if (userID != User.ID_INVITE) { // Si l'user est invité
                            final User us = UserDAO.getUserFromId(userID);
                            int idMatiere = -1;
                            switch (d) {
                                case FRANCAIS:
                                    idMatiere = Question.ID_CG_FR;
                                    break;
                                case GEO:
                                    idMatiere = Question.ID_CG_GEO;
                                    break;
                                case HISTOIRE:
                                    idMatiere = Question.ID_CG_HIST;
                                    break;
                            }

                            us.setBestScore(idMatiere, reponsesCorrectes); // Enregistrer le nouveau score effectué

                        }
                    } else if (exerciceTermine) { // Un nouveau clic sur le bouton Terminer met fin à l'activité
                        setResult(RESULT_OK);
                        CultGQcm.super.finish();
                    }

                    exerciceTermine = true;
                }


            }
        });

    }

    /**
     * Affiche la question numéro numQuestion
     * @param numQuestion Numéro de la question à afficher
     */
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

        // Affichage des propositions de réponse
        r1.setText(reponses.get(0));
        r2.setText(reponses.get(1));
        r3.setText(reponses.get(2));

    }

    /**
     * Correction de la question numéro numQuestion
     * @param numQuestion numéro de la question à corriger
     */
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
