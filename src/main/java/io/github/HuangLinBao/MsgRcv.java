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
                Socket clientSocket = new Socket(Controller.aux_tcpIp.getText(), Integer.parseInt(Controller.aux_tcpPort.getText()));
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                msgReceive = inFromServer.readLine();
                if (msgReceive.contains(",")) {
                    msg = msgReceive.split(",");
                    Controller.sb.append(msg[0]).append("\n");
                    Controller.aux_shown_msg.setText(Controller.sb.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
