import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckPasswordTest {

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
        boolean actual = password.checkSonderzeichen("Salma");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void testsonderzeichen_Scenario2() {
        boolean actual = password.checkSonderzeichen("$@lm@");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void testsonderzeichen_Scenario3() {
        boolean actual = password.checkSonderzeichen("Salma:");
        boolean expected = false;
        assertEquals(expected, actual);
    }
/*
    // test dreizahlen in Folge hintereinander --> false ausgeben
    @Test
    void testdigits_Scenario1(){
        boolean actual = password.checkdreiZahlen("Salma1234");// Alarm schlagen
        boolean expected = false;
        assertEquals(expected, actual);}
    @Test
    void testdigits_Scenario2(){
        boolean actual = password.checkdreiZahlen("Sa1lm2a12");
        boolean expected = true;
        assertEquals(expected, actual);}
    @Test
    void testdigits_Scenario3(){
        boolean actual = password.checkdreiZahlen("Sa1lm2a458");
        boolean expected = true;
        assertEquals(expected, actual);}
    @Test
    void testdigits_Scenario4(){
        boolean actual = password.checkdreiZahlen("Sa1lm2a456");// Alarm schlagen
        boolean expected = false;
        assertEquals(expected, actual);}

    // test dieselbe Zahl >3x hintereinander --> false ausgeben
    @Test
    void testsamedigit_Scenario1(){
        boolean actual = password.checkselbeZahl("Sa1lm2a1111");// Alarm schlagen
        boolean expected = false;
        assertEquals(expected, actual);}
    @Test
    void testsamedigit_Scenario2(){
        boolean actual = password.checkselbeZahl("1Salma21101111");// Alarm schlagen
        boolean expected = false;
        assertEquals(expected, actual);}
    @Test
    void testsamedigit_Scenario3(){
        boolean actual = password.checkselbeZahl("1Salma2110");
        boolean expected = true;
        assertEquals(expected, actual);}

 */
}



