package tuloskortti;

import java.io.OutputStream;
import java.io.PrintStream;

import kanta.UusiKayttaja;
import kanta.UusiSeura;

/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: Seura                   | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        |                                      |
 * |                                      |                                      |
 * | - Huolehtii golf seuran tiedoista    |                                      |
 * | - Ei tiedä käyttöliittymästä         |                                      |
 * | - Tietää seuran kentät (id,          |                                      |
 * |   seurannimi, osoitetiedot, jne)     |                                      |
 * | - Osaa antaa ja laittaa merkkijonon  |                                      |
 * |   i:n kentän tiedoksi ja i:neksi     |                                      |
 * |   kentäksi                           |                                      |
 * | - Osaa etsiä seuran                  |                                      |
 * | - Osaa lukea ja kirjoittaa seuran    |                                      |
 * |   tiedostoon                         |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * +--------------------------------------+--------------------------------------+
 * @author Janne Kähkönen
 * @version 12.7.2022
 */
public class Seura {

    private int id;
    private String seurannimi;
    private String katuosoite;
    private int postinumero;
    private String postitoimipaikka;
    private String puhelinnumero;
    
    // Luo jokaiselle kayttajalle oman "globaalin" seuraan id-numeron
    private static int seuraavaId = 1;
    
    /**
     * Luodaan seuran muodostaja new Seura() metodilla oletusarvoilla
     */
    public Seura() {
        this.id = 0;
        this.seurannimi = "";
        this.katuosoite = "";
        this.postinumero = 0;
        this.postitoimipaikka = "";
        this.puhelinnumero = "";
    }
    
    /**
     * Tulostetaan käyttäjän tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(String.format("%03d", id) + "|" + this.seurannimi + "|" + this.katuosoite + "|" + this.postinumero + 
                "|" + this.postitoimipaikka + "|" + this.puhelinnumero);
    }
    
    
    /**
     * Tulostetaan käyttäjän tiedot
     * @param os tietovirta johon tulosetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    /**
     * Palauttaa seuran id:n
     * @return palauttaa id:n
     */
    public int getTunnusNro() {
        return this.id;
    }
    
    
    /**
     * Antaa Seuralle seuraavan rekisterinumeron.
     * @return seuran uusi id
     * @example
     * <pre name="test">
     * Seura seura = new Seura();
     * seura.getTunnusNro() === 0;
     * seura.rekisteroi();
     * Seura seura2 = new Seura();
     * seura2.rekisteroi();
     * int n1 = seura.getTunnusNro();
     * int n2 = seura2.getTunnusNro();
     * n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        this.id = seuraavaId;
        seuraavaId++;
        return this.id;
    }
    
    /**
     * @return palauttaa seuran nimen
     */
    public String getSeurannimi() {
        return this.seurannimi;
    }
    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot käyttäjälle.
     * TODO: poista kun kaikki toimii
     */
    public void taytaTestiTiedoilla() {
        this.seurannimi = UusiSeura.arvoGolfSeura();
        this.katuosoite = UusiSeura.arvoKatuosoite();
        this.postinumero = UusiSeura.arvoPostinumero();
        this.postitoimipaikka = UusiSeura.arvoPostitoimipaikka();
        this.puhelinnumero = UusiSeura.arvoPuhelinnumero();
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Seura seura1 = new Seura();
        Seura seura2 = new Seura();
        
        seura1.rekisteroi();
        seura2.rekisteroi();
        
        seura1.tulosta(System.out);
        seura2.tulosta(System.out);
        
        seura1.taytaTestiTiedoilla();
        seura2.taytaTestiTiedoilla();
        
        seura1.tulosta(System.out);
        seura2.tulosta(System.out);
    }

}
