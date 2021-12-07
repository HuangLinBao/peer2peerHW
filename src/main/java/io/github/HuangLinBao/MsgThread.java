package io.github.HuangLinBao;
import java.io.*;
import java.net.*;
public class MsgThread extends Thread{


    @Override
    public  void run(){
        String msgSend,X;
        String[] msg;
        String IP = Controller.aux_tcpIp.getText();
        byte[] ip = IP.getBytes();
            try {
                Socket clientSocket = new Socket(InetAddress.getByAddress(ip),Integer.parseInt(Controller.aux_tcpPort.getText()));
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

                msgSend = Controller.aux_username.getText() + ": " + Controller.aux_send_msg.getText() + "," + Controller.remote_ip.getText() + "," + Controller.remote_port.getText();
                outToServer.writeBytes(msgSend+"\n");
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

