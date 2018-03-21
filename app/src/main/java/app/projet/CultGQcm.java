package app.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import app.projet.Question.Domaine;

public class CultGQcm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultutre_gqcm);

        final Domaine d = (Domaine) getIntent().getSerializableExtra(CultGQCMOpt.DOMAINE);
        setTitle(d.toString() + " - QCM");

        TableLayout table = (TableLayout) findViewById(R.id.cultG_qcm_table_layout);

        List<Question> q = QuestionDAO.questionsFromDomaine(d, 5);

        for (int i = 0; i < q.size(); i++){
            // Creation d'une nouvelle ligne
            TableRow r = new TableRow(this);

            // Creation d'une nouvelle TextView
            TextView v = new TextView(this);
            v.setText(q.size() + q.get(i).getEnnonce());

            r.addView(v);
            table.addView(r);
        }

    }
}
