package tuloskortti;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;
import kanta.UusiTuloskortti;

/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: Tulokortti              | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        |                                      |
 * |                                      |                                      |
 * | - Huolehtii tuloskorttien tiedoista  |                                      |
 * | - Ei tiedä käyttöliittymästä         |                                      |
 * | - Tietää tuloskortin kentät (id,     |                                      |
 * |   seuran, vaylan, pituudet, par, hcp)|                                      |
 * | - Osaa muuttaa merkkijonon           |                                      |
 * |   seurantiedoiksi                    |                                      |
 * | - Osaa muuttaa merkkijonon numeroksi |                                      |
 * |   ja numeron merkkijonoksi           |                                      |
 * | - Osaa lukea ja kirjoittaa           |                                      |
 * |   tuloskortti tiedostoon             |                                      |
 * | - Osaa pyytää apua avustajiltaan     |                                      |
 * |                                      |                                      |
 * +--------------------------------------+--------------------------------------+
 * @author Janne Kähkönen
 * @version 13.7.2022
 */
public class Tuloskortti {

    private int id;
    private int seuraId;
    private int vayla;
    private int pituus62;
    private int pituus55;
    private int pituus51;
    private int pituus48;
    private int par;
    private int hcp;
    
    // Luo jokaiselle tuloskortille oman "globaalin" seuraava id-numeron
    private static int seuraavaId = 1;
    
    
    /**
     * Tuloskortin muodostaja oletusarvoilla
     */
    public Tuloskortti() {
        this.id = 0;
        this.seuraId = 0;
        this.vayla = 0;
        this.pituus62 = 0;
        this.pituus55 = 0;
        this.pituus51 = 0;
        this.pituus48 = 0;
        this.par = 0;
        this.hcp = 0;
    }
    
    /**
     * @param seuraId seuran numero
     * @param vayla väylän numero
     * @param pituus62 väylän pituus tee- paikalta
     * @param pituus55 väylän pituus tee- paikalta
     * @param pituus51 väylän pituus tee- paikalta
     * @param pituus48 väylän pituus tee- paikalta
     * @param par väylän par tulos
     * @param hcp väylän hcp luku
     */
    public Tuloskortti(int seuraId, int vayla, int pituus62, int pituus55, int pituus51, int pituus48, int par, int hcp) {
        this.rekisteroi();
        this.seuraId = seuraId;
        this.vayla = vayla;
        this.pituus62 = pituus62;
        this.pituus55 = pituus55;
        this.pituus51 = pituus51;
        this.pituus48 = pituus48;
        this.par = par;
        this.hcp = hcp;
    }
    
    
    /**
     * Tulostetaan tuloskortin tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(String.format("%03d", id) + "|" + this.seuraId + "|" + this.vayla + "|" + this.pituus62 + "|" + this.pituus55 + 
                "|" + this.pituus51 + "|" + this.pituus48 + "|" + this.par + "|" + this.hcp);
    }
    
    @Override
    public String toString() {
        return this.id + "|" + this.seuraId + "|" + this.vayla + "|" + this.pituus62 + "|" + this.pituus55 + 
                "|" + this.pituus51 + "|" + this.pituus48 + "|" + this.par + "|" + this.hcp;
    }
    
    /**
     * Tulostetaan tuloskortin tiedot
     * @param os tietovirta johon tulosetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    
    /**
     * Palauttaa tuloskortin id:n
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
     * Palauttaa seuran id:n
     * @return palauttaa id:n
     */
    public int getSeuraNro() {
        return this.seuraId;
    }
    
    /**
     * Palauttaa pelatun väylän numeron
     * @return palauttaa numeron
     */
    public int getVaylaNro() {
        return this.vayla;
    }
    
