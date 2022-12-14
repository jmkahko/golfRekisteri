package fxTuloskortti;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.ohj2.WildChars;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import tuloskortti.GolfRekisteri;
import tuloskortti.Kayttaja;
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
    
    @FXML
    private TextField etsiKierrosTextField;
    
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
        chooserKierrokset.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                naytaKierros();
            }
        });
    }
    
    /**
     * Käsitellään kierroksen etsintä syöte
     */
    @FXML
    void handleEtsiKierros() {
        etsiKierros();
    }
    
    /**
     * Käsitellään uuden kierroksen syöttäminen
     */
    @FXML 
    private void handleUusiKierros() {
        uusiKierros();
    }
    
    /**
     * Käsitellään uuden seuran syöttäminen
     */
    @FXML 
    private void handleUusiSeura() {
        uusiSeura();
    }
       
    /**
     * Käsitellään seuran muokkaamista
     */
    @FXML 
    private void handleMuokkaaSeuraa() {
        ModalController.showModal(TuloskorttiGUIController.class.getResource("SeuraView.fxml"), "Muokkaa seuraa", null, golfRekisteri);
        haeKierrokset();
    }
    
    /**
     * Käsitellään kierroksen tuloskortin muokkaus
     */
    @FXML 
    private void handleMuokkaaKierrosta() {
        naytaKierros();
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
        poistaKierros();
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
    private Object[] vietavaTieto = new Object[3];
    private Kierros kierroksenKohdalla;
    private List<Kierros.YksittainenKierros> kierrokset = new ArrayList<Kierros.YksittainenKierros>();

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
    
    /**
     * Näytetään sovelluksen tiedoissa GitLab linkki projektille
     */
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
     * Käynnistyksessä jos pelaajaa ei ole luotu luodaan pelaaja
     * @return palauttaa true, että saadaan uuden pelaajan luonti auki
     */
    public boolean avaa() {     
        lueTiedostosta();
               
        if (this.golfRekisteri == null) {
            ModalController.showModal(TuloskorttiGUIController.class.getResource("LuoUusiPelaajaView.fxml"), "Luo pelaaja", null, golfRekisteri);
            return false;
        }
        haeKierrokset();
        return true;
    }
    
    /**
     * Haetaan käyttäjän tiedot tiedostosta
     */
    private void haeKayttajanTiedot() {
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
    private void haeKierrokset() {
        chooserKierrokset.clear();
        this.kierrokset.clear();

        List<Kierros> kaikkiKierrokset = (List<Kierros>) golfRekisteri.annaKaikkiKierrokset();
        int tulosLaskuri = 0;

        int rivi = 1;
        
        for (int x = 0; x < kaikkiKierrokset.size(); x++) {            
            tulosLaskuri += kaikkiKierrokset.get(x).getTulos();
            
            if (rivi >= 18) {
              String seuranNimi = "";
              for (Seura s : this.golfRekisteri.annaSeurat()) {
                  if (s.getTunnusNro() == kaikkiKierrokset.get(x).getSeuraId()) {
                      seuranNimi = s.getSeurannimi();
                  }
              }
              kierrokset.add(new Kierros.YksittainenKierros(kaikkiKierrokset.get(x).getPelattuPaiva(), seuranNimi, String.valueOf(tulosLaskuri), kaikkiKierrokset.get(x)));
              tulosLaskuri = 0;
              rivi = 0;
            }
            rivi++;
        }
        Collections.sort(kierrokset, new Kierros.VertailijaPaiva());
        
        for (Kierros.YksittainenKierros k : kierrokset) {
            chooserKierrokset.add(k.toString(), k.getKierros());
        }
    }
    
    /**
     * Haetaan kieroksen tiedot
     */
    private void naytaKierros() {
        kierroksenKohdalla = chooserKierrokset.getSelectedObject();
        
        if (kierroksenKohdalla == null) {
            Dialogs.showMessageDialog("Valitse muokattava kierros");
            return;
        }
        
        this.vietavaTieto[0] = kierroksenKohdalla;
        this.vietavaTieto[1] = golfRekisteri;
        this.vietavaTieto[2] = false; // Muuttuja tieto, että onko kyseessä Uusi kierros vai vanha. False jos vanha
                
        Object[] tulos = SyotaKierrosController.kysyKierros("Kierroksen muokkaus", null, vietavaTieto);
        if (tulos == null) {
            haeKierrokset();
            return;
        }
        haeKierrokset();
    }
    
    /**
     * Alustetaan Golf Rekisteri lukemalla valitun niminen tiedosto
     */
    private void lueTiedostosta() {
        try {
            golfRekisteri.lueTiedostosta("golfRekisteri");
            haeKayttajanTiedot();
        } catch (SailoException e) {
            if (Dialogs.showQuestionDialog("Pelaajaa ei löydy", "Haluatko luoda uuden?", "Kyllä", "Ei")) {
                luoUusiKayttaja();
                return;
            }
            Platform.exit();
        }
    }
    
    /**
     * Luodaan käyttäjä tuloskortti golf rekisterille ensimmäisellä käynnistys kerralla
     */
    private void luoUusiKayttaja() {
        GolfRekisteri luotu = LuoUusiPelaajaController.luoKayttaja("Luo käyttäjä", null, golfRekisteri);
        if (luotu == null) {
            return;
        }
        haeKayttajanTiedot();
    }
    
    /**
     * Voidaan muokata käyttäjää
     */
    private void muokkaaKayttajaa() {
        LuoUusiPelaajaController.kysyKayttaja("Muokkaa käyttäjää", null, golfRekisteri);
        haeKayttajanTiedot();
    }
    
    /**
     * Uuden kierroksen syöttäminen
     */
    private void uusiKierros() {
        // Luodaan uusi kierros dummy tiedoilla
        List<Kierros> luotuKierros = new ArrayList<Kierros>();

        for (int x = 1; x < 19; x++) {
            Kierros vayla = new Kierros();
            vayla.luoDummyKierros(x);
            luotuKierros.add(vayla);
        }
        golfRekisteri.lisaaKierros(luotuKierros);
        
        // Haetaan kaikki kierrokset
        Collection<Kierros> kaikkiKierros = this.golfRekisteri.annaKaikkiKierrokset();
        
        // Otetaan viimeinen kierros
        Kierros viimeinenKierros = new Kierros();
        for (Kierros k : kaikkiKierros) {
            viimeinenKierros = k;
        }

        this.vietavaTieto[0] = viimeinenKierros;
        this.vietavaTieto[1] = golfRekisteri;
        this.vietavaTieto[2] = true;
        
        Object[] tulos = SyotaKierrosController.luoUusiKierros("Syötä uusi kierros", null, vietavaTieto);
        
        if (tulos == null) {
            return;
        }       
        
        haeKierrokset();
    }
    
    /**
     * Lisätään tuloskorttiin uusi seura
     */
    private void uusiSeura() {
        Seura uusiSeura = new Seura();
        Seura saatiinSeura = LuoSeuraController.kysySeura("Luo uusi seura", null, uusiSeura);
        
        if (saatiinSeura == null || (saatiinSeura.getKatuosoite().equals("") && saatiinSeura.getSeurannimi().equals("") && saatiinSeura.getPuhelinnumero().equals(""))) {
            return;
        }
               
        try {
            this.golfRekisteri.lisaaSeura(uusiSeura);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia uuden seuran luonnissa: " + e.getMessage());
        }
    }
    
    /**
     * Etsitään haluttu kierros
     */
    private void etsiKierros() {
        chooserKierrokset.clear();
        int index = 0;
        String ehto = etsiKierrosTextField.getText();
        
        if (ehto.indexOf('*') < 0) {
            ehto = "*" + ehto + "*";
        }   
        
        for (Kierros.YksittainenKierros k : kierrokset) {
        
            if (WildChars.onkoSamat(k.getSeura(), ehto)) {
                chooserKierrokset.add(k.toString(), k.getKierros());
            }
        }
        
        chooserKierrokset.setSelectedIndex(index);
        
        if (ehto.length() == 0) {
            kierrokset.clear();
            haeKierrokset();
        }
    }
    
    /**
     * Poistaa halutun kierroksen
     */
    private void poistaKierros() {
        kierroksenKohdalla = chooserKierrokset.getSelectedObject();
        
        if (kierroksenKohdalla == null) {
            Dialogs.showMessageDialog("Valitse poistettava kierros");
            return;
        }
        
        String seuranNimi = "";
        for (Seura s : this.golfRekisteri.annaSeurat()) {
            if (kierroksenKohdalla.getSeuraId() == s.getTunnusNro()) {
                seuranNimi = s.getSeurannimi();
            }
        }
        
        if (!Dialogs.showQuestionDialog("Poisto", "Haluatko poistaa kierroksen: " + kierroksenKohdalla.getPelattuPaiva() + " " + seuranNimi, "Kyllä", "Ei")) {
            return;
        }
        
        Collection<Kierros> vaylat = this.golfRekisteri.annaKaikkiKierrokset();
        List<Kierros> poistettavaKierros = new ArrayList<Kierros>();
        
        int kierrosLaskuri = kierroksenKohdalla.getTunnusNro()-17; // Tulee kierroksen viimeisin kohta, tästä pitää mennä 17 pykällää taaksepäin
        
        // Otetaan kierrokset yhden tuloskortin kokoiseksi eli 18 väylää
        for (Kierros kierros : vaylat) {
            if (kierrosLaskuri > kierroksenKohdalla.getTunnusNro()) {
                break;
            }
            if (kierros.getTunnusNro() == kierrosLaskuri) {
                poistettavaKierros.add(kierros);
                kierrosLaskuri++;
            }
        }   
        
        this.golfRekisteri.poistaKierros(poistettavaKierros);
        
        int index = chooserKierrokset.getSelectedIndex();
        haeKierrokset();
        chooserKierrokset.setSelectedIndex(index);
    }
}