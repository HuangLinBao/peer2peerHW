package io.github.HuangLinBao;
import java.io.IOException;
import java.util.*;
import java.net.*;

public class ReceiverThread extends Thread {

        public void run() {
            try {
                DatagramSocket clientSocket = new DatagramSocket(6969);
                while (true) {
                    byte[] receivedData = new byte[1024];
                    DatagramPacket receivePacket =
                            new DatagramPacket(receivedData, receivedData.length);

                    clientSocket.receive(receivePacket);
                    String sentence = new String(receivePacket.getData());
                    Controller.sb.append(sentence).append("\n");
                    Controller.send_msg.setText(Controller.sb.toString());


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
