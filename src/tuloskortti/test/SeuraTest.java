package tuloskortti.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import tuloskortti.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2022.08.29 16:19:57 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class SeuraTest {



  // Generated by ComTest BEGIN
  /** testRekisteroi96 */
  @Test
  public void testRekisteroi96() {    // Seura: 96
    Seura seura = new Seura(); 
    assertEquals("From: Seura line: 98", 0, seura.getTunnusNro()); 
    seura.rekisteroi(); 
    Seura seura2 = new Seura(); 
    seura2.rekisteroi(); 
    int n1 = seura.getTunnusNro(); 
    int n2 = seura2.getTunnusNro(); 
    assertEquals("From: Seura line: 104", n2-1, n1); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testToString197 */
  @Test
  public void testToString197() {    // Seura: 197
    Seura s = new Seura(); 
    s.parse("       3         |       Ankkala    |   1"); 
    assertEquals("From: Seura line: 200", true, s.toString().startsWith("3|Ankkala|1")); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testClone214 
   * @throws CloneNotSupportedException when error
   */
  @Test
  public void testClone214() throws CloneNotSupportedException {    // Seura: 214
    Seura s1 = new Seura(); 
    s1.setSeurannimi("AnkkaGolf"); 
    Seura kopio = s1.clone(); 
    assertEquals("From: Seura line: 219", s1.toString(), kopio.toString()); 
    assertEquals("From: Seura line: 220", true, kopio.toString().equals(s1.toString())); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testParse246 */
  @Test
  public void testParse246() {    // Seura: 246
    Seura seura = new Seura(); 
    seura.parse("  3  | Fyrkkala Golf    |   Fyrkkalankatu 24  "); 
    assertEquals("From: Seura line: 249", 3, seura.getTunnusNro()); 
    assertEquals("From: Seura line: 250", true, seura.toString().startsWith("3|Fyrkkala Golf|Fyrkkalankatu 24")); 
    seura.rekisteroi(); 
    int n = seura.getTunnusNro(); 
    seura.parse("" + (n + 20));  // Otetaan merkkijonon alusta vain id numero ja lisätään siihen 20
    seura.rekisteroi();  // Tarkistetaan tämän jälkeen, että tulee isompi numero
    assertEquals("From: Seura line: 255", n + 20 + 1, seura.getTunnusNro()); 
  } // Generated by ComTest END
}