package app.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.os.SystemClock.sleep;

public class CreerCompte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte);

        final EditText prenom = (EditText) findViewById(R.id.activity_creer_compte_prenom);
        final EditText nom = (EditText) findViewById(R.id.activity_creer_compte_nom);

        final Button valider = (Button) findViewById(R.id.activity_creer_compte_validerBtn);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User u = new User(prenom.getText().toString(), nom.getText().toString(), "image");
                u.save();
                Toast t = Toast.makeText(getApplicationContext(), "Utilisateur créé avec succès !", Toast.LENGTH_LONG);
//                Toast t = Toast.makeText(getApplicationContext(), u.getPrenom(), Toast.LENGTH_LONG);
                t.show();

                sleep(3);
                CreerCompte.super.finish(); // Terminer l'activité après création du l'utilisateur

            }
        });

    }
}
