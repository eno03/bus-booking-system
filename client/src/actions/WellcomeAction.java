/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import controller.Controller;
import data.Request;
import frames.MainFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 *
 * @author wint4
 */
public class WellcomeAction implements EventHandler<ActionEvent> {

    public WellcomeAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        if (Controller.getInstance().getMainFrame() == null) {
            Controller.getInstance().setMainFrame(new MainFrame());
        }
        if (Controller.getInstance().getMainScene() == null) {
            Controller.getInstance().setMainScene(new Scene(Controller.getInstance().getMainFrame()));
        }
        Controller.getInstance().getPrimaryStage().setTitle("Reservation");
        Controller.getInstance().getPrimaryStage().setScene(Controller.getInstance().getMainScene());
        Controller.getInstance().getMainFrame().getPriceField().setText("~~~ RSD");
        Controller.getInstance().getMainFrame().getStatusField().setText("~~~ seats available");
        Controller.getInstance().getMainFrame().getBook_btn().setDisable(true);
        String funcName = "LocationA";
        ArrayList<String> parametres;
        parametres = new ArrayList<>();
        Request request = new Request(funcName, parametres);
        try {
            Controller.getInstance().getToServer().writeObject(request);
            Request received = (Request) Controller.getInstance().getFromServer().readObject();
            Platform.runLater(() -> {
                for (int i = 0; i < received.getParametres().size(); i++) {
                    Controller.getInstance().getMainFrame().getaLocation_combo().getItems().add(received.getParametres().get(i));
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(WellcomeAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WellcomeAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
