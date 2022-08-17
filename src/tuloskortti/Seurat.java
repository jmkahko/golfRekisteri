package tuloskortti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.WildChars;

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
     * @example
     * <pre name="test">
     * #THROWS SailoException
     * Seurat seurat = new Seurat();
     * Seura seura1 = new Seura();
     * Seura seura2 = new Seura();
     * Seura seura3 = new Seura();
     * Seura seura4 = new Seura();
     * Seura seura5 = new Seura();
     * Seura seura6 = new Seura();
     * seurat.getLkm() === 0;
     * seurat.lisaa(seura1); seurat.getLkm() === 1;
     * seurat.lisaa(seura2); seurat.getLkm() === 2;
     * seurat.annaSeura(0) === seura1;
     * seurat.annaSeura(1) === seura2;
     * seurat.annaSeura(0) == seura2 === false;
     * seurat.annaSeura(0) == seura1 === true;
     * seurat.lisaa(seura3);
     * seurat.lisaa(seura3);
     * seurat.lisaa(seura3);
     * seurat.lisaa(seura4);
     * seurat.lisaa(seura5);
     * seurat.lisaa(seura6);
     * seurat.getLkm() === 8;
     * </pre> 
     */
    public void lisaa(Seura seura) {
        if (this.lkm >= this.alkiot.length) {
            kasvataTaulukonKokoa();
        }
            
        this.alkiot[this.lkm] = seura;
        lkm++;
    }
    
    /**
     * Tuplataan private Seura[] alkiot = new Seura[MAX_SEUROJA]; taulukon koon, kun taulukko tulee täyteen.
     * Haetaan uuden taulukon koko nykyinen taulukko * 2
     * Luodaan uusi taulukko uudella koolla esim. ennen oli 5 niin on 10
     * Käydään vanha taulukko for-silmukassa läpi ja kopioidaan rivit uuteen taulukkoon
     * Muutetaan, että uusi taulukko on vanha taulukko
     */
    public void kasvataTaulukonKokoa() {
        int uusiTaulukonKoko = this.alkiot.length * 2;
        Seura[] alkiotUusi = new Seura[uusiTaulukonKoko];
        for (int x = 0; x < this.alkiot.length; x++) {
            alkiotUusi[x] = this.alkiot[x];
        }
        
        this.alkiot = alkiotUusi;
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
     * Tallentaa seuran tiedostoon
     * Tiedoston muoto:
     * <pre>
     * 1|Fyrkkala Golf|Fyrkkalankatu 24|44100|Fyrkkala|042-8248582
     * 2|Tavilaakso Golf|Tavilaaksontie 21|56689|Tavilaakso|042-1236836
     * </pre>
     * @param hakemisto johon tiedosto tallennetaan
     * @throws SailoException jos talennus epäonnistuu
     */
    public void tallenna(String hakemisto) throws SailoException {
        File ftiedosto = new File(hakemisto + "/seura.dat");
        
        try (PrintStream fo = new PrintStream(new FileOutputStream(ftiedosto, false))) {

            for (int x = 0; x < this.getLkm(); x++) {
                Seura seura = this.annaSeura(x);
                fo.println(seura.toString());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Tiedosto " + ftiedosto.getAbsolutePath() + " " + e.getMessage());
        }
        
    }
    
    /**
     * Lukee käyttäjät tiedostosta
     * @param hakemisto josta tiedosto löytyy
     * @throws SailoException jos lukeminen epäonnistuu
     */
    public void lueTiedostosta(String hakemisto) throws SailoException {
        String hnimi = hakemisto + "/seura.dat";
        File ftiedosto = new File(hnimi);
        
        try (Scanner fi = new Scanner(new FileInputStream(ftiedosto))) {
            while (fi.hasNext()) {
                String merkkijono = fi.nextLine();
                if (merkkijono == null || merkkijono.equals("") || merkkijono.charAt(0) == ';') {
                    continue;
                }
                
                Seura seura = new Seura();
                seura.parse(merkkijono);
                this.lisaa(seura);
            }
        } catch (FileNotFoundException e) {
            throw new SailoException("Ei saa luettua tiedostoa: " + hnimi);
        }
    }
    
    
    /**
     * Lisää uuden seuran tai muuttaa olemassa olevan seuran tietoja.
     * Etsii samalla seura -tunnuksella olevaa seuraa, jos ei löydy niin luo uuden seuran
     * @param seura lisättävän tai muutettavan seuran tieto
     * @throws SailoException jos ei onnistu
     */
    public void lisaaTaiMuutaSeura(Seura seura) throws SailoException {
        int id = seura.getTunnusNro();
        
        // Etsitään löytyykö tulevan seuran id -numeroa, jos ei löydy niin lisätään seura
        for (int x = 0; x < this.lkm; x++) {
            if (this.alkiot[x].getTunnusNro() == id) {
                this.alkiot[x] = seura;
                return;
            }
        }
        this.lisaa(seura);
    }
    
    /**
     * Etsitään seuroja hakuehdolla
     * @param ehto hakuehto jolla etsitään
     * @return palautetaan lista seuroista jotka löytyivät
     */
    public Collection<Seura> etsiSeura(String ehto) {
        Collection<Seura> loytyneet = new ArrayList<Seura>();
        
        for (int x = 0; x < this.getLkm(); x++) {
            Seura seura = this.annaSeura(x);
            String sisalto = seura.getSeurannimi();
            if (WildChars.onkoSamat(sisalto, ehto)) {
                loytyneet.add(seura);
            }
        }
        return loytyneet;
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Seurat seurat = new Seurat();
        
        // Luetaan tiedostosta seurat
        try {
            seurat.lueTiedostosta("golfRekisteri");
        }  catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        
        Seura seura1 = new Seura();
        Seura seura2 = new Seura();
        
        seura1.rekisteroi();
        seura1.taytaTestiTiedoilla();
        seura2.rekisteroi();
        seura2.taytaTestiTiedoilla();
        
        seurat.lisaa(seura1);
        seurat.lisaa(seura2);

        System.out.println("======================= Seurat testi =======================");
        for (int x = 0; x < seurat.getLkm(); x++) {
           Seura seura = seurat.annaSeura(x);
           System.out.println("Seuran indeksi: " + x);
           seura.tulosta(System.out);
        }
        
        int seuroja = seurat.annaSeurat().size();
        System.out.println("Seurojen määrä: " + seuroja);
        
        // Tiedostoon tallennus
        try {
            seurat.tallenna("golfRekisteri");
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
    }

}
