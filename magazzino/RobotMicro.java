/*
 * questa classe che implementa l'interfaccia robot rappresenta un robot mini, che può spostare sono 1 pacco per viaggio
 */

import java.util.Objects;

public class RobotMicro implements Robot{


    //MODIFIES:  a, b
    //EFFECTS: questo metodo sposta n pacchi dallo scaffale a uno scaffale b 
    //          e restituisce il numero di viaggi che il robot ci mette
    //          solleva un eccezione se a e b sono nulli, se n < di 0, e se a non ci sono abbastanza pacchi
    //          non ne sposta neanche uno e restituisce -1
    @Override
    public int sposta(Scaffale a, Scaffale b, int n) throws IllegalArgumentException, NullPointerException {
        Objects. requireNonNull(a, "lo scaffale non può essere nullo");
        Objects. requireNonNull(b, "lo scaffale non può essere nullo");

        if (n<0)
            throw new IllegalArgumentException("i pacchi da spostare non possono essere minori di 0");

        if (a.numeroPacchi()<n)
            return -1;  
        for (int i = 0; i<n; i++){
            Pacco p = a.togli();
            b.aggiungi(p);
        }
        return n;
    }


    
}
