package fxTuloskortti;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tuloskortti.GolfRekisteri;
import tuloskortti.Kayttaja;
import tuloskortti.SailoException;
import tuloskortti.Seura;

/**
 * @author Janne Kähkönen
 * @version 13.6.2022
 * Uuden pelaajan luonti/muokkaus controlleri
 */
public class LuoUusiPelaajaController implements ModalControllerInterface<GolfRekisteri>, Initializable {

    @FXML private TextField nimiTextField;
    @FXML private TextField seuraTextField;
    @FXML private TextField tasoitusTextField;
    @FXML private TextField aloitusVuosiTextField;
    
    /**
     * Perutaan muutokset
     * @param event
     */
    @FXML 
    private void handlePeruuta() {
        //Dialogs.showMessageDialog("Ei vielä osata tehdä");
        //luoTestiPelaaja();
        ModalController.closeStage(nimiTextField); // Kun painetaan Peruuta nappia, niin tällä saadaan suljettua ikkuna
    }

    /**
     * Tallennetaan muutokset
     * @param event
     */
    @FXML
    private void handleTallenna() {
        //Dialogs.showMessageDialog("Ei vielä osata tehdä");
        //luoPelaaja();
        tallennaPelaaja();
    }

    @Override
    public GolfRekisteri getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        //haePelaajanTiedot();
    }

    @Override
    public void setDefault(GolfRekisteri golfRekisteri) {
        this.golfRekisteri = golfRekisteri;
        
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
    
    // =================================================================
    // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia
    
    private GolfRekisteri golfRekisteri;
    
    /**
     * Luodaan pelaaja tuloskortille
     */
    public void luoTestiPelaaja() {
        Kayttaja uusiKayttaja = new Kayttaja();
        uusiKayttaja.rekisteroi();
        uusiKayttaja.taytaTestiTiedoilla();
        
        try {
            this.golfRekisteri.lisaaKayttaja(uusiKayttaja);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia uuden käyttäjän luonnissa: " + e.getMessage());
        }
        
        Dialogs.showMessageDialog("Uusi käyttäjä luotu. Tulostuu Console lokiin tieto");
        uusiKayttaja.tulosta(System.out);
    }
    
    /**
     * Luodaan uusi pelaaja annetuilla tiedoilla
     */
    public void luoPelaaja() {
        Kayttaja uusiPelaaja = new Kayttaja(nimiTextField.getText(), seuraTextField.getText(), Double.valueOf(tasoitusTextField.getText()), Integer.valueOf(aloitusVuosiTextField.getText()));
        try {
            this.golfRekisteri.lisaaKayttaja(uusiPelaaja);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia uuden käyttäjän luonnissa: " + e.getMessage());
        }
        
        Dialogs.showMessageDialog("Uusi käyttäjä luotu. Tulostuu Console lokiin tieto");
        uusiPelaaja.tulosta(System.out);
    }
    
    /**
     * Tallennetaan pelaajan tiedot näytöltä
     */
    public void tallennaPelaaja() {
        Kayttaja uusiKayttaja = new Kayttaja(nimiTextField.getText(), seuraTextField.getText(), Double.valueOf(tasoitusTextField.getText()), Integer.valueOf(aloitusVuosiTextField.getText()));
    
        try {
            this.golfRekisteri.lisaaKayttaja(uusiKayttaja);
            this.golfRekisteri.tallenna();
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia uuden käyttäjän luonnissa: " + e.getMessage());
        }
    }
    
    /**
     * Luetaan tiedostosta pelaajan tiedot
     */
    public void haePelaajanTiedot() {       
        Kayttaja uusiKayttaja = this.golfRekisteri.annaKayttaja(0);
        
        if (uusiKayttaja == null) {
                nimiTextField.setText("");
                seuraTextField.setText("");
                tasoitusTextField.setText(String.valueOf(0.0));
                aloitusVuosiTextField.setText(String.valueOf(0));
        } else {
                nimiTextField.setText(uusiKayttaja.getNimi());
                seuraTextField.setText(uusiKayttaja.getKotiseura());
                tasoitusTextField.setText(String.valueOf(uusiKayttaja.getTasoitus()));
                aloitusVuosiTextField.setText(String.valueOf(uusiKayttaja.getAloitusvuosi()));
            }
    }
    
    /**
     * @param modalityStage modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param kayttaja mitä dataa näytetään oletuksena, kun muokataan käyttäjää, niin olemassa olevan käyttäjän tiedot
     * @return null jos painetaan Peruuta, muuten täytetään tietue
     */
    public static Kayttaja kysyKayttaja(Stage modalityStage, Kayttaja kayttaja) {
        return ModalController.showModal(TuloskorttiGUIController.class.getResource("LuoUusiPelaajaView.fxml"), "Muokkaa jäsentä", modalityStage, kayttaja);
    }
}
