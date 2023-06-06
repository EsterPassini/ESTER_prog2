/**
 * Cargo è un record che rappresenta una nave cargo determinata da nome e peso
 */
/*public record Cargo(String name, int peso) {

    /*
     * AF: name rappresenta il nome del cargo e peso il peso
     * 
     * IR: name deve essere diverso da null, peso >=0
     
     public Cargo(String name, int peso){
        if (peso<=0 || name == null)
            throw new IllegalArgumentException("peso nn può essere minore o uguale a zero e name deve essere non null");
        this.name = name;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "cargo di nome: "+ name + " e peso: " + Integer.toString (peso);
    }
}*/

public class Cargo {
    private String name; 
    private int peso;

    /*
     * AF: name rappresenta il nome del cargo e peso il peso
     * 
     * IR: name deve essere diverso da null, peso >=0
     */
     public Cargo(String name, int peso){
        if (peso<=0 || name == null)
            throw new IllegalArgumentException("peso nn può essere minore o uguale a zero e name deve essere non null");
        this.name = name;
        this.peso = peso;
    }
    

    @Override
    public String toString() {
        return "{cargo: "+ name + ", peso: " + Integer.toString (peso)+"}";
    }


    public String name() {
        return name;
    }


    public int peso() {
        return peso;
    }
}
