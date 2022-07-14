package fxTuloskortti;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import tuloskortti.GolfRekisteri;
import tuloskortti.SailoException;
import tuloskortti.Seura;

/**
 * @author janne
 * @version 13.6.2022
 * Seura käyttöliittymän muokkaamista varten, voidaan syöttää uusi tuloskortti tai muokata. Voidaan muokata seurantietoja
 */
public class SeuraController implements ModalControllerInterface<String> {
   
    /**
     * Golf seurojen listaus
     */
    @FXML
    private ListChooser<Seura> chooserSeurat;
    
    /**
     * Voidaan muokata seurantietoja
     */
    @FXML
    private void handleMuokkaaSeuraa() {
        ModalController.showModal(SeuraController.class.getResource("LuoSeuraView.fxml"), "Muokkaa seuraa", null, "");
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
        ModalController.showModal(SeuraController.class.getResource("LuoUusiTuloskorttiView.fxml"), "Luo uusi tuloskortti", null, "");
    }

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDefault(String arg0) {
        // TODO Auto-generated method stub
        
    }
    
 // =================================================================
 // Tästä eteenpäin ei ole suoraan käyttöliittymään viittaavaa koodia

    private GolfRekisteri golfRekisteri;
    
    /**
     * Lisätään tuloskorttiin uusi seura
     */
    public void uusiSeura() {
        Seura uusiSeura = new Seura();
        uusiSeura.rekisteroi();
        uusiSeura.taytaTestiTiedoilla();
        
        try {
            golfRekisteri.lisaaSeura(uusiSeura);
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
        for (int x = 0; x < golfRekisteri.getSeuroja(); x++) {
            Seura seura = golfRekisteri.annaSeura(x);
            if (seura.getTunnusNro() == seuranro) index = x;
            chooserSeurat.add(seura.getSeurannimi(), seura);
        }
        chooserSeurat.setSelectedIndex(index);
    }

}
