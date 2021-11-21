package io.github.HuangLinBao;

import java.net.*;
import java.util.*;
import java.io.*;


import com.jfoenix.controls.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class Controller implements Initializable {
    @FXML
    private JFXTextArea shown_msgs,send_msg;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton Button_login;

    StringBuilder sb = new StringBuilder();
    ServerThread sv;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set Label's text intialize() is called
        try {
            sv = new ServerThread("192.168.122.1");

                sv.start();
                String msg;
                msg = sv.getReceivedMsg();
                if(msg != null) {
                    sb.append("Madd: ").append(msg).append("\n");
                    shown_msgs.setText(sb.toString());
                }


            } catch(UnknownHostException | SocketException e){
                e.printStackTrace();
            }


        // Set Label's text on Button's action


    }


    public void print(ActionEvent actionEvent) throws IOException {
        ClientThread ct = new ClientThread(send_msg.getText(),"192.168.122.1");

        ct.send();
        ct.closeSocket();





        sb.append("Ayyy: ").append(send_msg.getText()).append("\n");
        shown_msgs.setText(sb.toString());
        send_msg.clear();
    }
}
