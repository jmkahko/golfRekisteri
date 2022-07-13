package tuloskortti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Tuloskortit tuloskortit = new Tuloskortit();

        // Haetaan generoitu tuloskortti ja lisätään listana  
        tuloskortit.lisaaTuloskortti(UusiTuloskortti.luoTuloskortti(1));
        tuloskortit.lisaaTuloskortti(UusiTuloskortti.luoTuloskortti(2));
        
        System.out.println("============= Tuloskortti testi =================");

        List<Tuloskortti> tuloskortti2 = tuloskortit.annaTuloskortit(2);


        for (Tuloskortti tulos : tuloskortti2) {
            System.out.print("Seura: " + tulos.getSeuraNro() + " ");
            tulos.tulosta(System.out);
        }

    }
}
