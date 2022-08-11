package fxTuloskortti;

import java.io.PrintStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import kanta.UusiTuloskortti;
import tuloskortti.GolfRekisteri;
import tuloskortti.SailoException;
import tuloskortti.Seura;
import tuloskortti.Tuloskortti;

/**
 * @author Janne Kähkönen
 * @version 13.6.2022
 * Seura käyttöliittymän muokkaamista varten, voidaan syöttää uusi tuloskortti tai muokata. Voidaan muokata seurantietoja
 */
public class SeuraController implements ModalControllerInterface<GolfRekisteri>, Initializable {
   
    /**
     * Golf seurojen listaus
     */
    @FXML public ListChooser<Seura> chooserSeurat;
    
    /**
     * Seuran tiedot rivit
     */
    @FXML private TextField katuosoiteTextField;
    @FXML private TextField postinumeroTextField;
    @FXML private TextField postiosoiteTextField;
    @FXML private TextField puhelinnumeroTextField;
    @FXML private TextField seuraTextField;
    
    
    @FXML private TextField vayla1_48;
    @FXML private TextField vayla1_51;
    @FXML private TextField vayla1_55;
    @FXML private TextField vayla1_62;
    @FXML private TextField vayla1_hcp;
    @FXML private TextField vayla1_par;
    
    @FXML private TextField vayla2_48;
    @FXML private TextField vayla2_51;
    @FXML private TextField vayla2_55;
    @FXML private TextField vayla2_62;
    @FXML private TextField vayla2_hcp;
    @FXML private TextField vayla2_par;
    
    @FXML private TextField vayla3_48;
    @FXML private TextField vayla3_51;
    @FXML private TextField vayla3_55;
    @FXML private TextField vayla3_62;
    @FXML private TextField vayla3_hcp;
    @FXML private TextField vayla3_par;
    
    @FXML private TextField vayla4_48;
    @FXML private TextField vayla4_51;
    @FXML private TextField vayla4_55;
    @FXML private TextField vayla4_62;
    @FXML private TextField vayla4_hcp;
    @FXML private TextField vayla4_par;
    
    @FXML private TextField vayla5_48;
    @FXML private TextField vayla5_51;
    @FXML private TextField vayla5_55;
    @FXML private TextField vayla5_62;
    @FXML private TextField vayla5_hcp;
    @FXML private TextField vayla5_par;
    
    @FXML private TextField vayla6_48;
    @FXML private TextField vayla6_51;
    @FXML private TextField vayla6_55;
    @FXML private TextField vayla6_62;
    @FXML private TextField vayla6_hcp;
    @FXML private TextField vayla6_par;
    
    @FXML private TextField vayla7_48;
    @FXML private TextField vayla7_51;
    @FXML private TextField vayla7_55;
    @FXML private TextField vayla7_62;
    @FXML private TextField vayla7_hcp;
    @FXML private TextField vayla7_par;
    
    @FXML private TextField vayla8_48;
    @FXML private TextField vayla8_51;
    @FXML private TextField vayla8_55;
    @FXML private TextField vayla8_62;
    @FXML private TextField vayla8_hcp;
    @FXML private TextField vayla8_par;
    
    @FXML private TextField vayla9_48;
    @FXML private TextField vayla9_51;
    @FXML private TextField vayla9_55;
    @FXML private TextField vayla9_62;
    @FXML private TextField vayla9_hcp;
    @FXML private TextField vayla9_par;
    
    @FXML private TextField vayla10_48;
    @FXML private TextField vayla10_51;
    @FXML private TextField vayla10_55;
    @FXML private TextField vayla10_62;
    @FXML private TextField vayla10_hcp;
    @FXML private TextField vayla10_par;
    
    @FXML private TextField vayla11_48;
    @FXML private TextField vayla11_51;
    @FXML private TextField vayla11_55;
    @FXML private TextField vayla11_62;
    @FXML private TextField vayla11_hcp;
    @FXML private TextField vayla11_par;
    
