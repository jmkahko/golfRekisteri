package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tuloskortti.GolfRekisteri;

/**
 * @author Janne Kähkönen
 * @version 13.6.2022
 * Pelatun kierroksen tuloksen syöttäminen
 */
public class SyotaKierrosController implements ModalControllerInterface<GolfRekisteri> {

    /**
     * Golf seuran, pelatun teen, päiväyksen valinta ja yhteensä tulokset
     */
    @FXML private DatePicker paivaPicker;
    @FXML private ChoiceBox<?> seuraChoiceBox;
    @FXML private ChoiceBox<?> teeChoiseBox;
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
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }



    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }



    @Override
    public GolfRekisteri getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDefault(GolfRekisteri rekisteri) {
        this.golfRekisteri = rekisteri;

        
    }
    
    // =================================================================
    // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia
    
    private GolfRekisteri golfRekisteri;

}
