import java.util.Objects;

public interface RimorchiatoreI {

    // EFFECTS: restituisce il peso della prima nave attraccata nel molo di input,
    // se esso è vuoto restituisce 0,
    // solleva un eccezione se molo è null
    default public int RichiediPesoPrimaNave(Molo m) {
        Objects.requireNonNull(m, "molo nn deve essere null");
        return m.PesoPrimaNave();
    };

    // EFFECTS: restituisce il peso di tutte le navi trasportate in un viaggio dal
    // rimorchiatore, se esso è vuoto restituisce 0
    public int PesoNaviTrasportate();

    // MODIFIES: a, b
    // EFFECTS: questo metodo sposta 1 nave dal molo a al molo b, solleva un
    // eccezione se a o b sono nulli, restituisce true se
    // lo stostamento è avvenuto bene, false se a non ha attraccata neanche 1 nave
    default public boolean Sposta(Molo a, Molo b) {
        Objects.requireNonNull(a, "molo di partenza non deve essere null");
        Objects.requireNonNull(b, "molo di arrivo non deve essere null");
        if (a.NumeroNavi() == 0)
            return false;
        Cargo c = a.Rimuovi();
        b.Aggiungi(c);
        return true;
    }

    // MODIFIES: a, b
    // EFFECTS: questo metodo sposta n navi insieme dal molo a al molo b, solleva un
    // eccezione se a o b sono nulli, restituisce true se
    // lo stostamento è avvenuto bene, false se a non ha attraccata n navi, in
    // questo caso non ne sposta neanche una
    public boolean Sposta(Molo a, Molo b, int n);

}
