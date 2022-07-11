package tuloskortti;

/**
 * Poikkeusluokka tietorakenteesta aiheutuville poikkeuksille
 * @author Janne Kähkönen
 * @version 11.7.2022
 *
 */
public class SailoException extends Exception {
    private static final long serialVersionUID = 1L;
    
    /**
     * Poikkeuksen muodostoja jolle tuodaan poikkeuksessa käytettävä viesti
     * @param viesti Poikkeuksen viesti
     */
    public SailoException(String viesti) {
        super(viesti);
    }
}
