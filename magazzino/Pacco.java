/*
 * questo record rappresenta un pacco
 */

import java.util.Objects;

public class Pacco {
    String prodotto;
    int h;
    /*
     * AF: prodotto indica di che tipo è il pacco, h ne indica l'altezza
     * 
     * IR: prodotto non deve essere una stringa nulla o blank,
     *     h non deve essere < di 1
     */

    //EFFECTS: costruisce un pacco a partire da prodotto e altezza, solleva un eccezione se prodotto o h
    //          non rispettano l'IR
    public Pacco(String prodotto, int h){
        Objects.requireNonNull(prodotto, "non può essereci un prodotto nullo");
        if (h<1 || prodotto.isBlank())
            throw new IllegalArgumentException("input non accettabili per costruire un pacco");
        this.prodotto = prodotto;
        this.h = h;
    }

    @Override
    public String toString(){
        return prodotto + " di altezza: "+ String.valueOf (h);
    }
 }