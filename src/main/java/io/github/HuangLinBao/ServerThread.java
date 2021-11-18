package io.github.HuangLinBao;
import java.io.IOException;
import java.util.*;
import java.net.*;

public class ServerThread extends Thread{
  private  DatagramSocket serverSocket ;
  private  InetAddress IPAddress;
  private String receivedMsg;
  private byte[] receiveData = new byte[1024];//packet arrays

  public ServerThread(String IP) throws UnknownHostException, SocketException {
      this.IPAddress = InetAddress.getByName(IP);
      this.serverSocket =new DatagramSocket();
  }

  @Override
    public void run() {
      while (true) {
          DatagramPacket receivePacket =
                  new DatagramPacket(receiveData, receiveData.length);//UDP server receives packet
          try {
              serverSocket.receive(receivePacket);
          } catch (IOException e) {
              e.printStackTrace();
          }

          this.receivedMsg = new String(receivePacket.getData()).trim();
      }
  }

    public String getReceivedMsg() {
        return receivedMsg;
    }
}
