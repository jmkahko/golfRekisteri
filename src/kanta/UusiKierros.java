package kanta;

import java.util.ArrayList;
import java.util.List;

import tuloskortti.Kierros;
import tuloskortti.Tuloskortti;

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
    
    
    /**
     * Arvotaan tuloskortille kierros
     * @param seuraNro seuran numero
     * @param pelattuTee miltä tee paikalta on pelattu
     * @return palauttaa tuloksen kierrokselle
     */
    public static List<Kierros> luoKierros(int seuraNro, int pelattuTee) {
        List<Kierros> luotuKierros = new ArrayList<Kierros>();
        
        List<Tuloskortti> tuloskortti = UusiTuloskortti.luoTuloskortti(seuraNro);
        
        for (Tuloskortti t : tuloskortti) {
            Kierros vayla = new Kierros();
            vayla.taytaTestiTiedoilla(t.getTunnusNro(), 1, t.getVaylaNro(), t.getParLuku(), pelattuTee);
            luotuKierros.add(vayla);
        }
        
        return luotuKierros;
    }
}
