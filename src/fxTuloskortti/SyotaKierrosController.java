package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * @author janne
 * @version 13.6.2022
 * Pelatun kierroksen tuloksen syöttäminen
 */
public class SyotaKierrosController {

    /**
     * Perutaan tehdyt muutokset
     * @param event
     */
    @FXML
    void handlePeruuta(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Tallennetaan syötetty kierros
     * @param event
     */
    @FXML
    void handleTallenna(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /**
     * Valitaan päiväys pelatulle kierrokselle
     * @param event
     */
    @FXML
    void handlePaivays(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

}
