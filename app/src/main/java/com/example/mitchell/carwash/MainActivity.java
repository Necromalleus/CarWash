package com.example.mitchell.carwash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double exteriorWash = 8.99;
    double exteriorWashVac = 12.99;
    int numOfWashes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);      //coding for logo and icon
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //coding for buttons
        final EditText washes = (EditText) findViewById(R.id.txtNumber);
        final RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfWashes = Integer.parseInt(washes.getText().toString());
                DecimalFormat tenth = new DecimalFormat("$##.##");
                if (radioButton.isChecked()) {
                    result.setText(tenth.format(numOfWashes * exteriorWash) + " for " + numOfWashes + " washes");
                    if (numOfWashes < 12) {
                        exteriorWash = 10.99;
                        //exteriorWashVac = 25.99;

                        Toast.makeText(MainActivity.this, "Must choose 12 washes to get discount",
                                Toast.LENGTH_LONG).show();
                    } else {
                        exteriorWash = 8.99;
                    }

                }
                if (radioButton2.isChecked()) {
                    result.setText(tenth.format(numOfWashes * exteriorWashVac) + " for " + numOfWashes + " washes");
                    if (numOfWashes < 12) {
                        exteriorWashVac = 15.99;
                        Toast.makeText(MainActivity.this, "Must choose 12 washes to get discount",
                                Toast.LENGTH_LONG).show();
                    }
                }
                }
            });
        }
    }


