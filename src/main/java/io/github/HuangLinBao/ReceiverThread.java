package io.github.HuangLinBao;
import java.io.IOException;
import java.util.*;
import java.net.*;

public class ReceiverThread extends Thread {

        public void run() {
            try {
                Controller.onlineUsers.append(Controller.aux_username.getText()).append(" - ").append(Controller.local_ip.getText()).append("\n");
                Controller.aux_online_list.setText(Controller.onlineUsers.toString());
                DatagramSocket clientSocket = new DatagramSocket(Integer.parseInt(Controller.local_port.getText()));
                    while (true) {
                        byte[] receivedData = new byte[1024];
                        DatagramPacket receivePacket =
                                new DatagramPacket(receivedData, receivedData.length);

                        clientSocket.receive(receivePacket);
                        String sentence = new String(receivePacket.getData());
                        Controller.sb.append(sentence).append("\n");
                        Controller.aux_shown_msg.setText(Controller.sb.toString());

                    }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
