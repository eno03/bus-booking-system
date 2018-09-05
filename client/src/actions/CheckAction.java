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
import javax.swing.JOptionPane;

/**
 *
 * @author wint4
 */
public class CheckAction implements EventHandler<ActionEvent> {

    public CheckAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        Platform.runLater(() -> {

            Controller.getInstance().getMainFrame().getBook_btn().setDisable(true);
            String locationA = Controller.getInstance().getMainFrame().getaLocation_combo().getValue();
            String locationB = Controller.getInstance().getMainFrame().getbLocation_combo().getValue();
            String date = "";
            if (Controller.getInstance().getMainFrame().getDatePicker().getValue() != null) {
                date = Controller.getInstance().getMainFrame().getDatePicker().getValue().toString();

            } else {
                date = "null";
            }
            String time = Controller.getInstance().getMainFrame().getDeparture_time().getValue();
            String company = Controller.getInstance().getMainFrame().getCompany_combo().getValue();
            String type = "";
            if (Controller.getInstance().getMainFrame().getType_group().getSelectedToggle() != null) {
                type = Controller.getInstance().getMainFrame().getType_group().getSelectedToggle().getUserData().toString().trim();

            } else {
                type = "null";
            }
            String discount = "";
            if (Controller.getInstance().getMainFrame().getDiscount_group().getSelectedToggle() != null) {
                discount = Controller.getInstance().getMainFrame().getDiscount_group().getSelectedToggle().getUserData().toString().trim();

            } else {
                discount = "null";
            }
            String luggage = "";
            if (Controller.getInstance().getMainFrame().getLuggage_group().getSelectedToggle() != null) {
                luggage = Controller.getInstance().getMainFrame().getLuggage_group().getSelectedToggle().getUserData().toString().trim();

            } else {
                luggage = "null";
            }
            Controller.getInstance().getMainFrame().getPriceField().setText("");
            Controller.getInstance().getMainFrame().getStatusField().setText("");
            try {
                String funcName = "Check";
                ArrayList<String> parametres = new ArrayList<>();
                parametres.add(locationA);
                parametres.add(locationB);
                parametres.add(date);
                parametres.add(time);
                parametres.add(company);
                parametres.add(type);
                parametres.add(discount);
                parametres.add(luggage);

                Request request = new Request(funcName, parametres);
                Controller.getInstance().getToServer().writeObject(request);

                Request received = (Request) Controller.getInstance().getFromServer().readObject();

                if (received.getParametres().get(0).equalsIgnoreCase("null")) {
                    JOptionPane.showMessageDialog(null, "Greška pri odabiru!");
                } else {
                    if (Integer.parseInt(received.getParametres().get(1)) > 0) {
                        Controller.getInstance().getMainFrame().getBook_btn().setDisable(false);
                        Controller.getInstance().getMainFrame().getPriceField().setText(received.getParametres().get(0) + " RSD");
                        Controller.getInstance().getMainFrame().getStatusField().setText(received.getParametres().get(1) + " seats available");
                    } else {
                        Controller.getInstance().getMainFrame().getPriceField().setText(received.getParametres().get(0) + " RSD");
                        Controller.getInstance().getMainFrame().getStatusField().setText(received.getParametres().get(1) + " seats available");
                        JOptionPane.showMessageDialog(null, "Sorry! All tickets have been sold out!");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TimeAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TimeAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

}
