/*
 * questa classe che implementa l'interfaccia robot rappresenta un robot “cauto”, 
 * caratterizzato da una altezza massima in grado di spostare più di un pacco se e solo se 
 * (oltre al primo pacco che è sempre in grado di spostare a prescindere dall'altezza), 
 * la somma delle altezze dei pacchi accumulati sulla sua superficie di carico non eccede mai l'altezza massima consentita
 */

 import java.util.Objects;

public class RobotCauto implements Robot{
    //CAMPI
    int altMax;

    /*
     * AF: altMax rappresenta l'altezza massima di un robot cauto
     * 
     * IR: altMax non può essere < o = a 0
     */

    public RobotCauto(int a) throws IllegalAccessException{
        if (a<=0)
            throw new IllegalAccessException("altMax deve essere maggiore di 0");
        this.altMax = a;
    }

    @Override
    public int sposta(Scaffale a, Scaffale b, int n) throws IllegalArgumentException, NullPointerException {
        Objects. requireNonNull(a, "lo scaffale non può essere nullo");
        Objects. requireNonNull(b, "lo scaffale non può essere nullo");

        if (n<0)
            throw new IllegalArgumentException("i pacchi da spostare non possono essere minori di 0");

        if (a.numeroPacchi()<n)
            return -1;
        
        throw new UnsupportedOperationException("Unimplemented method 'sposta'");
    }
    
}
