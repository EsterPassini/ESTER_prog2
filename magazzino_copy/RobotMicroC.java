/*
 * questa classe che implementa l'interfaccia robot rappresenta un robot mini, che può spostare sono 1 pacco per viaggio
 */

import java.util.Objects;

public class RobotMicroC implements RobotC{


    //MODIFIES:  a, b
    //EFFECTS: questo metodo sposta n pacchi dallo scaffale a uno scaffale b 
    //          e restituisce il numero di viaggi che il robot ci mette
    //          solleva un eccezione se a e b sono nulli, se n < di 0, e se a non ci sono abbastanza pacchi
    //          non ne sposta neanche uno e restituisce -1
    @Override
    public int sposta(MagazzinoC m, int a, int b, int n)throws IllegalArgumentException, NullPointerException{
        Objects. requireNonNull(m, "il magazino non può essere nullo");

        if (n<0)
            throw new IllegalArgumentException("i pacchi da spostare non possono essere minori di 0");

        if (m.numeroPacchiScaffale(a)<n)
            return -1;  
        for (int i = 0; i<n; i++){
            PaccoC p = m.togliAScaffale(a);
            m.aggiungiAScaffale(b, p);
        }
        return n;
    }


    
}
