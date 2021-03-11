import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class checkPasswordTest {

    @BeforeAll
    static void init() {System.out.println("Testing Exercise1");}

    @BeforeEach
    void setUp() {}

    // muss nicht sein!
    @AfterAll
    public static void finish(){ System.out.println("Finished Testing Exercise1"); }


    // testlaenge
    @Test
    void testlength_Scenario1(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.laenge("Salma");
        boolean expected = false;
        assertEquals(expected, actual);}
    @Test
    void testlength_Scenario2(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.laenge("SalmaAb0uEle22");
        boolean expected = true;
        assertEquals(expected, actual);}
    @Test
    void testlength_Scenario3(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.laenge("SalmaAb0uElezzSal3aSAlmaSalma");
        boolean expected = false;
        assertEquals(expected, actual);}

    // test Groß- Kleinschreibung
    @Test
    void testgrossklein_Scenario1(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.kleinGross("Salma");
        boolean expected = true;
        assertEquals(expected, actual);}
    @Test
    void testgrossklein_Scenario2(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.kleinGross("SALMA");
        boolean expected = false;
        assertEquals(expected, actual);}
    @Test
    void testgrossklein_Scenario3(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.kleinGross("salma");
        boolean expected = false;
        assertEquals(expected, actual);}

    // test Zahlen
    @Test
    void testzahlen_Scenario1(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.zahlen("Salma");
        boolean expected = false;
        assertEquals(expected, actual);}
    @Test
    void testzahlen_Scenario2(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.zahlen("5al30");
        boolean expected = true;
        assertEquals(expected, actual);}

    // test Sonderzeichen
    @Test
    void testsonderzeichen_Scenario1(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.sonderzeichen("Salma");
        boolean expected = false;
        assertEquals(expected, actual);}
    @Test
    void testsonderzeichen_Scenario2(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.sonderzeichen("$@lm@");
        boolean expected = true;
        assertEquals(expected, actual);}
    @Test
    void testsonderzeichen_Scenario3(){
        checkPasswordClass password = new checkPasswordClass();
        boolean actual = password.sonderzeichen("Salma:");
        boolean expected = false;
        assertEquals(expected, actual);}



}



