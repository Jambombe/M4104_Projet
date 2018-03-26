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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_user);

        TableLayout table = (TableLayout) findViewById(R.id.choisirUser_table_layout);
        final TableRow[] listeUsers = new TableRow[5];

        List<User> users = new ArrayList<>();
        final List<User> u = UserDAO.allUsers();

        try{ // try / catch pour eviter que l'appli crash
            users = UserDAO.allUsers();
        } catch (Exception e){}

        if (users.size() == 0){
            TextView erreur = new TextView(this);
            erreur.setText("Aucun utilisateur enregistré");
            table.addView(erreur);
        } else {

            for (int i = 0; i < users.size(); i++){

                listeUsers[i] = new TableRow(this);
                listeUsers[i].setBackground(ContextCompat.getDrawable(getApplicationContext() ,R.drawable.cell_border));
                listeUsers[i].setPadding(30,30,30,30);
                TextView t = new TextView(this);
                t.setText(users.get(i).getPrenom() + " " + users.get(i).getNom());
                listeUsers[i].addView(t);
                table.addView(listeUsers[i]);

                listeUsers[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent listeDisciplinesAct = new Intent(ChoisirUser.this, ListeDisciplines.class);
//                        listeDisciplinesAct.putExtra(MainActivity.MAIN_ACTIVITY_PRENOM, u.get(i).getPrenom().toString());
//                        listeDisciplinesAct.putExtra(MainActivity.MAIN_ACTIVITY_PRENOM, u.get(i).getNom().toString());

                        startActivity(listeDisciplinesAct);
                    }
                });
            }

        }

    }
}
