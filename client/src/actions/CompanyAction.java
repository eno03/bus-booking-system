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
public class CompanyAction implements EventHandler<ActionEvent> {

    public CompanyAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        String locationA = Controller.getInstance().getMainFrame().getaLocation_combo().getValue();
        String locationB = Controller.getInstance().getMainFrame().getbLocation_combo().getValue();
        String date = Controller.getInstance().getMainFrame().getDatePicker().getValue().toString();
        String time = Controller.getInstance().getMainFrame().getDeparture_time().getValue();
        String company = Controller.getInstance().getMainFrame().getCompany_combo().getValue();
        Controller.getInstance().getMainFrame().getPriceField().setText("~~~ RSD");
        Controller.getInstance().getMainFrame().getStatusField().setText("~~~ seats available");
        Controller.getInstance().getMainFrame().getBook_btn().setDisable(true);
        Controller.getInstance().getMainFrame().getStandard_rb().setDisable(true);
        Controller.getInstance().getMainFrame().getMinibus_rb().setDisable(true);
        Controller.getInstance().getMainFrame().getDouble_rb().setDisable(true);

        try {
            String funcName = "Type";
            ArrayList<String> parametres = new ArrayList<>();
            parametres.add(locationA);
            parametres.add(locationB);
            parametres.add(date);
            parametres.add(time);
            parametres.add(company);

            Request request = new Request(funcName, parametres);
            Controller.getInstance().getToServer().writeObject(request);

            Request received = (Request) Controller.getInstance().getFromServer().readObject();
            Platform.runLater(() -> {
                for (int i = 0; i < received.getParametres().size(); i++) {
                    if (received.getParametres().get(i).equals("Minibus")) {
                        Controller.getInstance().getMainFrame().getMinibus_rb().setDisable(false);
                    }
                    if (received.getParametres().get(i).equals("Standard")) {
                        Controller.getInstance().getMainFrame().getStandard_rb().setDisable(false);
                    }
                    if (received.getParametres().get(i).equals("Double-decker")) {
                        Controller.getInstance().getMainFrame().getDouble_rb().setDisable(false);
                    }

                }
            });

        } catch (IOException ex) {
            Logger.getLogger(TimeAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
