//un molo è una struttura da cui possono salpare e attraccare delle navi cargo,
//Ciascun molo si comporta come una sorta di fila (che può essere eventualmente vuota) di navi cargo 
//dalla fine della quale esse possono salpare e attraccare una alla volta. 
//Altrimenti detto, il primo di una sequenza di cargo che attraccano sarà l'ultimo a salpare

import java.util.LinkedList;
import java.util.Objects;

public class Molo {
    // CAMPI
    private LinkedList<Cargo> molo;

    /*
     * AF: molo rappresenta le navi attraccate ad un molo in un determinato momento
     * esempio: indici: 0 | 1 ...
     * navi: 1 che esce | 2 che esce ...
     * 
     * IR: molo deve essere non null e non può contenere navi null
     */

    public Molo() {
        molo = new LinkedList<Cargo>();
    }

    public Molo(LinkedList<Cargo> molo) {
        super();
        Objects.requireNonNull(molo, "molo non può essere nullo");
        if (molo.contains(null))
            throw new IllegalArgumentException("molo non può contenere navi nulle");
        this.molo = molo;
    }

    // EFFECTS: restituisce il numero di navi attraccate al molo
    public int NumeroNavi() {
        return molo.size();
    }

    // EFFECTS: restituisce il peso della prima nave attraccata (la prima che
    // salperà), se il molo è vuoto restituisce 0
    public int PesoPrimaNave() {
        if (NumeroNavi() == 0)
            return 0;
        return molo.element().peso();
    }

    /*
     * EFFECTS: rumuove la prima nave dal molo e la restituisce, se il molo è vuoto
     * restituisce null
     */
    public Cargo Rimuovi() {
        if (molo.size() == 0)
            return null;
        return molo.remove();
    }

    /*
     * EFFECTS: aggiunge c al molo, solleva un eccezione se c è null
     */
    public void Aggiungi(Cargo c) {
        Objects.requireNonNull(c, "c non deve essere null");
        molo.addFirst(c);
    }

    @Override
    public String toString() {
        return "Molo " + molo + " ";
    }

}
