import java.util.Objects;

public abstract class Molecola {
    // CAMPI
    private String nome;
    // int peso;
    // String formula;

    /*
     * AF:
     * 
     * IR: nome e formula != null, peso>0
     */


    public Molecola(String nome) {
        Objects.requireNonNull(nome);
        this.nome = nome;
    }
    
    
    //effects: metodo che ritorna il nome della molecola in forma di stringa
    public String getNome() {
        return nome;
    }

    //EFFECTS: restituisce la formula in forma di stringa
    abstract public String getFormula();

    //EFFECTS: restituisce il peso della molecola
    abstract public float peso();
}
