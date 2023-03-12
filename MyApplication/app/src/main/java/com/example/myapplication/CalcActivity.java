package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


//        Intent intent = getIntent();
//        String m = intent.getStringExtra("message");
//
//        int p = intent.getIntExtra("price", -1);
//
//        Toast.makeText(this, m+ " : " + p, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Welcome to\nsimple calculator", Toast.LENGTH_SHORT).show();

        Button btnAdd = findViewById(R.id.button1);
        Button btnSubs = findViewById(R.id.button2);
        Button btnMult = findViewById(R.id.button3);
        Button btnDiv = findViewById(R.id.button4);
        TextView lbl = findViewById(R.id.lbl);
        EditText strnumb1 = findViewById(R.id.numb1);
        EditText strnumb2 = findViewById(R.id.numb2);


        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class
        );
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (strnumb1.getText().toString().equals("") || strnumb2.getText().toString().equals("")) {
                    Snackbar.make(view, "One of the numbers is not inputted", BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }
                Double numb1 = Double.parseDouble(strnumb1.getText().toString());
                Double numb2 = Double.parseDouble(strnumb2.getText().toString());
                Snackbar.make(view, "The sum is: " + (numb1+ numb2), BaseTransientBottomBar.LENGTH_LONG).show();
                lbl.setText("The sum is: " + (numb1+ numb2));
                String answer = numb1 +"+"+numb2 + "=" + (numb1+numb2);
                intent.putExtra("answer",answer);
            }

        });

        btnSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (strnumb1.getText().toString().equals("") || strnumb2.getText().toString().equals("")) {
                    Snackbar.make(view, "One of the numbers is not inputted", BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }
                Double numb1 = Double.parseDouble(strnumb1.getText().toString());
                Double numb2 = Double.parseDouble(strnumb2.getText().toString());
                Snackbar.make(view, "The difference is: " + (numb1 - numb2), BaseTransientBottomBar.LENGTH_LONG).show();
                lbl.setText("The difference is: " + (numb1 - numb2));
                String answer = numb1 + "-" + numb2 + "=" + (numb1 - numb2);
                intent.putExtra("answer", answer);
            }

        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (strnumb1.getText().toString().equals("") || strnumb2.getText().toString().equals("")) {
                    Snackbar.make(view, "One of the numbers is not inputted", BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }
                Double numb1 = Double.parseDouble(strnumb1.getText().toString());
                Double numb2 = Double.parseDouble(strnumb2.getText().toString());
                Snackbar.make(view, "The product is: " + (numb1 * numb2), BaseTransientBottomBar.LENGTH_LONG).show();
                lbl.setText("The product is: " + (numb1 * numb2));
                String answer = numb1 + "*" + numb2 + "=" + (numb1*numb2);
                intent.putExtra("answer",answer);
            }

        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (strnumb1.getText().toString().equals("") || strnumb2.getText().toString().equals("")) {
                    Snackbar.make(view, "One of the numbers is not inputted", BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }
                Double numb1 = Double.parseDouble(strnumb1.getText().toString());
                Double numb2 = Double.parseDouble(strnumb2.getText().toString());
                Snackbar.make(view, "The ratio is: " + (numb1 / numb2), BaseTransientBottomBar.LENGTH_LONG).show();
                lbl.setText("The ratio is: " + (numb1 / numb2));
                String answer = numb1 + "/" + numb2 + "=" + (numb1/numb2);
                intent.putExtra("answer", answer);
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