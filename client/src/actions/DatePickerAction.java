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
public class DatePickerAction implements EventHandler<ActionEvent> {

    public DatePickerAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        String locationA = Controller.getInstance().getMainFrame().getaLocation_combo().getValue();
        String locationB = Controller.getInstance().getMainFrame().getbLocation_combo().getValue();
        String date = Controller.getInstance().getMainFrame().getDatePicker().getValue().toString();
        Controller.getInstance().getMainFrame().getDeparture_time().getItems().clear();
        Controller.getInstance().getMainFrame().getPriceField().setText("~~~ RSD");
        Controller.getInstance().getMainFrame().getStatusField().setText("~~~ seats available");
        Controller.getInstance().getMainFrame().getBook_btn().setDisable(true);
        try {
            String funcName = "Date";
            ArrayList<String> parametres = new ArrayList<>();
            parametres.add(locationA);
            parametres.add(locationB);
            parametres.add(date);
            Request request = new Request(funcName, parametres);
            Controller.getInstance().getToServer().writeObject(request);

            Request received = (Request) Controller.getInstance().getFromServer().readObject();
            Platform.runLater(() -> {
                for (int i = 0; i < received.getParametres().size(); i++) {
                    Controller.getInstance().getMainFrame().getDeparture_time().getItems().add(received.getParametres().get(i));
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(LocationAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatePickerAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
