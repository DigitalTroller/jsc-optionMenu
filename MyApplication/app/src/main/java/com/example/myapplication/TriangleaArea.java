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

public class TriangleaArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trianglea_area);


        Button button = findViewById(R.id.button);
        EditText a = findViewById(R.id.a);
        EditText b = findViewById(R.id.b);
        EditText c = findViewById(R.id.c);
        TextView lbl = findViewById(R.id.myLabel);

        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class
        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (a.getText().toString().equals("") || b.getText().toString().equals("")|| c.getText().toString().equals("")) {
                    Snackbar.make(view, "One of the numbers is not inputted", BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }
                Double sidea = Double.parseDouble(a.getText().toString());
                Double sideb = Double.parseDouble(b.getText().toString());
                Double sidec = Double.parseDouble(c.getText().toString());
                Double p = (sidea+sideb+sidec)/2;
                Double Area = Math.sqrt(p*(p-sidea)*(p-sideb)*(p-sidec));
                Snackbar.make(view, "The Area is: " + Area, BaseTransientBottomBar.LENGTH_LONG).show();
                lbl.setText("The Area is: " + Math.round(Area * 1000.0) / 1000.0);
                String answer = "The Area is: " + Math.round(Area * 1000.0) / 1000.0;
                intent.putExtra("answer",answer);
            }

        });

        Button btnSave = findViewById(R.id.save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }
}