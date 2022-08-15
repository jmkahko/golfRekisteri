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
     * Voidaan tallentaa seurantiedot
     */
    @FXML 
    private void handleTallenna() {
        ModalController.closeStage(seuraTextField);
    }
    
    /**
     * Voidaan peruuttaa muutokset
     */
    @FXML 
    private void handlePeruuta() {
        ModalController.closeStage(seuraTextField);
    }

    @Override
    public void handleShown() {
        // Ei toimintoa
    }    

    @Override
    public void setDefault(Seura oletus) {
        this.seuraKohdalla = oletus;
        naytaSeura(seuraKohdalla);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        seuraTextField.setOnKeyReleased(e -> kasitteleSeuraMuutos(1, seuraTextField));
        katuosoiteTextField.setOnKeyReleased(e -> kasitteleSeuraMuutos(2, katuosoiteTextField));
        postinumeroTextField.setOnKeyReleased(e -> kasitteleSeuraMuutos(3, postinumeroTextField));
        postiosoiteTextField.setOnKeyReleased(e -> kasitteleSeuraMuutos(4, postiosoiteTextField));
        puhelinnumeroTextField.setOnKeyReleased(e -> kasitteleSeuraMuutos(5, puhelinnumeroTextField));
    }

    @Override
    public Seura getResult() {
        return seuraKohdalla;
    }
    
 // =================================================================
 // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia

    private Seura seuraKohdalla;
 
    private void kasitteleSeuraMuutos(int k, TextField edit) {
        if (seuraKohdalla == null) {
            return;
        }
        
        String s = edit.getText();
        
        switch (k) {
            case 1: seuraKohdalla.setSeurannimi(s); break;
            case 2: seuraKohdalla.setKatuosoite(s); break;
            case 3: seuraKohdalla.setPostinumero(Integer.valueOf(s)); break;
            case 4: seuraKohdalla.setPostitoimipaikka(s); break;
            case 5: seuraKohdalla.setPuhelinnumero(s); break;
        default:
            break;
        }
    }
    
    /**
     * Laitetaan seuran tiedot näkymälle
     * @param seura viedään seuran tiedot
     */
    private void naytaSeura(Seura seura) {
        if (seura == null) {
            katuosoiteTextField.setText("");
            postinumeroTextField.setText("");
            postiosoiteTextField.setText("");
            puhelinnumeroTextField.setText("");
            seuraTextField.setText("");
        } else {
            katuosoiteTextField.setText(seura.getKatuosoite());
            postinumeroTextField.setText(String.valueOf(seura.getPostinumero()));
            postiosoiteTextField.setText(seura.getPostitoimipaikka());
            puhelinnumeroTextField.setText(seura.getPuhelinnumero());
            seuraTextField.setText(seura.getSeurannimi());
        }
    }
    
    /**
     * Luodaan seuran muokkaus dialogi ja palautetaan sama tietue muutettuna tai null arvo
     * @param otsikko näytettävä otsikko näkymällä
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param seura mitä dataa näytetään oletuksena, kun muokataan seuraa, niin olemassa olevan seuran tiedot
     * @return null jos painetaan Peruuta, muuten täytetään tietue
     */
    public static Seura kysySeura(String otsikko, Stage modalityStage, Seura seura) {
        return ModalController.showModal(SeuraController.class.getResource("LuoSeuraView.fxml"), otsikko, modalityStage, seura);
    }
}
