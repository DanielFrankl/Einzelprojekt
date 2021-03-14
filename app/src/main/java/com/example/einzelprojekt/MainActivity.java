package com.example.einzelprojekt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abschickenClick(View v) throws InterruptedException {
        textView = findViewById(R.id.txtMatrikelNr);

        PrimeRun primeRun = new PrimeRun(textView.getText().toString());
        new Thread(primeRun).start();
        Thread.sleep(200);
        message = primeRun.backValue;

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Auswertung");
        msg.setMessage(message);
        msg.setCancelable(true);

        AlertDialog msgDialog = msg.create();
        msgDialog.show();
    }

    public void berechnungClick(View v) {
        textView = findViewById(R.id.txtMatrikelNr);

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Deine Matrikelnummer enthält folgende Primzahl/en:");
        msg.setMessage(primeNumbers(textView.getText().toString()));
        msg.setCancelable(true);

        AlertDialog msgDialog = msg.create();
        msgDialog.show();
    }


    public String primeNumbers(String matrikelnummer) {
        String primeNumbers = "";
        char[] matrikelnumber = matrikelnummer.toCharArray();
        for (int i = 0; i < matrikelnumber.length; i++) {
            if (matrikelnumber[i] == 50 || matrikelnumber[i] == 51 || matrikelnumber[i] == 55) {
                primeNumbers = primeNumbers.concat(String.valueOf(matrikelnumber[i]));
            }
        }
        return primeNumbers;
    }


}