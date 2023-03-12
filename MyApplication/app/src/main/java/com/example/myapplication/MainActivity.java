package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView lbl = findViewById(R.id.myLabel);
//        lbl.setText("Samsung Campus");



        Intent intent1 = getIntent();
        String answer = intent1.getStringExtra("answer");
        lbl.setText(answer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Toast.makeText(this, "items clicked " + item.getTitle(), Toast.LENGTH_LONG).show();
        if(item.getItemId() == R.id.simpleCalc){
            startActivity(new Intent(
                    getApplicationContext(), CalcActivity.class
            ));
        } else if (item.getItemId() == R.id.triangleArea) {
            startActivity(new Intent(
                    getApplicationContext(), TriangleaArea.class
            ));
        } else if (item.getItemId() == R.id.deposit) {
            startActivity(new Intent(
                    getApplicationContext(), Deposit.class
            ));
        }
        return super.onOptionsItemSelected(item);
    }

}