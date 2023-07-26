import java.util.Iterator;

/*
 * questa interfaccia descrive i comportamenti che deve avere una programmazione
 * è una sequenza (non vuota, ma eventualmente di un solo elemento e in ordine strettamente crescente) 
 * di interi compresi tra 1 e 31 
 * che rappresentano i giorni del mese in cui si svolge la proiezione
 */
public interface Programmazione extends Iterable<Integer> {

    //EFFECTS: restituisce true se l'intero passato, che rappresenta un giorno del mese 
    //          è contenuto nella programmazione, solleva un eccezione se g<di 1 o g > 31
    public boolean isInProgrammazione(int g) throws IllegalArgumentException;

    //EFFECTS: restituisce true se la programmazione passata in input è sovrapposta a this
    //         solleva un eccezione se p è null
    public boolean isSovrapposta(Programmazione p) throws NullPointerException;

    //EFFECTS: restituisce un iteratore sui giorni della programmazione
    public Iterator<Integer> iterator();

}
