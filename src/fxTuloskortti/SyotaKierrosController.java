package fxTuloskortti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tuloskortti.GolfRekisteri;
import tuloskortti.Kierros;
import tuloskortti.Seura;
import tuloskortti.Tuloskortti;

/**
 * @author Janne Kähkönen
 * @version 13.6.2022
 * Pelatun kierroksen tuloksen syöttäminen
 */
public class SyotaKierrosController implements ModalControllerInterface<Object[]> {

    /**
     * Golf seuran, pelatun teen, päiväyksen valinta ja yhteensä tulokset
     */
    @FXML private DatePicker paivaPicker;
    @FXML private ChoiceBox<String> seuraChoiceBox;
    @FXML private ChoiceBox<String> teeChoiseBox;
    @FXML private TextField matkaYhteensa;
    @FXML private TextField parYhteensa;
    @FXML private TextField tulosYhteensa;
    @FXML private TextField pelattuTee;
    
    /**
     * Pelattujen väylien HCP kentät
     */
    @FXML private TextField vaylaHcp1;
    @FXML private TextField vaylaHcp10;
    @FXML private TextField vaylaHcp11;
    @FXML private TextField vaylaHcp12;
    @FXML private TextField vaylaHcp13;
    @FXML private TextField vaylaHcp14;
    @FXML private TextField vaylaHcp15;
    @FXML private TextField vaylaHcp16;
    @FXML private TextField vaylaHcp17;
    @FXML private TextField vaylaHcp18;
    @FXML private TextField vaylaHcp2;
    @FXML private TextField vaylaHcp3;
    @FXML private TextField vaylaHcp4;
    @FXML private TextField vaylaHcp5;
    @FXML private TextField vaylaHcp6;
    @FXML private TextField vaylaHcp7;
    @FXML private TextField vaylaHcp8;
    @FXML private TextField vaylaHcp9;

    /**
     * Pelattujen välien tuloskenttä
     */
    @FXML private TextField vaylaId_1;
    @FXML private TextField vaylaId_10;
    @FXML private TextField vaylaId_11;
    @FXML private TextField vaylaId_12;
    @FXML private TextField vaylaId_13;
    @FXML private TextField vaylaId_14;
    @FXML private TextField vaylaId_15;
    @FXML private TextField vaylaId_16;
    @FXML private TextField vaylaId_17;
    @FXML private TextField vaylaId_18;
    @FXML private TextField vaylaId_2;
    @FXML private TextField vaylaId_3;
    @FXML private TextField vaylaId_4;
    @FXML private TextField vaylaId_5;
    @FXML private TextField vaylaId_6;
    @FXML private TextField vaylaId_7;
    @FXML private TextField vaylaId_8;
    @FXML private TextField vaylaId_9;
    
    /**
     * Pelattujen välien par kentät
     */
    @FXML private TextField vaylaPar1;
    @FXML private TextField vaylaPar10;
    @FXML private TextField vaylaPar11;
    @FXML private TextField vaylaPar12;
    @FXML private TextField vaylaPar13;
    @FXML private TextField vaylaPar14;
    @FXML private TextField vaylaPar15;
    @FXML private TextField vaylaPar16;
    @FXML private TextField vaylaPar17;
    @FXML private TextField vaylaPar18;
    @FXML private TextField vaylaPar2;
    @FXML private TextField vaylaPar3;
    @FXML private TextField vaylaPar4;
    @FXML private TextField vaylaPar5;
    @FXML private TextField vaylaPar6;
    @FXML private TextField vaylaPar7;
    @FXML private TextField vaylaPar8;
    @FXML private TextField vaylaPar9;

