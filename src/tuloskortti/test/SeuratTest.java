package tuloskortti.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import tuloskortti.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2022.07.12 18:57:13 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class SeuratTest {



  // Generated by ComTest BEGIN
  /** 
   * testLisaa43 
   * @throws SailoException when error
   */
  @Test
  public void testLisaa43() throws SailoException {    // Seurat: 43
    Seurat seurat = new Seurat(); 
    Seura seura1 = new Seura(); 
    Seura seura2 = new Seura(); 
    Seura seura3 = new Seura(); 
    assertEquals("From: Seurat line: 49", 0, seurat.getLkm()); 
    seurat.lisaa(seura1); assertEquals("From: Seurat line: 50", 1, seurat.getLkm()); 
    seurat.lisaa(seura2); assertEquals("From: Seurat line: 51", 2, seurat.getLkm()); 
    assertEquals("From: Seurat line: 52", seura1, seurat.annaSeura(0)); 
    assertEquals("From: Seurat line: 53", seura2, seurat.annaSeura(1)); 
    assertEquals("From: Seurat line: 54", false, seurat.annaSeura(0) == seura2); 
    assertEquals("From: Seurat line: 55", true, seurat.annaSeura(0) == seura1); 
    try {
    assertEquals("From: Seurat line: 56", seura1, seurat.annaSeura(5)); 
    fail("Seurat: 56 Did not throw IndexOutOfBoundsException");
    } catch(IndexOutOfBoundsException _e_){ _e_.getMessage(); }
    seurat.lisaa(seura3); 
    seurat.lisaa(seura3); 
    seurat.lisaa(seura3); 
    try {
    seurat.lisaa(seura3); 
    fail("Seurat: 60 Did not throw SailoException");
    } catch(SailoException _e_){ _e_.getMessage(); }
  } // Generated by ComTest END
}