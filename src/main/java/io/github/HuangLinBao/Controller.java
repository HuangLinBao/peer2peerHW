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
     JFXTextArea shown_msgs;
    @FXML
    static JFXTextArea send_msg;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton Button_login;

    static StringBuilder sb = new StringBuilder();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       new ReceiverThread().start();


    }


    public void print(ActionEvent actionEvent) throws IOException {

        new SenderThread().start();

        sb.append("Ayyy: ").append(send_msg.getText()).append("\n");
        shown_msgs.setText(sb.toString());
        send_msg.clear();
    }
}





