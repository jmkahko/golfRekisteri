package fxTuloskortti;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
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
import tuloskortti.Kayttaja;
import tuloskortti.Kierrokset;
import tuloskortti.Kierros;
import tuloskortti.SailoException;
import tuloskortti.Seura;

/**
 * Luokka käyttöliittymän tapahtumien hoitamiseksi
 * @author Janne Kähkönen
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
        chooserKierrokset.addSelectionListener(e -> naytaKierros());
    }
    
    /**
     * Käsitellään uuden kierroksen syöttäminen
     */
    @FXML 
    private void handleUusiKierros() {
        uusiKierros();
        //kierroksenTiedot();
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
     * Muokkaa tallennettua jäsentä/käyttäjää
     */
    @FXML 
    private void handleMuokkaaJasenta() {
        muokkaaKayttajaa();
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
        try {
            golfRekisteri.tallenna();
        } catch (SailoException e) {
            Dialogs.showMessageDialog(e.getMessage());
        }
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
        golfRekisteri.lisaaKierros(UusiKierros.luoKierros(1, 55));
        
        Dialogs.showMessageDialog("Luotu uusi väylä kierrokselle. Tulostuu Console lokiin tieto");
        
        golfRekisteri.annaKierrokset(golfRekisteri.annaSeura(0), golfRekisteri.annaKayttaja(0));
        
        
        List<Kierros> kierrokset2 = golfRekisteri.annaKierrokset(golfRekisteri.annaSeura(0), golfRekisteri.annaKayttaja(0));
        
        System.out.println("============= Kierrokset testi =================");

        for (Kierros tulos : kierrokset2) {
            System.out.print("SeuraId: " + tulos.getSeuraId() + " ");
            tulos.tulosta(System.out);
        }
        haeKierrokset();
    }
    
    /**
     * Käynnistyksessä jos pelaajaa ei ole luotu luodaan pelaaja
     * @return palauttaa true, että saadaan uuden pelaajan luonti auki
     */
    public boolean avaa() {     
        lueTiedostosta();
               
        if (this.golfRekisteri == null || this.golfRekisteri.getKayttajia() == 0) {
            ModalController.showModal(TuloskorttiGUIController.class.getResource("LuoUusiPelaajaView.fxml"), "Luo pelaaja", null, golfRekisteri);
            return false;
        }
        haeKierrokset();
        return true;
    }
    
    /**
     * Haetaan käyttäjän tiedot tiedostosta
     */
    public void haeKayttajanTiedot() {
        Kayttaja kayttaja = golfRekisteri.annaKayttaja(0);
        
        if (kayttaja != null) {
            nimiTextField.setText(kayttaja.getNimi());
            seuraTextField.setText(kayttaja.getKotiseura());
            tasoitusTextField.setText(String.valueOf(kayttaja.getTasoitus()));
            aloitusVuosiTextField.setText(String.valueOf(kayttaja.getAloitusvuosi()));
        }
    }
    
    /**
     * Haetaan kierrokset rivi per kierros
     */
    public void haeKierrokset() {
        chooserKierrokset.clear();

        Collection<Kierros> kaikkiKierrokset = golfRekisteri.annaKaikkiKierrokset();
        int kierrosLaskuri = 18;
        int tulosLaskuri = 0;
        for (Kierros tulos : kaikkiKierrokset) {
            tulosLaskuri += tulos.getTulos();
            if (kierrosLaskuri == tulos.getTunnusNro()) {
                String seuranNimi = this.golfRekisteri.annaSeura(tulos.getSeuraId()-1).getSeurannimi();
                chooserKierrokset.add(tulos.getPelattuPaiva() + " " + seuranNimi + " " + String.valueOf(tulosLaskuri), tulos);
                kierrosLaskuri += 18;
                tulosLaskuri = 0;
            }
        }
    }
    
    /**
     * Haetaan kieroksen tiedot
     */
    public void naytaKierros() {
        Kierros kierroksenKohdalla = chooserKierrokset.getSelectedObject();
        System.out.println("Näytettiin: " + kierroksenKohdalla.getTunnusNro());
    }
    
    /**
     * Alustetaan Golf Rekisteri lukemalla valitun niminen tiedosto
     * @param nimi golfRekisterin tiedot luetaan täältä
     */
    private void lueTiedostosta() {
        try {
            golfRekisteri.lueTiedostosta("golfRekisteri");
            haeKayttajanTiedot();
        } catch (SailoException e) {
            Dialogs.showMessageDialog(e.getMessage());
        }
    }
    
    private void muokkaaKayttajaa() {
        LuoUusiPelaajaController.kysyKayttaja(null, golfRekisteri);
    }
    
    private void kierroksenTiedot() {
        ModalController.showModal(TuloskorttiGUIController.class.getResource("SyotaKierrosView.fxml"), "Syötä uuden kierroksen tulos", null, golfRekisteri);
    }
}