/*
 * questa classe descrive un magazzino, 
 * cioè un elenco numerato non vuoto di scaffali (numerazione parte da 1)
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class MagazzinoC {

    /*
    * questa classe descrive degli scaffali, cioè una struttura in cui i pacchi sono inseriti
    * da sopra e prelevati da sotto
    */
    public class Scaffale{
        //campi
        private List<PaccoC> s;

         /*
         * AF: s rappresenta la struttura di uno scaffale su cui sono posizionati i pacchi, la size di s rappresenta il numero di pacchi in un dato momento
         * 
        * IR: s non deve essere null, può essere vuota, ma se contiene pacchi essi non possono essere nulli.
        */

   
        public Scaffale() {
             s = new LinkedList<PaccoC>();
        }

         //EFFECTS: questo metodo aggiunge un pacco allo scaffale, se il pacco è nullo solleva un eccezione 
        private void aggiungi(PaccoC p){
            Objects.requireNonNull(p, "impossibile aggiungere pacco nullo");

             s.add(0, p);
        }

        //EFFECTS: questo metodo toglie un pacco dallo scaffale e lo restituisce, se il pacco è nullo solleva un eccezione,
        //      se s è vuota restituisce null
        private PaccoC togli(){
            if (s.size()==0)
                return null;
            PaccoC p = s.remove(s.size()-1);
            return p;
        }

        //EFFECTS: restituisce il numero di pacchi attualmente su uno scaffale
        private int numeroPacchi() {
            return s.size();
        }

        //EFFECTS: restituisce il peso del primo pacco da estrarre, se lo scaffale è vuoto ritorna -1
        private int pesoPrimoPacco() {
            if (numeroPacchi()==0)
                return -1;
            return s.get(s.size()-1).getH();
        }

        @Override
        public String toString(){
            return s.toString();
        }
    } 


    //CAMPI
    private List<Scaffale> scaf;

    /*
     * AF: s rappresenta la lista di scaffali, il numero dello scaffale è rappresentato
     *      dal indice che quello scaffale occupa nella lista s
     * 
     * IR: s non deve essere vuota, nulla o contenere scaffali nulli
     */

    //questo costruttore riceve in input il numero di scaffali di cui è composto il magazzino
    //e crea un magazzino con quel numero di scaffali, se n è <o = a 0 solleva un eccezione
    public MagazzinoC(int n){
        if (n<=0)
            throw new IllegalArgumentException("n non può essere minore di 1");
        scaf = new ArrayList<Scaffale>();
        for (int i = 0; i<n; i++){
            scaf.add(new Scaffale());
        }
    }



    //MODIFIES: scaffale numero a, scaffale numero b
    //EFFECTS:questo metodo sposta n pacchi dallo scaffale a uno scaffale b 
    //          e restituisce il numero di viaggi che il robot ci mette
    //          solleva un eccezione se a e b sono nulli, se n < di 0, e se a non ci sono abbastanza pacchi
    //          non ne sposta neanche uno e restituisce -1
    public int spostaMag(int a, int b, RobotC r, int n){
        Objects. requireNonNull(a, "lo scaffale non può essere nullo");
        Objects. requireNonNull(b, "lo scaffale non può essere nullo");

        int viaggi = r.sposta(this, a, b, n);
        return viaggi;
    }

    //MODIFIES: scaffale numero a
    //EFFECTS:aggiunge il pacco p allo scaffale numero a, solleva eccezione se p è nullo o se a minore di uno o maggiore del numero di scaffali del magazzino
    public void aggiungiAScaffale(int a, PaccoC p){
        Objects.requireNonNull(p, "no nullo p");
        if (a<1 || a > numeroScaffali())
            throw new IllegalArgumentException("scaffale non accettabile");
        scaf.get(a-1).aggiungi(p);
    }

    //MODIFIES: scaffale numero a
    //EFFECTS:toglie il primo pacco e lo restituisce, 
    //solleva eccezione se a minore di uno o maggiore del numero di scaffali del magazzino
    //ritorna null se sacaffale numero a è vuoto
    public PaccoC togliAScaffale(int a){
        if (a<1 || a > numeroScaffali())
            throw new IllegalArgumentException("scaffale non accettabile");
        return scaf.get(a-1).togli();
    }

     //EFFECTS:restituisce il numero di scaffali del magazzino
    public int numeroScaffali() {
        return scaf.size();
    }

    //EFFECTS: RESTITUISCE IL numero di pacchi di uno scaffale numero a, 
    //solleva un eccezione se a< di 1 o se a maggiore del numero di scaffali
    public int numeroPacchiScaffale(int a) {
        if (a<1 || a > numeroScaffali())
            throw new IllegalArgumentException("scaffale non accettabile");
       return scaf.get(a-1).numeroPacchi();
    }

    //EFFECTS: restituisce l'altezza del primo pacco da rimuovere da un dato scaffale a, 
    //se scaffale a è vuoto restituisce 0
    //solleva un eccezione se a< di 1 o se a maggiore del numero di scaffali
    public int PesoPrimoPaccoScaffale(int a) {
        if (a<1 || a > numeroScaffali())
            throw new IllegalArgumentException("scaffale non accettabile");
       return scaf.get(a-1).pesoPrimoPacco();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i<numeroScaffali(); i++){
            sb.append(scaf.get(i)+  "\n");
        }
        return sb.toString();
    }
    
}
