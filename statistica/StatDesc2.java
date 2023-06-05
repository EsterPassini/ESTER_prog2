/*
 * overview: questa classe che estende StatDesc, calcola la variianza solo dopo aver calcolato la media delle osservazioni
 */
public class StatDesc2 extends StatDesc{
    //campi
    private double m;
    private double v;
    private boolean ok_m;
    private boolean ok_v;

    /*
     * AF:
     * 
     * IR: m rappresenta la media dei valori se ok_m è true,
     *      v rappresenta la var dei valori se ok_v è true, 
     */

    public StatDesc2(double[] f) {
        super(f);
    }

    @Override
    public double media() {
        if (ok_m)
            return m;
        double s = 0;
        for (int i=0; i<n(); i++){
            s = s+ getXi(i);
        }
        this.ok_m =true;
        m = s/n();
        return s/n();
    }

    @Override
    public double var() {
        if (ok_v)
            return v;
        double med = 0.0f;
        if (ok_m)
            med = m;
        else med = media();
        double s = 0;
        for (int i=0; i<n(); i++){
            s = s+ ((getXi(i)-med)*(getXi(i)-med));
        }
        this.ok_v =true;
        v = s/(n()-1);
        return s/(n()-1);
    }
    
}
