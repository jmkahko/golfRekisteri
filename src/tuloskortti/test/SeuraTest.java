package tuloskortti.test;
// Generated by ComTest BEGIN
import fi.jyu.mit.ohj2.Suuntaaja;
import static org.junit.Assert.*;
import org.junit.*;
import tuloskortti.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2022.08.25 17:21:07 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class SeuraTest {



  // Generated by ComTest BEGIN
  /** testTulosta60 */
  @Test
  public void testTulosta60() {    // Seura: 60
    Seura seura = new Seura(); 
    seura.setSeurannimi("AnkkaGolf"); 
    seura.setKatuosoite("Ankkatie 2"); 
    seura.setPostinumero(90100); 
    seura.setPostitoimipaikka("Ankkala"); 
    seura.setPuhelinnumero("040-313"); 
    Suuntaaja.StringOutput so = new Suuntaaja.StringOutput(); 
    String tulos = "000|AnkkaGolf|Ankkatie 2|90100|Ankkala|040-313"; 
    seura.tulosta(System.out); 
    assertEquals("From: Seura line: 71", null, so.ero(tulos)); 
    so.palauta(); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testRekisteroi111 */
  @Test
  public void testRekisteroi111() {    // Seura: 111
    Seura seura = new Seura(); 
    assertEquals("From: Seura line: 113", 0, seura.getTunnusNro()); 
    seura.rekisteroi(); 
    Seura seura2 = new Seura(); 
    seura2.rekisteroi(); 
    int n1 = seura.getTunnusNro(); 
    int n2 = seura2.getTunnusNro(); 
    assertEquals("From: Seura line: 119", n2-1, n1); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testToString212 */
  @Test
  public void testToString212() {    // Seura: 212
    Seura s = new Seura(); 
    s.parse("       3         |       Ankkala    |   1"); 
    assertEquals("From: Seura line: 215", true, s.toString().startsWith("3|Ankkala|1")); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testClone229 
   * @throws CloneNotSupportedException when error
   */
  @Test
  public void testClone229() throws CloneNotSupportedException {    // Seura: 229
    Seura s1 = new Seura(); 
    s1.setSeurannimi("AnkkaGolf"); 
    Seura kopio = s1.clone(); 
    assertEquals("From: Seura line: 234", s1.toString(), kopio.toString()); 
    assertEquals("From: Seura line: 235", true, kopio.toString().equals(s1.toString())); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testParse262 */
  @Test
  public void testParse262() {    // Seura: 262
    Seura seura = new Seura(); 
    seura.parse("  3  | Fyrkkala Golf    |   Fyrkkalankatu 24  "); 
    assertEquals("From: Seura line: 265", 3, seura.getTunnusNro()); 
    assertEquals("From: Seura line: 266", true, seura.toString().startsWith("3|Fyrkkala Golf|Fyrkkalankatu 24")); 
    seura.rekisteroi(); 
    int n = seura.getTunnusNro(); 
    seura.parse("" + (n + 20));  // Otetaan merkkijonon alusta vain id numero ja lisätään siihen 20
    seura.rekisteroi();  // Tarkistetaan tämän jälkeen, että tulee isompi numero
    assertEquals("From: Seura line: 271", n + 20 + 1, seura.getTunnusNro()); 
  } // Generated by ComTest END
}