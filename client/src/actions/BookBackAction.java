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
public class BookBackAction implements EventHandler<ActionEvent> {

    public BookBackAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        Controller.getInstance().getPrimaryStage().setScene(Controller.getInstance().getMainScene());
    }

}
