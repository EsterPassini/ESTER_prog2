# Cartellone mensile

## Descrizione

L'obiettivo di questa prova è progettare e implementare una gerarchia di oggetti
utili a rappresentare il *cartellone* di un mese di proiezioni cinematografiche.

Si richiede di decidere quali interfacce e classi (concrete o astratte)
implementare. Per ciascuna di esse, è necessario fornire una **descrizione**
attraverso commenti nel codice (preferibilmente in formato Javadoc); questa
documentazione dovrà includere le scelte relative alla **rappresentazione**
dello stato (con particolare riferimento all'*invariante di rappresentazione* e
alla *funzione di astrazione*) e ai **metodi** (con particolare riferimento a
*pre/post-condizioni*, *eccezioni* ed eventuali *effetti collaterali*). Si
sottolinea che *il risultato della prova sarà valutato sia in base a questa
documentazione che al codice sorgente*.

### Dettagli pratici

La soluzione deve essere realizzata in una serie di file `.java` che dovranno
essere salvati nella *stessa cartella* in cui si trova il testo d'esame. È
importante utilizzare solo il *default package*, evitando di creare
sottocartelle o di introdurre dichiarazioni `package` nei file sorgenti. **Se
queste indicazioni non vengono seguite correttamente, il materiale non sarà
raccolto dal sistema di consegna e il lavoro non potrà essere valutato**.

Si prega di prestare attenzione agli *errori di compilazione*: l'intero
contenuto dei file che il compilatore rifiuta di compilare *non verrà
esaminato*. Nel caso in cui si verifichino errori di compilazione che non si
riescono a correggere, è possibile considerare la possibilità di commentare le
porzioni di codice che li causano tenendo tuttavia presente che il codice così
commentato non sarà valutato (ma verrà almeno esaminato il resto del codice del
file).

## Il cartellone mensile

Il **cartellone** mensile di un cinema è caratterizzato dal nome del *cinema*
(non vuoto), dalla *durata* del mese in giorni (28, 29, 30 o 31) e da un elenco
di *proiezioni*. Ogni proiezione può avvenire in uno o più giorni del mese, per
semplicità considereremo solo il caso in cui ci sia al più una proiezione al
giorno (che avvenga, nel caso, ad un orario prefissato).

Il cartellone deve consentire di:

* *aggiungere* una nuova proiezione, data la programmazione in cui sarebbe
 destinata, a patto che ciò non comporti sovrapposizioni con altre proiezioni
 già in cartellone;
* elencare le proiezioni *per ciascun giorno* del mese (con eventuali
  ripetizioni nei vari giorni);
* elencare le proiezioni *nell'ordine in cui sono state aggiunte* (a prescindere
  dalle date in cui hanno luogo, una sola volta ciascuna).

L'aggiunta di una proiezione con una programmazione che determinerebbe una o più
sovrapposizioni *non* è da considerarsi evenienza eccezionale, tale circostanza
va pertanto segnalata tenendo conto di questa osservazione. Si assuma per
semplicità che il cartellone non consenta di eliminare, o modificare, le
proiezioni già inserite.

## Proiezioni e programmazione

Una **proiezione** è caratterizzata da un *titolo* (non vuoto) e da una
*programmazione* che descrive le date in cui si verifica. Dato che una
proiezione ha senso solo nel contesto di un cartellone, è consigliato l'uso di
una *classe interna* per implementarla.

La **programmazione** è semplicemente una sequenza (non vuota, ma eventualmente
di un solo elemento e in ordine strettamente crescente) di interi compresi tra 1
e 31 che rappresentano i giorni del mese in cui si svolge la proiezione. La
sequenza di date va preferibile implementata facendo uso di un *iteratore*.

Ci sono diversi tipi di programmazione, ad esempio:

* una singola data,
* una data seguita da un certo numero di repliche,
* una serie di date ad intervalli regolari (a partire da una data specifica, con
  intervalli di lunghezza costante);

evidentemente potrebbero esserci molti altri tipi di programmazione, per questa
ragione la soluzione deve essere progettata in modo da consentire l'aggiunta di
nuovi tipi di programmazione senza dover modificare il codice già esistente
(fatta eventualmente eccezione per la classe di test).

Ad esempio, una programmazione periodica potrebbe partire dall'inizio del mese e
ripetersi ogni 5 giorni dando luogo alla sequenza di date: 1, 6, 11, 16, 21, 26
e 31; evidentemente, nell'ambito di un cartellone relativo ad un mese di 28 o 30
giorni, tale sequenza andrebbe però limitata alle prime 6 date.

