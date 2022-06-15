package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;

/**
 * @author janne
 * @version 13.6.2022
 * Uuden pelaajan luonti/muokkaus controlleri
 */
public class LuoUusiPelaajaController implements ModalControllerInterface<String> {

    /**
     * Perutaan muutokset
     * @param event
     */
    @FXML 
    private void handlePeruuta() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Tallennetaan muutokset
     * @param event
     */
    @FXML
    private  void handleTallenna() {
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
