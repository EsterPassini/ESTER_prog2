import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

        Cargo c1 = new Cargo("c1", 1);
        Cargo c2 = new Cargo("c2", 2);
        Cargo c3 = new Cargo("c3", 3);
        Cargo c4 = new Cargo("c4", 4);
        Cargo c5 = new Cargo("c5", 5);
        Cargo c6 = new Cargo("c6", 6);
        LinkedList<Cargo> l_a = new LinkedList<Cargo>(Arrays.asList(c1, c2));
        LinkedList<Cargo> l_b = new LinkedList<Cargo>(Arrays.asList(c3));
        LinkedList<Cargo> l_c = new LinkedList<Cargo>(Arrays.asList(c4, c5));
        LinkedList<Cargo> l_d = new LinkedList<Cargo>(Arrays.asList(c6));

        Molo a = new Molo(l_a);
        Molo b = new Molo(l_b);
        Molo c = new Molo(l_c);
        Molo d = new Molo(l_d);

        ArrayList<Molo> l_m = new ArrayList<Molo>(Arrays.asList(a, b, c, d));

        ScaloNavale scalo = new ScaloNavale(l_m);

        System.out.println("=^.^=");
        System.out.println("scalo: " + scalo);
        System.out.println("peso prima nave molo a: " + a.PesoPrimaNave());
        System.out.println("=^.^=");

        SuperRimorchiatore supR = new SuperRimorchiatore();
        MiniRimorchiatore minR = new MiniRimorchiatore();
        PrudenteRimorchiatore prudR = new PrudenteRimorchiatore(100);
        /*
         * System.out.println("supR"+ supR);
         * System.out.println("minR" + minR);
         * System.out.println("prudR");
         */

        minR.Sposta(a, b, 2);
        System.out.println("scalo: " + scalo);

    }
}
