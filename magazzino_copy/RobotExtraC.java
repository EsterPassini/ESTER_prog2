/*
 * questa classe che implementa l'interfaccia robot rappresenta un robot extra, che può spostare infiniti pacchi per viaggio
 */

import java.util.Objects;

public class RobotExtraC implements RobotC{

    @Override
    public int sposta(MagazzinoC m, int a, int b, int n)throws IllegalArgumentException, NullPointerException{
        Objects. requireNonNull(m, "il magazino non può essere nullo");

        if (n<0)
            throw new IllegalArgumentException("i pacchi da spostare non possono essere minori di 0");

        if (m.numeroPacchiScaffale(a)<n)
            return -1;  

        PaccoC[] nastroTrasp = new PaccoC[n];
        for (int i = n - 1; i >= 0; i--) {
            PaccoC p = m.togliAScaffale(a);
            nastroTrasp[i] = p;
        }
        for (int i = 0; i < nastroTrasp.length; i++) {
            m.aggiungiAScaffale(b, nastroTrasp[i]);
        }
        return 1;
    }
    
}
