package tuloskortti.test;
// Generated by ComTest BEGIN
import java.util.*;
import kanta.UusiKierros;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.*;
import tuloskortti.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2022.08.29 16:18:45 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class KierroksetTest {



  // Generated by ComTest BEGIN
  /** testLisaaKierros62 */
  @Test
  public void testLisaaKierros62() {    // Kierrokset: 62
    Kierrokset kierrokset = new Kierrokset(); 
    Kierros vayla1 = new Kierros(1, 1, "01-01-2001", 55, 1, 4); 
    kierrokset.lisaaKierros(vayla1); 
    assertEquals("From: Kierrokset line: 66", 1, kierrokset.getLkm()); 
    Kierros vayla2 = new Kierros(1, 1, "01-01-2001", 55, 2, 3); 
    kierrokset.lisaaKierros(vayla2); 
    assertEquals("From: Kierrokset line: 69", 2, kierrokset.getLkm()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testLisaaKierros80 */
  @Test
  public void testLisaaKierros80() {    // Kierrokset: 80
    Kierrokset kierrokset = new Kierrokset(); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 48));  // Lisää koko kierros eli 18 väylää
    assertEquals("From: Kierrokset line: 83", 18, kierrokset.getLkm()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testLisaaTaiMuutaKierros96 */
  @Test
  public void testLisaaTaiMuutaKierros96() {    // Kierrokset: 96
    Kierrokset kierrokset = new Kierrokset(); 
    try {
    kierrokset.lisaaTaiMuutaKierros(UusiKierros.luoKierros(1, 48)); 
    } catch (SailoException e) {
    e.printStackTrace(); 
    }
    assertEquals("From: Kierrokset line: 103", 18, kierrokset.getLkm()); 
    try {
    kierrokset.lisaaTaiMuutaKierros(UusiKierros.luoKierros(1, 48));  // Tässä luodaan uudet 18 väylää, josta johtuen kierrosmäärä on 36
    } catch (SailoException e) {
    e.printStackTrace(); 
    }
    assertEquals("From: Kierrokset line: 111", 36, kierrokset.getLkm()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testAnnaKierrokset133 */
  @Test
  public void testAnnaKierrokset133() {    // Kierrokset: 133
    Kierrokset kierrokset = new Kierrokset(); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55)); 
    List<Kierros> loytyneet; 
    loytyneet = kierrokset.annaKierrokset(1, 1); 
    assertEquals("From: Kierrokset line: 141", 18, loytyneet.size()); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55)); 
    loytyneet = kierrokset.annaKierrokset(1, 1); 
    assertEquals("From: Kierrokset line: 144", 36, loytyneet.size()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testAnnaKaikkiKierrokset162 */
  @Test
  public void testAnnaKaikkiKierrokset162() {    // Kierrokset: 162
    Kierrokset kierrokset = new Kierrokset(); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55)); 
    Collection<Kierros> kierrosYksiRivi = kierrokset.annaKaikkiKierrokset(); 
    assertEquals("From: Kierrokset line: 169", 18, kierrosYksiRivi.size()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testPoistaKierros181 */
  @Test
  public void testPoistaKierros181() {    // Kierrokset: 181
    Kierrokset kierrokset = new Kierrokset(); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 48));  // Lisää koko kierros eli 18 väylää, seura 1
    assertEquals("From: Kierrokset line: 184", 18, kierrokset.getLkm()); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(2, 48));  // Lisää koko kierros eli 18 väylää, seura 2
    assertEquals("From: Kierrokset line: 186", 36, kierrokset.getLkm()); 
    kierrokset.poistaKierros(1); 
    assertEquals("From: Kierrokset line: 188", 18, kierrokset.getLkm()); 
    kierrokset.poistaKierros(2); 
    assertEquals("From: Kierrokset line: 190", 0, kierrokset.getLkm()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testPoistaKierros212 */
  @Test
  public void testPoistaKierros212() {    // Kierrokset: 212
    Kierrokset kierrokset = new Kierrokset(); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55)); 
    List<Kierros> poistaKierros = kierrokset.annaKierrokset(1, 1); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55)); 
    assertEquals("From: Kierrokset line: 219", 18, poistaKierros.size()); 
    assertEquals("From: Kierrokset line: 220", 36, kierrokset.getLkm()); 
    kierrokset.poistaKierros(poistaKierros); 
    List<Kierros> poistaKierros2 = kierrokset.annaKierrokset(1, 1); 
    assertEquals("From: Kierrokset line: 223", 18, kierrokset.getLkm()); 
    assertEquals("From: Kierrokset line: 224", 18, poistaKierros2.size()); 
    kierrokset.poistaKierros(poistaKierros2); 
    assertEquals("From: Kierrokset line: 226", 0, kierrokset.getLkm()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testLueTiedostosta266 
   * @throws SailoException when error
   */
  @Test
  public void testLueTiedostosta266() throws SailoException {    // Kierrokset: 266
    Kierrokset kierrokset = new Kierrokset(); 
    Kierros vayla1 = new Kierros(1, 1, "01-01-2001", 55, 1, 4); 
    Kierros vayla2 = new Kierros(1, 1, "01-01-2001", 55, 2, 3); 
    String hakemisto = "testiGolfRekisteri"; 
    String tiedostonNimi = hakemisto + "/kierros"; 
    File fTiedosto = new File(tiedostonNimi + ".dat"); 
    File dir = new File(hakemisto); 
    dir.mkdir(); 
    fTiedosto.delete(); 
    try {
    kierrokset.lueTiedostosta(tiedostonNimi); 
    fail("Kierrokset: 278 Did not throw SailoException");
    } catch(SailoException _e_){ _e_.getMessage(); }
    kierrokset.lisaaKierros(vayla1); 
    kierrokset.lisaaKierros(vayla2); 
    kierrokset.tallenna(hakemisto); 
    assertEquals("From: Kierrokset line: 282", 2, kierrokset.getLkm()); 
    kierrokset = new Kierrokset();  // Tyhjennetään kierrokset
    try {
    kierrokset.lueTiedostosta(tiedostonNimi); 
    fail("Kierrokset: 284 Did not throw SailoException");
    } catch(SailoException _e_){ _e_.getMessage(); }
    kierrokset.lisaaKierros(vayla1); 
    kierrokset.tallenna(hakemisto); 
    assertEquals("From: Kierrokset line: 287", true, fTiedosto.delete()); 
    assertEquals("From: Kierrokset line: 288", true, dir.delete()); 
  } // Generated by ComTest END
}