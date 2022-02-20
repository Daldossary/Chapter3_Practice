package com.example.chapter3_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String chosen;
    double total;
    int entered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bttnCost = (Button) findViewById(R.id.bttnCost);
        final Spinner bands = (Spinner) findViewById(R.id.bands);
        final EditText enteredNum = (EditText) findViewById(R.id.ticketNum);
        final TextView finalCost = (TextView) findViewById(R.id.finalCost);
        final DecimalFormat dformat = new DecimalFormat("$#.#");
        Toast toast = new Toast(MainActivity.this);

        bttnCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosen = bands.getSelectedItem().toString();
                entered = Integer.parseInt(enteredNum.getText().toString());
                if(chosen.equals("Life Revealed")) {
                    total = entered * 25.99;
                } else if(chosen.equals("Zig Zag")) {
                    total = entered * 35.99;
                } else if(chosen.equals("Spatial Sense")) {
                    total = entered * 45.99;
                }

                finalCost.setText("Total cost is: " + dformat.format(total));
                toast.setText("Calculated!");
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}