package tuloskortti.test;
// Generated by ComTest BEGIN
import java.util.*;
import kanta.UusiKierros;
import static org.junit.Assert.*;
import org.junit.*;
import tuloskortti.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2022.07.24 21:01:08 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class KierroksetTest {



  // Generated by ComTest BEGIN
  /** testAnnaKierrokset83 */
  @Test
  public void testAnnaKierrokset83() {    // Kierrokset: 83
    Kierrokset kierrokset = new Kierrokset(); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55)); 
    List<Kierros> loytyneet; 
    loytyneet = kierrokset.annaKierrokset(1, 1); 
    assertEquals("From: Kierrokset line: 91", 18, loytyneet.size()); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55)); 
    loytyneet = kierrokset.annaKierrokset(1, 1); 
    assertEquals("From: Kierrokset line: 94", 36, loytyneet.size()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testAnnaKaikkiKierrokset113 */
  @Test
  public void testAnnaKaikkiKierrokset113() {    // Kierrokset: 113
    Kierrokset kierrokset = new Kierrokset(); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 55)); 
    List<Kierros> loytyneet; 
    loytyneet = kierrokset.annaKaikkiKierrokset(); 
    assertEquals("From: Kierrokset line: 121", 1, loytyneet.size()); 
    kierrokset.lisaaKierros(UusiKierros.luoKierros(1, 51)); 
    loytyneet = kierrokset.annaKaikkiKierrokset(); 
    assertEquals("From: Kierrokset line: 124", 2, loytyneet.size()); 
  } // Generated by ComTest END
}