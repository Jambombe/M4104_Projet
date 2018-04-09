package app.projet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static android.os.SystemClock.sleep;

public class CreerCompte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_compte);

        final EditText prenomET = (EditText) findViewById(R.id.activity_creer_compte_prenom);
        final EditText nomET = (EditText) findViewById(R.id.activity_creer_compte_nom);

        final String prenom = prenomET.getText().toString();
        final String nom = nomET.getText().toString();

        final Button valider = (Button) findViewById(R.id.activity_creer_compte_validerBtn);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<User> users = UserDAO.allUsers();

                boolean alreadyExist = false; // True si l'utilisateur saisi existe déjà

                for (int i = 0; i < users.size(); i++){
                    if (prenom.equalsIgnoreCase(users.get(i).getPrenom()) && nom.equalsIgnoreCase(users.get(i).getNom())){
                        alreadyExist = true;
                        break;
                    }
                }

                if (! alreadyExist) { // L'utilisateur n'existe pas, on le crée

                    User u = new User(prenomET.getText().toString(), nomET.getText().toString(), "image");
                    u.save();

                    Toast t = Toast.makeText(getApplicationContext(), "Utilisateur créé avec succès !", Toast.LENGTH_LONG);
                    t.show();

                    sleep(3);
                    CreerCompte.super.finish(); // Terminer l'activité après création du l'utilisateur
                } else { // L'utilisateur existe , on ne le crée pas
                    Toast t = Toast.makeText(getApplicationContext(), "Cet utilisateur existe déjà", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }
}
