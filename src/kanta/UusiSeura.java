package kanta;

/**
 * UusiSeura -luokalla saadaan luotua testidataa golf seuralle
 * @author Janne Kähkönen
 * @version 12.7.2022
 *
 */
public class UusiSeura {

    private static String kaupunki = "";
    
    /**
     * Arvotaan satunnainen kaupunki
     * @return palauttaa kaupungin
     */
    public static String arvoKaupunki() {
        String[] seura = {"Ankkalinna", "Hanhivaara", "Fyrkkala", "Kurjenmutka", "Sorsakylä", "Tavilaakso",
                "Sorsala", "Hepsula", "Rankkalinna", "Kukkola", "Ankkala", "Puluperä"};
        kaupunki = seura[Yleinen.arvoLuku(0,11)];
        return kaupunki;
    }
    
    /**
     * Arvotaan satunnainen golf seura
     * @return palauttaa golf seuran nimen
     */
    public static String arvoGolfSeura() {
        arvoKaupunki();
        return kaupunki + " Golf";
    }
    
    /**
     * Arvotaan satunnainen katuosoite
     * @return palauttaa katuosoitteen
     */
    public static String arvoKatuosoite() {
        String[] loppu = {"ntie", "nkatu"};
        String katu = kaupunki + loppu[Yleinen.arvoLuku(0, 1)];
        String katuosoite = katu + " " + Yleinen.arvoLuku(1, 40);
        return katuosoite;
    }
    
    /**
     * Arvotaan satunnainen postinumero
     * @return palauttaa postinumeron
     */
    public static int arvoPostinumero() {
        return Yleinen.arvoLuku(00000, 99999);
    }
    
    /**
     * arvoKaupunki() -metodissa saatu kaupunki
     * @return palauttaa postitoimipaikan
     */
    public static String arvoPostitoimipaikka() {
        return kaupunki;
    }
    
    /**
     * Arvotaan satunnainen puhelinnumero
     * @return palautetaan puhelinnumero string muodossa
     */
    public static String arvoPuhelinnumero() {
        String[] suunta = { "040", "041", "042", "043", "044", "045", "046", "050"};
        String alku = suunta[Yleinen.arvoLuku(0, 7)];
        int loppu = Yleinen.arvoLuku(0000000, 9999999);
        return alku + "-" + loppu;
    }
}
