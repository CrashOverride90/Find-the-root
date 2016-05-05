package edu.uh.findtheroot;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class NewtonRaphsonActivity extends Activity {

    TextView eqTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton_raphson);
        eqTextView = (TextView) findViewById(R.id.textViewEquation);
        ArrayList<Double> listDouble = (ArrayList<Double>) getIntent().getSerializableExtra("coefficients");
        String eq = getIntent().getStringExtra("equation");
        eqTextView.setText(Html.fromHtml(eq));
    }
}
