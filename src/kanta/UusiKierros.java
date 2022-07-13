package kanta;

/**
 * UusiKierros -luokalla saadaan luotua uusia golf kierroksia
 * @author Janne Kähkönen
 * @version 13.7.2022
 */
public class UusiKierros {

    
    /**
     * @param parLuku mikä on väylän par tulos
     * @return palauttaa väylän tuloksen
     */
    public static int luoTulos(int parLuku) {
        int tulos;
        if (parLuku == 3) {
            tulos = Yleinen.arvoLuku(1, 6);
        } else if (parLuku == 4) {
            tulos = Yleinen.arvoLuku(2, 8);
        } else {
            tulos = Yleinen.arvoLuku(3, 10);
        }
        return tulos;
    }
}
