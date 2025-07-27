package br.com.ernando.sockets.udp;

import javax.swing.*;
import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            byte[] sendData = new byte[1024];
            InetAddress IPAdress = InetAddress.getByName("localhost");
            while (true) {
                String sentence = JOptionPane.showInputDialog("Digite: ");
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(), IPAdress, 5000);
                clientSocket.send(sendPacket);
                if(sentence.equals("fim")) {
                    break;
                }
            }
        }
    }
}
