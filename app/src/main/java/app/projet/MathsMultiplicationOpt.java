package app.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MathsMultiplicationOpt extends AppCompatActivity {

    public static final String MATHS_MULT_NUM_TABLE = "numTable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_multiplication_opt);

        final Button valider = (Button) findViewById(R.id.MathsMultOpt_validerBtn);
        final Spinner tables = (Spinner) findViewById(R.id.mathsMultOpt_tables);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent multAct = new Intent(MathsMultiplicationOpt.this, MathsMultiplications.class);
                multAct.putExtra(MATHS_MULT_NUM_TABLE, tables.getSelectedItem().toString());

                startActivity(multAct);
            }
        });
    }
}
