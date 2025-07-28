package br.com.ernando.sockets.tcp;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5001);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String entradaServidor = "";
        String entradaUsuario = JOptionPane.showInputDialog("Type the message:");
        while (!entradaUsuario.equalsIgnoreCase("end")) {
            out.println(entradaUsuario);
            entradaServidor = in.readLine();
            entradaUsuario = JOptionPane.showInputDialog("Arrived: " + entradaServidor + "Type to send: ");
        }
        out.close();
        in.close();
        socket.close();
    }
}
