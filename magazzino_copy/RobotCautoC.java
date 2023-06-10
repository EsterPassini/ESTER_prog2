/*
 * questa classe che implementa l'interfaccia robot rappresenta un robot “cauto”, 
 * caratterizzato da una altezza massima in grado di spostare più di un pacco se e solo se 
 * (oltre al primo pacco che è sempre in grado di spostare a prescindere dall'altezza), 
 * la somma delle altezze dei pacchi accumulati sulla sua superficie di carico non eccede mai l'altezza massima consentita
 */

 import java.util.LinkedList;
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

        int viaggi = 0;
        LinkedList<PaccoC >nastroTrasp = new LinkedList<PaccoC>();
        boolean isPrimo = true;

        for (int i = n - 1; i >= 0; i--) { //ciclo con pacchi
            
            if (isPrimo || m.PesoPrimoPaccoScaffale(a)+ pesoTrasportato(nastroTrasp)<altMax){
                if(isPrimo){
                    viaggi +=1;
                    isPrimo = false;
                }
                
                PaccoC p = m.togliAScaffale(a);
                nastroTrasp.addFirst(p);

            } else {
                for (int t = 0; t < nastroTrasp.size(); t++) { //scarico nastro
                    m.aggiungiAScaffale(b, nastroTrasp.get(t));
                }
                
                nastroTrasp.clear();

                //visto che questo giro non ho caricato il nastro con il pacco che non ci stava incremento di uno i, recuperando il giro
                i = i+1; 
                isPrimo = true;
                //stesso effetto di queste righe sotto
                /*viaggi +=1;
                PaccoC p = m.togliAScaffale(a);
                nastroTrasp.addFirst(p);*/
            }

        }
        if (!nastroTrasp.isEmpty()){
            for (int t = 0; t < nastroTrasp.size(); t++) { //scarico nastro se vi sono rimasti pacchi
                m.aggiungiAScaffale(b, nastroTrasp.get(t));
            }
        }
        return viaggi;
    }



    //EFFECTS: metodo che utilizzo per non dover scrivere queste righe nella funzione sposta
    //mi restituisce il peso totale che è in un dato momento sul nastroTrasp
    private int pesoTrasportato(LinkedList<PaccoC> n){
        int p = 0;
        for (int i = 0; i< n.size(); i++){
            p = p + n.get(i).getH();
        }
        return p;
    }
    
}
