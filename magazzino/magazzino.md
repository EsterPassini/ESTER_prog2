# Patagon

## Descrizione

Scopo della prova è progettare e implementare una gerarchia di oggetti utili a
rappresentare la gestione di un *magazzino logistico* dell'e-commerce
"Patagon".

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

### Magazzino logistico

Un **magazzino logistico** è un elenco numerato (non vuoto e finito) di
**scaffalature** ciascuna delle quali ospita diversi **pacchi** ciascuno dei
quali è caratterizzato da un *prodotto* (specificato con una stringa non vuota).

Ogni scaffalatura si comporta come una sorta di colonna (eventualmente vuota) di
pacchi che vengono *depositati* sulla cima della colonna e *prelevati* dal fondo
di essa. Altrimenti detto, il primo di una sequenza di pacchi depositati sarà il
primo ad essere prelevato.

Per ragioni di efficienza, può essere necessario riorganizzare i pacchi
spostandoli da una scaffalatura all'altra; questa funzione è svolta da un
**robot** che preleva un certo *numero* di pacchi da una scaffalatura di
*partenza* per depositarli in un'altra di *arrivo*. Per svolgere il suo compito,
il robot impila uno sull'altro, sulla sua superficie di carico, i pacchi man mano
che li preleva e quindi li deposita a partire da quello impilato più in alto.
Altrimenti detto, il primo di una sequenza di pacchi prelevati sarà l'ultimo ad
essere depositato.

Per fare un esempio, se all'inizio il magazzino fosse rappresentato dalla figura

      E
      D
      C
      B G   L
    X A F H I
    ---------
    0 1 2 3 4

e un robot ricevesse l'ordine di spostare 3 pacchi dalla scaffalatura 1 alla
scaffalatura 4,dopo aver spostato i pacchi una alla volta, il magazzino potrebbe
essere rappresentato da

            C
            B
            A
      E G   L
    X D F H I
    ---------
    0 1 2 3 4

se invece (dalle stesse condizioni di partenza e ricevendo il medesimo ordine)
il robot spostasse tutte e tre i pacchi in una sola volta, il magazzino potrebbe
essere rappresentato da

            A
            B
            C
      E G   L
    X D F H I
    ---------
    0 1 2 3 4

Esistono vari *modelli* di robot, ad esempio:

* un "micro" robot in grado di spostare solo un pacco alla vota;
* un "extra" robot in grado di spostare un numero potenzialmente illimitato di
  pacchi alla volta;
* un robot "cauto", caratterizzato da una *altezza massima* in grado di
  spostare più di un pacco se e solo se (oltre al primo pacco che è sempre in
  grado di spostare a prescindere dall'altezza), la somma delle altezze dei
  pacchi accumulati sulla sua superficie di carico non eccede mai l'altezza
  massima consentita;

e potenzialmente molti altri tipi che differiranno dalla strategia e dai vincoli
in base ai quali realizzano l'ordine di spostare i pacchi da una scaffalatura
all'altra.

Ovviamente il robot può conoscere l'altezza dei pacchi sulla sua superficie di
carico, ma per rendere possibili strategie più sofisticate, un robot può
chiedere alla scaffalatura di comunicargli l'altezza del primo pacco che
preleverà.

Potete decidere quanti e quali tipi di robot implementare, ma la gerarchia che
avete sviluppato deve rendere possibile estenderne il numero e le
caratteristiche in modo conveniente.

### La classe di test

La classe di test deve leggere dal flusso di ingresso il numero di scaffalature
del magazzino seguito dalla loro composizione specificata con una riga per
scaffalatura e avente su ogni riga una sequenza di coppie di valori separati da
spazio corrispondenti alla categoria e all'altezza dei pacchi inizialmente
depositate nelle scaffalature.

La classe riceve inoltre come argomenti sulla linea di comando l'ordine per il
robot, ossia il numero di pacchi da spostare, il numero della scaffalatura di
partenza e quindi di quella d'arrivo.

La classe emette nel flusso d'uscita:

* una rappresentazione del magazzino prima dello spostamento,
* il numero di viaggi compiuto dal robot per effettuare lo spostamento,
* una rappresentazione del magazzino dopo lo spostamento.

## Esempio

Invocando l'esecuzione della classe con `3 1 2` come argomenti sulla linea di
comando e avendo

    4
    MickeyMouse 4 Woody 6 BuzzLightyear 12 Baloo 21 LiloPelekai 5 Simba 9 Mowgli 5
    Polaris 10 Castor 33 Pollux 11 Orion 24 Sirius 42 Altair 12 Sun 9 Antares 51
    Neon 10 Hydrogen 1 Argon 39 Iron 55 Calcium 40 
    London 9 Paris 2 Tokyo 14 Dubai 3 Barcelona 1 Rome 3 Madrid 3

nel flusso d'ingresso, nel caso di "mini" robot la classe emetterebbe
nel flusso d'uscita

    |                   | Antares[51] |             |              |
    | Mowgli[5]         | Sun[9]      |             | Madrid[3]    |
    | Simba[9]          | Altair[12]  |             | Rome[3]      |
    | LiloPelekai[5]    | Sirius[42]  | Calcium[40] | Barcelona[1] |
    | Baloo[21]         | Orion[24]   | Iron[55]    | Dubai[3]     |
    | BuzzLightyear[12] | Pollux[11]  | Argon[39]   | Tokyo[14]    |
    | Woody[6]          | Castor[33]  | Hydrogen[1] | Paris[2]     |
    | MickeyMouse[4]    | Polaris[51] | Neon[10]    | London[9]    |
    +-------------------+-------------+-------------+--------------+
    | 0                 | 1           | 2           | 3            |
    3
    |                   |             | Pollux[11]  |              |
    | Mowgli[5]         |             | Castor[33]  | Madrid[3]    |
    | Simba[9]          |             | Polaris[51] | Rome[3]      |
    | LiloPelekai[5]    | Antares[51] | Calcium[40] | Barcelona[1] |
    | Baloo[21]         | Sun[9]      | Iron[55]    | Dubai[3]     |
    | BuzzLightyear[12] | Altair[12]  | Argon[39]   | Tokyo[14]    |
    | Woody[6]          | Sirius[42]  | Hydrogen[1] | Paris[2]     |
    | MickeyMouse[4]    | Orion[24]   | Neon[10]    | London[9]    |
    +-------------------+-------------+-------------+--------------+
    | 0                 | 1           | 2           | 3            |

Si noti che nell'input i pacchi sono elencati in ordine di deposito (per cui il
primo della riga in input sarà il primo a essere prelevato).

