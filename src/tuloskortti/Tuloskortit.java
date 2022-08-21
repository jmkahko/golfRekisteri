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

import kanta.UusiTuloskortti;

/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: Tuloskortit             | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        | - Tuloskortti                        |
 * |                                      |                                      |
 * | - Pitää yllä varsinaista tuloskortti-|                                      |
 * |   rekisteriä, eli lisätä ja          |                                      |
 * |   poistaa tuloskortin                |                                      |
 * | - Osaa lukea ja kirjoittaa tulos-    |                                      |
 * |   kortti tiedostoon                  |                                      |
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
public class Tuloskortit implements Iterable<Tuloskortti> {
    
    private Collection<Tuloskortti> alkiot;
    
    /**
     * Tuloskorttien alustaminen
     */
    public Tuloskortit() {
        this.alkiot = new ArrayList<Tuloskortti>();
    }
    
    /**
     * Lisätään uusi tuloskortti(väylän rivi) Tuloskortteihin
     * @param tulosk lisättävä tuloskortti
     */
    public void lisaaTuloskortti(Tuloskortti tulosk) {
        this.alkiot.add(tulosk);
    }
    
    /**
     * Lisätään valmis lista kerralla, ettei yksitellen
     * @param tuloskorttiLista lisättävä tuloskortti lista
     */
    public void lisaaTuloskortti(List<Tuloskortti> tuloskorttiLista) {
        this.alkiot.addAll(tuloskorttiLista);
    }
    
    /**
     * Lisää uuden tuloskortin tai muuttaa olemassa olevan tuloskortin tietoja.
     * Etsii samalla tuloskortin -tunnuksella olevaa tuloskortin, jos ei löydy niin luo uuden tuloskortin
     * @param tuloskorttiLista lisättävän tai muutettavan seuran tieto
     * @throws SailoException jos ei onnistu
     */
    public void lisaaTaiMuutaTuloskorttia(List<Tuloskortti> tuloskorttiLista) throws SailoException {
        this.lisaaTuloskortti(tuloskorttiLista);
    }
    
    /**
     * Iteraattori kaikkien tuloskorttien läpikäyntiin
     * @return tuloskortti iteraattorin
     */
    @Override
    public Iterator<Tuloskortti> iterator() {
        return this.alkiot.iterator();
    }
    
    /**
     * @return palauttaa tuloskortti rivien lukumäärän
     */
    public int getLkm() {
        return this.alkiot.size();
    }
    
    /**
     * Haetaan tietyn seuran kaikki tuloskortin tuloskortit (väylät)
     * @param seuraId viedään seuranId tieto, että minkä seuran tuloskortti halutaan
     * @return palauttaa löydetyn tuloskortin tiedot
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     *  Tuloskortit tuloskortit = new Tuloskortit();
     *  Tuloskortti vayla1 = new Tuloskortti(2,1,433,407,387,387,5,1); 
     *  tuloskortit.lisaaTuloskortti(vayla1);
     *  Tuloskortti vayla2 = new Tuloskortti(2,2,119,117,115,115,3,4); 
     *  tuloskortit.lisaaTuloskortti(vayla2);
     *  Tuloskortti vayla3 = new Tuloskortti(2,3,320,308,308,284,4,9); 
     *  tuloskortit.lisaaTuloskortti(vayla3);
     *  
     *  List<Tuloskortti> loytyneet;
     *  loytyneet = tuloskortit.annaTuloskortit(3);
     *  loytyneet.size() === 0; 
     *  loytyneet = tuloskortit.annaTuloskortit(2);
     *  loytyneet.size() === 3; 
     *  loytyneet.get(0) == vayla1 === true;
     *  loytyneet.get(1) == vayla2 === true;
     * </pre> 
     */
    public List<Tuloskortti> annaTuloskortit(int seuraId) {
        List<Tuloskortti> loydetyt = new ArrayList<Tuloskortti>();
        
        for (Tuloskortti t : this.alkiot) {
            if (t.getSeuraNro() == seuraId) {
                loydetyt.add(t);
            }
        }
        return loydetyt;
    }
    
    /**
     * Poistetaan seuran tuloskortti
     * @param tunnusNro seuran numero, jonka tuloskortti poistetaan
     * @return palautetaan poistetut rivit
     */
    public int poistaTuloskortti(int tunnusNro) {
        int n = 0;
        
        for (Iterator<Tuloskortti> it = this.alkiot.iterator(); it.hasNext();) {
            Tuloskortti tuloskortti = it.next();
            if (tuloskortti.getSeuraNro() == tunnusNro) {
                it.remove();
                n++;
            }
        }
        return n;
    }
    
    /**
     * Tallentaa tuloskortin tiedostoon
     * Tiedoston muoto:
     * <pre>
     * 1|1|1|143|133|109|109|3|5
     * 2|1|2|503|470|470|454|5|9
     * </pre>
     * @param hakemisto johon tiedosto tallennetaan
     * @throws SailoException jos talennus epäonnistuu
     */
    public void tallenna(String hakemisto) throws SailoException {
        File ftiedosto = new File(hakemisto + "/tuloskortti.dat");
        
        try (PrintStream fo = new PrintStream(new FileOutputStream(ftiedosto, false))) {

            for (Tuloskortti t : this) {
                fo.println(t.toString());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Tiedosto " + ftiedosto.getAbsolutePath() + " " + e.getMessage());
        }
    }
    
    /**
     * Lukee tuloskortin tiedostosta
     * @param hakemisto josta tiedosto löytyy
     * @throws SailoException jos lukeminen epäonnistuu
     */
    public void lueTiedostosta(String hakemisto) throws SailoException {
        String hnimi = hakemisto + "/tuloskortti.dat";
        File ftiedosto = new File(hnimi);
        
        try (Scanner fi = new Scanner(new FileInputStream(ftiedosto))) {
            while (fi.hasNext()) {
                String merkkijono = fi.nextLine();
                if (merkkijono == null || merkkijono.equals("") || merkkijono.charAt(0) == ';') {
                    continue;
                }
                
                Tuloskortti tuloskortti = new Tuloskortti();
                tuloskortti.parse(merkkijono);
                this.lisaaTuloskortti(tuloskortti);
            }
        } catch (FileNotFoundException e) {
            throw new SailoException("Ei saa luettua tiedostoa: " + hnimi);
        }
    }

    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {

        Tuloskortit tuloskortit = new Tuloskortit();
        
        // Luetaan tiedostosta kierrokset
        try {
            tuloskortit.lueTiedostosta("golfRekisteri");
        }  catch (SailoException e) {
            System.err.println(e.getMessage());
        }

        // Haetaan generoitu tuloskortti ja lisätään listana  
        tuloskortit.lisaaTuloskortti(UusiTuloskortti.luoTuloskortti(1));
        tuloskortit.lisaaTuloskortti(UusiTuloskortti.luoTuloskortti(2));
        
        System.out.println("============= Tuloskortti testi =================");

        List<Tuloskortti> tuloskortti2 = tuloskortit.annaTuloskortit(1);

        for (Tuloskortti tulos : tuloskortti2) {
            System.out.print("Seura: " + tulos.getSeuraNro() + " ");
            tulos.tulosta(System.out);
        }
        
        // Tiedostoon tallennus
        try {
            tuloskortit.tallenna("golfRekisteri");
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
    }
}
