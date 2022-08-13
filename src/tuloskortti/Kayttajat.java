package tuloskortti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: Kayttajat               | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        | - Kayttaja                           |
 * |                                      |                                      |
 * | - Pitää yllä varsinaista kayttaja-   |                                      |
 * |   rekisteriä, eli lisätä ja          |                                      |
 * |   poistaa kayttajan                  |                                      |
 * | - Osaa lukea ja kirjoittaa kayttaja  |                                      |
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
 * @version 11.7.2022
 *
 */
public class Kayttajat {
    
    private static final int MAX_KAYTTAJIA = 5;
    private int lkm = 0;
    private Kayttaja[] alkiot;
    
    /**
     * Luodaan alustava taulukko
     */
    public Kayttajat() {
        this.alkiot = new Kayttaja[MAX_KAYTTAJIA];
    }
    
    
    /**
     * Lisätään uusi käyttäjä Kayttaja[] tietorakenteesen. Ottaa käyttäjän omistukseensa.
     * @param kayttaja annetaan käyttäjä
     * @throws SailoException jos Kayttaja[] taulukko täynnä
     * @example
     * <pre name="test">
     * #THROWS SailoException
     * Kayttajat kayttajat = new Kayttajat();
     * Kayttaja henkilo1 = new Kayttaja();
     * Kayttaja henkilo2 = new Kayttaja();
     * Kayttaja henkilo3 = new Kayttaja();
     * kayttajat.getLkm() === 0;
     * kayttajat.lisaa(henkilo1); kayttajat.getLkm() === 1;
     * kayttajat.lisaa(henkilo2); kayttajat.getLkm() === 2;
     * kayttajat.annaKayttaja(0) === henkilo1;
     * kayttajat.annaKayttaja(1) === henkilo2;
     * kayttajat.annaKayttaja(0) == henkilo2 === false;
     * kayttajat.annaKayttaja(0) == henkilo1 === true;
     * kayttajat.annaKayttaja(5) === henkilo1; #THROWS IndexOutOfBoundsException
     * kayttajat.lisaa(henkilo3); #THROWS SailoException
     * </pre> 
     */
    public void lisaa(Kayttaja kayttaja) throws SailoException {
        if (this.lkm >= this.alkiot.length) throw new SailoException("Liikaa alkioita, ei voida listätä");
        this.alkiot[this.lkm] = kayttaja;
        lkm++;
    }
    
    /**
     * Lisää uuden kayttajan tai muuttaa olemassa olevan kayttajan tietoja.
     * Etsii samalla kayttaja -tunnuksella olevaa käyttäjän, jos ei löydy niin luo uuden käyttäjän
     * @param kayttaja lisättävän tai muutettavan seuran tieto
     * @throws SailoException jos ei onnistu
     */
    public void lisaaTaiMuutaKayttaja(Kayttaja kayttaja) throws SailoException {
        int id = kayttaja.getTunnusNro();
        
        // Etsitään löytyykö tulevan seuran id -numeroa, jos ei löydy niin lisätään seura
        for (int x = 0; x < this.lkm; x++) {
            if (this.alkiot[x].getTunnusNro() == id) {
                this.alkiot[x] = kayttaja;
                return;
            }
        }
        this.lisaa(kayttaja);
    }
    
    /**
     * Palauttaa käyttäjien käyttäjien lukumäärän
     * @return käyttäjien lukumäärän
     */
    public int getLkm() {
        return this.lkm;
    }
    
    /**
     * Palauttaa viitteen i:teen käyttäjän
     * @param i monennenko käyttäjän viite halutaan
     * @return viite käyttäjään, jonka indeksi on i
     * @throws IndexOutOfBoundsException jos i ei ole sallitulla alueella
     */
    public Kayttaja annaKayttaja(int i) throws IndexOutOfBoundsException {
        if (i < 0 || this.lkm <= i) {
            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
        }
        return alkiot[i];
    }
    
    /**
     * Tallentaa käyttäjän tiedostoon
     * Tiedoston muoto:
     * <pre>
     * 1|Iines Ankka|Rankkalinna Golf|51.0|1966
     * 2|Hupu|Ankkalinna Golf|27.0|1994
     * </pre>
     * @param hakemisto johon tiedosto tallennetaan
     * @throws SailoException jos talennus epäonnistuu
     */
    public void tallenna(String hakemisto) throws SailoException {
        File ftiedosto = new File(hakemisto + "/kayttaja.dat");
        
        try (PrintStream fo = new PrintStream(new FileOutputStream(ftiedosto, false))) {

            for (int x = 0; x < this.getLkm(); x++) {
                Kayttaja kayttaja = this.annaKayttaja(x);
                fo.println(kayttaja.toString());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Tiedosto " + ftiedosto.getAbsolutePath() + " " + e.getMessage());
        }
        
    }
    
    /**
     * Lukee käyttäjät tiedostosta
     * @param hakemisto josta tiedosto löytyy
     * @throws SailoException jos lukeminen epäonnistuu
     */
    public void lueTiedostosta(String hakemisto) throws SailoException {
        String hnimi = hakemisto + "/kayttaja.dat";
        File ftiedosto = new File(hnimi);
        
        try (Scanner fi = new Scanner(new FileInputStream(ftiedosto))) {
            while (fi.hasNext()) {
                String merkkijono = fi.nextLine();
                if (merkkijono == null || merkkijono.equals("") || merkkijono.charAt(0) == ';') {
                    continue;
                }
                
                Kayttaja kayttaja = new Kayttaja();
                kayttaja.parse(merkkijono);
                this.lisaa(kayttaja);
            }
        } catch (FileNotFoundException e) {
            throw new SailoException("Ei saa luettua tiedostoa: " + hnimi);
        }
    }

    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Kayttajat kayttajat = new Kayttajat();
        
        // Luetaan tiedostosta käyttäjät
        try {
            kayttajat.lueTiedostosta("golfRekisteri");
        }  catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        

        Kayttaja henkilo1 = new Kayttaja();
        Kayttaja henkilo2 = new Kayttaja();
        
        henkilo1.rekisteroi();
        henkilo1.taytaTestiTiedoilla();
        henkilo2.rekisteroi();
        henkilo2.taytaTestiTiedoilla();
        
        try {
            kayttajat.lisaa(henkilo1);
            kayttajat.lisaa(henkilo2);
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }

        
        System.out.println("======================= Käyttäjät testi =======================");
        for (int x = 0; x < kayttajat.getLkm(); x++) {
           Kayttaja kayttaja = kayttajat.annaKayttaja(x);
           System.out.println("Käyttäjän indeksi: " + x);
           kayttaja.tulosta(System.out);
        }
        
        // Tiedostoon tallennus
        try {
            kayttajat.tallenna("golfRekisteri");
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        
        
    }
}
