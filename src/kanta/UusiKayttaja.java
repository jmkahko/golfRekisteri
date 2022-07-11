package kanta;

/**
 * Saadaan luotua käyttäjälle satunnaisia arvoja
 * @author Janne Kähkönen
 * @version 11.7.2022
 */
public class UusiKayttaja {

    /**
     * Arvotaan satunnainen double väliltä 0.0 - 54
     * @return palauttaa satunnaisen luvun
     */
    public static double arvoTasoitus() {
        double tasoitus = (54.0 - 0.0)*Math.random() + 0.0;
        return Math.round(tasoitus);
    }
    
    /**
     * Arvotaan satunnainen kokonaisluku väliltä [ala, yla]
     * @param ala arvonnan alaraja
     * @param yla arvonnan yläraja
     * @return palauttaa satunnaisen kokonaisluvun väliltä [ala, yla]
     */
    public static int arvoLuku(int ala, int yla) {
        double luku = (yla-ala)*Math.random() + ala;
        return (int)Math.round(luku);
    }
    
    /**
     * Arvotaan satunnainen pelaaja ennalta määrätyistä nimistä
     * @return palauttaa pelaajan nimen
     */
    public static String arvoPelaaja() {
        String[] nimi = {"Roope Ankka", "Taavi Ankka", "Tupu", "Hupu", "Lupu", "Hannu Hanhi", "Touho Ankka", "Sisuvius Ankka", "Hansu Hanhi",
                "Into Ankka", "José Carioca", "Panchito Pistoles", "Pelle Peloton", "Iines Ankka", "Mikki Hiiri", "Hessu Hopo"};
        return nimi[arvoLuku(0,15)];
    }
    
    /**
     * Arvotaan satunnainen aloitusvuosi väliltä 1940 - 2010
     * @return palauttaa vuoden
     */
    public static int arvoVuosi() {
        double vuosi = (2010-1940)*Math.random() + 1940;
        return (int)Math.round(vuosi);
    }
    
    
    /**
     * Arvotaan satunnainen golf seura ennalta määrätyistä seuroista
     * @return palauttaa golf seuran nimen
     */
    public static String arvoGolfSeura() {
        String[] seura = {"Ankkalinna Golf", "Hanhivaara Golf", "Fyrkkala Golf", "Kurjenmutka Golf", "Sorsakylä Golf", "Tavilaakso Golf",
                "Sorsala Golf", "Hepsula Golf", "Rankkalinna Golf", "Kukkola Golf", "Ankkala Golf", "Puluperä Golf", "Joutsenlampi Golf"};
        return seura[arvoLuku(0,12)];
    }
    
    

}
