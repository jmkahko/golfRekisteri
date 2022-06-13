package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author janne
 * @version 13.6.2022
 * Uuden pelaajan luonti controlleri
 */
public class LuoUusiPelaajaController {

    /**
     * Perutaan muutokset
     * @param event
     */
    @FXML
    void handlePeruuta(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Tallennetaan muutokset
     * @param event
     */
    @FXML
    void handleTallenna(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

}
