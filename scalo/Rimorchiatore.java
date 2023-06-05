
/*
 * questa classe astratta rappresenta il tipo rimorchiatore, una nave il cui compito è quello di spostare cargo da un molo all'altro
 * possiede uno scalo nel quale lavora
 */

import java.util.Objects;

public abstract class Rimorchiatore {
    // Campi
    private String scaloNavale;

    /*
     * AF: scaloNavale rappresenta lo scalo navale in cui lavora questo
     * rimorchiatore
     * 
     * IR: scaloNavale non deve essere null
     */

    public Rimorchiatore(String scaloNavale) {
        Objects.requireNonNull(scaloNavale, "scaloNavale non deve essere null");
        this.scaloNavale = scaloNavale;
    }

    // EFFECTS: restituisce il peso della prima nave attraccata nel molo di input,
    // se esso è vuoto restituisce 0,
    // solleva un eccezione se molo è null
    public int RichiediPesoPrimaNave(Molo m) {
        Objects.requireNonNull(m, "molo nn deve essere null");

        return m.PesoPrimaNave();
    };

    abstract int PesoNaviTrasportate();

    abstract void Sposta(Molo a, Molo b, int n);

    // MODIFIES: a, b
    // EFFECTS: questo metodo sposta 1 nave dal molo a al molo b, solleva un
    // eccezione se a o b sono nulli, restituisce true se
    // lo stostamento è avvenuto bene, false se a non ha attraccata neanche 1 nave
    public boolean Sposta(Molo a, Molo b) {
        Objects.requireNonNull(a, "molo di partenza non deve essere null");
        Objects.requireNonNull(b, "molo di arrivo non deve essere null");
        if (a.NumeroNavi() == 0)
            return false;
        Cargo c = a.Rimuovi();
        b.Aggiungi(c);
        return true;
    }

    public String getScaloNavale() {
        return scaloNavale;
    }

}