### Cosa dovete implementare

È necessario implementare una gerarchia di classi che permetta di costruire e
interrogare un cartellone in grado di gestire *almeno* i tre tipi di
programmazione descritti in precedenza.

Prestare particolare attenzione alla rappresentazione delle informazioni. Non è
corretto, ad esempio, utilizzare collezioni o array di dimensione pari al numero
di giorni del mese per implementare le programmazioni definite solamente da uno
o due parametri interi.

#### La classe di test

La classe di test riceve come argomenti sulla riga di comando il nome del cinema
e il numero di giorni del mese. Successivamente, legge dal flusso di ingresso
standard una sequenza di richieste di aggiunte al cartellone, una per riga. Ogni
richiesta segue uno dei seguenti formati:

* `"titolo" data` (per una proiezione singola),
* `"titolo" data R repliche` (per una proiezione con repliche),
* `"titolo" data P intervallo` (per una proiezione periodica),

Dove `titolo` è una sequenza di caratteri che non contiene le virgolette,
`data`, `repliche` e `intervallo` sono interi positivi. Si fa notare che i
caratteri 'R' e 'P' compaiono in maiuscolo, se presenti. Le parti della riga
sono separate da uno spazio singolo, ma è importante notare che potrebbero
esserci spazi all'interno del titolo.

La classe di test emette nel flusso di uscita standard il cartellone seguito
dall'elenco degli spettacoli.

Ad esempio, supponiamo che la classe di test venga eseguita con i seguenti
argomenti sulla linea di comando: `Archipelago 30`, e che il flusso di ingresso
contenga le seguenti richieste:

    "My Frozen Chestnuts" 3 P 4
    "They Call Me Trinity" 4 R 3
    "The Single Standard" 8
    "Three Amigos" 10 R 3

In questo caso, la classe di test emetterà il seguente output nel flusso di
uscita:

    CARTELLONE

    Cinema: Archipelago, giorni: 30, proiezioni: 3

    1 - 
    2 - 
    3 - My Frozen Chestnuts
    4 - They Call Me Trinity
    5 - They Call Me Trinity
    6 - They Call Me Trinity
    7 - My Frozen Chestnuts
    8 - The Single Standard
    9 - 
    10 - 
    11 - My Frozen Chestnuts
    12 - 
    13 - 
    14 - 
    15 - My Frozen Chestnuts
    16 - 
    17 - 
    18 - 
    19 - My Frozen Chestnuts
    20 - 
    21 - 
    22 - 
    23 - My Frozen Chestnuts
    24 - 
    25 - 
    26 - 
    27 - My Frozen Chestnuts
    28 - 
    29 - 
    30 - 

    PROIEZIONI

    Cinema: Archipelago, titolo: "My Frozen Chestnuts", date: 3, 7, 11, 15, 19, 23, 27
    Cinema: Archipelago, titolo: "They Call Me Trinity", date: 4, 5, 6
    Cinema: Archipelago, titolo: "The Single Standard", date: 8

nel flusso di uscita. 

Si fa notare che il quarto spettacolo non è stato aggiunto perché la data 11 era
già occupata, e il primo film non elenca il 31 tra le sue date perché il mese
del cartellone è di 30 giorni.

#### Suggerimento

Per decodificare le linee del flusso di ingresso è possibile utilizzare
l'*espressione regolare* 

    static final Pattern PATTERN = Pattern.compile("\"(?<titolo>[^\"]+)\" (?<primo>\\d+)( (?<tipo>R|P)? (?<secondo>\\d+))?");

Se `linea` è una variabile di tipo `String` che contiene la linea corrente del
flusso di ingresso, allora il seguente codice

    Matcher matcher = PATTERN.matcher(line);
    if (!matcher.matches()) throw new IllegalArgumentException("Input in formato non corretto");
    String titolo = matcher.group("titolo");
    String tipo = matcher.group("tipo");
    int primo = Integer.parseInt(matcher.group("primo"));
    int secondo = tipo != null ? Integer.parseInt(matcher.group("secondo")) : -1;

ha per effetto di memorizzare in `titolo` il titolo (senza virgolette), in
`tipo` il tipo di proiezione (`"R˝`, `"P"` o `null`), in `primo` il primo
parametro (che è sempre presente) e in `secondo` il secondo parametro (se
presente, o `-1` se assente).