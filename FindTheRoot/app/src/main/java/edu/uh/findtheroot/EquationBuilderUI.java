
package edu.uh.findtheroot;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EquationBuilderUI extends Activity {

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonX,
            buttonExp, buttonDot , buttonC , buttonEqual;
    TextView eqTextView;
    String equationText = "";
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
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        eqTextView = (TextView) findViewById(R.id.eqView);

        equationText = "";



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "1";
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
                equationText += "3";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "4";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "5";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "6";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "7";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "8";
                eqTextView.setText(Html.fromHtml(equationText));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equationText += "9";
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
        
    }

    private void updateButtonStatusOnExponent(boolean status) {
        buttonAdd.setEnabled(status);
        buttonSub.setEnabled(status);
        button0.setEnabled(status);
        buttonDot.setEnabled(status);
        buttonX.setEnabled(status);
        buttonEqual.setEnabled(status);
        buttonExp.setEnabled(status);
        buttonC.setEnabled(status);
    }
}
