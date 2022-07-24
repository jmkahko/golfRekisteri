package tuloskortti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class Kierrokset implements Iterable<Kierros> {

    private Collection<Kierros> alkiot;
    
    
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
     * Iteraattori kaikkien kierroksien läpikäyntiin
     * @return kierros iteraattorin
     */
    @Override
    public Iterator<Kierros> iterator() {
        return this.alkiot.iterator();
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
            if (k.getKayttajaId() == kayttajaId && k.getSeuraId() == tuloskorttiId) {
                loydetytKierrokset.add(k);
            }
        }
        return loydetytKierrokset;
    }
    
    /**
     * Palauttaa kierrokset jotka pelattu, näistä näytetään päiväys, kenttä ja tulos
     * Tehdään oletus, että aina on 18 väylää kierretty ja syötetty. Joten uuden kierroksen alku löytyy paikoista 1, 19, 37...
     * @return palauttaa yhden rivin per kierros.
     */
    public List<Kierros> annaKaikkiKierrokset() {
        List<Kierros> loydetytKierrokset = new ArrayList<Kierros>();
        
        int laskuri = 1;
        for (Kierros k : this.alkiot) {
            if (k.getTunnusNro() == laskuri) {
                loydetytKierrokset.add(k);
                laskuri += 18;
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
        
        //Kierros kierros1 = new Kierros();
        //kierros1.taytaTestiTiedoilla(1, 1, 2, 4, 55);
        
        //kierrokset.lisaaKierros(kierros1);
        
        System.out.println("============= Kierrokset testi =================");
        List<Kierros> kierrokset2 = kierrokset.annaKierrokset(1, 1);

        for (Kierros tulos : kierrokset2) {
            System.out.print("SeuraId: " + tulos.getSeuraId() + " ");
            tulos.tulosta(System.out);
        }
        
        System.out.println("============= Yksi rivi per kierros testi =================");
        
        kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 48));
        kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 62));
        kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55));
        
        List<Kierros> kierrosYksiRivi = kierrokset.annaKaikkiKierrokset();
        for (Kierros tulos : kierrosYksiRivi) {
            System.out.println("KierrosId: " + tulos.getTunnusNro() + ", pelattu päivä: " + tulos.getPelattuPaiva());
        }
    }
}
