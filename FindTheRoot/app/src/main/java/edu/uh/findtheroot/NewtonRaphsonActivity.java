package edu.uh.findtheroot;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewtonRaphsonActivity extends Activity {

    TextView eqTextView;
    ArrayList<Double> coefficients;
    ArrayList<Integer> exponents;
    private final static String TAG = "NewtonRaphson";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton_raphson);
        eqTextView = (TextView) findViewById(R.id.textViewEquation);
        final EditText guess = (EditText) findViewById(R.id.editTextGuess);
        final EditText tolerance = (EditText) findViewById(R.id.editTextTolerance);
        final EditText iterations = (EditText) findViewById(R.id.editTextIterations);
        final TextView computedValueTextView = (TextView) findViewById(R.id.textViewComputedValue);
        coefficients = (ArrayList<Double>) getIntent().getSerializableExtra("coefficients");
        exponents = getIntent().getIntegerArrayListExtra("exponents");
        String eq = getIntent().getStringExtra("equation");
        if (eq == null) {
            eq = "";
        }
        eqTextView.setText(Html.fromHtml(eq));

        Button btnSolve = (Button) findViewById(R.id.buttonSolve);
        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // compute the answer
                EquationBuilder equationBuilder = new EquationBuilder(coefficients, exponents);
                NewtonRaphson newtonRaphson = new NewtonRaphson(equationBuilder);
                double computedValue = newtonRaphson.compute(
                        getDoubleFromString(guess.getText().toString()),
                        getDoubleFromString(tolerance.getText().toString()),
                        getDoubleFromString(iterations.getText().toString())
                );

                Log.d(TAG, "value: " + computedValue);
                computedValueTextView.setText(""+computedValue);
            }
        });
    }

    private double getDoubleFromString(String number) {
        if(number.length() <= 0) {
            return 0;
        }
        else {
            try {
                double num = Double.parseDouble(number);
                return num;
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage());
                return 0;
            }

        }
    }
}
