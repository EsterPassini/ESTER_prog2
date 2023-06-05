
/*
questa classe rappresenta l'oggetto tavola periodica, cioè un elenco ordinato per numero atomico di elementi
*/

import java.util.LinkedList;
import java.util.Objects;

public class TavPeriodica {
    // campi
    LinkedList<Elemento> tavola;

    /*
     * AF: tavola rappresenta una tavola periodica contente gli elementi che
     * contiene tavola
     * 
     * IR: tavola non deve essere nulla e non deve contenere elementi nulli, inoltre
     * gli elementi dentro tavola
     * devono essere memorizzati per numero atomico crescente
     */

    public TavPeriodica(LinkedList<Elemento> tavola) {
        Objects.requireNonNull(tavola, "tavola non deve essere nulla ");

        if (tavola.contains(null))
            throw new IllegalArgumentException("tavola non deve contenere elementi nulli");

        for (int i = 1; i < tavola.size(); i++) {
            if (tavola.get(i).num_atomico() <= tavola.get(i + 1).num_atomico())
                throw new IllegalArgumentException(
                        "gli elementi in tavola devono essere in ordine crescente di num atomico");
        }

        this.tavola = tavola;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tavola.size(); i++) {
            sb.append("numero_atomico:" + tavola.get(i).num_atomico() + tavola.get(i).toString() + "/n");
        }

        return sb.toString();
    }
    
    /*
    EFFECTS: restituisce true solo se l'elemento appartiene alla tavola periodica,
            solleva un eccezione se e è nullo
    */
    public boolean contiene(Elemento e){
        Objects.requireNonNull(e, "e non deve essere nullo ");
        
        return tavola.contains(e);
    }
}
