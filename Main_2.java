import java.util.Scanner;
import java.util.Stack;


public class Main {
    static Stack<String> verem=new Stack<>();
    static int allapotKeres(String s) {

        for (int i = 0; i < verem.size(); i++) {
            if (s.equals(verem.get(i))) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int allapot=1;
        int vegallapot=4;
        Character[] term={'a','b','c','d'};
        String[] nonterm={"S","A"};
        String[] allapotmegfelel={"","aS","bAc","bAc","d"};// a táblázatban a 0 tól eltérő karakterek megfeleltetése
        int [][] table={
                {1,2,0,0,0},//állapot 1 S-nemterminális megfelelője
                {0,3,4,0,0}//állapot 2 A terminális megfelelője
        };
        Scanner obj=new Scanner(System.in);
        String in=obj.nextLine();
        verem.push("#");
        for (int i = 0; i <in.length() ; i++) {
            if(in.charAt(i)=='a'&& allapot==1)
            {
                verem.push("aS");
            }
            else if(in.charAt(i)=='b'&& allapot==1){
                verem.push("bAc");
                allapot=2;
            }
            else if(in.charAt(i)=='b'&& allapot==2){
                verem.push("bAc");
            }
            else if (in.charAt(i)=='d'&& allapot==2){
                allapot=3;
                verem.push("d");
            }
        }
        /*
        *Ha 1 es állapotba vagyok és a jön akkor a verembe aS-t teszek és maradok 1 es állapotba
        * Ha 1 es állapotba vagyok és b jön akkor a verembe bAc-t teszek és átmegyek 2 es állapotba
        * Ha 2 es állapotba vagyok és c van a verem végén akkor c-t pusholom a veremből!
        * Ha 2 es állapotba vagyok és b jön akkor maradok 2 es állapotba és a verembe bAc-t teszek az A helyére
        * Ha 2 es állapotba vagyok és d jön akkor az A helyére d-t teszek és átmegyek 3-as állapotba ami végállapot
        * Vizsgálatképp elég ha a verem tartalmát összehasonlítom a bemenő string d karakteréig.
        * Ha az adott állapotokban bármilyen eltérő karakter jön errort dobok.
        */


        /*
        * S->aS|bAc
        * A->bAc|d
        */

        System.out.println(verem);
    }
}
