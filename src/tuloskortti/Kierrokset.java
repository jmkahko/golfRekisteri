package tuloskortti;

import java.util.ArrayList;
import java.util.List;

import kanta.UusiKierros;


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
     * Saadaan lisätty uudet kierrokset listana
     * @param kierrosLista annetaan listaus kierroksen tuloksista
     */
    public void lisaaKierros(List<Kierros> kierrosLista) {
        this.alkiot.addAll(kierrosLista);
    }
    
    /**
     * @param tuloskorttiId viedään tuloskorttiId numero, että minkä tuloskortin kierros kyseessä
     * @param kayttajaId viedään kayttajaId numero, että minkä käyttäjän kierros on kyseessä
     * @return palauttaa kierrokset
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     *  Kierrokset kierrokset = new Kierrokset();
     *  Kierros kierros1 = new Kierros();
     *  kierros1.taytaTestiTiedoilla(1, 1, 2, 4, 55);
     *  Kierros kierros2 = new Kierros();
     *  kierros2.taytaTestiTiedoilla(2, 1, 2, 4, 48);
     *  kierrokset.lisaaKierros(kierros1);
     *  kierrokset.lisaaKierros(kierros2);
     *  List<Kierros> loytyneet;
     *  loytyneet = kierrokset.annaKierrokset(1, 1);
     *  loytyneet.size() === 0; 
     *  loytyneet = kierrokset.annaKierrokset(2, 1);
     *  loytyneet.get(0) == kierros1 === true;
     *  loytyneet.get(1) == kierros2 === true;
     *  loytyneet.size() === 1; 
     * </pre> 
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
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Kierrokset kierrokset = new Kierrokset();
        
        kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55));
        
        Kierros kierros1 = new Kierros();
        kierros1.taytaTestiTiedoilla(1, 1, 2, 4, 55);
        
        kierrokset.lisaaKierros(kierros1);
        
        System.out.println("============= Kierrokset testi =================");
        List<Kierros> kierrokset2 = kierrokset.annaKierrokset(1, 1);

        for (Kierros tulos : kierrokset2) {
            System.out.print("Seura: " + tulos.getKayttajaId() + " ");
            tulos.tulosta(System.out);
        }
    }
}
