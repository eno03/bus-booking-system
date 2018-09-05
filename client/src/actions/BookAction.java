/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import controller.Controller;
import frames.BookFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 *
 * @author wint4
 */
public class BookAction implements EventHandler<ActionEvent> {

    public BookAction() {
    }

    @Override
    public void handle(ActionEvent event) {
        if (Controller.getInstance().getBookFrame() == null) {
            Controller.getInstance().setBookFrame(new BookFrame());
        }
        if (Controller.getInstance().getBookScene() == null) {
            Controller.getInstance().setBookScene(new Scene(Controller.getInstance().getBookFrame(), 288, 390));
        }
        Controller.getInstance().getPrimaryStage().setScene(Controller.getInstance().getBookScene());
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

        Controller.getInstance().getBookFrame().getInfo_ta().clear();
        Controller.getInstance().getBookFrame().getInfo_ta().appendText("\t\t\t~~~~INFO~~~" + "\n\n");

        Controller.getInstance().getBookFrame().getInfo_ta().appendText("Route:           " + locationA + " - " + locationB + "\n\n");
        Controller.getInstance().getBookFrame().getInfo_ta().appendText("Date:             " + date + " / Time: " + time + "\n\n");
        Controller.getInstance().getBookFrame().getInfo_ta().appendText("Company:     " + company + " / Type: " + type + "\n\n");
        Controller.getInstance().getBookFrame().getInfo_ta().appendText("Discount:      " + discount + "\n\n" + "Luggage:       " + luggage + "\n\n\n");
        Controller.getInstance().getBookFrame().getInfo_ta().appendText("\t\t\t\t\t" + "       Price: " + price);
    }

}
