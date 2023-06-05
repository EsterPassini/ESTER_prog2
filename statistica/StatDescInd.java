public class StatDescInd extends StatDesc {
    private double m;
    private double v; 
    private boolean ok_m;
    private boolean ok_v;

    public StatDescInd(double[] f) {
        super(f);
    }

    @Override
    public double media() {
        if(ok_m)
            return m;
        double me = 0.0;
       for (int i=1; i<n();i++){
            me = me+ (getXi(i)-me)/i;
       }
       ok_m = true;
       this.m = me;
       return me;
    }

    @Override
    public double var() {
        if(ok_v)
            return v;
        double va = 0.0;
        double me = 0.0;
        double p_me = 0.0;
       for (int i=1; i<n();i++){
            p_me = me+ (getXi(i)-m)/i;
            va = va+ (getXi(i)-me)*(getXi(i)-p_me);
            me = me+ (getXi(i)-m)/i;
       }
       ok_v = true;
       this.v = va;
       return va;
    }
    
}
