import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Fordito {

    static HashMap<String,String> Lexical =new HashMap<String, String>();

    static void lexicalSearch(String a){
        char[] Operators={'%','+','-','>','<'};
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < Operators.length; j++) {
                if (a.charAt(i) == Operators[j]) {
                    String temp = String.valueOf(a.charAt(i));
                    Lexical.put(temp, "Operátor");
                }
                if (a.charAt(i) == '=' && a.charAt(i - 1) == ':') {
                    Lexical.put(":=", "Token");
                }
                if (a.charAt(i) == '>' && a.charAt(i - 1) == '<') {
                    Lexical.put("<>", "Operátor");
                }
                if (a.charAt(i)=='/'&&(a.charAt(i-1)!='/'&&a.charAt(i+1)!='/')) {
                    Lexical.put("/", "Operátor");
                }
                if(a.charAt(i)=='*'&&(a.charAt(i-1)!='('&&a.charAt(i+1)!=')')){
                        Lexical.put("*", "Operátor");
                }



            }
            }

        }



    public static void main(String[] args) {

        System.out.println("Add meg a kifejezést:");
        String kif = System.console().readLine();
        lexicalSearch(kif);
        String pattern1 = "^[^\\w](\\d)+((.)(\\d)+)?";
        String pattern2="[a-zA-Z]+[1-9]*";
        String pattern3="(\\/\\/)(\\w)*(\\d)*";
        String pattern4= "(\\(\\*)[\\d\\w\\W\\D\\s\\S]*(\\*\\))";
        Pattern r = Pattern.compile(pattern1);
        Matcher m = r.matcher(kif);
        if(m.find()){

            Lexical.put(m.group(),"Szám");
        }
        r = Pattern.compile(pattern2);
        m = r.matcher(kif);
        while(m.find()){
            Lexical.put(m.group(),"Változó");

        }
        r = Pattern.compile(pattern3);
        m = r.matcher(kif);
        while(m.find()){
            Lexical.put(m.group(),"Egysoros komment");
        }
        r = Pattern.compile(pattern4);
        m = r.matcher(kif);
        while(m.find()){
            Lexical.put(m.group(),"Többsoros komment");
        }
        for (String i:Lexical.keySet()) {
            System.out.println(i+' '+Lexical.get(i));
        }

    }
}