    @FXML private TextField vayla12_48;
    @FXML private TextField vayla12_51;
    @FXML private TextField vayla12_55;
    @FXML private TextField vayla12_62;
    @FXML private TextField vayla12_hcp;
    @FXML private TextField vayla12_par;
    
    @FXML private TextField vayla13_48;
    @FXML private TextField vayla13_51;
    @FXML private TextField vayla13_55;
    @FXML private TextField vayla13_62;
    @FXML private TextField vayla13_hcp;
    @FXML private TextField vayla13_par;
    
    @FXML private TextField vayla14_48;
    @FXML private TextField vayla14_51;
    @FXML private TextField vayla14_55;
    @FXML private TextField vayla14_62;
    @FXML private TextField vayla14_hcp;
    @FXML private TextField vayla14_par;
    
    @FXML private TextField vayla15_48;
    @FXML private TextField vayla15_51;
    @FXML private TextField vayla15_55;
    @FXML private TextField vayla15_62;
    @FXML private TextField vayla15_hcp;
    @FXML private TextField vayla15_par;
    
    @FXML private TextField vayla16_48;
    @FXML private TextField vayla16_51;
    @FXML private TextField vayla16_55;
    @FXML private TextField vayla16_62;
    @FXML private TextField vayla16_hcp;
    @FXML private TextField vayla16_par;
    
    @FXML private TextField vayla17_48;
    @FXML private TextField vayla17_51;
    @FXML private TextField vayla17_55;
    @FXML private TextField vayla17_62;
    @FXML private TextField vayla17_hcp;
    @FXML private TextField vayla17_par;
    
    @FXML private TextField vayla18_48;
    @FXML private TextField vayla18_51;
    @FXML private TextField vayla18_55;
    @FXML private TextField vayla18_62;
    @FXML private TextField vayla18_hcp;
    @FXML private TextField vayla18_par;

    
    /**
     * Seuran tuloskortin rivit
     */
    @FXML private ScrollPane panelTuloskortti;
    

    
    /**
     * Yhteensä tulokset
     */
    @FXML private TextField parYhteensa;
    @FXML private TextField pituusYhteensa48;
    @FXML private TextField pituusYhteensa51;
    @FXML private TextField pituusYhteensa55;
    @FXML private TextField pituusYhteensa62;
   
    
    /**
     * Voidaan muokata seurantietoja
     */
    @FXML
    private void handleMuokkaaSeuraa() {
        muokkaaSeuraa();
    }
    
    /**
     * Voidaan poistaa valittu seura
     */
    @FXML
    void handlePoistaSeura() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /**
     * Voidaan muokata tuloskorttia
     */
    @FXML
    private void handleMuokkaaTuloskortti() {
        muokkaaTuloskorttia();
    }

    /**
     * Voidaan syöttää uusi tuloskortti
     */
    @FXML
    private void handleUusiTuloskortti() {
        //ModalController.showModal(SeuraController.class.getResource("LuoUusiTuloskorttiView.fxml"), "Luo uusi tuloskortti", null, "");
        uusiTuloskortti();
    }
    
    @FXML
    void handleUusiSeura() {
        ModalController.showModal(SeuraController.class.getResource("LuoSeuraView.fxml"), "Luo uusi seura", null, golfRekisteri);
        //uusiSeura();
    }

    @Override
    public GolfRekisteri getResult() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void handleShown() {
        // TODO Auto-generated method stub

        haeSeura(0); // Haetaan seurojen tiedot, kun tullaan Seurat näkymälle ja valitaan ensimmäisessä indeksi oleva
    }

    @Override
    public void setDefault(GolfRekisteri rekisteri) {
        this.golfRekisteri = rekisteri;
        
        // Alustetaan tässä vaiheessa tässä tiedot;
        alusta();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }
    
 // =================================================================
 // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia

