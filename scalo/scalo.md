# Scalo navale

## Descrizione

Scopo della prova è progettare e implementare una gerarchia di oggetti utili a
rappresentare la gestione di uno *scalo navale*.

Per portare a termine il lavoro dovrà decidere se e quali interfacce e classi
(concrete o astratte) implementare. Per ciascuna di esse **dovrà descrivere**
(preferibilmente in formato Javadoc, ma comunque solo attraverso commenti
presenti nel codice) le scelte relative alla **rappresentazione** dello stato
(con particolare riferimento all'*invariante di rappresentazione* e alla
*funzione di astrazione*) e ai **metodi** (con particolare riferimento a
*pre/post-condizioni*, *eccezioni* ed *effetti collaterali*, soffermandosi a
illustrare le ragioni della *correttezza* solo per le implementazioni che
riterrà più critiche). Osservi che *l'esito di questa prova si baserà tanto su
questa documentazione quanto sul codice sorgente*.

Presti particolare attenzione agli *errori di compilazione: l'intero contenuto
dei file che il compilatore si rifiuta di compilare non sarà affatto esaminato*.
Se riscontrasse errori di compilazione che non è in grado di correggere, valuti
la possibilità di racchiudere le porzioni di codice che li causano all'interno
di commenti; resta inteso che tale codice commentato non sarà valutato, ma
almeno verrà esaminato il resto del codice del file.

### Scalo navale

Uno **scalo navale** è un elenco numerato (non vuoto e finito) di **moli** a
ciascuno dei quali sono attraccate alcune **navi cargo**. Ogni nave cargo è
caratterizzata da un *nome* e da un *peso*. 

Ciascun molo si comporta come una sorta di fila (eventualmente vuota) di navi cargo
dalla fine della quale esse possono *salpare* e *attraccare* una alla volta.
Altrimenti detto, il primo di una sequenza di cargo che attraccano sarà l'ultimo
a salpare.

Finché sono nello scalo, le navi cargo non hanno propulsione, per questa ragione
quando devono spostarsi tra due moli, una volta salpate dal primo, è un
**rimorchiatore** a doverle portare fino al secondo, dove possono quindi
attraccare; il rimorchiatore riceve l'ordine di spostare un certo *numero* di
navi *da* un molo *a* un altro e può soddisfare tale ordine muovendo una o più
navi cargo alla volta.

Per fare un esempio, se all'inizio lo scalo fosse rappresentato dalla figura

    0: X
    1: A B C D E
    2: F G
    3: H
    4: I L

e un rimorchiatore ricevesse l'ordine di spostare 3 navi cargo dal molo 1 al
molo 4, dopo aver spostato le navi una alla volta, lo scalo potrebbe essere
rappresentato da

    0: X
    1: A B
    2: F G
    3: H
    4: I L E D C

se invece (dalle stesse condizioni di partenza e ricevendo il medesimo ordine)
il rimorchiatore spostasse tutte e tre le navi in una sola volta, lo scalo
potrebbe essere rappresentato da

    0: X
    1: A B 
    2: F G
    3: H
    4: I L C D E

Esistono vari *modelli* di rimorchiatore, ad esempio:

* un "mini" rimorchiatore in grado di spostare solo una nave cargo alla vota;
* un "super" rimorchiatore in grado di spostare un numero potenzialmente
  illimitato di navi cargo alla volta;
* un rimorchiatore "prudente", caratterizzato da un *carico massimo* in grado di
  spostare più di una nave cargo se e solo se (oltre alla prima nave cargo che è
  sempre in grado di spostare a prescindere dal carico massimo), la somma delle
  navi spostate in ciascun viaggio non eccede il carico massimo;

e potenzialmente molti altri tipi che differiranno dalla strategia e dai vincoli
in base ai quali realizzano l'ordine di spostare le navi cargo da un molo
all'altro.

Ovviamente il rimorchiatore può conoscere il peso delle navi cargo che sta
spostando (ossia che ha fatto salpare dal molo e sono legate a esso), per
rendere possibili strategie più sofisticate, un rimorchiatore può chiedere al
molo di comunicargli il peso del primo cargo che salperà.

Potete decidere quanti e quali tipi di rimorchiatore implementare, ma la
gerarchia che avete sviluppato deve rendere possibile estenderne il numero e le
caratteristiche in modo conveniente.

### La classe di test

La classe di test deve leggere dal flusso di ingresso il numero di moli dello
scalo seguito dalla loro composizione specificata con una riga per molo e avente
su ogni riga una sequenza di coppie di valori separati da spazio corrispondenti
al nome e al peso di una nave cargo in inizialmente attraccate a ciascun molo.

La classe riceve inoltre come argomenti sulla linea di comando l'ordine per il
rimorchiatore, ossia il numero di navi cargo da spostare, il numero del molo di
partenza e quindi quello d'arrivo.

La classe emette nel flusso d'uscita:

* una rappresentazione dello scalo prima dello spostamento,
* il numero di viaggi compiuto dal rimorchiatore per effettuare lo spostamento,
* una rappresentazione dello scalo dopo lo spostamento.

## Esempio

Invocando l'esecuzione della classe con `3 1 2` e avendo

    4
    MickeyMouse 4 Woody 6 BuzzLightyear 12 Baloo 21 LiloPelekai 5 Simba 9 Mowgli 5
    Polaris 10 Castor 33 Pollux 11 Orion 24 Sirius 42 Altair 12 Sun 9 Antares 51
    Neon 10 Hydrogen 1 Argon 39 Iron 55 Calcium 40 
    London 9 Paris 2 Tokyo 14 Dubai 3 Barcelona 1 Rome 3 Madrid 3

