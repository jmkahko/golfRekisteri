package tuloskortti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
     * #import kanta.UusiKierros;
     * 
     *  Kierrokset kierrokset = new Kierrokset();
     *  kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55));
     *  List<Kierros> loytyneet;
     *  loytyneet = kierrokset.annaKierrokset(1, 1);
     *  loytyneet.size() === 18; 
     *  kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55));
     *  loytyneet = kierrokset.annaKierrokset(1, 1);
     *  loytyneet.size() === 36; 
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
     * Palauttaa kaikki pelatut väylät ja kierrokset
     * @return palauttaa kaikki
     * @example
     * <pre name="test">
     * #import java.util.*;
     * #import kanta.UusiKierros;
     * 
     *  Kierrokset kierrokset = new Kierrokset();
     *  kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55));
     *  Collection<Kierros> kierrosYksiRivi = kierrokset.annaKaikkiKierrokset();
     *  kierrosYksiRivi.size() === 18;
     * </pre> 
     */
    public Collection<Kierros> annaKaikkiKierrokset() {
        return this.alkiot;
    }
        
    
    /**
     * Tallentaa kierroksen tiedostoon
     * Tiedoston muoto:
     * <pre>
     * 1|1|1|01-01-2022|55|1|7
     * 2|1|1|01-01-2022|55|2|4
     * </pre>
     * @param hakemisto johon tiedosto tallennetaan
     * @throws SailoException jos talennus epäonnistuu
     */
    public void tallenna(String hakemisto) throws SailoException {
        File ftiedosto = new File(hakemisto + "/kierros.dat");
        
        try (PrintStream fo = new PrintStream(new FileOutputStream(ftiedosto, false))) {

            for (Kierros k : this) {
                fo.println(k.toString());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Tiedosto " + ftiedosto.getAbsolutePath() + " " + e.getMessage());
        }
        
    }
    
    /**
     * Lukee kierroksen tiedostosta
     * @param hakemisto josta tiedosto löytyy
     * @throws SailoException jos lukeminen epäonnistuu
     */
    public void lueTiedostosta(String hakemisto) throws SailoException {
        String hnimi = hakemisto + "/kierros.dat";
        File ftiedosto = new File(hnimi);
        
        try (Scanner fi = new Scanner(new FileInputStream(ftiedosto))) {
            while (fi.hasNext()) {
                String merkkijono = fi.nextLine();
                if (merkkijono == null || merkkijono.equals("") || merkkijono.charAt(0) == ';') {
                    continue;
                }
                
                Kierros kierros = new Kierros();
                kierros.parse(merkkijono);
                this.lisaaKierros(kierros);
            }
        } catch (FileNotFoundException e) {
            throw new SailoException("Ei saa luettua tiedostoa: " + hnimi);
        }
    }
        
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Kierrokset kierrokset = new Kierrokset();
        
        // Luetaan tiedostosta kierrokset
        try {
            kierrokset.lueTiedostosta("golfRekisteri");
        }  catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
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
        
        Collection<Kierros> kierrosYksiRivi = kierrokset.annaKaikkiKierrokset();
        int kierrosLaskuri = 18;
        int tulosLaskuri = 0;
        for (Kierros tulos : kierrosYksiRivi) {
            tulosLaskuri += tulos.getTulos();
            if (kierrosLaskuri == tulos.getTunnusNro()) {
                System.out.println("KierrosId: " + tulos.getSeuraId() + ", pelattu päivä: " + tulos.getPelattuPaiva() + ", tulos: " + tulosLaskuri);
                kierrosLaskuri += 18;
                tulosLaskuri = 0;
            }
        }
        
        // Tiedostoon tallennus
        try {
            kierrokset.tallenna("golfRekisteri");
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
    }
}
