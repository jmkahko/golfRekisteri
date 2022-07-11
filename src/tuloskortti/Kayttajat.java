package tuloskortti;

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
    
    private static final int MAX_KAYTTAJIA = 3;
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
     * kayttajat.lisaa(henkilo2); kayttajat.getLkm() === 3;
     * kayttajat.lisaa(henkilo3); #THROWS SailoException
     * </pre> 
     */
    public void lisaa(Kayttaja kayttaja) throws SailoException {
        if (this.lkm >= this.alkiot.length) throw new SailoException("Liikaa alkioita, ei voida listätä");
        this.alkiot[this.lkm] = kayttaja;
        lkm++;
    }
    
    /**
     * Palauttaa käyttäjien käyttäjien lukumäärän
     * @return käyttäjien lukumäärän
     */
    public int getLkm() {
        return lkm;
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
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Kayttajat kayttajat = new Kayttajat();
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
    }
}
