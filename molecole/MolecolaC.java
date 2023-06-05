/*
questa classe estende la classe astratta Molecola e rappresenta una molecola complessa, 
cioè composta da atomi di più di un elemento chimico
*/

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class MolecolaC extends Molecola {

    // campi
    Map<Elemento, Integer> molecolaC;

    /*
     * AF: molecolaC rappresenta una molecola complessa, formata dagli elementi
     * rappresentati nelle chiavi in numero uguale al intero mappato
     * 
     * IR:molecolaC non deve essere null, non deve contenere elementi nulli e i
     * valori della mappa devono essere >= a 1
     * 
     */

    public MolecolaC(String nome, Map<Elemento, Integer> m) {
        super(nome);
        Objects.requireNonNull(m, "molecola non deve essere nulla");

        if (m.containsKey(null))
            throw new IllegalArgumentException("una molecola non può contenere elementi nulli");

        for (Map.Entry<Elemento, Integer> entry : m.entrySet()) {
            if (entry.getValue() < 1)
                throw new IllegalArgumentException("non possono esserci numerosità delle molecole < di 1");
        }
        this.molecolaC = m;
    }

    /*
     * C, H, N e O seguiti dagli altri elementi in ordine alfabetico del simbolo e,
     * se la numerosità di un elemento è pari a 1, tale numero viene omesso
     */
    @Override
    public String getFormula() {
        StringBuilder sb = new StringBuilder("");

        LinkedList<Elemento> l = new LinkedList<Elemento>();
        for (int i = 0; i < 10; i++) {
            l.add(null);
        }
        for (Map.Entry<Elemento, Integer> entry : molecolaC.entrySet()) {
            if (entry.getKey().simbolo() == "C") {
                l.add(0, entry.getKey());
                continue;
            }
            if (entry.getKey().simbolo() == "H") {
                l.add(1, entry.getKey());
                continue;
            }
            if (entry.getKey().simbolo() == "N") {
                l.add(2, entry.getKey());
                continue;
            }
            if (entry.getKey().simbolo() == "O") {
                l.add(3, entry.getKey());
                continue;
            }
            l.add(5, entry.getKey());

        }

        for (Elemento e : l) {
            if (e != null)
                sb.append(e.toString() + String.format("%d", molecolaC.get(e)));
        }
        return sb.toString();
    }

    @Override
    public float peso() {
        float p = 0.0f;
        for (Map.Entry<Elemento, Integer> entry : molecolaC.entrySet()) {
            p = p + (entry.getKey().peso() * entry.getValue());
        }
        return p;
    }
}