nel flusso d'ingresso, nel caso di "mini" rimorchiatore la classe emetterebbe
nel flusso d'uscita

    0: < Mowgli[5], Simba[9], LiloPelekai[5], Baloo[21], BuzzLightyear[12], Woody[6], MickeyMouse[4] #
    1: < Antares[51], Sun[9], Altair[12], Sirius[42], Orion[24], Pollux[11], Castor[33], Polaris[10] #
    2: < Calcium[40], Iron[55], Argon[39], Hydrogen[1], Neon[10] #
    3: < Madrid[3], Rome[3], Barcelona[1], Dubai[3], Tokyo[14], Paris[2], London[9] #
    3
    0: < Mowgli[5], Simba[9], LiloPelekai[5], Baloo[21], BuzzLightyear[12], Woody[6], MickeyMouse[4] #
    1: < Sirius[42], Orion[24], Pollux[11], Castor[33], Polaris[10] #
    2: < Altair[12], Sun[9], Antares[51], Calcium[40], Iron[55], Argon[39], Hydrogen[1], Neon[10] #
    3: < Madrid[3], Rome[3], Barcelona[1], Dubai[3], Tokyo[14], Paris[2], London[9] #

Si noti che, nell'input, le navi cargo sono elencate in ordine di attracco (per
cui l'ultima della riga sarà la prima a salpare), mentre nella rappresentazione
usata nell'output, viceversa, le navi sono rappresentate nell'ordine in cui
salpano (per cui l'ultima della riga è l'ultima a salpare). 

Nel caso del "mini" rimorchiatore serviranno 3 viaggi e alla fine dello
spostamento `Sirius` sarà la prima nave a salpare dal molo 1 mentre sul molo 2
si troveranno `Altair`, `Sun` e `Antares` davanti a `Calcium`, nell'ordine
inverso rispetto al quale sono salpate dal molo 1.

Usando il "super" rimorchiatore (con il medesimo input e i medesimi argomenti
sulla linea di comando), la soluzione emetterebbe

    0: < Mowgli[5], Simba[9], LiloPelekai[5], Baloo[21], BuzzLightyear[12], Woody[6], MickeyMouse[4] #
    1: < Antares[51], Sun[9], Altair[12], Sirius[42], Orion[24], Pollux[11], Castor[33], Polaris[10] #
    2: < Calcium[40], Iron[55], Argon[39], Hydrogen[1], Neon[10] #
    3: < Madrid[3], Rome[3], Barcelona[1], Dubai[3], Tokyo[14], Paris[2], London[9] #
    1
    0: < Mowgli[5], Simba[9], LiloPelekai[5], Baloo[21], BuzzLightyear[12], Woody[6], MickeyMouse[4] #
    1: < Sirius[42], Orion[24], Pollux[11], Castor[33], Polaris[10] #
    2: < Antares[51], Sun[9], Altair[12], Calcium[40], Iron[55], Argon[39], Hydrogen[1], Neon[10] #
    3: < Madrid[3], Rome[3], Barcelona[1], Dubai[3], Tokyo[14], Paris[2], London[9] #

In questo caso è infatti bastato 1 solo viaggio e `Antares`, `Sun` e `Altair` si
trovano sul molo d'arrivo nello stesso ordine in cui erano in quello di
partenza.

Per finire, usando un rimorchiatore "prudente" con carico massimo pari a 30,
(sempre con il medesimo input e i medesimi argomenti sulla linea di comando), la
soluzione emetterebbe

    0: < Mowgli[5], Simba[9], LiloPelekai[5], Baloo[21], BuzzLightyear[12], Woody[6], MickeyMouse[4] #
    1: < Antares[51], Sun[9], Altair[12], Sirius[42], Orion[24], Pollux[11], Castor[33], Polaris[10] #
    2: < Calcium[40], Iron[55], Argon[39], Hydrogen[1], Neon[10] #
    3: < Madrid[3], Rome[3], Barcelona[1], Dubai[3], Tokyo[14], Paris[2], London[9] #
    2
    0: < Mowgli[5], Simba[9], LiloPelekai[5], Baloo[21], BuzzLightyear[12], Woody[6], MickeyMouse[4] #
    1: < Sirius[42], Orion[24], Pollux[11], Castor[33], Polaris[10] #
    2: < Sun[9], Altair[12], Antares[51], Calcium[40], Iron[55], Argon[39], Hydrogen[1], Neon[10] #
    3: < Madrid[3], Rome[3], Barcelona[1], Dubai[3], Tokyo[14], Paris[2], London[9] #

In questo caso infatti sono necessari 2 viaggi: durante il primo, una volta
prelevato `Antares`, il rimorchiatore non può più aggiungere altri cargo (il
peso di `Antares` supera da solo il massimo carico) deve quindi portarlo a
destinazione dove attraccherà davanti a `Calcium`; a questo punto però può
spostare i rimanenti due cargo nel solo secondo viaggio (prelevato `Sun` gli
restano 21 unità di carico che bastano per prelevare anche `Altair` che pesa
12), i due compariranno quindi sul molo di destinazione nell'ordine in cui sono
salpati. La situazione finale del molo 2 è `Sun`, `Altair`, `Antares` e quindi
`Calcium` e il resto dei cargo presenti prima dello spostamento.