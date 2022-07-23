package tuloskortti;

import java.util.ArrayList;
import java.util.List;

/**
 * +--------------------------------------+--------------------------------------+
 * | Luokan nimi: Seurat                  | Avustajat:                           |
 * +--------------------------------------+--------------------------------------+
 * | Vastuualueet:                        | - Seura                              |
 * |                                      |                                      |
 * | - Pitää yllä varsinaista seura-      |                                      |
 * |   rekisteriä, eli lisätä ja          |                                      |
 * |   poistaa seuran                     |                                      |
 * | - Osaa lukea ja kirjoittaa seuran    |                                      |
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
 * @version 12.7.2022
 */
public class Seurat {

    private static final int MAX_SEUROJA = 5;
    private int lkm = 0;
    private Seura[] alkiot;
    
    /**
     * Luodaan alustava taulukko
     */
    public Seurat() {
        this.alkiot = new Seura[MAX_SEUROJA];
    }
    
    /**
     * Lisätään uusi Seura Seura[] tietorakenteesen. Ottaa seuran omistukseensa.
     * @param seura annetaan seura
     * @throws SailoException jos Kayttaja[] taulukko täynnä
     * @example
     * <pre name="test">
     * #THROWS SailoException
     * Seurat seurat = new Seurat();
     * Seura seura1 = new Seura();
     * Seura seura2 = new Seura();
     * Seura seura3 = new Seura();
     * seurat.getLkm() === 0;
     * seurat.lisaa(seura1); seurat.getLkm() === 1;
     * seurat.lisaa(seura2); seurat.getLkm() === 2;
     * seurat.annaSeura(0) === seura1;
     * seurat.annaSeura(1) === seura2;
     * seurat.annaSeura(0) == seura2 === false;
     * seurat.annaSeura(0) == seura1 === true;
     * seurat.annaSeura(5) === seura1; #THROWS IndexOutOfBoundsException
     * seurat.lisaa(seura3);
     * seurat.lisaa(seura3);
     * seurat.lisaa(seura3);
     * seurat.lisaa(seura3); #THROWS SailoException
     * </pre> 
     */
    public void lisaa(Seura seura) throws SailoException {
        if (this.lkm >= this.alkiot.length) throw new SailoException("Liikaa alkioita, ei voida listätä");
        this.alkiot[this.lkm] = seura;
        lkm++;
    }
    
    /**
     * Palauttaa seurojen lukumäärän
     * @return seurojen lukumäärän
     */
    public int getLkm() {
        return lkm;
    }
    
    /**
     * Palauttaa viitteen i:teen seuran
     * @param i monennenko seuran viite halutaan
     * @return viite seuraan, jonka indeksi on i
     * @throws IndexOutOfBoundsException jos i ei ole sallitulla alueella
     */
    public Seura annaSeura(int i) throws IndexOutOfBoundsException {
        if (i < 0 || this.lkm <= i) {
            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
        }
        return alkiot[i];
    }
    
    /**
     * Palauttaa kaikki seurat
     * @return kaikki seurat
     * @example
     * <pre name="test">
     * #import java.util.*;
     * 
     * Seurat seurat = new Seurat();
     * List<Seura> loytyneet;
     * 
     * Seura seura1 = new Seura();
     * seura1.rekisteroi();
     * seura1.taytaTestiTiedoilla();

     * loytyneet = seurat.annaSeurat();
     * loytyneet.size() === 1;
     * Seura seura2 = new Seura();
     * seura2.rekisteroi();
     * seura2.taytaTestiTiedoilla();

     * loytyneet = seurat.annaSeurat();
     * loytyneet.size() === 2;
     * </pre>
     */
    public List<Seura> annaSeurat() {
        List<Seura> loydetyt = new ArrayList<Seura>();
        
        for (int i = 0; i < this.lkm; i++) {
            loydetyt.add(alkiot[i]);
        }

        return loydetyt;
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Seurat seurat = new Seurat();
        Seura seura1 = new Seura();
        Seura seura2 = new Seura();
        
        seura1.rekisteroi();
        seura1.taytaTestiTiedoilla();
        seura2.rekisteroi();
        seura2.taytaTestiTiedoilla();
        
        try {
            seurat.lisaa(seura1);
            seurat.lisaa(seura2);
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("======================= Seurat testi =======================");
        for (int x = 0; x < seurat.getLkm(); x++) {
           Seura seura = seurat.annaSeura(x);
           System.out.println("Seuran indeksi: " + x);
           seura.tulosta(System.out);
        }
        
        int seuroja = seurat.annaSeurat().size();
        System.out.println("Seurojen määrä: " + seuroja);
    }

}
