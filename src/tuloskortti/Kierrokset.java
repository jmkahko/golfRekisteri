package tuloskortti;

import java.util.ArrayList;
import java.util.List;


/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: Kierrokset              | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        | - Kierros                            |
 * |                                      |                                      |
 * | - Pitää yllä varsinaista kierrokset- |                                      |
 * |   rekisteriä, eli lisätä ja          |                                      |
 * |   poistaa kierroksen                 |                                      |
 * | - Osaa lukea ja kirjoittaa kierros   |                                      |
 * |   tiedostoon                         |                                      |
 * | - Osaa etsiä ja lajitella            |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * +--------------------------------------+--------------------------------------+
 * @author Janne Kähkönen
 * @version 13.7.2022
 */
public class Kierrokset extends Kierros {

    private List<Kierros> alkiot;
    
    
    /**
     * Kierrosten alustaminen
     */
    public Kierrokset() {
        this.alkiot = new ArrayList<Kierros>();
    }
    
    /**
     * @return palauttaa kierrosten määrän
     */
    public int getLkm() {
        return this.alkiot.size();
    }
    
    /**
     * Saadaan lisättyä uusi kierros
     * @param kierros lisättävä kierros
     */
    public void lisaaKierros(Kierros kierros) {
        this.alkiot.add(kierros);
    }
    
    /**
     * @param tuloskorttiId viedään tuloskorttiId numero, että minkä tuloskortin kierros kyseessä
     * @param kayttajaId viedään kayttajaId numero, että minkä käyttäjän kierros on kyseessä
     * @return palauttaa kierrokset
     */
    public List<Kierros> annaKierrokset(int tuloskorttiId, int kayttajaId) {
        List<Kierros> loydetytKierrokset = new ArrayList<Kierros>();
        
        for (Kierros k : this.alkiot) {
            if (k.getKayttajaId() == kayttajaId && k.getTuloskorttiId() == tuloskorttiId) {
                loydetytKierrokset.add(k);
            }
        }
        return loydetytKierrokset;
        
    }
    
    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot kierroksille.
     * TODO: poista kun kaikki toimii
     */
    public void taytaTestiTiedoilla() {
        //
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        //Kierrokset kierrokset1 = new Kierrokset();
        


    }
    
}
