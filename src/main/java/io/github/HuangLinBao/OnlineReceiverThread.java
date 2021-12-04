package io.github.HuangLinBao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class OnlineReceiverThread extends Thread{
    static ServerSocket welcomeSocket;

    static {
        try {
            welcomeSocket = new ServerSocket(Integer.parseInt(Controller.local_port.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        String onlineList;
        String[] msg;

        try {
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                onlineList = inFromServer.readLine();
                if (onlineList.contains("-")) {
                    Controller.onlineUsers.append(onlineList).append("\n");
                    Controller.aux_online_list.setText(Controller.onlineUsers.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
