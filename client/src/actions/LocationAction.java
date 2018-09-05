/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import controller.Controller;
import data.Request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author wint4
 */
public class LocationAction implements EventHandler<ActionEvent> {

    public LocationAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        String locationA = Controller.getInstance().getMainFrame().getaLocation_combo().getSelectionModel().getSelectedItem();
        Controller.getInstance().getMainFrame().getbLocation_combo().getItems().clear();
        try {
            String funcName = "LocationB";
            ArrayList<String> parametres = new ArrayList<>();
            parametres.add(locationA);
            Request request = new Request(funcName, parametres);
            Controller.getInstance().getToServer().writeObject(request);

            Request received = (Request) Controller.getInstance().getFromServer().readObject();
            Platform.runLater(() -> {
                for (int i = 0; i < received.getParametres().size(); i++) {
                    Controller.getInstance().getMainFrame().getbLocation_combo().getItems().add(received.getParametres().get(i));
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(LocationAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocationAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
