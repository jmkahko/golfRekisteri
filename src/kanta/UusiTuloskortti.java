package kanta;

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
        
        // Arvotaan väylän pituus tee- paikalle 55
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
        
        // Arvotaan tee- paikan 51 pituus. Joko tee- paikan 48 tai 55 pituus
        int arvo51 = Yleinen.arvoLuku(1, 2);
        
        if (arvo51 == 1) {
            pituus51 = pituus55;
        } else {
            pituus51 = pituus48;
        }
        
        return true;
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
}
