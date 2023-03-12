package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class Deposit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        Button button = findViewById(R.id.save);
        EditText initial = findViewById(R.id.initial);
        EditText rate = findViewById(R.id.rate);
        EditText years = findViewById(R.id.years);

        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class
        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (initial.getText().toString().equals("") || rate.getText().toString().equals("")|| years.getText().toString().equals("")) {
                    Snackbar.make(view, "One of the numbers is not inputted", BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }
                Double init = Double.parseDouble(initial.getText().toString());
                Double percentRate = Double.parseDouble(rate.getText().toString());
                Double yearsTime = Double.parseDouble(years.getText().toString());
                Double a = init*Math.pow((1+((percentRate/100)/12)), 12*yearsTime);
                Snackbar.make(view, "The total savings will be: " + Math.round(a * 1000.0) / 1000.0, BaseTransientBottomBar.LENGTH_LONG).show();
                String answer = "The total savings will be: " + Math.round(a * 1000.0) / 1000.0;
                intent.putExtra("answer",answer);
                startActivity(intent);
            }

        });
    }
}