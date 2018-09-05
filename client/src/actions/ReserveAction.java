/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import exceptions.unallowedString;
import exceptions.emptyString;
import controller.Controller;
import data.Request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javax.swing.JOptionPane;

/**
 *
 * @author wint4
 */
public class ReserveAction implements EventHandler<ActionEvent> {

    public ReserveAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        String locationA = Controller.getInstance().getMainFrame().getaLocation_combo().getValue();
        String locationB = Controller.getInstance().getMainFrame().getbLocation_combo().getValue();
        String date = Controller.getInstance().getMainFrame().getDatePicker().getValue().toString();
        String time = Controller.getInstance().getMainFrame().getDeparture_time().getValue();
        String company = Controller.getInstance().getMainFrame().getCompany_combo().getValue();
        String type = Controller.getInstance().getMainFrame().getType_group().getSelectedToggle().getUserData().toString().trim();
        String discount = "";
        if (Controller.getInstance().getMainFrame().getDiscount_group().getSelectedToggle() != null) {
            discount = Controller.getInstance().getMainFrame().getDiscount_group().getSelectedToggle().getUserData().toString().trim();

        } else {
            discount = "Without";
        }
        String luggage = "";
        if (Controller.getInstance().getMainFrame().getLuggage_group().getSelectedToggle() != null) {
            luggage = Controller.getInstance().getMainFrame().getLuggage_group().getSelectedToggle().getUserData().toString().trim();

        } else {
            luggage = "0";
        }
        String price = Controller.getInstance().getMainFrame().getPriceField().getText();
        String priceT = "";
        for (int i = 0; i < price.length(); i++) {
            if (Character.isDigit(price.charAt(i))) {
                priceT += price.charAt(i);
            } else if (Character.isLetter(price.charAt(i))) {
                break;
            } else if (price.charAt(i) == '.') {
                break;
            } else if (price.charAt(i) == ',') {
                break;
            }
        }
        String name = Controller.getInstance().getBookFrame().getFirstName_tf().getText();
        String lastName = Controller.getInstance().getBookFrame().getLastName_tf().getText();

        try {
            checkStrings(name, lastName);
            String funcName = "success";
            ArrayList<String> parametres = new ArrayList<>();
            parametres.add(locationA);
            parametres.add(locationB);
            parametres.add(date);
            parametres.add(time);
            parametres.add(company);
            parametres.add(type);
            parametres.add(discount);
            parametres.add(luggage);
            parametres.add(priceT);
            parametres.add(name);
            parametres.add(lastName);

            Request request = new Request(funcName, parametres);
            Controller.getInstance().getToServer().writeObject(request);

            Request received = (Request) Controller.getInstance().getFromServer().readObject();
            if (received.getFuncName().equalsIgnoreCase("success")) {
                JOptionPane.showMessageDialog(null, name + " have a nice trip! :)");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Something was wrong :(\nGo back and check status again!");

            }

        } catch (emptyString ex) {
            JOptionPane.showMessageDialog(null, "Please enter your full name!");
        } catch (unallowedString ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid full name!");
        } catch (IOException ex) {
            Logger.getLogger(ReserveAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void checkStrings(String name, String lastName) throws emptyString, unallowedString {

        if (name.equals("") || lastName.equals("")) {
            throw new emptyString("Please enter your name");

        }

        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!(Character.isLetter(ch) || ch == '-')) {
                Controller.getInstance().getBookFrame().getFirstName_tf().setText("");
                throw new unallowedString("Unallowed string!");
            }
        }
        for (int i = 0; i < lastName.length(); i++) {
            char ch = lastName.charAt(i);
            if (!(Character.isLetter(ch) || ch == '-')) {
                Controller.getInstance().getBookFrame().getLastName_tf().setText("");
                throw new unallowedString("Unallowed string");
            }
        }
    }

}
