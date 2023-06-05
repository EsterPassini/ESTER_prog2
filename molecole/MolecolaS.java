/*
questa classe estende la classe astratta Molecola e rappresenta una molecola semplice, 
cioè composta da un solo elemento chimico
*/

import java.util.Objects;

public class MolecolaS extends Molecola {
    // campi
    private Elemento ele;
    private int numero;

    /*
     * AF: ele rappresenta l'elemento di cui è composta la molecola semplice,
     * numero il numero di molecole di atomi di quell'elemento che la compongono
     * 
     * IR: ele non deve essere nullo, numero deve essere >1
     */

    public MolecolaS(String nome, Elemento ele, int numero) {
        super(nome);

        Objects.requireNonNull(ele, "ele non deve essere nul");
        if (numero < 1)
            throw new IllegalArgumentException("numero deve essere >1");

        this.ele = ele;
        this.numero = numero;

    }

    @Override
    public String toString() {
        return getNome() + " formata da: " + String.valueOf(numero) + ele;
    }

    @Override
    public String getFormula() {
        return ele.toString() + String.format("%d", numero);
    }

    @Override
    public float peso() {
        return ele.peso() * (float) numero;
    }

}
