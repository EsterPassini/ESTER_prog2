/*
 * questa classe rappresenta uno scalo navale, cioè un elenco numerato (non vuoto e finito) di moli
 */

import java.util.ArrayList;
import java.util.Objects;

public class ScaloNavale {
    // campi
    ArrayList<Molo> scalo;

    /*
     * AF: scalo rappresenta i moli facente parti dello scalo, numerati secondo le
     * posizioni nell'array, partendo da 1
     * 
     * IR: scalo != null, scalo non deve contenere moli null, e deve contenere per
     * forza almeno un molo
     */

    public ScaloNavale(ArrayList<Molo> scalo) {
        Objects.requireNonNull(scalo, "<lo scalo non deve essere null>");
        if (scalo.contains(null))
            throw new IllegalArgumentException("scalo non deve contenere moli null");
        if (scalo.size() < 1)
            throw new IllegalArgumentException("scalo deve contenere almeno 1 molo");
        this.scalo = scalo;
    }

    /*
     * EFFECTS: restituisce true solo se m appartiene allo scalo, solleva un
     * eccezione se m è nullo
     */
    public boolean ContainsMolo(Molo m) {
        Objects.requireNonNull(scalo, "molo nullo non accettato");
        return scalo.contains(m);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < scalo.size(); i++) {
            sb.append(i + 1 + " " + scalo.get(i));
        }
        return sb.toString();
    }

}
