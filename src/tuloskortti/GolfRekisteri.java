package tuloskortti;

import java.io.File;
import java.util.List;

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
     * @throws SailoException jos käyttäjän lisääminen ei onnistu
     */
    public void lisaaSeura(Seura seura) throws SailoException {
        this.seurat.lisaa(seura);
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
     * Palauttaa kierrokset jotka pelattu, näistä näytetään päiväys, kenttä ja tulos
     * Tehdään oletus, että aina on 18 väylää kierretty ja syötetty. Joten uuden kierroksen alku löytyy paikoista 1, 19, 37...
     * @return palauttaa yhden rivin per kierros.
     */
    public List<Kierros> annaKaikkiKierrokset() {
        return this.kierrokset.annaKaikkiKierrokset();
    }
            

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        GolfRekisteri golfRekisteri = new GolfRekisteri();
        
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