    private GolfRekisteri golfRekisteri;
    private TextField[] tuloskorttiEdits;
    
    
    /**
     * Alustetaan seuralistan kuuntelija
     */
    protected void alusta() {
        panelTuloskortti.setFitToHeight(true);
        chooserSeurat.clear();
        chooserSeurat.addSelectionListener(e -> naytaSeura());
        TextField[] tuloskorttiEdits = {
                vayla1_48,
                vayla1_51,
                vayla1_55,
                vayla1_62,
                vayla1_hcp,
                vayla1_par,
                vayla2_48,
                vayla2_51,
                vayla2_55,
                vayla2_62,
                vayla2_hcp,
                vayla2_par,
                vayla3_48,
                vayla3_51,
                vayla3_55,
                vayla3_62,
                vayla3_hcp,
                vayla3_par,
                vayla4_48,
                vayla4_51,
                vayla4_55,
                vayla4_62,
                vayla4_hcp,
                vayla4_par,
                vayla5_48,
                vayla5_51,
                vayla5_55,
                vayla5_62,
                vayla5_hcp,
                vayla5_par,
                vayla6_48,
                vayla6_51,
                vayla6_55,
                vayla6_62,
                vayla6_hcp,
                vayla6_par,
                vayla7_48,
                vayla7_51,
                vayla7_55,
                vayla7_62,
                vayla7_hcp,
                vayla7_par,
                vayla8_48,
                vayla8_51,
                vayla8_55,
                vayla8_62,
                vayla8_hcp,
                vayla8_par,
                vayla9_48,
                vayla9_51,
                vayla9_55,
                vayla9_62,
                vayla9_hcp,
                vayla9_par,
                vayla10_48,
                vayla10_51,
                vayla10_55,
                vayla10_62,
                vayla10_hcp,
                vayla10_par,
                vayla11_48,
                vayla11_51,
                vayla11_55,
                vayla11_62,
                vayla11_hcp,
                vayla11_par,
                vayla12_48,
                vayla12_51,
                vayla12_55,
                vayla12_62,
                vayla12_hcp,
                vayla12_par,
                vayla13_48,
                vayla13_51,
                vayla13_55,
                vayla13_62,
                vayla13_hcp,
                vayla13_par,
                vayla14_48,
                vayla14_51,
                vayla14_55,
                vayla14_62,
                vayla14_hcp,
                vayla14_par,
                vayla15_48,
                vayla15_51,
                vayla15_55,
                vayla15_62,
                vayla15_hcp,
                vayla15_par,
                vayla16_48,
                vayla16_51,
                vayla16_55,
                vayla16_62,
                vayla16_hcp,
                vayla16_par,
                vayla17_48,
                vayla17_51,
                vayla17_55,
                vayla17_62,
                vayla17_hcp,
                vayla17_par,
                vayla18_48,
                vayla18_51,
                vayla18_55,
                vayla18_62,
                vayla18_hcp,
                vayla18_par};
        this.tuloskorttiEdits = tuloskorttiEdits;
    }
    
    /**
     * Lisätään tuloskorttiin uusi seura
     */
    public void uusiSeura() {
        Seura uusiSeura = new Seura();
        uusiSeura.rekisteroi();
        uusiSeura.taytaTestiTiedoilla();
        
        try {
            this.golfRekisteri.lisaaSeura(uusiSeura);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia uuden seuran luonnissa: " + e.getMessage());
        }
        haeSeura(uusiSeura.getTunnusNro());
    }
    
    
    /**
     * @param seuranro annetaan seuran numero
     */
    public void haeSeura(int seuranro) {
        chooserSeurat.clear();
        
        int index = 0;
        for (int x = 0; x < this.golfRekisteri.getSeuroja(); x++) {
            Seura seura = this.golfRekisteri.annaSeura(x);
            if (seura.getTunnusNro() == seuranro) index = x;
            chooserSeurat.add(seura.getSeurannimi(), seura);
        }
        chooserSeurat.setSelectedIndex(index);        
    }
    
    /**
     * Luodaan uusi tulokortti seuralle
     */
    public void uusiTuloskortti() {
        Seura seuranKohdalla = chooserSeurat.getSelectedObject();
        
        if (seuranKohdalla == null) {
            return;
        }

        golfRekisteri.lisaaTuloskortti(UusiTuloskortti.luoTuloskortti(seuranKohdalla.getTunnusNro()));
        naytaTuloskortti(tuloskorttiEdits, seuranKohdalla);
    }
    
