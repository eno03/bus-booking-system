/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import frames.StartFrame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author wint4
 */
public class Client extends Application {

    private Socket socket = null;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream ObjectInputStream;

    @Override
    public void start(Stage primaryStage) {
        StartFrame startFrame = new StartFrame();
        Scene startScene = new Scene(startFrame);

        Controller.getInstance().setPrimaryStage(primaryStage);
        Controller.getInstance().setStartFrame(startFrame);
        Controller.getInstance().setStartScene(startScene);
        Controller.getInstance().getPrimaryStage().setScene(startScene);
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(startScene);
        primaryStage.setResizable(false);
        primaryStage.show();

        try {
            socket = new Socket("localhost", 9026);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream = new ObjectInputStream(socket.getInputStream());
            Controller.getInstance().setToServer(objectOutputStream);
            Controller.getInstance().setFromServer(ObjectInputStream);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "The server encountered an internal error or misconfiguration and was unable to complete your request.");
            System.exit(0);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
