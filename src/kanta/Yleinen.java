package kanta;

/**
 * Yleinen -luokka aputyökaluille
 * @author Janne Kähkönen
 * @version 12.7.2022
 */
public class Yleinen {

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
}