    /**
     * Hakee seuran tiedot joka on valittuna seura listalla
     */
    public void naytaSeura() {
        Seura seuranKohdalla = chooserSeurat.getSelectedObject();
        
        if (seuranKohdalla == null) {
            return;
        }
        
        seuraTextField.setText(seuranKohdalla.getSeurannimi());
        katuosoiteTextField.setText(seuranKohdalla.getKatuosoite());
        postinumeroTextField.setText(String.valueOf(seuranKohdalla.getPostinumero()));
        postiosoiteTextField.setText(seuranKohdalla.getPostitoimipaikka());
        puhelinnumeroTextField.setText(seuranKohdalla.getPuhelinnumero());
        naytaTuloskortti(tuloskorttiEdits, seuranKohdalla);
    }

    /**
     * Hakee seuran tuloskortin joka on valittuna seura listalta
     * @param edits viedään näytettävät kentät
     * @param seura jonka tuloskortti näytetään
     */
    public void naytaTuloskortti(TextField[] edits, Seura seura) {
        if (seura == null) {
            return;
        }
        
        List<Tuloskortti> tuloskortti = golfRekisteri.annaTuloskortti(seura);

        int pituus48 = 0;
        int pituus51 = 0;
        int pituus55 = 0;
        int pituus62 = 0;
        int par = 0;
        
        int x = 0;
        for (Tuloskortti t : tuloskortti) {
            // Lisätään textField sarakkeisiin tuloskortin tiedot
            edits[x].setText(String.valueOf(t.getPituus48()));
            pituus48 += t.getPituus48();
            x++;
            edits[x].setText(String.valueOf(t.getPituus51()));
            pituus51 += t.getPituus51();
            x++;
            edits[x].setText(String.valueOf(t.getPituus55()));
            pituus55 += t.getPituus55();
            x++;
            edits[x].setText(String.valueOf(t.getPituus62()));
            pituus62 += t.getPituus62();
            x++;
            edits[x].setText(String.valueOf(t.getHcp()));
            x++;
            edits[x].setText(String.valueOf(t.getPar()));
            par += t.getPar();
            x++;
        }
        
        pituusYhteensa48.setText(String.valueOf(pituus48));
        pituusYhteensa51.setText(String.valueOf(pituus51));
        pituusYhteensa55.setText(String.valueOf(pituus55));
        pituusYhteensa62.setText(String.valueOf(pituus62));
        parYhteensa.setText(String.valueOf(par));
    }
    
    /**
     * Tulostetaan tuloskortin tiedot
     * @param os PrintStream
     * @param seura minkä tuloskortti tulostetaan
     */
    @SuppressWarnings("unused") // TODO: poistetaan kun käytetään
    private void tulosta(PrintStream os, final Seura seura) {
        os.println("-------- Pituudet --- " + seura.getSeurannimi());
        os.println("---Väylä - 62, 55, 51, 48, PAR, HCP----");
        List<Tuloskortti> tuloskortti = golfRekisteri.annaTuloskortti(seura);
        
        for (Tuloskortti t : tuloskortti) {
            t.tulosta(os);
        }
        os.println("---------------------------------------");
    }
    
    /**
     * Muokataan seuran tietoja
     */
    private void muokkaaSeuraa() {
        Seura seuranKohdalla = chooserSeurat.getSelectedObject();
        if (seuranKohdalla == null) {
            return;
        }
        Seura seura = LuoSeuraController.kysySeura(null, seuranKohdalla);
        
        if (seura == null) {
            return;
        }
        haeSeura(seura.getTunnusNro());
    }
    
    /**
     * Muokataan tuloskortin tietoja
     */
    private void muokkaaTuloskorttia() {
        Seura seuranKohdalla = chooserSeurat.getSelectedObject();
        
        if (seuranKohdalla == null) {
            return;
        }

       List<Tuloskortti> tuloskorttia = LuoUusiTuloskorttiController.kysyTuloskortti(null, this.golfRekisteri.annaTuloskortti(seuranKohdalla));
        
        if (tuloskorttia == null) {
            return;
        }
    }
}
