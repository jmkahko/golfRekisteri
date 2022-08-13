package tuloskortti;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;
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
public class Seura implements Cloneable {

    private int id;
    private String seurannimi;
    private String katuosoite;
    private int postinumero;
    private String postitoimipaikka;
    private String puhelinnumero;
    
    // Luo jokaiselle seuralle oman "globaalin" seuraan id-numeron
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
     * Asettaa id numeron ja samalla varmistetaan, että seuraavaId numero on aina suurempi kuin nykyinen id numero
     * @param idNro joka asetetaan
     */
    public void setTunnusNro(int idNro) {
        this.id = idNro;
        if (this.id >= seuraavaId) {
            seuraavaId = this.id + 1;
        }
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
     * @return palauttaa seuran katuosoitteen
     */
    public String getKatuosoite() {
        return this.katuosoite;
    }
    
    /**
     * @return palauttaa seuran postinumeron
     */
    public int getPostinumero() {
        return this.postinumero;
    }
    
    /**
     * @return palauttaa seuran postitoimipaikan
     */
    public String getPostitoimipaikka() {
        return this.postitoimipaikka;
    }
    
    /**
     * @return palauttaa seuran puhelinnumeron
     */
    public String getPuhelinnumero() {
        return this.puhelinnumero;
    }
    
    /**
     * Asetataan seurannimi
     * @param seurannimi asetettava seurannimi
     */
    public void setSeurannimi(String seurannimi) {
        this.seurannimi = seurannimi;
    }
    
    /**
     * Asetataan katuosoite
     * @param katuosoite tieto
     */
    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }
    
    /**
     * Asetataan postinuero
     * @param postinumero tieto
     */
    public void setPostinumero(int postinumero) {
        this.postinumero = postinumero;
    }
    
    /**
     * Asetataan postitoimipaikka
     * @param postitoimipaikka tieto
     */
    public void setPostitoimipaikka(String postitoimipaikka) {
        this.postitoimipaikka = postitoimipaikka;
    }
    
    /**
     * Asetataan puhelinnumero
     * @param puhelinnumero tieto
     */
    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    @Override
    public String toString() {
        return this.id + "|" + this.seurannimi + "|" + this.katuosoite + "|" + this.postinumero + 
                "|" + this.postitoimipaikka + "|" + this.puhelinnumero;
    }
    
    /**
     * Cloonataan seura
     * @thorws CloneNotSupportedException otetaan poikkeus jos tulee
     */
    @Override
    public Seura clone() throws CloneNotSupportedException {
        Seura uusiSeura;
        uusiSeura = (Seura) super.clone();
        return uusiSeura;
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
     * Selvittää seuran tiedot | putkella erotellusta merkkijonosta
     * Tarkistaa, että seuraavaId on suurempi kuin tuleva Id numero
     * @param merkkijono josta seuran tiedot saadaan
     * @example
     * <pre name="test">
     * Seura seura = new Seura();
     * seura.parse("  3  | Fyrkkala Golf    |   Fyrkkalankatu 24  ");
     * seura.getTunnusNro() === 3;
     * seura.toString().startsWith("3|Fyrkkala Golf|Fyrkkalankatu 24") === true;
     * seura.rekisteroi();
     * int n = seura.getTunnusNro();
     * seura.parse("" + (n + 20));   // Otetaan merkkijonon alusta vain id numero ja lisätään siihen 20
     * seura.rekisteroi();           // Tarkistetaan tämän jälkeen, että tulee isompi numero
     * seura.getTunnusNro() === n + 20 + 1;
     */
    public void parse(String merkkijono) {
        var sb = new StringBuilder(merkkijono);
        this.setTunnusNro(Mjonot.erota(sb, '|', this.getTunnusNro()));
        this.seurannimi = Mjonot.erota(sb, '|', seurannimi);
        this.katuosoite = Mjonot.erota(sb, '|', katuosoite);
        this.postinumero = Mjonot.erota(sb, '|', postinumero);
        this.postitoimipaikka = Mjonot.erota(sb, '|', postitoimipaikka);
        this.puhelinnumero = Mjonot.erota(sb, '|', puhelinnumero);
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
