package tuloskortti;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;
import kanta.UusiKayttaja;
import kanta.UusiSeura;

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
public class Kayttaja implements Cloneable {
    
    private int id;
    private String nimi;
    private String kotiseura;
    private double tasoitus;
    private int aloitusvuosi;
    
    // Luo jokaiselle kayttajalle oman "globaali" id-numero
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
     * Muodostetaan uusi käyttäjä annetuilla tiedoilla
     * @param nimi käyttäjän nimi
     * @param kotiseura käyttäjän kotiseura
     * @param tasoitus käyttäjän tasoitus
     * @param aloitusvuosi käyttäjän aloitusvuosi
     */
    public Kayttaja(String nimi, String kotiseura, double tasoitus, int aloitusvuosi) {
        this.rekisteroi();
        this.nimi = nimi;
        this.kotiseura = kotiseura;
        this.tasoitus = tasoitus;
        this.aloitusvuosi = aloitusvuosi;
    }
    
    /**
     * Tulostetaan käyttäjän tiedot | putkella eroteltuna
     * @param out tietovirta johon tulostetaan
     * @example
     * <pre name="test">
     * #import fi.jyu.mit.ohj2.Suuntaaja;
     * Kayttaja kayttaja = new Kayttaja("Aku", "Ankka Golf", 2.1, 2001);
     * 
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * String tulos = "99|Aku|Ankka Golf|2.1|2001";
     * kayttaja.setTunnusNro(99);
     * kayttaja.tulosta(System.out);
     * so.ero(tulos) === null;
     * so.palauta();
     * </pre>
     */
    public void tulosta(PrintStream out) {
        out.println(this.id + "|" + this.nimi + "|" + this.kotiseura + "|" + this.tasoitus + "|" + this.aloitusvuosi);
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
     * Asettaa id numeron ja samalla varmistetaan, että seuraavaId numero on aina suurempi kuin nykyinen id numero
     * @param idNro joka asetetaan
     * @example
     * <pre name="test">
     * Kayttaja kayttaja = new Kayttaja("Aku", "Ankka Gol", 2.1, 2001);
     * kayttaja.setTunnusNro(5);
     * kayttaja.getTunnusNro() === 5;
     * </pre>
     */
    public void setTunnusNro(int idNro) {
        this.id = idNro;
        if (this.id >= seuraavaId) {
            seuraavaId = this.id + 1;
        }
    }
    
    /**
     * Saadaan kysyttyä käyttäjän nimi
     * @return palauttaa käyttäjän nimen
     */
    public String getNimi() {
        return this.nimi;
    }
    
    /**
     * Saadaan kysyttyä käyttäjän kotiseuran nimi
     * @return palauttaa käyttäjän kotiseuran
     */
    public String getKotiseura() {
        return this.kotiseura;
    }
    
    /**
     * Saadaan kysyttyä käyttäjän tasoitus
     * @return palauttaa käyttäjän tasoituksen
     */
    public double getTasoitus() {
        return this.tasoitus;
    }
    
    /**
     * Saadaan kysyttyä käyttäjän aloitusvuosi
     * @return palauttaa käyttäjän aloitusvuoden
     */
    public int getAloitusvuosi() {
        return this.aloitusvuosi;
    }
    
    /**
     * Asetetaan käyttäjän nimi
     * @param nimi asettaa käyttäjän nimen
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    /**
     * Asetetaan käyttäjän kotiseura
     * @param kotiseura asettaa käyttäjän kotiseuran
     */
    public void setKotiseura(String kotiseura) {
        this.kotiseura = kotiseura;
    }
    
    /**
     * Asetetaan käyttäjän tasoitus
     * @param tasoitus asettaa käyttäjän tasoituksen
     */
    public void setTasoitus(double tasoitus) {
        this.tasoitus = tasoitus;
    }
    
    /**
     * Asetetaan käyttäjän aloitusvuosi
     * @param aloitusvuosi asettaa käyttäjän aloitusvuoden
     */
    public void setAloitusvuosi(int aloitusvuosi) {
        this.aloitusvuosi = aloitusvuosi;
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
     * Tulostaa käyttäjän tiedon samassa formaatissa, kuin tiedostoon tallennus tehdään
     * @return palauttaa käyttäjän tiedon formatoituna
     * @example
     * <pre name="test">
     * Kayttaja kayttaja = new Kayttaja();
     * kayttaja.parse("       3         |       Iines Ankka     |   Ankkalinna Golf");
     * kayttaja.toString().startsWith("3|Iines Ankka|Ankkalinna Golf") === true;
     * </pre>
     */
    @Override
    public String toString() {
        return this.getTunnusNro() + "|" + this.nimi + "|" + this.kotiseura + "|" + this.tasoitus + "|" + this.aloitusvuosi;
    }
    
    /**
     * Selvittää käyttäjän tiedot | putkella erotellusta merkkijonosta
     * Tarkistaa, että seuraavaId on suurempi kuin tuleva Id numero
     * @param merkkijono josta käyttäjän tiedot saadaan
     * @example
     * <pre name="test">
     * Kayttaja kayttaja = new Kayttaja();
     * kayttaja.parse("       3         |       Iines Ankka     |   Ankkalinna Golf");
     * kayttaja.getTunnusNro() === 3;
     * kayttaja.toString().startsWith("3|Iines Ankka|Ankkalinna Golf") === true;
     * kayttaja.rekisteroi();
     * int n = kayttaja.getTunnusNro();
     * kayttaja.parse("" + (n + 20));   // Otetaan merkkijonon alusta vain id numero ja lisätään siihen 20
     * kayttaja.rekisteroi();           // Tarkistetaan tämän jälkeen, että tulee isompi numero
     * kayttaja.getTunnusNro() === n + 20 + 1;
     */
    public void parse(String merkkijono) {
        var sb = new StringBuilder(merkkijono);
        this.setTunnusNro(Mjonot.erota(sb, '|', this.getTunnusNro()));
        this.nimi = Mjonot.erota(sb, '|', nimi);
        this.kotiseura = Mjonot.erota(sb, '|', kotiseura);
        this.tasoitus = Mjonot.erota(sb, '|', tasoitus);
        this.aloitusvuosi = Mjonot.erota(sb, '|', aloitusvuosi);
    }
    
    /**
     * Cloonataan kayttaja
     * @return palauttaa kloonatun Object Kayttajan
     * @thorws CloneNotSupportedException otetaan poikkeus jos tulee
     * @example
     * <pre name="test">
     * #THROWS CloneNotSupportedException 
     * Kayttaja k1 = new Kayttaja();
     * k1.parse("       4         |       Tupu Ankka     |   Ankkalinna Golf");
     * Kayttaja kopio = k1.clone();
     * kopio.toString() === k1.toString();
     * k1.parse("    1    | Iines Ankka    | Roope Golf");
     * kopio.toString().equals(k1.toString()) === false;
     * </pre>
     */
    @Override
    public Kayttaja clone() throws CloneNotSupportedException {
        Kayttaja uusiKayttaja;
        uusiKayttaja = (Kayttaja) super.clone();
        return uusiKayttaja;
    }
    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot käyttäjälle.
     */
    public void taytaTestiTiedoilla() {
        this.nimi = UusiKayttaja.arvoPelaaja();
        this.kotiseura = UusiSeura.arvoGolfSeura();
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
