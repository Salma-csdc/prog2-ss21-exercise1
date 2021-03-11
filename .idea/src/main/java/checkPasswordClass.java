import java.util.Scanner;
// wird ueblicherweise mit regex gelöst

public class checkPasswordClass{
    Scanner scan = new Scanner(System.in);
    String kennwort = scan.next();

    public boolean checkPassword(String kennwort){
        boolean zeroorone = false;
        boolean length = laenge(kennwort);
        boolean casesens = kleinGross(kennwort);
        boolean numbers = zahlen(kennwort);
        boolean specialcharacter = sonderzeichen(kennwort);
        //boolean threedigits = dreizahlen(kennwort);
        //boolean threetimessamedigit = selbezahl(kennwort);
/*
            if(length= casesens = numbers = specialcharacter = true){
                zeroorone = true;
            }else {
                zeroorone = false;
            }

 */
        return zeroorone;
    }

    // laenge des Kennwortes ueberpruefen
    public static boolean laenge(String kennwort){
        boolean a = false;
        if(kennwort.length()>7 && kennwort.length()<26){ a = true; }
        //System.out.println("a = "+ kennwort.length());        Test1
        return a;
    }

    // Kennwort auf Klein- & Grossbuchstaben ueberpruefen
    // kann man auch mit regex pattern lösen!!!
    public static boolean kleinGross(String kennwort){
        boolean a = false;
        boolean gross = false;
        boolean klein = false;
        char currentvalue;
        for(int i = 0; i < kennwort.length(); i++){
            currentvalue = kennwort.charAt(i);

            if(Character.isUpperCase(currentvalue)){ gross = true; }
            else if(Character.isLowerCase(currentvalue)){ klein = true; }

        }
        if(klein && gross){ a = true; }
        return a;       // kann mir letzten if sparen indem ich statt a gleich: "return klein && gross" einsetze
    }

    // Kennwort soll Zahlen enthalten Zahlen
    public static boolean zahlen(String kennwort) {
        boolean a = false;
        char currentvalue;
        for (int i = 0; i < kennwort.length(); i++) {
            currentvalue = kennwort.charAt(i);
            if (Character.isDigit(currentvalue)) { a = true; }
        }
        return a;
    }

    // Kennwort soll mind 1 Sonderzeichen enthalten
    public static boolean sonderzeichen(String kennwort) {
        boolean a = false;
        char currentvalue;
        char sonderzeichn[] = {'(',')','#','$','?','!','%','/','@'};
        for (int i = 0; i < kennwort.length(); i++) {
            currentvalue = kennwort.charAt(i);
            for(int c = 0; c< 9; i++){
                if (currentvalue == sonderzeichn[c]){ a = true; }
            }
        }
        return a;
    }

/*
    // Wenn mehr als zweiZahlen fortlaufend vorkommen --> false wird ausgegeben
    public static boolean dreizahlen(String kennwort){
        boolean a = true;                                    // wenn wir die Grenze ueberschreiten, wird a auf false gesetzt
        char currentvalue;
        char firstvalue;
        char nextvalue;
        char lastvalue;
        char except = 'E';
        int current;
        if(zahlen(kennwort) == true){                       // schaue obs eine Zahl gibt
            int count = 0;                                  // um bei count > 2 abzubrechen

            //boolean erstezahl = false;                      // man kann hier statt false auch true setzen denn irgendwann gibt es zumindest eine Zahl sonst waeren wir nicht mit der if Anweisung erfolgreich gewesen
            //boolean zweitezahl = false;
            //boolean nichterwuenschtezahl = false;


            for(int i = 0; i < kennwort.length(); i++){
                currentvalue = kennwort.charAt(i);
                firstvalue = kennwort.charAt(i);
                nextvalue = kennwort.charAt(i+1);
                lastvalue = kennwort.charAt(i+2);
                if(Character.isDigit(currentvalue) && Character.isDigit(currentvalue+1) && Character.isDigit(currentvalue+2)){
                    firstvalue = kennwort.charAt(currentvalue);
                    nextvalue = kennwort.charAt(currentvalue+1);
                    lastvalue = kennwort.charAt(currentvalue+2);

                    //for(int k = currentvalue; k < currentvalue+ 2; k++){
                    //   firstvalue = kennwort.charAt(currentvalue);
                     //   nextvalue = kennwort.charAt(currentvalue+1);
                     //   lastvalue = kennwort.charAt(currentvalue+2);
                   // }
            }



               // kennwort[kennwort.length()+1] = except;
               // kennwort[kennwort.length()+2] = except;

               // firstvalue = kennwort.charAt(i);
               // nextvalue = kennwort.charAt(i+1);
              //  lastvalue = kennwort.charAt(i+2);


                current = firstvalue;
                //System.out.println("current: "+ current);
                if(Character.isDigit(firstvalue)) { count++;}
                if(Character.isDigit(nextvalue) && (nextvalue == current+1)) { count++;}
                if(Character.isDigit(lastvalue) && (lastvalue == current+2)) { count++;}
            }
            if(count > 2){ a = false; }
        }
        return a;
    }

    // wenn dieselbe Zahl >3x hintereinander vorhanden ist --> false wird ausgegeben
    public static boolean selbezahl(String kennwort){
        boolean a = true;                                   // wenn wir die Grenze ueberschreiten, wird a auf false gesetzt
        char currentvalue;
        char firstvalue;
        char secondvalue;
        char thirdvalue;
        char lastvalue;
        int current;
        if(zahlen(kennwort) == true){
            int count = 0;
            for(int i = 0; i < kennwort.length()+2; i++){       //!!!PFUSCH!!!
                firstvalue = kennwort.charAt(i);
                secondvalue = kennwort.charAt(i+1);
                thirdvalue = kennwort.charAt(i+2);
                lastvalue = kennwort.charAt(i+3);

                current = firstvalue;
                //System.out.println("current: "+ current);
                if(Character.isDigit(firstvalue)) { count++; }
                if(Character.isDigit(secondvalue) && (secondvalue == current)) { count++; }
                if(Character.isDigit(thirdvalue) && (thirdvalue == current)) { count++; }
                if(Character.isDigit(lastvalue) && (lastvalue == current)) { count++; }
            }
            if(count > 3){ a = false; }
        }


        return a;
    }
*/

    public static void main(String[] args){
        //laenge("abcdefg");                                    //Test1
        /*System.out.println("Test 3: ... sollte sein ttt");
        dreizahlen("Sa123lma");
        System.out.println("Test 1: ... sollte sein ttf");
        dreizahlen("Salma12m");
        System.out.println("Test 2: ... sollte sein ttf");
        dreizahlen("Salma128");
        System.out.println("Test 3: ... sollte sein ttt");
        dreizahlen("Salm123a");*/
/*      checkPasswordClass exercise1 = new checkPasswordClass();
        System.out.println("Task 1: Das Kennwort muss zwischen 8 und 25 Zeichen lang sein");
        exercise1.laenge();
*/
    }
}
