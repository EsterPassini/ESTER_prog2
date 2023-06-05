public class StatDesc1  extends StatDesc{
    //campi:
    double m;
    double v; 
    private boolean ok_m;
    private boolean ok_v;

    public StatDesc1(double[] f) {
        super(f);
    }

    @Override
    public double media() {
        if (ok_m)
            return m;
        double sm = 0.0f;
        double sv1 = 0.0f;
        double sv = 0.0f;
        for (int i=0; i<n(); i++){
            sm = sm+ getXi(i);
            sv1 = sv1 + (getXi(i)*getXi(i));
        }
        sv = (n()*sv1) - (sm*sm);
        this.ok_v = true;
        v = sv/(n()*(n()-1));
        this.ok_m =true;
        m = sm/n();
        return sm/n();
    }

    @Override
    public double var() {
        if (ok_v)
            return v;
        double sm = 0.0f;
        double sv1 = 0.0f;
        double sv = 0.0f;
        for (int i=0; i<n(); i++){
            sm = sm+ getXi(i);
            sv1 = sv1 + (getXi(i)*getXi(i));
        }
        sv = (n()*sv1) - (sm*sm);
        this.ok_v = true;
        v = sv/(n()*(n()-1));
        this.ok_m =true;
        m = sm/n();
        return sv/(n()*(n()-1));
        
    }
    
}
