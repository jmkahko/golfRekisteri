package kanta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tuloskortti.Tuloskortti;

/**
 * UusiTuloskortti -luokalla saadaan luotua uusia golf väyliä
 * @author Janne Kähkönen
 * @version 13.7.2022
 */
public class UusiTuloskortti {
   
    private static int pituus62 = 0;
    private static int pituus55 = 0;
    private static int pituus51 = 0;
    private static int pituus48 = 0;
    private static int par = 0;
    private static int hcp = 0;
    

    /**
     * Väylän luonnin päätoteuttaja
     * @return palauttaa true kun väylä on luotu
     */
    public static boolean luoVayla() {
        par = Yleinen.arvoLuku(3, 5);
        hcp = Yleinen.arvoLuku(1, 18);
        
        // Arvotaan väylän pituus paikalle 55
        if (par == 3) {
            pituus55 = Yleinen.arvoLuku(105, 150);
        } else if (par == 4) {
            pituus55 = Yleinen.arvoLuku(283, 384);
        } else {
            pituus55 = Yleinen.arvoLuku(405, 495);
        }
        
        int arvo62 = Yleinen.arvoLuku(0, 35);
        int arvo48 = Yleinen.arvoLuku(0, 25);
        
        pituus62 = pituus55 + arvo62;
        pituus48 = pituus55 - arvo48;
        
        // Arvotaan väylän pituus paikalle 51. Joko tee- paikan 48 tai 55 pituus
        int arvo51 = Yleinen.arvoLuku(1, 2);
        
        if (arvo51 == 1) {
            pituus51 = pituus55;
        } else {
            pituus51 = pituus48;
        }
        
        return true;
    }
    
    /**
     * Luodaan väylän pituudet tietyn par-luvun mukaan
     * @param parLuku annetaan luku minkä parin väylä tehdään
     * @return palauttaa taulukossa väylän pituuden eri tee- paikoille
     */
    public static List<Integer> luoVaylaPituus(int parLuku) {
        // Arvotaan väylän pituus paikalle 55
        if (parLuku == 3) {
            pituus55 = Yleinen.arvoLuku(105, 150);
        } else if (parLuku == 4) {
            pituus55 = Yleinen.arvoLuku(283, 384);
        } else {
            pituus55 = Yleinen.arvoLuku(405, 495);
        }
        
        int arvo62 = Yleinen.arvoLuku(0, 35);
        int arvo48 = Yleinen.arvoLuku(0, 25);
        
        pituus62 = pituus55 + arvo62;
        pituus48 = pituus55 - arvo48;
        
        // Arvotaan väylän pituus paikalle 51. Joko tee- paikan 48 tai 55 pituus
        int arvo51 = Yleinen.arvoLuku(1, 2);
        
        if (arvo51 == 1) {
            pituus51 = pituus55;
        } else {
            pituus51 = pituus48;
        }
        
        List<Integer> vaylanPituudet = new ArrayList<Integer>();
        vaylanPituudet.add(pituus62);
        vaylanPituudet.add(pituus55);
        vaylanPituudet.add(pituus51);
        vaylanPituudet.add(pituus48);
        
        return vaylanPituudet;
    }
    
    
    /**
     * @return palauttaa tee- paikan 62 pituuden
     */
    public static int getPituus62() {
        return pituus62;
    }
    
    /**
     * @return palauttaa tee- paikan 55 pituuden
     */
    public static int getPituus55() {
        return pituus55;
    }
    
    /**
     * @return palauttaa tee- paikan 51 pituuden
     */
    public static int getPituus51() {
        return pituus51;
    }
    
    /**
     * @return palauttaa tee- paikan 48 pituuden
     */
    public static int getPituus48() {
        return pituus48;
    }
    
    /**
     * @return palauttaa väylän par-luvun
     */
    public static int getPar() {
        return par;
    }
    
    /**
     * @return palauttaa väylän hcp-luvun
     */
    public static int getHcp() {
        return hcp;
    }
    
    /**
     * Tuloskortilla on par3 väyliä monesti 4-5 kpl, par5 väyliä monesti 2-5 kpl ja loput väylät ovat par4
     * @param seuraNro annetaan halutun seuran numero, jolle tuloskortti luodaan
     * @return palauttaa taulukkona arvotun 18-reikäisen tuloskortin
     */
    public static List<Tuloskortti> luoTuloskortti(int seuraNro) {
        // Luodaan väylien määrät
        int par3 = Yleinen.arvoLuku(4, 5);
        int par5 = Yleinen.arvoLuku(2, 5);
        int par4 = 18 - par3 - par5;
              
        List<Integer> hcpTaulukko = new ArrayList<Integer>();

        while (hcpTaulukko.size() < 18) {
            int arvottu = Yleinen.arvoLuku(1, 19);
            if (!hcpTaulukko.contains(arvottu)) {
                hcpTaulukko.add(arvottu);
            }
        }
        
        List<Integer> vaylaParLuku = new ArrayList<Integer>();
        
        for (int x = 0; x < 18; x++) {
            int parLuku = Yleinen.arvoLuku(1, 3);
            boolean lisatty = false;
            
            if (par3 != 0 && parLuku == 1) {
                vaylaParLuku.add(3);
                par3--;
                lisatty = true;
            }
            
            if (par4 != 0 && parLuku == 3) {
                vaylaParLuku.add(4);
                par4--;
                lisatty = true;
            } 
            
            if (par5 != 0 && parLuku == 2) {
                vaylaParLuku.add(5);
                par5--;
                lisatty = true;
            }
            
            if (!lisatty) {
                vaylaParLuku.add(Yleinen.arvoLuku(3, 5));
            }
                
        }

        List<Tuloskortti> luotu = new ArrayList<Tuloskortti>();
        
        for (int x = 0; x < 18; x++) {
            List<Integer> pituudet = luoVaylaPituus(vaylaParLuku.get(x));
            Tuloskortti tuloskortti = new Tuloskortti(seuraNro, x+1, pituudet.get(0), pituudet.get(1), pituudet.get(2), pituudet.get(3), vaylaParLuku.get(x), hcpTaulukko.get(x));
            luotu.add(tuloskortti);
        }
        
        return luotu;
    }
}
