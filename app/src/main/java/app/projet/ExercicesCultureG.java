package app.projet;

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















        ///// INFO BULLE BOUTONS D'AIDE /////

        Button qcmHelp = (Button) findViewById(R.id.activity_exercices_cultureG_qcmHelp);
        qcmHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "Répondre correctement aux 10 questions proposées.\nUne seule réponse correcte par question.";
                Toast t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
                t.show();
            }
        });
    }
}
