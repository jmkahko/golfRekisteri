package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author janne
 * @version 13.6.2022
 * Seura käyttöliittymän muokkaamista varten, voidaan syöttää uusi tuloskortti tai muokata. Voidaan muokata seurantietoja
 */
public class SeuraController {

    /**
     * Voidaan muokata seurantietoja
     * @param event
     */
    @FXML
    void handleMuokkaaSeuraa(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /**
     * Voidaan muokata tuloskorttia
     * @param event
     */
    @FXML
    void handleMuokkaaTuloskortti(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Voidaan syöttää uusi tuloskortti
     * @param event
     */
    @FXML
    void handleUusiTuloskortti(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

}