    /**
     * Pelattujen välien tee paikan pituudet
     */
    @FXML private TextField vaylaTee1;
    @FXML private TextField vaylaTee10;
    @FXML private TextField vaylaTee11;
    @FXML private TextField vaylaTee12;
    @FXML private TextField vaylaTee13;
    @FXML private TextField vaylaTee14;
    @FXML private TextField vaylaTee15;
    @FXML private TextField vaylaTee16;
    @FXML private TextField vaylaTee17;
    @FXML private TextField vaylaTee18;
    @FXML private TextField vaylaTee2;
    @FXML private TextField vaylaTee3;
    @FXML private TextField vaylaTee4;
    @FXML private TextField vaylaTee5;
    @FXML private TextField vaylaTee6;
    @FXML private TextField vaylaTee7;
    @FXML private TextField vaylaTee8;
    @FXML private TextField vaylaTee9;
    
    /**
     * Perutaan tehdyt muutokset
     * @param event
     */
    @FXML
    private void handlePeruuta() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Tallennetaan syötetty kierros
     * @param event
     */
    @FXML
    private void handleTallenna() {
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }
    
    /**
     * Valitaan päiväys pelatulle kierrokselle
     * @param event
     */
    @FXML
    private void handlePaivays() {
        //Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }



    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        boolean naytettavaKierros = (boolean) this.objectLista[2];
        if (!naytettavaKierros) {
            naytaKierros(kierrosEdits, objectLista);
        } else {
            syotaUusiKierros(kierrosEdits, objectLista);
        }
    }



    @Override
    public Object[] getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDefault(Object[] lista) {
        this.objectLista = lista;
        alusta();
    }
    
    // =================================================================
    // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia
    
    private Object[] objectLista;
    private TextField[] kierrosEdits;
    
    /**
     * Alustetaan kierroslistan kuuntelijat
     */
    protected void alusta() {

        TextField[] kierrosEdits = {
                vaylaTee1, vaylaPar1, vaylaHcp1, vaylaId_1,
                vaylaTee2, vaylaPar2, vaylaHcp2, vaylaId_2,
                vaylaTee3, vaylaPar3, vaylaHcp3, vaylaId_3,
                vaylaTee4, vaylaPar4, vaylaHcp4, vaylaId_4,
                vaylaTee5, vaylaPar5, vaylaHcp5, vaylaId_5,
                vaylaTee6, vaylaPar6, vaylaHcp6, vaylaId_6,
                vaylaTee7, vaylaPar7, vaylaHcp7, vaylaId_7,
                vaylaTee8, vaylaPar8, vaylaHcp8, vaylaId_8,
                vaylaTee9, vaylaPar9, vaylaHcp9, vaylaId_9,
                vaylaTee10, vaylaPar10, vaylaHcp10, vaylaId_10,
                vaylaTee11, vaylaPar11, vaylaHcp11, vaylaId_11,
                vaylaTee12, vaylaPar12, vaylaHcp12, vaylaId_12,
                vaylaTee13, vaylaPar13, vaylaHcp13, vaylaId_13,
                vaylaTee14, vaylaPar14, vaylaHcp14, vaylaId_14,
                vaylaTee15, vaylaPar15, vaylaHcp15, vaylaId_15,
                vaylaTee16, vaylaPar16, vaylaHcp16, vaylaId_16,
                vaylaTee17, vaylaPar17, vaylaHcp17, vaylaId_17,
                vaylaTee18, vaylaPar18, vaylaHcp18, vaylaId_18
        };
        this.kierrosEdits = kierrosEdits;
    }

    /**
     * Luodaan kierroksen muokkaus dialogi ja palautetaan sama tietue muutettuna tai null arvo
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param object taulukossa tuodaan pelattu kierros ja golfRekisteri, jotta saadaan tuloskortti ja seuratiedot myös
     * @return null jos painetaan Peruuta, muuten täytetään tietue
     */
    public static Object[] kysyKierros(Stage modalityStage, Object[] object) {
        return ModalController.showModal(TuloskorttiGUIController.class.getResource("SyotaKierrosView.fxml"), "Syötä uuden kierroksen tulos", modalityStage, object);
    }
    
