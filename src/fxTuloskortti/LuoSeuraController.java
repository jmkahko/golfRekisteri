package fxTuloskortti;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tuloskortti.GolfRekisteri;
import tuloskortti.SailoException;
import tuloskortti.Seura;

/**
 * @author Janne Kähkönen
 * @version 13.6.2022
 * LuoSeura käyttöliittymän controllerit
 */
public class LuoSeuraController implements ModalControllerInterface<Seura>, Initializable {

    @FXML private TextField katuosoiteTextField;
    @FXML private TextField postinumeroTextField;
    @FXML private TextField postiosoiteTextField;
    @FXML private TextField puhelinnumeroTextField;
    @FXML private TextField seuraTextField;
    
    
    /**
     * Voidaan syöttää uusi tuloskortti
     * @param event
     */
    @FXML 
    private void handleSyotaTuloskortti() {
        ModalController.showModal(LuoSeuraController.class.getResource("LuoUusiTuloskorttiView.fxml"), "Muokkaa tuloskorttia", null, golfRekisteri);
    }

    /**
     * Voidaan tallentaa seurantiedot
     * @param event
     */
    @FXML 
    private void handleTallenna() {
        //Dialogs.showMessageDialog("Ei vielä osata tehdä");
        tallenna();
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }    

    @Override
    public void setDefault(Seura oletus) {
        this.seuraKohdalla = oletus;
        naytaSeura(seuraKohdalla);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Seura getResult() {
        // TODO Auto-generated method stub
        return null;
    }
    
 // =================================================================
 // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia

    private GolfRekisteri golfRekisteri;
    private Seura seuraKohdalla;

    
    /**
     * Laitetaan seuran tiedot näkymälle
     * @param seura viedään seuran tiedot
     */
    private void naytaSeura(Seura seura) {
        if (seura == null) {
            return;
        }
        katuosoiteTextField.setText(seura.getKatuosoite());
        postinumeroTextField.setText(String.valueOf(seura.getPostinumero()));
        postiosoiteTextField.setText(seura.getPostitoimipaikka());
        puhelinnumeroTextField.setText(seura.getPuhelinnumero());
        seuraTextField.setText(seura.getSeurannimi());
    }
    
    /**
     * Luodaan seuran muokkaus dialogi ja palautetaan sama tietue muutettuna tai null arvo
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param seura mitä dataa näytetään oletuksena, kun muokataan seuraa, niin olemassa olevan seuran tiedot
     * @return null jos painetaan Peruuta, muuten täytetään tietue
     */
    public static Seura kysySeura(Stage modalityStage, Seura seura) {
        return ModalController.showModal(SeuraController.class.getResource("LuoSeuraView.fxml"), "Muokkaa seuraa", modalityStage, seura);
    }
    
    /**
     * Tallennetaan seuran tiedot tai lisätään uusi seura
     */
    public void tallenna() {
        
        if (seuraKohdalla == null) {
            Seura seura = new Seura();
            seura.setSeurannimi(seuraTextField.getText());
            seura.setKatuosoite(katuosoiteTextField.getText());
            seura.setPostinumero(Integer.valueOf(postinumeroTextField.getText()));
            seura.setPostitoimipaikka(postiosoiteTextField.getText());
            seura.setPuhelinnumero(puhelinnumeroTextField.getText());
            seura.rekisteroi();
            try {
                this.golfRekisteri.lisaaSeura(seura);
            } catch (SailoException e) {
                // TODO Auto-generated catch block
                Dialogs.showMessageDialog("Seuran lisääminen epäonnistui: " + e.getMessage());
            }
        } else {
            //this.golfRekisteri.lisaaTaiMuutaSeura(seura);
        }
        
        
        
    }

}
