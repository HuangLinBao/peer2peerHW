package io.github.HuangLinBao;

import java.net.*;
import java.util.*;
import java.io.*;


import com.jfoenix.controls.*;
import javafx.event.*;
import javafx.fxml.*;

public class Controller implements Initializable {
    @FXML
    static
    JFXTextField aux_username;
    @FXML
    static
    JFXTextArea aux_shown_msg;
    @FXML
    static
    JFXTextArea aux_send_msg;
    @FXML
    static
    JFXTextArea aux_online_list;
    @FXML
    static
    JFXTextField local_ip;
    @FXML
    static
    JFXTextField remote_ip;
    @FXML
    static
    JFXTextField local_port;
    static
    JFXTextField remote_port;
    @FXML
    private JFXTextArea online;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton Button_login;
    @FXML
    private JFXTextArea shown_msg;
    @FXML
    private JFXTextArea send_msg;
    @FXML
    private  JFXTextField rem_port;
    @FXML
    private  JFXTextField rem_ip;
    @FXML
    private  JFXTextField loc_ip;
    @FXML
    private  JFXTextField loc_port;

    static StringBuilder sb = new StringBuilder();
    static StringBuilder onlineUsers = new StringBuilder();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Controller.aux_send_msg = send_msg;
        Controller.aux_shown_msg = shown_msg;
        Controller.aux_online_list = online;
        Controller.aux_username = username;
        Controller.local_ip = loc_ip;
        Controller.local_port = loc_port;
        Controller.remote_ip = rem_ip;
        Controller.remote_port = rem_port;


    }

    public void connect (){
        new ReceiverThread().start();
    }


    public void print(ActionEvent actionEvent) throws IOException {
        sb.append("Ayyy: ").append(send_msg.getText()).append("\n");
        shown_msg.setText(sb.toString());
        new SenderThread().start();
    }
}





