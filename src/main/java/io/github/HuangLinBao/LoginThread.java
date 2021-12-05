package io.github.HuangLinBao;
import java.io.*;
import java.net.*;
public class LoginThread extends Thread{
    @Override
    public  void run(){
        String credentials,onlineList;
        String[] msg;

            try {
                Socket clientSocket = new Socket(Controller.aux_tcpIp.getText(),Integer.parseInt(Controller.aux_tcpPort.getText()));
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                credentials = Controller.aux_username.getText() + "-" + Controller.local_ip.getText() + "-" + Controller.local_port.getText();
                outToServer.writeBytes(credentials+"\n".trim());
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

