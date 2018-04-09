package app.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);


        final int userID = getIntent().getExtras().getInt(MainActivity.MAIN_ACTIVITY_USERID);

        final User u = UserDAO.getUserFromId(userID);

        final TableLayout table = (TableLayout) findViewById(R.id.scores_table_layout);
        final List scores = u.getAllScoresString();

        for (int i = 0; i < scores.size(); i++) {

            TableRow r = new TableRow(this);
            TextView e = new TextView(this);
            e.setText(scores.get(i).toString());
            r.addView(e);
            table.addView(r);

        }

    }
}
