
/*
questo record rappresenta un elemento chimico della tavola periodica
*/


public record Elemento(String nome, String simbolo, int num_atomico, Float peso) {
    /*
     * AF: name è il nome del'elemento, il simbolo il simbolo, il num_atomico il
     * numero atomico e peso il peso
     * atomico della molecola
     * 
     * IR: nome non deve essere nul, simbolo deve essere costituito da una o più
     * lettere, di cui solo la prima è maiuscola
     * peso deve essere >di 0, numero atomico deve essere > di 0
     */

    public Elemento(String nome, String simbolo, int num_atomico, Float peso) {
        if (nome == null || simbolo == null || num_atomico < 0 || peso < 0)
            throw new IllegalArgumentException("variabili non accettate per la creazione di una molecola");

        this.nome = nome;
        this.simbolo = simbolo;
        this.num_atomico = num_atomico;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return this.simbolo;
    }
}
