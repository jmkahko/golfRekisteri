package fxTuloskortti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tuloskortti.SailoException;
import tuloskortti.Tuloskortti;

/**
 * @author Janne Kähkönen
 * @version 13.6.2022
 * Uuden tuloskortin luonti seuralle
 */
public class LuoUusiTuloskorttiController implements ModalControllerInterface<List<Tuloskortti>>, Initializable {
    
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
     * Yhteensä tulokset
     */
    @FXML private TextField parYhteensa;
    @FXML private TextField pituusYhteensa48;
    @FXML private TextField pituusYhteensa51;
    @FXML private TextField pituusYhteensa55;
    @FXML private TextField pituusYhteensa62;

    /**
     * Peruuta muutokset
     * @param event
     */
    @FXML
    private void handlePeruuta() {
        ModalController.closeStage(parYhteensa);
    }

    /**
     * Tallenna tuloskortin muutokset
     * @param event
     */
    @FXML
    private void handleTallenna() {
        ModalController.closeStage(parYhteensa);
    }


    @Override
    public void handleShown() {
        if (this.tuloskorttiLista.size() == 0) {
            tyhjennaTuloskortti();
        }
        naytaTuloskortti(tuloskorttiEdits, tuloskorttiLista);
    }  
    
    
    @Override
    public List<Tuloskortti> getResult() {
        return tuloskorttiLista;
    }

