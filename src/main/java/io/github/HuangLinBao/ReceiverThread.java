package io.github.HuangLinBao;
import java.io.IOException;
import java.util.*;
import java.net.*;

public class ReceiverThread extends Thread {

        public void run() {
            try {
//                Controller.onlineUsers.append(Controller.aux_username.getText()).append(" - ").append(InetAddress.getLocalHost().getHostAddress()).append("\n");
//                Controller.aux_online_list.setText(Controller.onlineUsers.toString());
                DatagramSocket clientSocket = new DatagramSocket(6960);
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
