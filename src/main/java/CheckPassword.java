// wird ueblicherweise mit regex gelöst

public class CheckPassword {

    static char[] SONDERZEICHEN = {'(', ')', '#', '$', '?', '!', '%', '/', '@'};


    public boolean checkPassword(String kennwort) {
        boolean isCorrectLength   = checkLaenge(kennwort);
        boolean isCorrectCase = kleinGross(kennwort);
        boolean isCorrectNumbers  = checkZahlen(kennwort);
        boolean isCorrectSpecialCharacter = sonderzeichen(kennwort);
        return isCorrectLength && isCorrectCase && isCorrectNumbers && isCorrectSpecialCharacter;
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
        if (klein && gross) {
            a = true;
        }
        return a;       // kann mir letzten if sparen indem ich statt a gleich: "return klein && gross" einsetze
    }

    // Kennwort soll Zahlen enthalten Zahlen
    public boolean checkZahlen(String kennwort) {
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
    public boolean sonderzeichen(String kennwort) {
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
}
