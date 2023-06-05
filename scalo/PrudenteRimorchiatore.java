/*
 * questa classe che estende rimorchiatore implementa un rimorchiatore "prudente", caratterizzato da un carico massimo in grado di spostare più di una nave cargo 
 * se e solo se (oltre alla prima nave cargo che è sempre in grado di spostare a prescindere dal carico massimo), 
 * la somma delle navi spostate in ciascun viaggio non eccede il carico massimo;
 */

import java.util.ArrayList;
import java.util.Objects;

public class PrudenteRimorchiatore implements RimorchiatoreI {
    // campi
    private ArrayList<Cargo> navi;
    private final int pesoMax;

    /*
     * AF: navi rappresenta le navi portate in un singolo momento da un
     * pridenterimorchiatore, pesoMax è il carico massimo in grado di spostare
     * (oltre alla prima nave cargo ),
     * la somma delle navi spostate in ciascun viaggio non eccede il carico massimo
     * 
     * IR: navi deve essere != da null, può contenere null ma solo se seguiti da
     * altri null e non da dei Cargo,
     * la somma dei pesi delle navi contenute in navi non deve essere > di pesoMax,
     * pesoMax deve essere >0
     */

    public PrudenteRimorchiatore(/* String scaloNavale, */ int pesoMax) {
        // super(scaloNavale);
        if (pesoMax <= 0)
            throw new IllegalArgumentException("pesoMax deve essere >di 0");
        this.pesoMax = pesoMax;
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
    // eccezione se a o b sono nulli,
    // se ----------- ------------------SISTEMA
    // restituisce true se
    // lo stostamento è avvenuto bene, false se a non ha attraccata n navi, in
    // questo caso non ne sposta neanche una
    public boolean Sposta(Molo a, Molo b, int n) {
        Objects.requireNonNull(a, "molo di partenza non deve essere null");
        Objects.requireNonNull(b, "molo di arrivo non deve essere null");
        if (a.NumeroNavi() < n)
            return false;

        return false;
    }

    /*
     * EFFECTS: restituisce il massimo peso che può portare un rimorchiatore
     * prudente
     */
    public int getPesoMax() {
        return pesoMax;
    }
}
