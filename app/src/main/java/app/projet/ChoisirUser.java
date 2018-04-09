package app.projet;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChoisirUser extends AppCompatActivity {

    public static int numUserCourant;
    protected static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_user);

        TableLayout table = (TableLayout) findViewById(R.id.choisirUser_table_layout);
        final TableRow[] listeUsers = new TableRow[5];

        users = new ArrayList<>();
        final List<User> u = UserDAO.allUsers();

        try{ // try / catch pour eviter que l'appli crash s'il n'existe pas d'utilisateur
            users = UserDAO.allUsers();
        } catch (Exception e){}

        if (users.size() == 0){ // Si il n'y a pas d'utilisateurs, on le signale
            TextView erreur = new TextView(this);
            erreur.setText("Aucun utilisateur enregistré");
            table.addView(erreur);

        } else { // Il existe au moins 1 utilisateur

            // On les affiche tous
            for (int i = 0; i < users.size(); i++){

                listeUsers[i] = new TableRow(this);
                listeUsers[i].setBackground(ContextCompat.getDrawable(getApplicationContext() ,R.drawable.cell_border));
                listeUsers[i].setPadding(30,30,30,30);
                TextView t = new TextView(this);
                t.setText(users.get(i).getPrenom() + " " + users.get(i).getNom());
                listeUsers[i].addView(t);
                table.addView(listeUsers[i]);

                numUserCourant = i;

                listeUsers[i].setOnClickListener(new View.OnClickListener() {
                    int userID = numUserCourant +1; // Permet d'enregistrer l'id de l'utilisateur courant

                    @Override
                    public void onClick(View v) {
                        Intent listeDisciplinesAct = new Intent(ChoisirUser.this, ListeDisciplines.class);
                        listeDisciplinesAct.putExtra(MainActivity.MAIN_ACTIVITY_USERID, userID);

                        startActivity(listeDisciplinesAct);
                    }
                });
            }

        }

    }
}
