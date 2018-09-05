/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author wint4
 */
public class Frame extends BorderPane {

    private TextArea areaInfo;

    public Frame() {
        areaInfo = new TextArea("~~~~~~~~~~~~~~~~~~~~~~~~~~SERVER~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        setCenter(new ScrollPane(areaInfo));
        areaInfo.setEditable(false);
     
    }

    public TextArea getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(TextArea areaInfo) {
        this.areaInfo = areaInfo;
    }

}
