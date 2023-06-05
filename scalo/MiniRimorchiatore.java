/*questa classe implementa un mini rimorchiatore cioè un rimorchiatore che può spostare 1 sola nave alla volta*/

import java.util.Objects;

public class MiniRimorchiatore implements RimorchiatoreI {

    // CAMPI
    private Cargo nave;

    /*
     * AF: il campo nave indica la nave che sta portando in quel momento il
     * minirimorchiatore, se è uguale a null è libero
     * 
     * IR: --
     */

    public MiniRimorchiatore(/* String scaloNavale, */) {
        // super(scaloNavale);
    }

    // EFFECTS: restituisce il peso della nave trasportata
    @Override
    public int PesoNaviTrasportate() {
        return nave.peso();
    }

    @Override
    public boolean Sposta(Molo a, Molo b, int n) {
        Objects.requireNonNull(a, "molo di partenza non deve essere null");
        Objects.requireNonNull(b, "molo di arrivo non deve essere null");
        if (a.NumeroNavi() < n)
            return false;

        for (int i = 0; i < n; i++) {
            Sposta(a, b);
        }
        return true;
    }
}
