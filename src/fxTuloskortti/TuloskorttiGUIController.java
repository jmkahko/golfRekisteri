package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.application.Platform;
import javafx.fxml.FXML;

/**
 * Luokka käyttöliittymän tapahtumien hoitamiseksi
 * @author janne
 * @version 13.6.2022
 *
 */
public class TuloskorttiGUIController {
      
    
    /**
     * Käsitellään uuden kierroksen syöttäminen
     */
    @FXML private void handleUusiKierros() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    
    /**
     * Käsitellään uuden seuran syöttäminen
     */
    @FXML private void handleUusiSeura() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /**
     * Käsitellään uuden tuloskortin syöttäminen
     */
    @FXML private void handleUusiTuloskortti() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /**
     * Käsitellään seuran muokkaamista
     */
    @FXML private void handleMuokkaaSeuraa() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /**
     * Käsitellään tuloskortin muokkaamista
     */
    @FXML private void handleMuokkaaTuloskortti() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Käsitellään tallennuskäsky
     */
    @FXML private void handleTallenna() {
        tallenna();
    }
    
    /**
     * Käsitellään lopetuskäsky
     */
    @FXML private void handleLopeta() {
        tallenna();
        Platform.exit();
    }
    
    /**
     * Käsitellään peruuta käsky
     */
    @FXML private void handlePeruuta() {
        Platform.exit();
    }
    
    /**
     * Apua valikon apua painike
     */
    @FXML
    void handleApua() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Muokkaa tallennettua jäsentä
     */
    @FXML
    void handleMuokkaaJasenta() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Poistaa seuran
     */
    @FXML
    void handlePoistaSeura() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Tuloskortin poistaminen
     */
    @FXML
    void handlePoistaTuloskortti() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /*
     * Luodaan/Muokataan seuraa
     */
    @FXML
    void handleSeura() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /*
     * Luodaan/Muokataan tuloskorttia
     */
    @FXML
    void handleTuloskortti() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Apua valikon tietoja näytetään
     */
    @FXML
    void handleTietoja() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
      

    /**
     * Tarkistetaan onko tallennus tehty
     * @return true jos saa sulkea sovelluksen, false jos ei
     */
    public boolean voikoSulkea() {
        tallenna();
        return true;
    }
    
    /**
     * Tietojen tallennus
     */
    private void tallenna() {
        Dialogs.showMessageDialog("Tallennetetaan! Mutta ei toimi vielä");
    }
}