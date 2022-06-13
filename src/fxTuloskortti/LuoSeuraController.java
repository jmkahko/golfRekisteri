package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author janne
 * @version 13.6.2022
 * LuoSeura käyttöliittymän controllerit
 */
public class LuoSeuraController {

    /**
     * Voidaan syöttää uusi tuloskortti
     * @param event
     */
    @FXML
    void handleSyotaTuloskortti(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Voidaan tallentaa seurantiedot
     * @param event
     */
    @FXML
    void handleTallenna(ActionEvent event) {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

}
