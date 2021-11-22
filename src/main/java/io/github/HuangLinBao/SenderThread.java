package io.github.HuangLinBao;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderThread extends Thread {

    public void run() {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("192.168.2.104");//VM server IP
            byte[] sendData;
            String sentence  = Controller.aux_send_msg.getText();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, 6960);

            clientSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}