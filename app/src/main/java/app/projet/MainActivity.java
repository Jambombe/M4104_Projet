package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ACTIVITY_PRENOM = "prenom";
    public static final String MAIN_ACTIVITY_NOM = "nom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button connexion = (Button) findViewById(R.id.activity_main_connectBtn);
        final Button creerUser = (Button) findViewById(R.id.activity_main_createAccountBtn);
        final Button connexionInvite = (Button) findViewById(R.id.activity_main_inviteBtn);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choisirUserAct = new Intent(MainActivity.this, ChoisirUser.class);

                startActivity(choisirUserAct);
            }
        });

        creerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creerUserAct = new Intent(MainActivity.this, CreerCompte.class);

                startActivity(creerUserAct);
            }
        });

        connexionInvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creerUserAct = new Intent(MainActivity.this, ListeDisciplines.class);

                startActivity(creerUserAct);
            }
        });

        // Sauvegarde users
        List<User> u = UserDAO.allUsers();

        // Permet de reset la db
        SugarContext.terminate();
        SchemaGenerator schemaGenerator = new SchemaGenerator(getApplicationContext());
        schemaGenerator.deleteTables(new SugarDb(getApplicationContext()).getDB());
        SugarContext.init(getApplicationContext());
        schemaGenerator.createDatabase(new SugarDb(getApplicationContext()).getDB());

        for (int i = 0; i < u.size(); i++){
            u.get(i).save();
        }

        QuestionDAO.updateDB();
        UserDAO.updateDB();

    }
}
