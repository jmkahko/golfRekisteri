package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;

/**
 * @author janne
 * @version 13.6.2022
 * LuoSeura käyttöliittymän controllerit
 */
public class LuoSeuraController implements ModalControllerInterface<String> {

    /**
     * Voidaan syöttää uusi tuloskortti
     * @param event
     */
    @FXML 
    private void handleSyotaTuloskortti() {
        ModalController.showModal(LuoSeuraController.class.getResource("LuoUusiTuloskorttiView.fxml"), "Muokkaa tuloskorttia", null, "");
    }

    /**
     * Voidaan tallentaa seurantiedot
     * @param event
     */
    @FXML 
    private void handleTallenna() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDefault(String oletus) {
        // TODO Auto-generated method stub
        
    }

}
