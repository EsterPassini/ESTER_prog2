import java.util.Iterator;
import java.util.Objects;
/*questa classe implementa l'interfaccia Programmazione, rappresenta una programmazione ad intervalli degolari di giorni 
a partire da uno specifico  */
public class ProgrammazioneAdIntervalli implements Programmazione{
    //CAMPI
    final int data;
    final int interv;

    /*
    AF: data rappresenta il primo giono di proiezione contenuto nella programmazione
        interv: rappresenta la lunghezza dell'intervallo in giorni dopo cui il giorno è 
        ricontenuto nella programmazione, fino ad arrivare a non più di 31
        es: data=3, interv=2 la programmazione conserrà (3, 5, 7...n) n<=31
    
    IR:data deve essere >= di 1 e < di 31
        interv>=2; interv<31
    */

    public ProgrammazioneAdIntervalli(int data, int interv){
        if(data<1||data>=31)
            throw new IllegalArgumentException("girno non accettabile");
        if (interv<2||interv>=31)
        throw new IllegalArgumentException("intervallo non accettabile"); 
        this.data = data;
        this.interv = interv;
    }
    
    @Override
    public boolean isInProgrammazione(int g) throws IllegalArgumentException {
        if(g<1||g>31)
            throw new IllegalArgumentException("girno non accettabile");
       for(int giorno=data; giorno<=g; giorno = giorno+interv){
            if(g ==giorno){
                return true;
            }
       }
       return false;
    }

    @Override
    public boolean isSovrapposta(Programmazione p) throws NullPointerException {
        Objects.requireNonNull(p, "programmazione non deve essere nulla");
        for (int giorno=data; giorno<=31; giorno = giorno+interv){
            if(p.isInProgrammazione(giorno)){
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
