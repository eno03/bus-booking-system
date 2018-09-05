/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import actions.WellcomeAction;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author wint4
 */
public class StartFrame extends StackPane {

    private final Button wellcome = new Button("Welcome");
    private final File cover = new File("src/start.jpg");
    private final Image image = new Image(cover.toURI().toString());
    private final ImageView imageView = new ImageView(image);

    public StartFrame() {

        getChildren().add(imageView);
        getChildren().add(wellcome);
        wellcome.setOnAction(new WellcomeAction());

    }

}