    /**
     * Palauttaa väylän par luvun
     * @return palauttaa par luvun
     */
    public int getParLuku() {
        return this.par;
    }
    
    
    /**
     * Antaa tuloskortille seuraavan rekisterinumeron.
     * @return tuloskortin uusi id
     * @example
     * <pre name="test">
     * Tuloskortti tuloskortti1 = new Tuloskortti();
     * tuloskortti1.getTunnusNro() === 0;
     * tuloskortti1.rekisteroi();
     * Tuloskortti tuloskortti2 = new Tuloskortti();
     * tuloskortti2.rekisteroi();
     * int n1 = tuloskortti1.getTunnusNro();
     * int n2 = tuloskortti2.getTunnusNro();
     * n1 === n2-1;
     * </pre>
     */
    public int rekisteroi() {
        this.id = seuraavaId;
        seuraavaId++;
        return this.id;
    }
    
    /**
     * Selvittää tiloskortin tiedot | putkella erotellusta merkkijonosta
     * Tarkistaa, että seuraavaId on suurempi kuin tuleva Id numero
     * @param merkkijono josta tuloskortin tiedot saadaan
     * @example
     * <pre name="test">
     * Tuloskortti tuloskortti = new Tuloskortti();
     * tuloskortti.parse(  3  |  1  | 1  );
     * tuloskortti.getTunnusNro() === 3;
     * tuloskortti.toString().startsWith(3|1|1) === true;
     * tuloskortti.rekisteroi();
     * int n = seura.getTunnusNro();
     * tuloskortti.parse("" + (n + 20));   // Otetaan merkkijonon alusta vain id numero ja lisätään siihen 20
     * tuloskortti.rekisteroi();           // Tarkistetaan tämän jälkeen, että tulee isompi numero
     * tuloskortti.getTunnusNro() === n + 20 + 1;
     */
    public void parse(String merkkijono) {
        var sb = new StringBuilder(merkkijono);
        this.setTunnusNro(Mjonot.erota(sb, '|', this.getTunnusNro()));             
        this.seuraId = Mjonot.erota(sb, '|', seuraId);
        this.vayla = Mjonot.erota(sb, '|', vayla);
        this.pituus62 = Mjonot.erota(sb, '|', pituus62);
        this.pituus55 = Mjonot.erota(sb, '|', pituus55);
        this.pituus51 = Mjonot.erota(sb, '|', pituus51);
        this.pituus48 = Mjonot.erota(sb, '|', pituus48);
        this.par = Mjonot.erota(sb, '|', par);
        this.hcp = Mjonot.erota(sb, '|', hcp);
    }
    
    
    /**
     * Apumetodi, jolla saadaan täytettyä testiarvot tuloskortille.
     * TODO: poista kun kaikki toimii
     * @param seuranro tuodaan seuran tieto
     * @param vaylanro tuodaan mones väylä halutaan tehdä
     */
    public void taytaTestiTiedoilla(int seuranro, int vaylanro) {
        this.seuraId = seuranro;
        this.vayla = vaylanro;
        UusiTuloskortti.luoVayla();
        this.pituus62 = UusiTuloskortti.getPituus62();
        this.pituus55 = UusiTuloskortti.getPituus55();
        this.pituus51 = UusiTuloskortti.getPituus51();
        this.pituus48 = UusiTuloskortti.getPituus48();
        this.par = UusiTuloskortti.getPar();
        this.hcp = UusiTuloskortti.getHcp();
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Tuloskortti tuloskortti1 = new Tuloskortti();
        Tuloskortti tuloskortti2 = new Tuloskortti();
        
        tuloskortti1.rekisteroi();
        tuloskortti2.rekisteroi();
        
        tuloskortti1.tulosta(System.out);
        tuloskortti2.tulosta(System.out);
        
        tuloskortti1.taytaTestiTiedoilla(1, 1);
        tuloskortti2.taytaTestiTiedoilla(1, 2);
        
        tuloskortti1.tulosta(System.out);
        tuloskortti2.tulosta(System.out);
    }
}
