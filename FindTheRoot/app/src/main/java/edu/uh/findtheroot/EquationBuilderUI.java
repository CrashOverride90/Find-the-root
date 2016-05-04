
package edu.uh.findtheroot;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Debug;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationBuilderUI extends Activity {

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonX,
            buttonExp, buttonDot , buttonC , buttonNext;
    TextView eqTextView;
    String equationText;
    private static final String TAG = "EquationBuilderActivity";
    public static final String PREFS_NAME = "localPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_builder_ui);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonExp = (Button) findViewById(R.id.buttonExp);
        buttonX = (Button) findViewById(R.id.buttonX);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        eqTextView = (TextView) findViewById(R.id.eqView);
        equationText = "";

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>1</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "1";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>2</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "2";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>3</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "3";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>4</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "4";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>5</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "5";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>6</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "6";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>7</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "7";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>8</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "8";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonExp.isSelected() == true) {
                    equationText += "<sup>9</sup>";
                    buttonExp.setSelected(false);
                    updateButtonStatusOnExponent(true);
                }
                else {
                    equationText += "9";
                }
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "0";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "x";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonExp.setSelected(true);
                updateButtonStatusOnExponent(false);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += " + ";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += " - ";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText = "";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNextScreen();
            }
        });
        
    }

    private ArrayList<Double> processText(String regex, String text) {
        ArrayList<Double> coefficients = new ArrayList<Double>();
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(text);
        while (matcher.find())
        {
            String xterm = matcher.group(1);
//            Log.d(TAG, "xterm = " + xterm);
            coefficients.add(Double.parseDouble(xterm));
        }
        String last = ""+text.charAt(text.length()-1);
        coefficients.add(Double.parseDouble(last));
        return coefficients;
    }


    private void loadNextScreen() {

//        ArrayList<Double> coeffs = processText("([0-9]*\\.?[0-9]+)(\\d*[x])", "2.5x<sup>3.5</sup> + 3x<sup>2</sup> + 5x + 3");
        String regex = "([0-9]*\\.?[0-9]+)(\\d*[x])";
        ArrayList<Double> coeffs = processText(regex, equationText);
        Log.d(TAG, coeffs.size()+"");

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String algorithm = settings.getString("algorithm", "newton");
        if(algorithm.equals("newton")) {
            // load newton screen
        }
        else if(algorithm.equals("regulaFalsi")) {

        }
        else if(algorithm.equals("secant")) {

        }
        else if(algorithm.equals("bisection")) {

        }
    }

    private void updateButtonStatusOnExponent(boolean status) {
        buttonAdd.setEnabled(status);
        buttonSub.setEnabled(status);
        button0.setEnabled(status);
        buttonDot.setEnabled(status);
        buttonX.setEnabled(status);
        buttonNext.setEnabled(status);
        buttonExp.setEnabled(status);
        buttonC.setEnabled(status);
    }
}
