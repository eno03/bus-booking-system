/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import controller.Flow;
import frames.Frame;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author wint4
 */
public class Server extends Application {

    private ServerSocket serverSocket = null;
    private Socket clientSocket;
    private InetAddress inetAddress;
    private final int port = 9026;
    private static int clientNo = 0;

    @Override
    public void start(Stage primaryStage) {
        Frame frame = new Frame();
        Scene scene = new Scene(frame, 485, 188);
        Controller.getInstance().setPrimaryStage(primaryStage);
        Controller.getInstance().setScene(scene);
        Controller.getInstance().setFrame(frame);
        Controller.getInstance().getFrame().getAreaInfo().appendText(new Date() + "\n" + "Server started." + '\n');
        Controller.getInstance().getFrame().getAreaInfo().appendText("Server connected on Database." + '\n' + "~~~~~~~~~~~~" + '\n');

        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                while (true) {
                    clientSocket = serverSocket.accept();
                    clientNo++;
                    Controller.getInstance().getFrame().getAreaInfo().appendText(new Date() + "\n" + "Client #" + clientNo + " is connected." + '\n');
                    inetAddress = clientSocket.getInetAddress();
                    Controller.getInstance().getFrame().getAreaInfo().appendText("Client #" + clientNo + " 's host name is " + inetAddress.getHostName() + '\n' + "~~~~~~~~~~~~" + '\n');
                    new Thread(new Flow(clientSocket)).start();
                }
            } catch (IOException ex) {
                inetAddress = clientSocket.getInetAddress();
                Controller.getInstance().getFrame().getAreaInfo().appendText("Client whose host name is " + inetAddress.getHostName() + "is disconnected at" + "\n");

            }
        }).start();

        Controller.getInstance().getPrimaryStage().setScene(scene);
        primaryStage.setTitle("Reservation-Server");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static int getClientNo() {
        return clientNo;
    }

    public static void setClientNo(int clientNo) {
        Server.clientNo = clientNo;
    }

}
