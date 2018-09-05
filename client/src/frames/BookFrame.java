/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import actions.ReserveAction;
import actions.BookBackAction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author wint4
 */
public class BookFrame extends VBox {

    private GridPane head = new GridPane();
    private GridPane buttons = new GridPane();
    private VBox body = new VBox();

    private TextField firstName_tf = new TextField();
    private TextField LastName_tf = new TextField();
    private TextArea info_ta = new TextArea();

    private Button backButton = new Button("Back");
    private Button reserveButton = new Button("Reserve");

    public BookFrame() {
        setSpacing(10);
        setStyle("-fx-background-color: #DAF2FC;");
        setPadding(new Insets(10, 10, 10, 10));
        head.add(new Label("First name:"), 0, 0);
        head.add(firstName_tf, 1, 0);
        firstName_tf.setAlignment(Pos.CENTER_RIGHT);
        head.add(new Label("Last name:"), 0, 1);
        head.add(LastName_tf, 1, 1);
        LastName_tf.setAlignment(Pos.CENTER_RIGHT);
        head.setPadding(new Insets(0, 0, 10, 0));
        head.setHgap(50);
        head.setVgap(5);
        getChildren().add(head);
        getChildren().add(info_ta);
        info_ta.setPadding(new Insets(0, 0, 10, 0));
        info_ta.setMinSize(265, 260);
        info_ta.setMaxSize(265, 260);

        getChildren().add(buttons);
        reserveButton.setMinSize(60, 25);
        backButton.setMinSize(60, 25);
        backButton.setOnAction(new BookBackAction());
        buttons.add(backButton, 0, 1);
        buttons.setHgap(140);
        buttons.add(reserveButton, 1, 1);
        reserveButton.setOnAction(new ReserveAction());
    }

    public GridPane getHead() {
        return head;
    }

    public void setHead(GridPane head) {
        this.head = head;
    }

    public GridPane getButtons() {
        return buttons;
    }

    public void setButtons(GridPane buttons) {
        this.buttons = buttons;
    }

    public VBox getBody() {
        return body;
    }

    public void setBody(VBox body) {
        this.body = body;
    }

    public TextField getFirstName_tf() {
        return firstName_tf;
    }

    public void setFirstName_tf(TextField firstName_tf) {
        this.firstName_tf = firstName_tf;
    }

    public TextField getLastName_tf() {
        return LastName_tf;
    }

    public void setLastName_tf(TextField LastName_tf) {
        this.LastName_tf = LastName_tf;
    }

    public TextArea getInfo_ta() {
        return info_ta;
    }

    public void setInfo_ta(TextArea info_ta) {
        this.info_ta = info_ta;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Button getReserveButton() {
        return reserveButton;
    }

    public void setReserveButton(Button reserveButton) {
        this.reserveButton = reserveButton;
    }

}
