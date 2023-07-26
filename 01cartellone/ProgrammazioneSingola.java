import java.util.Iterator;
import java.util.Objects;

/*
questa classe implementa l'interfaccia Programmazione, rappresenta una programmazione con un singolo giorno */

public class ProgrammazioneSingola implements Programmazione{

    //CAMPI
    final int data;

    /*
    AF: data rappresenta l'unico giorno della programmazione
    
    IR: data deve essere >= di 1 e <= di 31
    */
    
    
    public ProgrammazioneSingola(int data) {
        if(data<1||data>31)
            throw new IllegalArgumentException("girno non accettabile");
        this.data = data;
    }


    @Override
    public boolean isInProgrammazione(int g) throws IllegalArgumentException {
        if(g<1||g>31)
            throw new IllegalArgumentException("girno non accettabile");
        return g ==data;
    }

    @Override
    public boolean isSovrapposta(Programmazione p) throws NullPointerException {
        Objects.requireNonNull(p, "programmazione non deve essere nulla");
        return (p.isInProgrammazione(data));
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
