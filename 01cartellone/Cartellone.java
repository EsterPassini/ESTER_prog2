import java.util.ArrayList;
import java.util.Objects;
import java.util.*;

/*
 * le istanze di questa classe rappresentano un cartellone mensile 
 * caratterizzato dal nome del cinema , dalla durata del mese in giorni 
 * e da un elenco di proiezioni, è possibile una sola proiezione al giorno
 * è mutabile
 */
public class Cartellone{

    /*
    * le istanze di questa classe rappresentano delle proiezioni cinematografiche,
        ognuna caratterizzata da un titolo e da una programmazione che 
        descrive le date in cui si verifica, è immutabile
    */
    public class Proiezione {
        //CAMPI
        final String titolo;
        private Programmazione program;

        /*
         * AF: titolo rappresenta il titolo della proiezione, 
         *      program rappresenta la programmazione di questa proiezione (le date in cui è in programma)
         * 
         * IR: titolo non deve essere null e non deve essere vuoto,
         *      programmazione non deve essere null
         */

        private Proiezione(String titolo, Programmazione program){
            Objects.requireNonNull(titolo);
            if (titolo == "" || titolo == " ")
                throw new IllegalArgumentException("titolo deve contenere almeno una lettera");

            this.titolo = titolo;
            this.program = program;
        }
        //EFFECTS: questo metodo restituisce true se le 2 proiezioni sono sovrapposte, false altrimenti
        private boolean isSovrapposta(Proiezione p){
            return p.program.isSovrapposta(p.program);
        }

        //EFFECTS: restituisce un array di interi che rappresentano i giorni contenuti nella programmazione della proiezione
        private int[] giorniDiProgrammazione(){
            int[] g = new int[31];
            Iterator<Integer> it =  program.iterator();
            while (it.hasNext()){
                for (int i=0; i<=31; i++){
                    g[i]= it.next();
                }
            }
            return g;
        }

        @Override
        public String toString(){
            return titolo + giorniDiProgrammazione().toString();
        }
    }



    //CAMPI
    final String nome;
    final int durataMese;
    private ArrayList<Proiezione> proiezioni;

    /*
     * AF: nome rappresenta il nome del cinema a cui appartiene il cartellone, 
     *      durata mese rappresenta la durata del mese in giorni a cui appartiene il cartellone,
     *      proiezioni rappresenta l'elenco di proiezioni di quel mese
     * 
     * IR: nome non nullo e non vuoto, durataMese deve essere un numero intero tra 28 e 31 compresi
     *      proiezioni non deve essere nullo
     */


     /*costruttore con nome del cinema e numero di giorni del mese */
    public Cartellone(String nome, int durateMese){
        Objects.requireNonNull(nome, "nome deve essere non null");
        if (nome== "" || nome == " ")
            throw new IllegalArgumentException("nome non deve essere vuoto");
        if (durateMese<1 || durateMese>31)
            throw new IllegalArgumentException("durata del mese deve essere compresa tra 28 e 31 compresi");
        this.nome = nome;
        this.durataMese= durateMese;
        this.proiezioni= new ArrayList<Proiezione>();

    }

   /*
    EFFECTS: Questo metodo consente di aggiungere una proiezione al cartellone,
        il metodo crea una proiezione a partire da un titolo e da una programmazione e la inserisce.
        viene sollevata un eccezione se titolo è null o vuoto, o se programmazione è null.
         se la proiezione 
            è sovrapposta con una già in cartellone, essa non viene aggiunta e viene restituito false, 
            se è aggiunta correttamente viene restituito true
    */
    public boolean aggiungi(String titolo, Programmazione prog){
        Proiezione p = new Proiezione( titolo,  prog);
        for (Proiezione pl : proiezioni) {
            if (pl.isSovrapposta(p))
                return false;
        }

        proiezioni.add(p);
        
        return true;
    }

    /*
    EFFECTS: questo metodo restituisce un array di proiezioni nell'ordine in cui sono state aggiunte 
    (a prescindere dalle date in cui hanno luogo, una sola volta ciascuna).
     */
    public Proiezione[] elencaProiezioniOrdineDiAggiunta(){
        Proiezione[] proiez = new Proiezione[proiezioni.size()];
        for (Proiezione pl : proiezioni) {
            for(int i=0; i<proiezioni.size(); i++){
                proiez[i] = pl;
            }
        }
        return proiez;
    }

    /*
    EFFECTS: questo metodo restituisce un array di interi che rappresentano i giorni in cui è in programmazione la proiezione
    passata in input. se la proiezione p è null si solleva un eccezione*/
    public int[] giorniDiProiezione(Proiezione p){
        
        return p.giorniDiProgrammazione();
    }
}