    @Override
    public void setDefault(List<Tuloskortti> lista) {
        this.tuloskorttiLista = lista;
        alusta();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        vayla1_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(1, 1, vayla1_48));
        vayla1_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(1, 2, vayla1_51));
        vayla1_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(1, 3, vayla1_55));
        vayla1_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(1, 4, vayla1_62));
        vayla1_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(1, 5, vayla1_hcp));
        vayla1_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(1, 6, vayla1_par));
        
        vayla2_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(2, 1, vayla2_48));
        vayla2_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(2, 2, vayla2_51));
        vayla2_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(2, 3, vayla2_55));
        vayla2_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(2, 4, vayla2_62));
        vayla2_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(2, 5, vayla2_hcp));
        vayla2_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(2, 6, vayla2_par));

        vayla3_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(3, 1, vayla3_48));
        vayla3_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(3, 2, vayla3_51));
        vayla3_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(3, 3, vayla3_55));
        vayla3_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(3, 4, vayla3_62));
        vayla3_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(3, 5, vayla3_hcp));
        vayla3_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(3, 6, vayla3_par));
        
        vayla4_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(4, 1, vayla4_48));
        vayla4_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(4, 2, vayla4_51));
        vayla4_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(4, 3, vayla4_55));
        vayla4_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(4, 4, vayla4_62));
        vayla4_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(4, 5, vayla4_hcp));
        vayla4_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(4, 6, vayla4_par));
        
        vayla5_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(5, 1, vayla5_48));
        vayla5_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(5, 2, vayla5_51));
        vayla5_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(5, 3, vayla5_55));
        vayla5_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(5, 4, vayla5_62));
        vayla5_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(5, 5, vayla5_hcp));
        vayla5_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(5, 6, vayla5_par));
        
        vayla6_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(6, 1, vayla6_48));
        vayla6_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(6, 2, vayla6_51));
        vayla6_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(6, 3, vayla6_55));
        vayla6_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(6, 4, vayla6_62));
        vayla6_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(6, 5, vayla6_hcp));
        vayla6_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(6, 6, vayla6_par));
        
        vayla7_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(7, 1, vayla7_48));
        vayla7_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(7, 2, vayla7_51));
        vayla7_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(7, 3, vayla7_55));
        vayla7_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(7, 4, vayla7_62));
        vayla7_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(7, 5, vayla7_hcp));
        vayla7_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(7, 6, vayla7_par));
        
        vayla8_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(8, 1, vayla8_48));
        vayla8_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(8, 2, vayla8_51));
        vayla8_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(8, 3, vayla8_55));
        vayla8_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(8, 4, vayla8_62));
        vayla8_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(8, 5, vayla8_hcp));
        vayla8_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(8, 6, vayla8_par));
        
        vayla9_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(9, 1, vayla9_48));
        vayla9_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(9, 2, vayla9_51));
        vayla9_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(9, 3, vayla9_55));
        vayla9_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(9, 4, vayla9_62));
        vayla9_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(9, 5, vayla9_hcp));
        vayla9_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(9, 6, vayla9_par));

        vayla10_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(10, 1, vayla10_48));
        vayla10_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(10, 2, vayla10_51));
        vayla10_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(10, 3, vayla10_55));
        vayla10_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(10, 4, vayla10_62));
        vayla10_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(10, 5, vayla10_hcp));
        vayla10_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(10, 6, vayla10_par));
        
        vayla11_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(11, 1, vayla11_48));
        vayla11_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(11, 2, vayla11_51));
        vayla11_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(11, 3, vayla11_55));
        vayla11_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(11, 4, vayla11_62));
        vayla11_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(11, 5, vayla11_hcp));
        vayla11_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(11, 6, vayla11_par));
        
        vayla12_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(12, 1, vayla12_48));
        vayla12_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(12, 2, vayla12_51));
        vayla12_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(12, 3, vayla12_55));
        vayla12_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(12, 4, vayla12_62));
        vayla12_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(12, 5, vayla12_hcp));
        vayla12_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(12, 6, vayla12_par));

        vayla13_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(13, 1, vayla13_48));
        vayla13_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(13, 2, vayla13_51));
        vayla13_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(13, 3, vayla13_55));
        vayla13_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(13, 4, vayla13_62));
        vayla13_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(13, 5, vayla13_hcp));
        vayla13_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(13, 6, vayla13_par));
        
        vayla14_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(14, 1, vayla14_48));
        vayla14_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(14, 2, vayla14_51));
        vayla14_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(14, 3, vayla14_55));
        vayla14_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(14, 4, vayla14_62));
        vayla14_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(14, 5, vayla14_hcp));
        vayla14_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(14, 6, vayla14_par));
        
        vayla15_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(15, 1, vayla15_48));
        vayla15_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(15, 2, vayla15_51));
        vayla15_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(15, 3, vayla15_55));
        vayla15_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(15, 4, vayla15_62));
        vayla15_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(15, 5, vayla15_hcp));
        vayla15_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(15, 6, vayla15_par));
        
        vayla16_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(16, 1, vayla16_48));
        vayla16_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(16, 2, vayla16_51));
        vayla16_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(16, 3, vayla16_55));
        vayla16_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(16, 4, vayla16_62));
        vayla16_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(16, 5, vayla16_hcp));
        vayla16_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(16, 6, vayla16_par));
        
        vayla17_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(17, 1, vayla17_48));
        vayla17_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(17, 2, vayla17_51));
        vayla17_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(17, 3, vayla17_55));
        vayla17_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(17, 4, vayla17_62));
        vayla17_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(17, 5, vayla17_hcp));
        vayla17_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(17, 6, vayla17_par));
        
        vayla18_48.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(18, 1, vayla18_48));
        vayla18_51.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(18, 2, vayla18_51));
        vayla18_55.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(18, 3, vayla18_55));
        vayla18_62.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(18, 4, vayla18_62));
        vayla18_hcp.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(18, 5, vayla18_hcp));
        vayla18_par.setOnKeyReleased(e -> kasitteleTuloskorttiMuutos(18, 6, vayla18_par));
    }

    
    // =================================================================
    // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia
    
    private List<Tuloskortti> tuloskorttiLista;
    private TextField[] tuloskorttiEdits;
    
    /**
     * Käsitellään kierroksen tuloksen muutoksia ja uuden kierroksen lisäyksessä seuran, tee-paikan ja päiväyksen muutoksia
     * @param vayla muutettava väylä
     * @param k TextField kentän rivinumero
     * @param edit TextField kenttä
     */
    private void kasitteleTuloskorttiMuutos(int vayla, int k, TextField edit) {
        if (this.tuloskorttiLista == null || this.tuloskorttiLista.size() == 0) {
            return;
        }
        
        int numero = 0;
        
        try {
            numero = Integer.parseInt(edit.getText());
        } catch (NumberFormatException e) {
            Dialogs.showMessageDialog("Kenttään ei voi syöttää kirjaimia");
        }
        
        int rivi = 1;
        for (Tuloskortti t : tuloskorttiLista) {
            if (rivi == vayla) {
                switch (k) {
                    case 1: t.setPituus48(numero); break;
                    case 2: t.setPituus51(numero); break;
                    case 3: t.setPituus55(numero); break;
                    case 4: t.setPituus62(numero); break;
                    case 5: t.setHcp(numero); break;
                    case 6: t.setPar(numero); break;
                default:
                    break;
                }
            }
            rivi++;
        }
    }
    
    /**
     * Alustetaan tuloskortin tiedot
     */
    protected void alusta() {
        TextField[] tuloskorttiEdits = {
                vayla1_48, vayla1_51, vayla1_55, vayla1_62, vayla1_hcp, vayla1_par,
                vayla2_48, vayla2_51, vayla2_55, vayla2_62, vayla2_hcp, vayla2_par,
                vayla3_48, vayla3_51, vayla3_55, vayla3_62, vayla3_hcp, vayla3_par,
                vayla4_48, vayla4_51, vayla4_55, vayla4_62, vayla4_hcp, vayla4_par,
                vayla5_48, vayla5_51, vayla5_55, vayla5_62, vayla5_hcp, vayla5_par,
                vayla6_48, vayla6_51, vayla6_55, vayla6_62, vayla6_hcp, vayla6_par,
                vayla7_48, vayla7_51, vayla7_55, vayla7_62, vayla7_hcp, vayla7_par,
                vayla8_48, vayla8_51, vayla8_55, vayla8_62, vayla8_hcp, vayla8_par,
                vayla9_48, vayla9_51, vayla9_55, vayla9_62, vayla9_hcp, vayla9_par,
                vayla10_48, vayla10_51, vayla10_55, vayla10_62, vayla10_hcp, vayla10_par,
                vayla11_48, vayla11_51, vayla11_55, vayla11_62, vayla11_hcp, vayla11_par,
                vayla12_48, vayla12_51, vayla12_55, vayla12_62, vayla12_hcp, vayla12_par,
                vayla13_48, vayla13_51, vayla13_55, vayla13_62, vayla13_hcp, vayla13_par,
                vayla14_48, vayla14_51, vayla14_55, vayla14_62, vayla14_hcp, vayla14_par,
                vayla15_48, vayla15_51, vayla15_55, vayla15_62, vayla15_hcp, vayla15_par,
                vayla16_48, vayla16_51, vayla16_55, vayla16_62, vayla16_hcp, vayla16_par,
                vayla17_48, vayla17_51, vayla17_55, vayla17_62, vayla17_hcp, vayla17_par,
                vayla18_48, vayla18_51, vayla18_55, vayla18_62, vayla18_hcp, vayla18_par};
        this.tuloskorttiEdits = tuloskorttiEdits;
    }
    
    /**
     * Luodaan tuloskortin muokkaus dialogi ja palautetaan sama tietue muutettuna tai null arvo
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param tuloskortti mitä dataa näytetään oletuksena, kun muokataan tuloskorttia, niin olemassa olevan tuloskortin tiedot
     * @param mitaTehdaan muokataanko vai luodaanko uutta
     * @return null jos painetaan Peruuta, muuten täytetään tietue
     */
    public static List<Tuloskortti> kysyTuloskortti(String mitaTehdaan, Stage modalityStage, List<Tuloskortti> tuloskortti) {
        return ModalController.showModal(SeuraController.class.getResource("LuoUusiTuloskorttiView.fxml"), mitaTehdaan, modalityStage, tuloskortti);
    }
    
    /**
     * Alustetaan / tyhjennetään tuloskortti
     */
    private void tyhjennaTuloskortti() {
        for (int x = 0; x < this.tuloskorttiEdits.length; x++) {
            this.tuloskorttiEdits[x].setText("");
        }
    }
    
    /**
     * Hakee seuran tuloskortin joka on valittuna seura listalta
     * @param edits viedään näytettävät kentät
     * @param lista jonka tuloskortti näytetään
     */
    private void naytaTuloskortti(TextField[] edits, List<Tuloskortti> lista) {
        if (lista == null) {
            return;
        }
        
        int pituus48 = 0;
        int pituus51 = 0;
        int pituus55 = 0;
        int pituus62 = 0;
        int par = 0;

        int x = 0;
        for (Tuloskortti t : lista) {
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
}
