package tuloskortti.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Ajetaan kaikki testit
 * @author Janne Kähkönen
 * @version 23.7.2022
 */
@RunWith(Suite.class)
@SuiteClasses({ KayttajaTest.class, KayttajatTest.class, KierroksetTest.class,
        KierrosTest.class, SeuraTest.class, SeuratTest.class,
        TuloskortitTest.class, TuloskorttiTest.class })
public class AllTests {
    //
}
