package tuloskortti;

import java.io.OutputStream;
import java.io.PrintStream;

import kanta.UusiKayttaja;

/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: Kayttaja                | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        |                                      |
 * |                                      |                                      |
 * | - Huolehtii käyttäjän tiedoista      |                                      |
 * | - Ei tiedä käyttöliittymästä         |                                      |
 * | - Tietää käyttäjän kentät (id,       |                                      |
 * |   nimi, kotiseura, tasoitus, jne)    |                                      |
 * | - Osaa muuttaa merkkijonon           |                                      |
 * |   käyttäjän tiedoiksi                |                                      |
 * | - Osaa lukea ja kirjoittaa käyttäjän |                                      |
 * |   tiedostoon                         |                                      |
 * | - Osaa antaa ja laittaa merkkijonon  |                                      |
 * |   i:n kentän tiedoksi ja i:neksi     |                                      |
 * |   kentäksi                           |                                      |
 * | - Yksi käyttäjä ainoastaan           |                                      |
 * +--------------------------------------+--------------------------------------+
 * @author Janne Kähkönen
 * @version 11.7.2022
 *
 */
public class Kayttaja {
    
    private int id;
    private String nimi;
    private String kotiseura;
    private double tasoitus;
    private int aloitusvuosi;
    
    // Luo jokaiselle kayttajalle oman "globaalin" seuraan id-numeron
    private static int seuraavaId = 1;
    
    /**
     * Käyttäjän muodostaja new Kayttaja() metodilla oletusarvoilla
     */
    public Kayttaja() {
        this.id = 0;
        this.nimi = "";
        this.kotiseura = "";
        this.tasoitus = 54;
        this.aloitusvuosi = 0;
    }
        
    
    /**
     * Tulostetaan käyttäjän tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(String.format("%03d", id) + "|" + this.nimi + "|" + this.kotiseura + "|" + this.tasoitus + "|" + this.aloitusvuosi);
    }
    
    
    /**
     * Tulostetaan käyttäjän tiedot
     * @param os tietovirta johon tulosetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    
    /**
     * Palauttaa käyttäjän id:n
     * @return palauttaa id:n
     */
    public int getTunnusNro() {
        return this.id;
    }
    
    
    /**
     * Antaa käyttäjälle seuraavan rekisterinumeron.
     * @return käyttäjän uusi id
     * @example
     * <pre name="test">
     * Kayttaja testi = new Kayttaja();
     * testi.getTunnusNro() === 0;
     * testi.rekisteroi();
     * Kayttaja testi2 = new Kayttaja();
     * testi2.rekisteroi();
     * int n1 = testi.getTunnusNro();
     * int n2 = testi2.getTunnusNro();
     * n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        this.id = seuraavaId;
        seuraavaId++;
        return this.id;
    }

    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot käyttäjälle.
     * TODO: poista kun kaikki toimii
     */
    public void taytaTestiTiedoilla() {
        this.nimi = UusiKayttaja.arvoPelaaja();
        this.kotiseura = UusiKayttaja.arvoGolfSeura();
        this.tasoitus = UusiKayttaja.arvoTasoitus();
        this.aloitusvuosi = UusiKayttaja.arvoVuosi();
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Kayttaja henkilo1 = new Kayttaja();
        Kayttaja henkilo2 = new Kayttaja();
        
        henkilo1.rekisteroi();
        henkilo2.rekisteroi();
        
        henkilo1.tulosta(System.out);
        henkilo2.tulosta(System.out);
        
        henkilo1.taytaTestiTiedoilla();
        henkilo2.taytaTestiTiedoilla();
        
        henkilo1.tulosta(System.out);
        henkilo2.tulosta(System.out);
    }

}
