package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;

/**
 * @author janne
 * @version 13.6.2022
 * Pelatun kierroksen tuloksen syöttäminen
 */
public class SyotaKierrosController implements ModalControllerInterface<String> {

    /**
     * Perutaan tehdyt muutokset
     * @param event
     */
    @FXML
    private void handlePeruuta() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Tallennetaan syötetty kierros
     * @param event
     */
    @FXML
    private void handleTallenna() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /**
     * Valitaan päiväys pelatulle kierrokselle
     * @param event
     */
    @FXML
    private void handlePaivays() {
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
