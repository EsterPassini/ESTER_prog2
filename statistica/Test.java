public class Test {
    public static void main(String[] args) {
        double[] f1 = {49.80401, 49.80400, 49.80309, 49.80399};

        StatDesc1 s1 = new StatDesc1(f1);
        StatDesc2 s2 = new StatDesc2(f1);
        StatDescInd si = new StatDescInd(f1);

        System.out.println("media s2: "+ s2.media()+ " var s2: "+ s2.var());
        System.out.println("media s1: "+ s1.media()+ " var s1: "+ s1.var());
        System.out.println("media si: "+ si.media()+ " var si: "+ si.var());
       
        
    }
}
