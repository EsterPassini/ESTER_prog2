import java.util.Iterator;
/*questa classe implementa l'interfaccia Programmazione, rappresenta una programmazione con 
una data più le repliche (nei giorni seguenti alla data) */
import java.util.Objects;

public class ProgrammazioneConRepliche implements Programmazione{
    //CAMPI
    final int data;
    final int numRepliche;

    /*
    AF: data rappresenta il primo giorno di proiezione,
        numRepliche rappresenta il numero di giorni seguenti a data contenuti in questa programmazione  
    
    IR: data deve essere >= di 1 e < di 31, numRepliche >=1, numRepliche <31
        data + numRepliche deve essere minore o uguale a 31
    */

    public ProgrammazioneConRepliche(int data, int numRepliche) {
        if(data<1||data>=31)
            throw new IllegalArgumentException("girno non accettabile");
        if(numRepliche<1 || numRepliche>=31)
            throw new IllegalArgumentException("numero repliche non accettabile");
        if (data + numRepliche>31)
            throw new IllegalArgumentException("data e numero repliche non compatibili");
        this.data = data;
        this.numRepliche = numRepliche;
    }
    

    @Override
    public boolean isInProgrammazione(int g) throws IllegalArgumentException {
        if(g<1||g>31)
            throw new IllegalArgumentException("girno non accettabile");
        return(g >=data || g<= data+numRepliche);
    }

    
    @Override
    public boolean isSovrapposta(Programmazione p) throws NullPointerException {
        Objects.requireNonNull(p, "programmazione non deve essere nulla");
        for (int i= 0; i<=numRepliche; i++){
            if(p.isInProgrammazione(data+i)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
