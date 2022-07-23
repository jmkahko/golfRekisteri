package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tuloskortti.GolfRekisteri;

/**
 * @author Janne Kähkönen
 * @version 13.6.2022
 * Uuden tuloskortin luonti seuralle
 */
public class LuoUusiTuloskorttiController implements ModalControllerInterface<GolfRekisteri> {
    
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
        Dialogs.showMessageDialog("Ei vielä osata tehdä");
    }

    /**
     * Tallenna tuloskortin muutokset
     * @param event
     */
    @FXML
    private void handleTallenna() {
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