Nel caso del "micro" robot serviranno 3 viaggi e alla fine dello spostamento
`Orion` sarà il primo pacco da prelevare dalla scaffalatura 1 mentre sulla
scaffalatura 2 si troveranno i pacchi `Pollux`, `Castor` e `Polaris` sopra a
`Calcium`, nello stesso ordine in cui sono stati prelevati dalla scaffalatura 1.

Usando l'"extra" robot (con il medesimo input e i medesimi argomenti sulla
linea di comando), la soluzione emetterebbe

    |                   | Antares[51] |             |              |
    | Mowgli[5]         | Sun[9]      |             | Madrid[3]    |
    | Simba[9]          | Altair[12]  |             | Rome[3]      |
    | LiloPelekai[5]    | Sirius[42]  | Calcium[40] | Barcelona[1] |
    | Baloo[21]         | Orion[24]   | Iron[55]    | Dubai[3]     |
    | BuzzLightyear[12] | Pollux[11]  | Argon[39]   | Tokyo[14]    |
    | Woody[6]          | Castor[33]  | Hydrogen[1] | Paris[2]     |
    | MickeyMouse[4]    | Polaris[51] | Neon[10]    | London[9]    |
    +-------------------+-------------+-------------+--------------+
    | 0                 | 1           | 2           | 3            |
    1
    |                   |             | Polaris[51] |              |
    | Mowgli[5]         |             | Castor[33]  | Madrid[3]    |
    | Simba[9]          |             | Pollux[11]  | Rome[3]      |
    | LiloPelekai[5]    | Antares[51] | Calcium[40] | Barcelona[1] |
    | Baloo[21]         | Sun[9]      | Iron[55]    | Dubai[3]     |
    | BuzzLightyear[12] | Altair[12]  | Argon[39]   | Tokyo[14]    |
    | Woody[6]          | Sirius[42]  | Hydrogen[1] | Paris[2]     |
    | MickeyMouse[4]    | Orion[24]   | Neon[10]    | London[9]    |
    +-------------------+-------------+-------------+--------------+
    | 0                 | 1           | 2           | 3            |

In questo caso è infatti bastato 1 solo viaggio ma i `Pollux`, `Castor` e
`Polaris` si trovano sulla scaffalatura d'arrivo nell'ordine inverso rispetto a
quello con cui sono stati prelevati.

Per finire, usando un robot "cauto" con altezza massima pari a 45, (sempre
con il medesimo input e i medesimi argomenti sulla linea di comando), la
soluzione emetterebbe

    |                   | Antares[51] |             |              |
    | Mowgli[5]         | Sun[9]      |             | Madrid[3]    |
    | Simba[9]          | Altair[12]  |             | Rome[3]      |
    | LiloPelekai[5]    | Sirius[42]  | Calcium[40] | Barcelona[1] |
    | Baloo[21]         | Orion[24]   | Iron[55]    | Dubai[3]     |
    | BuzzLightyear[12] | Pollux[11]  | Argon[39]   | Tokyo[14]    |
    | Woody[6]          | Castor[33]  | Hydrogen[1] | Paris[2]     |
    | MickeyMouse[4]    | Polaris[51] | Neon[10]    | London[9]    |
    +-------------------+-------------+-------------+--------------+
    | 0                 | 1           | 2           | 3            |
    2
    |                   |             | Castor[33]  |              |
    | Mowgli[5]         |             | Pollux[11]  | Madrid[3]    |
    | Simba[9]          |             | Polaris[51] | Rome[3]      |
    | LiloPelekai[5]    | Antares[51] | Calcium[40] | Barcelona[1] |
    | Baloo[21]         | Sun[9]      | Iron[55]    | Dubai[3]     |
    | BuzzLightyear[12] | Altair[12]  | Argon[39]   | Tokyo[14]    |
    | Woody[6]          | Sirius[42]  | Hydrogen[1] | Paris[2]     |
    | MickeyMouse[4]    | Orion[24]   | Neon[10]    | London[9]    |
    +-------------------+-------------+-------------+--------------+
    | 0                 | 1           | 2           | 3            |

In questo caso infatti sono necessari 2 viaggi: durante il primo, una volta
prelevato `Polaris`, il robot non può più aggiungere altri pacchi (l'altezza di
`Polaris` supera da sola la massima altezza) deve quindi portarlo a destinazione
dove finirà sopra a `Calcium`; a questo punto però può spostare i rimanenti due
pacchi nel solo secondo viaggio (prelevato `Castor` gli restano 12 centimetri
che bastano per prelevare anche `Pollux`), i due compariranno quindi sulla
scaffalatura di destinazione nell'ordine inverso rispetto a quello con cui sono
stati prelevati. La situazione finale della scaffalatura 2 è `Castor`, `Pollux`,
`Polaris` e quindi `Calcium` e il resto dei pacchi presenti prima dello
spostamento.