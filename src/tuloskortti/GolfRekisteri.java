package tuloskortti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: GolfRekisteri           | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        | - Kayttaja                           |
 * |                                      | - Seura                              |
 * | - Huolehtii Kayttaja, Seura,         | - Tuloskortti                        |
 * |   Tuloskortti ja Kierros -luokkien   | - Kierros                            |
 * |   välisestä yhteistyöstä ja välittää |                                      |
 * |   näitä tietoja pyydettäessä         |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * |                                      |                                      |
 * +--------------------------------------+--------------------------------------+
 * @author Janne Kähkönen
 * @version 12.7.2022
 */
public class GolfRekisteri {
    
    private Kayttajat kayttajat;
    private Seurat seurat;
    private Tuloskortit tuloskortit;
    private Kierrokset kierrokset;
    
    private String hakemisto = "golfRekisteri";
    
    
    /**
     * Luodaan GolfRekisterin muodostajat
     */
    public GolfRekisteri() {
        this.kayttajat = new Kayttajat();
        this.seurat = new Seurat();
        this.tuloskortit = new Tuloskortit();
        this.kierrokset = new Kierrokset();
    }
    
    /**
     * Lisätään uusi käyttäjä
     * @param kayttaja lisättävä käyttäjä
     * @throws SailoException jos käyttäjän lisääminen ei onnistu
     */
    public void lisaaKayttaja(Kayttaja kayttaja) throws SailoException {
        this.kayttajat.lisaa(kayttaja);
    }
    
    /**
     * @return palauttaa käyttäjien määrä
     */
    public int getKayttajia() {
        return this.kayttajat.getLkm();
    }
    
    /**
     * @param i Antaa GolfRekisterin käyttäjän
     * @return palautta seuran
     */
    public Kayttaja annaKayttaja(int i) {
        return this.kayttajat.annaKayttaja(i);
    }
    
    
    /**
     * Lisätään uusi seura
     * @param seura lisättävä seura
     * @throws SailoException jos seuran lisääminen ei onnistu
     */
    public void lisaaSeura(Seura seura) throws SailoException {
        this.seurat.lisaa(seura);
    }
    
    /**
     * Lisätään uusi seura tai muutetaan olemassa olevaa seuraa
     * @param seura muutettavan tai lisättävän seuran tieto
     * @throws SailoException jos seuran lisääminen ei onnistu
     */
    public void lisaaTaiMuutaSeura(Seura seura) throws SailoException {
        this.seurat.lisaaTaiMuutaSeura(seura);
    }
    
    /**
     * @return palauttaa seurojen määrän
     */
    public int getSeuroja() {
        return this.seurat.getLkm();
    }
    
    /**
     * @param i Antaa GolfRekisterin seuran
     * @return palautta seurann
     */
    public Seura annaSeura(int i) {
        return this.seurat.annaSeura(i);
    }
    
    /**
     * Saadaan haettua kaikki golf seurat
     * @return palauttaa kaikki seurat
     */
    public List<Seura> annaSeurat() {
        return this.seurat.annaSeurat();
    }
    
    /**
     * Lisätään uusi tuloskortti
     * @param tuloskortti lisättävä tuloskortti
     * @throws SailoException jos tuloskortin lisääminen ei onnistu
     */
    public void lisaaTuloskortti(Tuloskortti tuloskortti) throws SailoException {
        this.tuloskortit.lisaaTuloskortti(tuloskortti);
    }
    
    /**
     * Luodaan 18-väyläinen tuloskortti
     * @param luoTuloskortti annetaan listana väylät
     */
    public void lisaaTuloskortti(List<Tuloskortti> luoTuloskortti) {
        this.tuloskortit.lisaaTuloskortti(luoTuloskortti);
    }
    
    /**
     * Lisätään uusi tuloskortti tai muutetaan olemassa olevaa tuloskorttia
     * @param tuloskortti muutettavan tai lisättävän tuloskortin tieto
     * @throws SailoException jos seuran lisääminen ei onnistu
     */
    public void lisaaTaiMuutaTuloskorttia(List<Tuloskortti> tuloskortti) throws SailoException {
        this.tuloskortit.lisaaTaiMuutaTuloskorttia(tuloskortti);
    }
    
    /**
     * @return palauttaa tuloskorttien määrän
     */
    public int getTuloskortteja() {
        return this.tuloskortit.getLkm();
    }
        
    /**
     * @param seura tunnus
     * @return palautta seuran tuloskortin
     */
    public List<Tuloskortti> annaTuloskortti(Seura seura) {
        return tuloskortit.annaTuloskortit(seura.getTunnusNro());
    }
    
