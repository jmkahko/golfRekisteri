package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * @author janne
 * @version 13.6.2022
 * Uuden tuloskortin luonti seuralle
 */
public class LuoUusiTuloskorttiController {

    /**
     * Peruuta muutokset
     * @param event
     */
    @FXML
    void handlePeruuta(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Tallenna tuloskortin muutokset
     * @param event
     */
    @FXML
    void handleTallenna(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

}
