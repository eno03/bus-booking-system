/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author wint4
 */
public class RadioAction implements EventHandler<ActionEvent> {

    public RadioAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        Controller.getInstance().getMainFrame().getPriceField().setText("~~~ RSD");
        Controller.getInstance().getMainFrame().getStatusField().setText("~~~ seats available");
        Controller.getInstance().getMainFrame().getBook_btn().setDisable(true);

    }

}