    /**
     * Lisätään uusi kierros
     * @param kierros lisättävä kierros
     * @throws SailoException jos kierroksen lisääminen ei onnistu
     */
    public void lisaaKierros(Kierros kierros) throws SailoException {
        this.kierrokset.lisaaKierros(kierros);
    }
    
    /**
     * Lisätään koko kierroksen tuloskortti
     * @param kierros taulukko
     */
    public void lisaaKierros(List<Kierros> kierros) {
        this.kierrokset.lisaaKierros(kierros);
    }
    
    /**
     * @return palauttaa kierrosten määrän
     */
    public int getKierroksia() {
        return this.kierrokset.getLkm();
    }
    
    /**
     * Antaa GolfRekisterin kierroksen
     * @param seura seuran id numero
     * @param kayttaja käyttäjän id numero
     * @return palautta kierrokset
     */
    public List<Kierros> annaKierrokset(Seura seura, Kayttaja kayttaja) {
        return this.kierrokset.annaKierrokset(seura.getTunnusNro(), kayttaja.getTunnusNro());
    }
    
    /**
     * Palauttaa kierrokset jotka pelattu
     * @return palauttaa kaikki kierrokset
     */
    public Collection<Kierros> annaKaikkiKierrokset() {
        return this.kierrokset.annaKaikkiKierrokset();
    }   
    
    /**
     * Lukee golfRekisterin tiedot tiedostosta
     * @param nimi käytetään tiedoston lukemiseen
     * @throws SailoException jos lukeminen epäonnistuu
     */
    public void lueTiedostosta(String nimi) throws SailoException {
        File file = new File(nimi);
        file.mkdir();
        
        kayttajat = new Kayttajat();
        seurat = new Seurat();
        kierrokset = new Kierrokset();
        tuloskortit = new Tuloskortit();
        
        hakemisto = nimi;
        kayttajat.lueTiedostosta(nimi);
        seurat.lueTiedostosta(nimi);
        kierrokset.lueTiedostosta(nimi);
        tuloskortit.lueTiedostosta(nimi);
    }
    
    /**
     * Tallentaan golfRekisterin tiedot tiedostoon
     * @throws SailoException jos tallennuksessa tulee ongelmaa
     */
    public void tallenna() throws SailoException {
        String virhe = "";
        
        try {
            kayttajat.tallenna(hakemisto);
        } catch (SailoException e) {
            virhe = e.getMessage();
        }
        
        try {
            seurat.tallenna(hakemisto);
        } catch (SailoException e) {
            virhe += e.getMessage();
        }
        
        try {
            kierrokset.tallenna(hakemisto);
        } catch (SailoException e) {
            virhe += e.getMessage();
        }
        
        try {
            tuloskortit.tallenna(hakemisto);
        } catch (SailoException e) {
            virhe += e.getMessage();
        }
        
        if (!"".equals(virhe)) {
            throw new SailoException(virhe);
        }
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        GolfRekisteri golfRekisteri = new GolfRekisteri();
        
        try {
            golfRekisteri.lueTiedostosta("koegolfRekisteri");
        }  catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        // Käyttäjien tiedot
        Kayttaja henkilo1 = new Kayttaja();
        Kayttaja henkilo2 = new Kayttaja();
        
        henkilo1.rekisteroi();
        henkilo1.taytaTestiTiedoilla();
        henkilo2.rekisteroi();
        henkilo2.taytaTestiTiedoilla();
        
        // Seurojen tiedot        
        Seura seura1 = new Seura();
        Seura seura2 = new Seura();
        
        seura1.rekisteroi();
        seura1.taytaTestiTiedoilla();
        seura2.rekisteroi();
        seura2.taytaTestiTiedoilla();
        
        try {
            golfRekisteri.lisaaKayttaja(henkilo1);
            golfRekisteri.lisaaKayttaja(henkilo2);
            golfRekisteri.lisaaSeura(seura1);
            golfRekisteri.lisaaSeura(seura2);
            
            golfRekisteri.tallenna();
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("GolfRekisterin käyttäjät:");
        for (int x = 0; x < golfRekisteri.getKayttajia(); x++) {
            Kayttaja kayttaja = golfRekisteri.annaKayttaja(x);
            kayttaja.tulosta(System.out);
        }
        
        System.out.println("");
        System.out.println("GolfRekisterin seurat:");
        for (int x = 0; x < golfRekisteri.getSeuroja(); x++) {
            Seura seura = golfRekisteri.annaSeura(x);
            seura.tulosta(System.out);
        }
    }
}
