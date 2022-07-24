package tuloskortti;

import java.io.OutputStream;
import java.io.PrintStream;

import kanta.UusiKierros;

/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: Kierros                 | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        |                                      |
 * |                                      |                                      |
 * | - Huolehtii kierroksen tiedoista     |                                      |
 * | - Ei tiedä käyttöliittymästä         |                                      |
 * | - Tietää kierroksen kentät (id,      |                                      |
 * |   tuloskortti, kayttaja, paiva, jne) |                                      |
 * | - Osaa muuttaa merkkijonon           |                                      |
 * |   kierroksen tiedoiksi               |                                      |
 * | - Osaa lukea ja kirjoittaa kierros   |                                      |
 * |   tiedostoon                         |                                      |
 * | - Osaa antaa ja laittaa merkkijonon  |                                      |
 * |   i:n kentän tiedoksi ja i:neksi     |                                      |
 * |   kentäksi                           |                                      |
 * |                                      |                                      |
 * +--------------------------------------+--------------------------------------+
 * @author Janne Kähkönen
 * @version 13.7.2022
 */
public class Kierros {

    private int id;
    private int seuraId;
    private int kayttajaId;
    private String kierrospaiva;
    private int pelattuTee;
    private int vayla;
    private int tulos;
    
    // Luo jokaiselle kierrokselle oman "globaalin" seuraavan id-numeron
    private static int seuraavaId = 1;
    
    
    /**
     * Kierroksen muodostaja oletusarvoilla
     */
    public Kierros() {
        this.id = 0;
        this.seuraId = 0;
        this.kayttajaId = 0;
        this.kierrospaiva = "01-01-2022";
        this.pelattuTee = 0;
        this.vayla = 0;
        this.tulos = 0;
    }
    
    /**
     * Kierroksen muodostaminen annetuilla tiedoilla ja id:n luonti automaattisesti
     * @param seuraId tuloskortti jolla kierros tehty
     * @param kayttajaId pelaajan id numero
     * @param kierrospaiva päivä jolloin kierretty
     * @param pelattuTee paikka jolta pelattu
     * @param vayla väylä
     * @param tulos tulos väylälle
     */
    public Kierros(int seuraId, int kayttajaId, String kierrospaiva, int pelattuTee, int vayla, int tulos) {
        this.rekisteroi();
        this.seuraId = seuraId;
        this.kayttajaId = kayttajaId;
        this.kierrospaiva = kierrospaiva;
        this.pelattuTee = pelattuTee;
        this.vayla = vayla;
        this.tulos = tulos;
    }
    
    
    /**
     * Tulostetaan tuloskortin tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(String.format("%03d", id) + "|" + this.seuraId + "|" + this.kayttajaId + "|" + this.kierrospaiva + "|" + this.pelattuTee + 
                "|" + this.vayla + "|" + this.tulos);
    }
    
    
    /**
     * Tulostetaan tuloskortin tiedot
     * @param os tietovirta johon tulosetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    
    /**
     * Palauttaa kierroksen id:n
     * @return palauttaa id:n
     */
    public int getTunnusNro() {
        return this.id;
    }
    

    /**
     * Palauttaa seuran id:n
     * @return palauttaa id:n
     */
    public int getSeuraId() {
        return this.seuraId;
    }
    
    
    /**
     * Palauttaa käyttäjän id:n
     * @return palauttaa id:n
     */
    public int getKayttajaId() {
        return this.kayttajaId;
    }
    
    /**
     * Palauttaa käyttäjän pelaaman tee-paikan
     * @return palauttaa käyttäjän pelaaman tee-paikan
     */
    public int getPelattuTee() {
        return this.pelattuTee;
    }
    
    /**
     * Palauttaa käyttäjän pelmaan kierrospäivän
     * @return palauttaa kierrospäivän
     */
    public String getPelattuPaiva() {
        return this.kierrospaiva;
    }
    
    
    /**
     * Antaa kierrokselle seuraavan rekisterinumeron.
     * @return kierroksen uusi id
     * @example
     * <pre name="test">
     * Kierros kierros1 = new Kierros();
     * kierros1.getTunnusNro() === 0;
     * kierros1.rekisteroi();
     * Kierros kierros2 = new Kierros();
     * kierros2.rekisteroi();
     * int n1 = kierros1.getTunnusNro();
     * int n2 = kierros2.getTunnusNro();
     * n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        this.id = seuraavaId;
        seuraavaId++;
        return this.id;
    }
    
    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot tuloskortille.
     * TODO: poista kun kaikki toimii
     * @param seuraNro tuodaan seuran tieto
     * @param kayttajanro tuodaan käyttäjän numero
     * @param vaylanro tuodaan mones väylä halutaan tehdä
     * @param parLuku tuodaan mikä on väylän ihanne par-tulos
     * @param pelattuTeeNro miltä tee paikalta on pelattu
     */
    public void taytaTestiTiedoilla(int seuraNro, int kayttajanro, int vaylanro, int parLuku, int pelattuTeeNro) {
        this.rekisteroi();
        this.seuraId = seuraNro;
        this.kayttajaId = kayttajanro;
        this.kierrospaiva = "01-01-2022";
        this.pelattuTee = pelattuTeeNro;
        this.vayla = vaylanro;
        this.tulos = UusiKierros.luoTulos(parLuku);
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Kierros kierros1 = new Kierros();
        Kierros kierros2 = new Kierros();
        
        kierros1.rekisteroi();
        kierros2.rekisteroi();
        
        kierros1.tulosta(System.out);
        kierros2.tulosta(System.out);
        
        kierros1.taytaTestiTiedoilla(1, 1, 1, 4, 55);
        kierros2.taytaTestiTiedoilla(1, 1, 2, 5, 55);
        
        kierros1.tulosta(System.out);
        kierros2.tulosta(System.out);
    }
}
