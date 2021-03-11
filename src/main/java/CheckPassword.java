// wird ueblicherweise mit regex gelöst

public class CheckPassword {

    static char[] SONDERZEICHEN = {'(', ')', '#', '$', '?', '!', '%', '/', '@'};


    public boolean checkPassword(String kennwort) {
        boolean isCorrectLength   = checkLaenge(kennwort);
        boolean isCorrectCase = kleinGross(kennwort);
        boolean isCorrectNumbers  = checkZahlen(kennwort);
        boolean isCorrectSpecialCharacter = checkSonderzeichen(kennwort);
        boolean isAvailable3Values= checkdreiZahlen(kennwort);
        boolean isAvailableSameValue= checkselbeZahl(kennwort);
        return isCorrectLength && isCorrectCase && isCorrectNumbers && isCorrectSpecialCharacter && isAvailable3Values && isAvailableSameValue;
    }

    public boolean checkLaenge(String kennwort) {
        return  (kennwort.length() > 7 && kennwort.length() < 26);
    }


    public boolean kleinGross(String kennwort) {
        boolean a = false;
        boolean gross = false;
        boolean klein = false;
        char currentvalue;
        for (int i = 0; i < kennwort.length(); i++) {
            currentvalue = kennwort.charAt(i);

            if (Character.isUpperCase(currentvalue)) {
                gross = true;
            } else if (Character.isLowerCase(currentvalue)) {
                klein = true;
            }
        }
        if (klein && gross) { a = true; }
        return a;       // kann mir letzten if sparen indem ich statt a gleich: "return klein && gross" einsetze
    }

    public static boolean checkZahlen(String kennwort) {
        boolean a = false;
        char currentvalue;
        for (int i = 0; i < kennwort.length(); i++) {
            currentvalue = kennwort.charAt(i);
            if (Character.isDigit(currentvalue)) {
                a = true;
            }
        }
        return a;
    }

    // Kennwort soll mind 1 Sonderzeichen enthalten
    public boolean checkSonderzeichen(String kennwort) {
        boolean a = false;
        char currentvalue;
        for (int i = 0; i < kennwort.length(); i++) {
            currentvalue = kennwort.charAt(i);
            for(int c = 0; c<9; c++) {
                if (currentvalue == SONDERZEICHEN[c]) {
                    a = true;
                }
            }
        }
        return a;
    }

//________________________________________----------------------------------------------------_________________________________________

    // Wenn mehr als zweiZahlen fortlaufend vorkommen --> false wird ausgegeben
    public static boolean checkdreiZahlen(String kennwort){
        boolean a = true;                                    // wenn wir die Grenze ueberschreiten, wird a auf false gesetzt
        char currentvalue;
        char firstvalue = 1;
        char nextvalue  = 1;
        char lastvalue  = 1;
        //char except = 'E';
        int current;
        if(checkZahlen(kennwort) == true){                       // schaue obs eine Zahl gibt
            int count = 0;                                  // um bei count > 2 abzubrechen
            /*
            boolean erstezahl = false;                      // man kann hier statt false auch true setzen denn irgendwann gibt es zumindest eine Zahl sonst waeren wir nicht mit der if Anweisung erfolgreich gewesen
            boolean zweitezahl = false;
            boolean drittetezahl = false;
            */
            for(int i = 0; i < kennwort.length(); i++){
                //currentvalue = kennwort.charAt(i);
                if(i < kennwort.length()-2){
                    firstvalue = kennwort.charAt(i);
                    nextvalue = kennwort.charAt(i+1);
                    lastvalue = kennwort.charAt(i+2);
                }
                else if(i == kennwort.length()-2){
                    nextvalue = kennwort.charAt(i);
                }
                else if(i == kennwort.length()-1){
                    lastvalue = kennwort.charAt(i);
                }

                current = firstvalue;
                if(Character.isDigit(firstvalue)) { count++;}
                if(Character.isDigit(nextvalue) && (nextvalue == current+1)) { count++;}
                if(Character.isDigit(lastvalue) && (lastvalue == current+2)) { count++;}
                if (count<3){ count = 0; }

                if(count > 2){ a = false; }
            }
        }
        return a;
}

    // wenn dieselbe Zahl >3x hintereinander vorhanden ist --> false wird ausgegeben
    public static boolean checkselbeZahl(String kennwort){
        boolean a = true;                                   // wenn wir die Grenze ueberschreiten, wird a auf false gesetzt
        char currentvalue;
        char firstvalue;
        char secondvalue;
        char thirdvalue;
        char lastvalue;
        int current;
        if(checkZahlen(kennwort) == true){
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
    public static void main(String[] args){
        //checkdreiZahlen("Sa12m3h456");
    }
}
