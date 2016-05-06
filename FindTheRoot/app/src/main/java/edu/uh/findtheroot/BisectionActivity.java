package edu.uh.findtheroot;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class BisectionActivity extends Activity {

    TextView eqTextView;
    ArrayList<Double> coefficients;
    ArrayList<Integer> exponents;
    private final static String TAG = "Bisection";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bisection);
        eqTextView = (TextView) findViewById(R.id.textViewEquationBisection);
        final EditText aValue = (EditText) findViewById(R.id.editTextAValueBisection);
        final EditText bValue = (EditText) findViewById(R.id.editTextBValueBisection);
        final EditText iterations = (EditText) findViewById(R.id.editTextIterationsBisection);
        final EditText tolerance = (EditText) findViewById(R.id.editTextToleranceBisection);
        final TextView computedValueTextView = (TextView) findViewById(R.id.txtViewValueBisection);

        coefficients = (ArrayList<Double>) getIntent().getSerializableExtra("coefficients");
        exponents = getIntent().getIntegerArrayListExtra("exponents");
        String eq = getIntent().getStringExtra("equation");
        eqTextView.setText(Html.fromHtml(eq));

        Button btnSolve = (Button) findViewById(R.id.btnSolveBisection);
        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // compute the answer
                EquationBuilder equationBuilder = new EquationBuilder(coefficients, exponents);
                Bisection equation = new Bisection(equationBuilder);
                double computedValue = equation.compute(
                        Helper.getDoubleFromString(aValue.getText().toString()),
                        Helper.getDoubleFromString(bValue.getText().toString()),
                        Helper.getDoubleFromString(tolerance.getText().toString()),
                        Helper.getDoubleFromString(iterations.getText().toString())
                );

                Log.d(TAG, "value: " + computedValue);
                computedValueTextView.setText(""+computedValue);
            }
        });

    }
}
