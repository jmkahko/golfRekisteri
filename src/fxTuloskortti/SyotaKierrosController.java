package fxTuloskortti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class SyotaKierrosController implements ModalControllerInterface<Object[]>, Initializable {

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
        ModalController.closeStage(parYhteensa);
    }

    /**
     * Tallennetaan syötetty kierros
     * @param event
     */
    @FXML
    private void handleTallenna() {
        ModalController.closeStage(parYhteensa);
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
            alustaSeuraNakyma(objectLista);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        // TODO Auto-generated method stub
        


//        teeChoiseBox.getSelectionModel().selectedIndexProperty().addListener((InvalidationListener) new ChangeListener<String>() {
//
//            @Override
//            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
//                // TODO Auto-generated method stub
//                System.out.println("muuttuiko");
//            }
//
//        });
        

        vaylaId_1.setOnKeyReleased(e -> kasitteleKierrosMuutos(1, vaylaId_1));
        vaylaId_2.setOnKeyReleased(e -> kasitteleKierrosMuutos(2, vaylaId_2));
        vaylaId_3.setOnKeyReleased(e -> kasitteleKierrosMuutos(3, vaylaId_3));
        vaylaId_4.setOnKeyReleased(e -> kasitteleKierrosMuutos(4, vaylaId_4));
        vaylaId_5.setOnKeyReleased(e -> kasitteleKierrosMuutos(5, vaylaId_5));
        vaylaId_6.setOnKeyReleased(e -> kasitteleKierrosMuutos(6, vaylaId_6));
        vaylaId_7.setOnKeyReleased(e -> kasitteleKierrosMuutos(7, vaylaId_7));
        vaylaId_8.setOnKeyReleased(e -> kasitteleKierrosMuutos(8, vaylaId_8));
        vaylaId_9.setOnKeyReleased(e -> kasitteleKierrosMuutos(9, vaylaId_9));
        vaylaId_10.setOnKeyReleased(e -> kasitteleKierrosMuutos(10, vaylaId_10));
        vaylaId_11.setOnKeyReleased(e -> kasitteleKierrosMuutos(11, vaylaId_11));
        vaylaId_12.setOnKeyReleased(e -> kasitteleKierrosMuutos(12, vaylaId_12));
        vaylaId_13.setOnKeyReleased(e -> kasitteleKierrosMuutos(13, vaylaId_13));
        vaylaId_14.setOnKeyReleased(e -> kasitteleKierrosMuutos(14, vaylaId_14));
        vaylaId_15.setOnKeyReleased(e -> kasitteleKierrosMuutos(15, vaylaId_15));
        vaylaId_16.setOnKeyReleased(e -> kasitteleKierrosMuutos(16, vaylaId_16));
        vaylaId_17.setOnKeyReleased(e -> kasitteleKierrosMuutos(17, vaylaId_17));
        vaylaId_18.setOnKeyReleased(e -> kasitteleKierrosMuutos(18, vaylaId_18));
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
    
    private void kasitteleKierrosMuutos(int k, TextField edit) {
        Kierros kierroksenKohdalla = (Kierros) objectLista[0];

        if (kierroksenKohdalla == null) {
            return;
        }
        
        String s = edit.getText();
        System.out.println(s);
        for (int x = 0; x < 18; x++) {
            if (x == k) {
                // TODO: muokata, että halutun väylän tulosta voidaan muokata, nyt muokkautuu viimeinen
                kierroksenKohdalla.setTulos(Integer.valueOf(s));
            }
        }
    }
    
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
     * @param otsikkotieto tuodaan otsikko näkymälle
     * @param modalityStage mille ollaan modaalisia, null = sovellukselle
     * @param object taulukossa tuodaan pelattu kierros ja golfRekisteri, jotta saadaan tuloskortti ja seuratiedot myös
     * @return null jos painetaan Peruuta, muuten täytetään tietue
     */
    public static Object[] kysyKierros(String otsikkotieto, Stage modalityStage, Object[] object) {
        return ModalController.showModal(TuloskorttiGUIController.class.getResource("SyotaKierrosView.fxml"), otsikkotieto, modalityStage, object);
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
     * Alustetaan uuden kierroksen seuran näyttäminen. Tuodaan seuran tiedot ja tee paikat
     * @param object
     */
    private void alustaSeuraNakyma(Object[] object) {
        GolfRekisteri golfRekisteri = (GolfRekisteri) object[1];
        List<Seura> seura = golfRekisteri.annaSeurat();
        
        // Tietojen asettaminen bokseihin
        for (Seura s: seura) {
            seuraChoiceBox.getItems().add(s.getSeurannimi());
        }
        
        teeChoiseBox.getItems().add(String.valueOf(62));
        teeChoiseBox.getItems().add(String.valueOf(55));
        teeChoiseBox.getItems().add(String.valueOf(51));
        teeChoiseBox.getItems().add(String.valueOf(48));
        
        // Asetataan oletusarvot
        paivaPicker.setValue(LocalDate.now());
        seuraChoiceBox.setValue(golfRekisteri.annaSeura(0).getSeurannimi());
        teeChoiseBox.setValue(String.valueOf(55));
        alustaTulosKorttiNakyma();
    }
    
    /**
     * Alustetaan uuden kierroksen tuloskortti näkymä. Tuodaan tuloskortin tiedot
     */
    private void alustaTulosKorttiNakyma() {
        System.out.println("valittu seura: " + seuraChoiceBox.getValue());
        System.out.println("valittu tee " + teeChoiseBox.getValue());
    }
    
 }
