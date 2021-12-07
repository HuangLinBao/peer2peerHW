package io.github.HuangLinBao;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.*;
import java.nio.file.*;


public class SenderThread extends Thread {

    public void run() {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(Controller.remote_ip.getText());//VM server IP
            byte[] sendData;
            if(Controller.sentFile != null){
                String sentence = readFile(Controller.sentFile.getAbsolutePath());
                sendData = sentence.getBytes();
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(Controller.local_port.getText()));
                clientSocket.send(sendPacket);
                return;
            }

            String sentence  =Controller.aux_username.getText()+": " +Controller.aux_send_msg.getText();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(Controller.local_port.getText()));

            clientSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String readFile(String path)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.US_ASCII);
    }
}