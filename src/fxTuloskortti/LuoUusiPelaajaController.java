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
import tuloskortti.Kayttaja;
import tuloskortti.SailoException;

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
     */
    @FXML 
    private void handlePeruuta() {
        ModalController.closeStage(nimiTextField); // Kun painetaan Peruuta nappia, niin tällä saadaan suljettua ikkuna
    }

    /**
     * Tallennetaan muutokset
     */
    @FXML
    private void handleTallenna() {
        tallennaPelaaja();
    }

    @Override
    public void handleShown() {
        haePelaajanTiedot();
    }

    @Override
    public GolfRekisteri getResult() {
        return golfRekisteri;
    }

    @Override
    public void setDefault(GolfRekisteri golfRekisteri) {
        this.golfRekisteri = golfRekisteri;
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {      
        nimiTextField.setOnKeyReleased(e -> kasitteleKayttajaMuutos(1, nimiTextField));
        seuraTextField.setOnKeyReleased(e -> kasitteleKayttajaMuutos(2, seuraTextField));
        tasoitusTextField.setOnKeyReleased(e -> kasitteleKayttajaMuutos(3, tasoitusTextField));
        aloitusVuosiTextField.setOnKeyReleased(e -> kasitteleKayttajaMuutos(4, aloitusVuosiTextField));
    }
    
    // =================================================================
    // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia
    
    private GolfRekisteri golfRekisteri;
    
    /**
     * Käsitellään pelaaja kenttien muutoksia
     * @param k mille riville tehdään
     * @param edit TextField kenttä josta tieto otetaan
     */
    private void kasitteleKayttajaMuutos(int k, TextField edit) {
        Kayttaja kayttaja = this.golfRekisteri.annaKayttaja(0);
        if (kayttaja == null) {
            return;
        }
        
        int numero = 0;
        double numerod = 0.0;
        String s = "";
        
        if (k == 4) {
            try {
                numero = Integer.parseInt(edit.getText());
            } catch (NumberFormatException e) {
                Dialogs.showMessageDialog("Kenttään ei voi syöttää kirjaimia");
            }
        } else if (k == 3) {
            try {
                numerod = Double.parseDouble(edit.getText());
            } catch (NumberFormatException e) {
                Dialogs.showMessageDialog("Kenttään ei voi syöttää kirjaimia");
            }
        } else {
            s = edit.getText();
        }
        
        switch (k) {
            case 1: kayttaja.setNimi(s); break;
            case 2: kayttaja.setKotiseura(s); break;
            case 3: kayttaja.setTasoitus(numerod); break;
            case 4: kayttaja.setAloitusvuosi(numero); break;
        default:
            break;
        }
    }
    
    /**
     * Tallennetaan pelaajan tiedot näytöltä
     */
    public void tallennaPelaaja() {
        if (this.golfRekisteri.annaKayttaja(0) != null) {
            ModalController.closeStage(seuraTextField);
        } else {
            Kayttaja uusiKayttaja = new Kayttaja(nimiTextField.getText(), seuraTextField.getText(), Double.valueOf(tasoitusTextField.getText()), Integer.valueOf(aloitusVuosiTextField.getText()));
            
            try {
                this.golfRekisteri.lisaaKayttaja(uusiKayttaja);
                this.golfRekisteri.tallenna();
            } catch (SailoException e) {
                Dialogs.showMessageDialog("Ongelmia uuden käyttäjän luonnissa: " + e.getMessage());
            }
        }
    }
    
    /**
     * Luetaan tiedostosta pelaajan tiedot
     */
    private void haePelaajanTiedot() {
        if (this.golfRekisteri != null) {
            Kayttaja uusiKayttaja = this.golfRekisteri.annaKayttaja(0);
            
            nimiTextField.setText(uusiKayttaja.getNimi());
            seuraTextField.setText(uusiKayttaja.getKotiseura());
            tasoitusTextField.setText(String.valueOf(uusiKayttaja.getTasoitus()));
            aloitusVuosiTextField.setText(String.valueOf(uusiKayttaja.getAloitusvuosi()));
        } else {
            nimiTextField.setText("");
            seuraTextField.setText("");
            tasoitusTextField.setText(String.valueOf(0.0));
            aloitusVuosiTextField.setText(String.valueOf(0));
        }
    }
    
    /**
     * Käyttäjä jota halutaan muokata
     * @param otsikko näytetään otsikkoteksti
     * @param modalityStage modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param golfRekisteri mitä dataa näytetään oletuksena, kun muokataan käyttäjää, niin olemassa olevan käyttäjän tiedot
     * @return null jos painetaan Peruuta, muuten täytetään tietue
     */
    public static GolfRekisteri kysyKayttaja(String otsikko, Stage modalityStage, GolfRekisteri golfRekisteri) {
        return ModalController.showModal(TuloskorttiGUIController.class.getResource("LuoUusiPelaajaView.fxml"), otsikko, modalityStage, golfRekisteri);
    }
    
    /**
     * Lisätään uusi käyttäjä
     * @param otsikko näytetään otsikkoteksti
     * @param modalityStage modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param golfRekisteri mitä dataa näytetään oletuksena, kun muokataan käyttäjää, niin olemassa olevan käyttäjän tiedot
     * @return null jos painetaan Peruuta, muuten täytetään tietue
     */
    public static GolfRekisteri luoKayttaja(String otsikko, Stage modalityStage, GolfRekisteri golfRekisteri) {
        Kayttaja uusiKayttaja = new Kayttaja();
        uusiKayttaja.rekisteroi();
        try {
            golfRekisteri.lisaaKayttaja(uusiKayttaja);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia uuden käyttäjän luonnissa: " + e.getMessage());
        }
        return ModalController.showModal(TuloskorttiGUIController.class.getResource("LuoUusiPelaajaView.fxml"), otsikko, modalityStage, golfRekisteri);
    }
}
