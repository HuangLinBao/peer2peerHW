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
  }

  @Override
  public void run() {
      try {
          this.serverSocket = new DatagramSocket(8080);

          while (true) {
              DatagramPacket receivePacket =
                      new DatagramPacket(this.receiveData, this.receiveData.length);
              this.serverSocket.receive(receivePacket);
              receivedMsg = new String(receivePacket.getData()).trim();
          }
          //UDP server receives packet


      } catch (SocketException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }

  }

    public String getReceivedMsg() {
        return receivedMsg;
    }
}
