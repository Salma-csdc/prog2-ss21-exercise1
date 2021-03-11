import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckPasswordTest{

    CheckPassword password;

    @BeforeAll
    static void init() {
        System.out.println("Testing Exercise1");
    }

    @BeforeEach
    void setUp() {
        password = new CheckPassword();
    }

    @AfterAll
    public static void finish() {
        System.out.println("Finished Testing Exercise1");
    }

    @Test
    void testlength_Scenario1() {

        boolean actual = password.checkLaenge("Salma");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void testlength_Scenario2() {
        boolean actual = password.checkLaenge("SalmaAb0uEle22");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void testlength_Scenario3() {
        boolean actual = password.checkLaenge("SalmaAb0uElezzSal3aSAlmaSalma");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    // test Groß- Kleinschreibung
    @Test
    void testgrossklein_Scenario1() {
        boolean actual = password.kleinGross("Salma");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void testgrossklein_Scenario2() {
        boolean actual = password.kleinGross("SALMA");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void testgrossklein_Scenario3() {
        boolean actual = password.kleinGross("salma");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    // test Zahlen
    @Test
    void testzahlen_Scenario1() {
        boolean actual = password.checkZahlen("Salma");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void testzahlen_Scenario2() {
        boolean actual = password.checkZahlen("5al30");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    // test Sonderzeichen
    @Test
    void testsonderzeichen_Scenario1() {
        boolean actual = password.sonderzeichen("Salma");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void testsonderzeichen_Scenario2() {
        boolean actual = password.sonderzeichen("$@lm@");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void testsonderzeichen_Scenario3() {
        boolean actual = password.sonderzeichen("Salma:");
        boolean expected = false;
        assertEquals(expected, actual);
    }

}



