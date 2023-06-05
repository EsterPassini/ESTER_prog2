/*
 * overview: questa classe astratta permette di calcolare gli indici di media e varianza per una serie di dati
 */

//import java.util.Objects;

public abstract class StatDesc{
    //CAMPI
    private double[] f;

    /*
     * AF: f rappresenta l'insiene di n osservazioni sul quale vogliamo operare, n == length di f
     * 
     * iR: -
     */

    public StatDesc(double[] f){
        this.f = f;
    }

    //EFFECTS: restituisce un float che è la media dei valori in f
    public abstract double media();

    //EFFECTS: restituisce un float che è la varianza dei valori in f
    public abstract double var();

    //EFFECTS: restituisce il numero di osservazioni contenute in f 
    public int n(){
        return f.length;
    }

    //EFFECTS: restituisce l'iesima osservazione (partendo da 0), 
    //se i<0 o i>len(f) solleva un eccezione index out of bound
    public double getXi(int i){
        if (i<0 || i>f.length)
            throw new IndexOutOfBoundsException("posizione non valida");
        return f[i];
    }



}