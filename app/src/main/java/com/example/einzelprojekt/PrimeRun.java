package com.example.einzelprojekt;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class PrimeRun implements Runnable {
    String matrikelnummer;
    String backValue;

    PrimeRun(String matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(matrikelnummer + '\n');

            backValue = inFromServer.readLine();

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
