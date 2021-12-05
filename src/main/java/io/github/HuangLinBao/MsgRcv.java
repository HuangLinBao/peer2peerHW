package io.github.HuangLinBao;
import java.io.*;
import java.net.*;

public class MsgRcv extends Thread{
    @Override
    public void run(){
        String msgReceive;
        String[] msg;

        try {
            while (true) {
                Socket connectionSocket = OnlineReceiverThread.welcomeSocket.accept();
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                msgReceive = inFromServer.readLine();
                    Controller.sb.append(msgReceive.trim()).append("\n");
                    Controller.aux_shown_msg.setText(Controller.sb.toString());


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
