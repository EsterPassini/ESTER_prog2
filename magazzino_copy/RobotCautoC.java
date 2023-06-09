/*
 * questa classe che implementa l'interfaccia robot rappresenta un robot “cauto”, 
 * caratterizzato da una altezza massima in grado di spostare più di un pacco se e solo se 
 * (oltre al primo pacco che è sempre in grado di spostare a prescindere dall'altezza), 
 * la somma delle altezze dei pacchi accumulati sulla sua superficie di carico non eccede mai l'altezza massima consentita
 */

 import java.util.Objects;

public class RobotCautoC implements RobotC{
    //CAMPI
    int altMax;

    /*
     * AF: altMax rappresenta l'altezza massima di un robot cauto
     * 
     * IR: altMax non può essere < o = a 0
     */

    public RobotCautoC(int a) throws IllegalAccessException{
        if (a<=0)
            throw new IllegalAccessException("altMax deve essere maggiore di 0");
        this.altMax = a;
    }

    public int sposta(MagazzinoC m, int a, int b, int n)throws IllegalArgumentException, NullPointerException{
        Objects. requireNonNull(m, "il magazino non può essere nullo");

        if (n<0)
            throw new IllegalArgumentException("i pacchi da spostare non possono essere minori di 0");

        if (m.numeroPacchiScaffale(a)<n)
            return -1; 
        
        throw new UnsupportedOperationException("Unimplemented method 'sposta'");
    }
    
}
