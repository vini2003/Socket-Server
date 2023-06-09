package dev.vini2003.unisul;

import javax.swing.*;
import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Socket socket;

            var port = Integer.parseInt(JOptionPane.showInputDialog("Digite a porta: "));

            try (var servidor = new ServerSocket(port)) {
                System.out.println("Aguardando cliente!");
                // espera
                socket = servidor.accept();
            }

            System.out.println("Chegou o cliente :" + socket.getInetAddress().getHostAddress());

            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            var mensagem = "";

            while ((mensagem = in.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}