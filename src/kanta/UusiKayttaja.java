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
     * Arvotaan satunnainen pelaaja ennalta määrätyistä nimistä
     * @return palauttaa pelaajan nimen
     */
    public static String arvoPelaaja() {
        String[] nimi = {"Roope Ankka", "Taavi Ankka", "Tupu", "Hupu", "Lupu", "Hannu Hanhi", "Touho Ankka", "Sisuvius Ankka", "Hansu Hanhi",
                "Into Ankka", "José Carioca", "Panchito Pistoles", "Pelle Peloton", "Iines Ankka", "Mikki Hiiri", "Hessu Hopo"};
        return nimi[Yleinen.arvoLuku(0,15)];
    }
    
    /**
     * Arvotaan satunnainen aloitusvuosi väliltä 1940 - 2010
     * @return palauttaa vuoden
     */
    public static int arvoVuosi() {
        double vuosi = (2010-1940)*Math.random() + 1940;
        return (int)Math.round(vuosi);
    }
}
