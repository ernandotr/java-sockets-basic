package br.com.ernando.sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Servidor iniciando...");
        byte[] receiveData = new byte[1024];

        DatagramSocket serverSocket = new DatagramSocket(5000);
        DatagramPacket recevePacket =  new DatagramPacket(receiveData, receiveData.length);
        while (true) {
            serverSocket.receive(recevePacket);
            String sentence  = new String(recevePacket.getData());
            if(sentence.substring(0,3).equals("fim")) {
                break;
            }
            InetAddress IPAddress = recevePacket.getAddress();
            System.out.println("Recebido de " + IPAddress.getHostAddress() + ":" + sentence);
        }
        serverSocket.close();
    }
}
