package fxTuloskortti;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import kanta.UusiKierros;
import tuloskortti.GolfRekisteri;
import tuloskortti.Kierrokset;
import tuloskortti.Kierros;
import tuloskortti.SailoException;
import tuloskortti.Seura;

/**
 * Luokka käyttöliittymän tapahtumien hoitamiseksi
 * @author janne
 * @version 13.6.2022
 *
 */
public class TuloskorttiGUIController implements Initializable {
    
    /**
     * Kierrokset listaus
     */
    @FXML
    private ListChooser<Kierros> chooserKierrokset;
    
    /**
     * Käyttäjän tietokentät
     */
    @FXML private TextField nimiTextField;
    @FXML private TextField seuraTextField;
    @FXML private TextField tasoitusTextField;
    @FXML private TextField aloitusVuosiTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        chooserKierrokset.clear();
    }
    
    /**
     * Käsitellään uuden kierroksen syöttäminen
     */
    @FXML 
    private void handleUusiKierros() {
        //ModalController.showModal(TuloskorttiGUIController.class.getResource("SyotaKierrosView.fxml"), "Syötä uuden kierroksen tulos", null, "");
        uusiKierros();
    }
    
    
    /**
     * Käsitellään uuden seuran syöttäminen
     */
    @FXML 
    private void handleUusiSeura() {
        ModalController.showModal(TuloskorttiGUIController.class.getResource("LuoSeuraView.fxml"), "Luo seura", null, golfRekisteri);
    }
       
    /**
     * Käsitellään seuran muokkaamista
     */
    @FXML 
    private void handleMuokkaaSeuraa() {
        ModalController.showModal(TuloskorttiGUIController.class.getResource("SeuraView.fxml"), "Muokkaa seuraa", null, golfRekisteri);
    }
    
    /**
     * Käsitellään kierroksen tuloskortin muokkaus
     */
    @FXML 
    private void handleMuokkaaKierrosta() {
        ModalController.showModal(TuloskorttiGUIController.class.getResource("SyotaKierrosView.fxml"), "Muokkaa kierrosta", null, golfRekisteri);
    }

    /**
     * Käsitellään tallennuskäsky
     */
    @FXML 
    private void handleTallenna() {
        tallenna();
    }
    
    /**
     * Käsitellään lopetuskäsky
     */
    @FXML 
    private void handleLopeta() {
        tallenna();
        Platform.exit();
    }
    
    /**
     * Käsitellään peruuta käsky
     */
    @FXML 
    private void handlePeruuta() {
        Platform.exit();
    }
    
    /**
     * Apua valikon apua painike
     */
    @FXML 
    private void handleApua() {
        Dialogs.showMessageDialog("Tänne tulee sovelluksen toimintaan helppejä");
    }

    /**
     * Muokkaa tallennettua jäsentä
     */
    @FXML 
    private void handleMuokkaaJasenta() {
        ModalController.showModal(TuloskorttiGUIController.class.getResource("LuoUusiPelaajaView.fxml"), "Muokkaa jäsentä", null, "");
    }

    /**
     * Kierroksen tuloskortin poistaminen
     */
    @FXML 
    private void handlePoistaKierros() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Apua valikon tietoja näytetään
     */
    @FXML 
    private void handleTietoja() {
        tietojaSovelluksesta();
    }
      
// =================================================================
// Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia
    
    private GolfRekisteri golfRekisteri;

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
    
    private void tietojaSovelluksesta() {
        Desktop desktop = Desktop.getDesktop();
        try {
            URI uri = new URI("https://gitlab.jyu.fi/jmkahkon/ohj2");
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            return;
        } catch (IOException e) {
            return;
        }
    }
    
    /**
     * Asetetaan käytettävä GolfRekisteri
     * @param golfRekisteri jota käytetään
     */
    public void setGolfRekisteri(GolfRekisteri golfRekisteri) {
        this.golfRekisteri = golfRekisteri;
    }
    
        
    /**
     * Lisätään uusi kierros
     */
    public void uusiKierros() {
        Kierrokset uusiKierros = new Kierrokset();
        uusiKierros.lisaaKierros(UusiKierros.luoKierros(1, 55));
        
        Dialogs.showMessageDialog("Luotu uusi väylä kierrokselle. Tulostyy Console lokiin tieto");
        uusiKierros.annaKierrokset(1, 1);
        
        List<Kierros> kierrokset2 = uusiKierros.annaKierrokset(1, 1);
        
        System.out.println("============= Kierrokset testi =================");

        for (Kierros tulos : kierrokset2) {
            System.out.print("SeuraId: " + tulos.getSeuraId() + " ");
            tulos.tulosta(System.out);
        }
    }
    
    /**
     * Käynnistyksessä jos pelaajaa ei ole luotu luodaan pelaaja
     * @return palauttaa true, että saadaan uuden pelaajan luonti auki
     */
    public boolean avaa() {
        ModalController.showModal(TuloskorttiGUIController.class.getResource("LuoUusiPelaajaView.fxml"), "Luo pelaaja", null, golfRekisteri);
        return true;
    }
}