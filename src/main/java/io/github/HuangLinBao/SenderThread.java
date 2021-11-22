package io.github.HuangLinBao;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderThread extends Thread {

    public void run() {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(Controller.remote_ip.getText());//VM server IP
            byte[] sendData;
            String sentence  =Controller.aux_username.getText()+": " +Controller.aux_send_msg.getText();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(Controller.local_port.getText()));

            clientSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}