import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Elemento oss = new Elemento("ossigeno", "O", 8, 15.99f);
        Elemento car = new Elemento("carbonio", "C", 2, 15.99f);
        Elemento sam = new Elemento("samm", "S", 33, 15.99f);
        MolecolaS ossMolec = new MolecolaS("ossigeno", oss, 2);

        HashMap<Elemento, Integer> m = new HashMap<Elemento, Integer>();

        m.put(sam, 5);
        m.put(oss, 3);
        m.put(car, 1);
        MolecolaC m1 = new MolecolaC("nome m1", m);

        System.out.println("=^.^=");
        System.out.println(ossMolec.peso());
        System.out.println(ossMolec.getFormula());
        System.out.println(m1.getFormula());

    }
}
