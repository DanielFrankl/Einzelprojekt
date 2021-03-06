package com.example.einzelprojekt;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws Exception {
        int matrikelnummer;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("hostname", 53212);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));

        matrikelnummer = inFromUser.read();

        outToServer.writeByte(matrikelnummer+'\n');

        System.out.println("FROM SERVER: " + matrikelnummer);

        clientSocket.close();
    }

}
