package com.example.einzelprojekt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abschickenClick(View v){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Primzahlen in deiner Matrikelnummer");
        msg.setMessage("");
        msg.setCancelable(true);

        AlertDialog msgDialog = msg.create();
        msgDialog.show();
    }

}