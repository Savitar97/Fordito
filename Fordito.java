
public class Fordito {
    private final String[] abc;
    private final int[][] allapotatmenet;
    private final int vegallapot;
    private int state;
    private int kezdoallapot;

    Fordito(String[] abc, int[][] allapotatmenet, int kezdoallapot, int vegallapot) {
        this.abc = abc;
        this.allapotatmenet = allapotatmenet;
        this.kezdoallapot = kezdoallapot;
        this.vegallapot = vegallapot;
        System.out.println("elindult");
    }

    boolean isValid(String s) {
        state = kezdoallapot;
        int test;

        for (int i = 0; i < s.length(); i++) {

                String Type = "other";

                    if (Character.isDigit(s.charAt(i))) {
                        Type = "number";
                        System.out.println(Type);
                    } else if (Character.isAlphabetic(s.charAt(i))) {
                        Type = "letter";
                        System.out.println(Type);
                    } else if (s.charAt(i) == '{') {
                        Type = "{";
                        System.out.println(Type);
                    } else if (s.charAt(i) == '}') {
                        Type = "}";
                        System.out.println(Type);
                    } else if (s.charAt(i) == '(') {
                        Type = "(";
                        System.out.println(Type);
                    } else if (s.charAt(i) == '*') {
                        Type = "*";
                        System.out.println(Type);
                    } else if (s.charAt(i) == ')') {
                        Type = ")";
                        System.out.println(Type);
                    } else if (s.charAt(i) == ':') {
                        Type = ":";
                        System.out.println(Type);
                    } else if (s.charAt(i) == '=') {
                        Type = "=";
                        System.out.println(Type);
                    } else if (s.charAt(i) == '<') {
                        Type = "<";
                        System.out.println(Type);
                    } else if (s.charAt(i) == '>') {
                        Type = ">";
                        System.out.println(Type);
                    } else if (s.charAt(i) == ' ') {
                        Type = "space";
                        System.out.println(Type);
                    } else if (s.charAt(i) == '$') {
                        Type = "$";
                        System.out.println(Type);
                    }

                    test = findState(Type);
                    state = allapotatmenet[state][test];
                    System.out.println(state);
                    if (state == 0) {
                        return false;
                    }
                    if (state == 21) {
                        return true;
                    }
                }

        return elfogadoAllapot();

    }

    int findState(String s) {

        for (int i = 0; i < abc.length; i++) {
            if (s.equals(abc[i])) {
                return i;
            }
        }
        return 0;
    }

        boolean elfogadoAllapot ()
        {

            if (state == vegallapot) {
                return true;
            } else {
                return false;
            }

        }

}

