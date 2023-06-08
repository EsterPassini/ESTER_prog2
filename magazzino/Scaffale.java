/*
* questa classe descrive degli scaffali, cioè una struttura in cui i pacchi sono inseriti
* da sopra e prelevati da sotto
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Scaffale{
   //campi
   private List<Pacco> s;

   /*
    * AF: s rappresenta la struttura di uno scaffale su cui sono posizionati i pacchi, la size di s rappresenta il numero di pacchi in un dato momento
    * 
    * IR: s non deve essere null, può essere vuota, ma se contiene pacchi essi non possono essere nulli.
   */

   
   public Scaffale() {
       s = new LinkedList<Pacco>();
   }

   //EFFECTS: questo metodo aggiunge un pacco allo scaffale, se il pacco è nullo solleva un eccezione 
   public void aggiungi(Pacco p){
       Objects.requireNonNull(p, "impossibile aggiungere pacco nullo");

       s.add(0, p);
   }

   //EFFECTS: questo metodo toglie un pacco dallo scaffale e lo restituisce, se il pacco è nullo solleva un eccezione,
   //      se s è vuota restituisce null
   public Pacco togli(){
       if (s.size()==0)
           return null;
       Pacco p = s.remove(s.size()-1);
       return p;
   }

   //EFFECTS: restituisce il numero di pacchi attualmente su uno scaffale
    public int numeroPacchi() {
      return s.size();
    }

    @Override
    public String toString(){
        return s.toString();
    }
} 
