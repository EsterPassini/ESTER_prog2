public class TestC {
    public static void main(String[] args) throws IllegalAccessException {
        MagazzinoC m = new MagazzinoC(3);

        RobotMicroC rMicro = new RobotMicroC();
        RobotExtraC rEx = new RobotExtraC();
        RobotCautoC rC = new RobotCautoC(6);


        PaccoC pa = new PaccoC("banane", 3);
        PaccoC pb = new PaccoC("gattini", 2);
        PaccoC pc = new PaccoC("profumo", 7);

        m.aggiungiAScaffale(1, pa);
        m.aggiungiAScaffale(1, pb);
        m.aggiungiAScaffale(1, pc);
        System.out.println(m);
        System.out.println(m.spostaMag(1, 3, rC, 3));
        System.out.println(m);
        /*System.out.println("torniamo come prima: "+m.spostaMag(3, 1, rMicro, 3));
        System.out.println(m);
        System.out.println(m.spostaMag(1, 3, rEx, 3));
        System.out.println(m);*/
    }
}
