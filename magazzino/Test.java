public class Test {
    public static void main(String[] args) {
        Magazzino m = new Magazzino(3);

        RobotMicro robMicro = new RobotMicro();
        RobotExtra robEx = new RobotExtra();


        Pacco pa = new Pacco("banane", 3);
        Pacco pb = new Pacco("gattini", 2);
        Pacco pc = new Pacco("profumo", 7);

        m.aggiungiAScaffale(1, pa);
        m.aggiungiAScaffale(1, pb);
        m.aggiungiAScaffale(1, pc);
        System.out.println(m);
        System.out.println(m.spostaMag(1, 3, robMicro, 3));
        System.out.println(m);
        System.out.println("torniamo come prima: "+m.spostaMag(3, 1, robMicro, 3));
        System.out.println(m);
        System.out.println(m.spostaMag(1, 3, robEx, 3));
        System.out.println(m);
    }
}
