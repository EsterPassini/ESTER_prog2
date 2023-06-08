/*
 * questa classe descrive un magazzino, 
 * cioè un elenco numerato non vuoto di scaffali (numerazione parte da 1)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Magazzino {

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
    public Magazzino(int n){
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
    public int spostaMag(int a, int b, Robot r, int n){
        Objects. requireNonNull(a, "lo scaffale non può essere nullo");
        Objects. requireNonNull(b, "lo scaffale non può essere nullo");

        int viaggi = r.sposta(scaf.get(a-1), scaf.get(b-1), n);
        return viaggi;
    }

    //MODIFIES: scaffale numero a
    //EFFECTS:aggiunge il pacco p allo scaffale numero a, solleva eccezione se p è nullo o se a minore di uno o maggiore del numero di scaffali del magazzino
    public void aggiungiAScaffale(int a, Pacco p){
        Objects.requireNonNull(p, "no nullo p");
        if (a<1 || a > numeroScaffali())
            throw new IllegalArgumentException("scaffale non accettabile");
        scaf.get(a-1).aggiungi(p);
    }

     //EFFECTS:restituisce il numero di scaffali
    private int numeroScaffali() {
        return scaf.size();
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
