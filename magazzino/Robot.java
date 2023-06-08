/*
 * questa interfaccia specifica i comportamenti che deve avere un robot
 */
public interface Robot {
    //MODIFIES:  a, b
    //EFFECTS: questo metodo sposta n pacchi dallo scaffale a uno scaffale b 
    //          e restituisce il numero di viaggi che il robot ci mette
    //          solleva un eccezione se a e b sono nulli, se n < di 0, e se a non ci sono abbastanza pacchi
    //          non ne sposta neanche uno e restituisce -1
    public int sposta(Scaffale a, Scaffale b, int n)throws IllegalArgumentException, NullPointerException;
}
