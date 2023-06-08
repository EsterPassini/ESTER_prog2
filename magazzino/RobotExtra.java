/*
 * questa classe che implementa l'interfaccia robot rappresenta un robot extra, che può spostare infiniti pacchi per viaggio
 */

import java.util.Objects;

public class RobotExtra implements Robot{

    @Override
    public int sposta(Scaffale a, Scaffale b, int n) throws IllegalArgumentException, NullPointerException {
        Objects. requireNonNull(a, "lo scaffale non può essere nullo");
        Objects. requireNonNull(b, "lo scaffale non può essere nullo");

        if (n<0)
            throw new IllegalArgumentException("i pacchi da spostare non possono essere minori di 0");

        if (a.numeroPacchi()<n)
            return -1;  

        Pacco[] nastroTrasp = new Pacco[n];
        for (int i = n - 1; i >= 0; i--) {
            Pacco p = a.togli();
            nastroTrasp[i] = p;
        }
        for (int i = 0; i < nastroTrasp.length; i++) {
            b.aggiungi(nastroTrasp[i]);
        }
        return 1;
    }
    
}