    /**
     * Näyttää kierroksen tiedot
     * @param edits näyttää kierroksen kentät
     * @param object taulukko
     */
    public void naytaKierros(TextField[] edits, Object[] object) {
        
        Kierros kierroksenKohdalla = (Kierros) object[0];
        GolfRekisteri golfRekisteri = (GolfRekisteri) object[1];
        
        Seura seura = golfRekisteri.annaSeura(kierroksenKohdalla.getSeuraId()-1);        
        Collection<Kierros> kaikkiKierrokset = golfRekisteri.annaKaikkiKierrokset();
        
        // Tiedot joista paristaan näyttönäkymä
        List<Kierros> halututKierrokset = new ArrayList<Kierros>();
        List<Tuloskortti> tuloskortinTiedot = golfRekisteri.annaTuloskortti(seura);
        int kierrosLaskuri = kierroksenKohdalla.getTunnusNro()-17; // Tulee kierroksen viimeisin kohta, tästä pitää mennä 17 pykällää taaksepäin
        
        // Otetaan kierrokset yhden tuloskortin kokoiseksi eli 18 väylää
        for (Kierros k : kaikkiKierrokset) {
            if (kierrosLaskuri > kierroksenKohdalla.getTunnusNro()) {
                break;
            }
            if (k.getTunnusNro() == kierrosLaskuri) {
                halututKierrokset.add(k);
                kierrosLaskuri++;
            }
        }   
        
        int tulosLaskuri = 0;
        int parLaskuri = 0;
        int matkaLaskuri = 0;        

        int i = 0;
        for (int x = 0; x < 18; x++) {
            
            if (kierroksenKohdalla.getPelattuTee() == 62) {
                edits[i].setText(String.valueOf(tuloskortinTiedot.get(x).getPituus62()));
                matkaLaskuri += tuloskortinTiedot.get(x).getPituus62();
            } else if (kierroksenKohdalla.getPelattuTee() == 55) {
                edits[i].setText(String.valueOf(tuloskortinTiedot.get(x).getPituus55()));
                matkaLaskuri += tuloskortinTiedot.get(x).getPituus55();
            } else if (kierroksenKohdalla.getPelattuTee() == 51) {
                edits[i].setText(String.valueOf(tuloskortinTiedot.get(x).getPituus51()));
                matkaLaskuri += tuloskortinTiedot.get(x).getPituus51();
            } else {
                edits[i].setText(String.valueOf(tuloskortinTiedot.get(x).getPituus48()));
                matkaLaskuri += tuloskortinTiedot.get(x).getPituus48();
            }

            i++;
            edits[i].setText(String.valueOf(tuloskortinTiedot.get(x).getPar()));
            i++;
            edits[i].setText(String.valueOf(tuloskortinTiedot.get(x).getHcp()));
            i++;
            edits[i].setText(String.valueOf(halututKierrokset.get(x).getTulos()));
            i++;
            
            parLaskuri += tuloskortinTiedot.get(x).getPar();
            tulosLaskuri += halututKierrokset.get(x).getTulos();
        }       
        
        matkaYhteensa.setText(String.valueOf(matkaLaskuri));
        parYhteensa.setText(String.valueOf(parLaskuri));
        tulosYhteensa.setText(String.valueOf(tulosLaskuri));
        pelattuTee.setText(String.valueOf(kierroksenKohdalla.getPelattuTee()));
        
        // Formatoidaan aika ja asetataan DatePicker boksiin
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate formatLocalDate = LocalDate.parse(kierroksenKohdalla.getPelattuPaiva(), formatDate);
        paivaPicker.setValue(formatLocalDate);

        teeChoiseBox.setValue(String.valueOf(kierroksenKohdalla.getPelattuTee()));
        seuraChoiceBox.setValue(seura.getSeurannimi());
    }
    
    /**
     * Syötetään uudet kierroksen tiedot
     * @param edits näyttää kierroksen kentät
     * @param object taulukko
     */
    private void syotaUusiKierros(TextField[] edits, Object[] object) {
        //
    }
    
 }
