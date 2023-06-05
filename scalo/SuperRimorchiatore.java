/*
 * questa classe estende rimorchiatore (classe astratta)
 * e implementa un "super" rimorchiatore in grado di spostare un numero potenzialmente illimitato di navi cargo alla volta
 */

import java.util.ArrayList;
import java.util.Objects;

public class SuperRimorchiatore implements RimorchiatoreI {
    // CAMPI
    ArrayList<Cargo> navi;

    /*
     * AF: navi rappresenta le navi portate in un singolo momento da un
     * superrimorchiatore
     * 
     * IR: navi deve essere != da null, può contenere null ma solo se seguiti da
     * altri null e non da dei Cargo
     */

    public SuperRimorchiatore(/* String scaloNavale, */) {
        // super(scaloNavale);
        navi = new ArrayList<Cargo>();
    }

    @Override
    public int PesoNaviTrasportate() {
        int p = 0;
        for (int i = 0; navi.get(i) != null; i++) {
            p = p + navi.get(i).peso();
        }
        return p;
    }

    // MODIFIES: a, b
    // EFFECTS: questo metodo sposta n navi insieme dal molo a al molo b, solleva un
    // eccezione se a o b sono nulli, restituisce true se
    // lo stostamento è avvenuto bene, false se a non ha attraccata n navi, in
    // questo caso non ne sposta neanche una
    public boolean Sposta(Molo a, Molo b, int n) {
        Objects.requireNonNull(a, "molo di partenza non deve essere null");
        Objects.requireNonNull(b, "molo di arrivo non deve essere null");
        if (a.NumeroNavi() < n)
            return false;

        Cargo[] prov = new Cargo[n];

        for (int i = n - 1; i >= 0; i--) {
            Cargo c = a.Rimuovi();
            prov[i] = c;
        }
        for (int i = 0; i < prov.length; i++) {
            b.Aggiungi(prov[i]);
        }
        return true;

    }
}
