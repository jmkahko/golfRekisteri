package fxTuloskortti;

import java.io.PrintStream;
import java.util.List;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.TextAreaOutputStream;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import kanta.UusiTuloskortti;
import tuloskortti.GolfRekisteri;
import tuloskortti.SailoException;
import tuloskortti.Seura;
import tuloskortti.Tuloskortit;
import tuloskortti.Tuloskortti;

/**
 * @author janne
 * @version 13.6.2022
 * Seura käyttöliittymän muokkaamista varten, voidaan syöttää uusi tuloskortti tai muokata. Voidaan muokata seurantietoja
 */
public class SeuraController implements ModalControllerInterface<GolfRekisteri> {
   
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
    
    /**
     * Seuran tuloskortin rivit
     */
    @FXML private ScrollPane panelTuloskortti;
    
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
     * Voidaan muokata seurantietoja
     */
    @FXML
    private void handleMuokkaaSeuraa() {
        //ModalController.showModal(SeuraController.class.getResource("LuoSeuraView.fxml"), "Muokkaa seuraa", null, "");
        uusiSeura();
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
        ModalController.showModal(SeuraController.class.getResource("LuoUusiTuloskorttiView.fxml"), "Muokkaa tuloskorttia", null, "");
    }

    /**
     * Voidaan syöttää uusi tuloskortti
     */
    @FXML
    private void handleUusiTuloskortti() {
        //ModalController.showModal(SeuraController.class.getResource("LuoUusiTuloskorttiView.fxml"), "Luo uusi tuloskortti", null, "");
        uusiTuloskortti();
    }

    @Override
    public GolfRekisteri getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDefault(GolfRekisteri rekisteri) {
        this.golfRekisteri = rekisteri;
        
        // Alustetaan tässä vaiheessa tässä tiedot;
        alusta();
        
        
    }
    
 // =================================================================
 // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia

    private GolfRekisteri golfRekisteri;
    private TextArea areaTuloskortti = new TextArea();
    
    
    /**
     * Tekee tarvittavat alustukset vaihdetaan GridPanen tilalle yksi iso tekstikenttä, johon tulostetaan seuran tuloskortti
     * Alustetaan seuralistan kuuntelija
     */
    protected void alusta() {
        panelTuloskortti.setContent(areaTuloskortti);
        areaTuloskortti.setFont(new Font("Courier New", 12));
        panelTuloskortti.setFitToHeight(true);
        
        chooserSeurat.clear();
        chooserSeurat.addSelectionListener(e -> naytaSeura());
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
     * Luodaan uusi tulokortti seuralle. Luo uuden väylän tuloskortille
     */
    public void uusiTuloskortti() {
        Seura seuranKohdalla = chooserSeurat.getSelectedObject();
        
        if (seuranKohdalla == null) {
            return;
        }

        golfRekisteri.lisaaTuloskortti(UusiTuloskortti.luoTuloskortti(seuranKohdalla.getTunnusNro()));

        Dialogs.showMessageDialog("Tuloskortti generoitu automaattisesti");
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
        naytaTuloskortti(seuranKohdalla);
    }

    /**
     * Hakee seuran tuloskortin joka on valittuna seura listalta
     * @param seura jonka tuloskortti näytetään
     */
    public void naytaTuloskortti(Seura seura) {
        if (seura == null) {
            return;
        }
        
        areaTuloskortti.setText("");
        try (PrintStream os = TextAreaOutputStream.getTextPrintStream(areaTuloskortti)) {
            tulosta(os, seura);
        }
    }
    
    /**
     * Tulostetaan tuloskortin tiedot
     * @param os PrintStream
     * @param seura minkä tuloskortti tulostetaan
     */
    private void tulosta(PrintStream os, final Seura seura) {
        os.println("-------- Pituudet --- " + seura.getSeurannimi());
        os.println("---Väylä - 62, 55, 51, 48, PAR, HCP----");
        List<Tuloskortti> tuloskortti = golfRekisteri.annaTuloskortti(seura);
        
        for (Tuloskortti t : tuloskortti) {
            t.tulosta(os);
        }
        os.println("---------------------------------------");
    }
}
