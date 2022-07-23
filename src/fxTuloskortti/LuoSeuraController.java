package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import tuloskortti.GolfRekisteri;

/**
 * @author janne
 * @version 13.6.2022
 * LuoSeura käyttöliittymän controllerit
 */
public class LuoSeuraController implements ModalControllerInterface<GolfRekisteri> {

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
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }    

    @Override
    public GolfRekisteri getResult() {
        // TODO Auto-generated method stub
        return null;
    }


    
    @Override
    public void setDefault(GolfRekisteri rekisteri) {
        this.golfRekisteri = rekisteri;
        
        // Alustetaan tässä vaiheessa tässä tiedot;
        
        
    }
    
 // =================================================================
 // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia

    private GolfRekisteri golfRekisteri;

}
