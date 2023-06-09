/*
 * questa classe rappresenta un pacchetto, in cui è codificata una parte del messaggio
 */
public class Pacchetto {
    //CAMPI
    int nSeq;
    Byte[] cont;
    boolean check;

    /*
     * AF: nSeq è ossia del posto occupato nella sequenza di pacchetti corrispondenti al messaggio,
     * cont è un contenuto, ossia dei byte di cui è costituito, 
     * check è un valore di controllo, ossia di un numero che consenta di capire se il contenuto del pacchetto è stato alterato. 
     * 
     * IR: nSeq > di 0
     * cont non deve essere null, e deve avere una lunghezza di minimo 1
     */
}
