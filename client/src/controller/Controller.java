/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import frames.BookFrame;
import frames.MainFrame;
import frames.StartFrame;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author wint4
 */
public class Controller {

    private static Controller instance = null;
    private Stage primaryStage;

    private Scene startScene;
    private StartFrame startFrame;

    private Scene mainScene;
    private MainFrame mainFrame;

    private Scene bookScene;
    private BookFrame bookFrame;

    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;

    private Controller() {
        startScene = null;
        startFrame = null;
        mainScene = null;
        mainFrame = null;
        bookScene = null;
        bookFrame = null;
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene getStartScene() {
        return startScene;
    }

    public void setStartScene(Scene startScene) {
        this.startScene = startScene;
    }

    public StartFrame getStartFrame() {
        return startFrame;
    }

    public void setStartFrame(StartFrame startFrame) {
        this.startFrame = startFrame;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public Scene getBookScene() {
        return bookScene;
    }

    public void setBookScene(Scene bookScene) {
        this.bookScene = bookScene;
    }

    public BookFrame getBookFrame() {
        return bookFrame;
    }

    public void setBookFrame(BookFrame bookFrame) {
        this.bookFrame = bookFrame;
    }

    public ObjectOutputStream getToServer() {
        return toServer;
    }

    public void setToServer(ObjectOutputStream toServer) {
        this.toServer = toServer;
    }

    public ObjectInputStream getFromServer() {
        return fromServer;
    }

    public void setFromServer(ObjectInputStream fromServer) {
        this.fromServer = fromServer;
    }

}
