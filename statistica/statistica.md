# Statistiche descrittive

## Descrizione

Scopo della prova è progettare e implementare una gerarchia di oggetti utili a
rappresentare il calcolo di *statistiche descrittive* elementari su sequenze di
numeri reali.

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

### Dettagli pratici

**Sviluppi la sua soluzione in una serie di file `.java` che salverà nella
medesima cartella che contiene questo testo d'esame**, usando esclusivamente il
*default package* — altrimenti detto, **senza creare sottocartelle e non
introducendo alcuna dichiarazione `package` nei suoi file sorgenti**. Se non
seguirà esattamente queste indicazioni, il suo materiale non verrà raccolto dal
sistema che gestisce la consegna e il suo lavoro non potrà essere valutato.

Presti particolare attenzione agli *errori di compilazione: l'intero contenuto
dei file che il compilatore si rifiuta di compilare non sarà affatto esaminato*.
Se riscontrasse errori di compilazione che non è in grado di correggere, valuti
la possibilità di racchiudere le porzioni di codice che li causano all'interno
di commenti; resta inteso che tale codice commentato non sarà valutato, ma
almeno verrà esaminato il resto del codice del file.

## Media e varianza campionaria

La **statistica** descrittiva studia, tra l'altro, diversi indici per
sintetizzare un insieme di $n$ osservazioni $x_i\in \mathbb{R}$; i più noti sono
l'indice di posizione denominato *media*

$$
\mu = \frac 1 n \sum_i x_i
$$

e l'indice di variabilità denominato *varianza*

$$
\sigma^2 = \frac{\sum_i (x_i - \mu)^2 }{n - 1}
$$

(ovunque compaia l'indice $i$ in queste e nelle successive formule, si intende
che $1 \leq i \leq n$).

Date le osservazioni, il calcolo di tali indici può essere realizzato
concretamente in modi diversi, in ordine crescente di complessità, efficienza e
stabilità numerica.

Il primo richiede due "passate" (sulle osservazioni, che vanno pertanto
memorizzate) ed è suggerito immediatamente dalla definizione stessa degli
indici:

* dapprima (attraverso la prima "passata") viene calcolata la media;
* tale valore viene quindi utilizzato (durante la seconda "passata") per
  calcolare la varianza.

A ben guardare, però, la seconda formula può essere riscritta come:

$$
\sigma^2 = \frac{n\sum_i x^2_i - \left(\sum_i x_i\right)^2 }{n(n - 1)}.
$$

Questa seconda formulazione suggerisce che possa bastare una sola "passata" (che
consente di evitare la memorizzazione delle osservazioni) durante la quale
vengano al contempo accumulate sia la somma $\sum_i x_i$ delle osservazioni che
quella $\sum_i x^2_i$ dei loro quadrati; utilizzando tali valori, al termine
della "passata", è possibile ottenere sia la media che la varianza.

La differenza che figura a numeratore può però porre un problema di stabilità
numerica che può essere corretto considerando la seguente riformulazione del
calcolo (dovuta a Welford) attraverso le successioni $\mu_i$ e $ \sigma^2_i$
definite induttivamente come segue: a partire dai due valori iniziali

$$
\mu_0 = 0,
\qquad
\sigma^2_0 = 0
$$

all'$i$-esimo passo i valori $\mu_i$ e $\sigma^2_i$ vengono calcolati, a partire
dai precedenti valori $\mu_{i-1}$ e $\sigma^2_{i-1}$ e dall'osservazione $x_i$,
come segue

$$
\mu_i = \mu_{i-1} + \frac{x_i - \mu_{i-1}}{i},
\qquad
\sigma^2_i = \sigma^2_{i-1} + (x_i - \mu_i)(x_i - \mu_{i-1});
$$

come è facile convincersi, una volta che sono state elaborate tutte le
osservazioni, si avrà

$$
\mu = \mu_n,
\qquad
\sigma^2 = \frac{\sigma^2_n}{n - 1}.
$$

### Cosa dovete implementare

Dovete implementare una gerarchia di classi atta a rappresentare il calcolo dei
due indici descrittivi introdotti nella precedente sezione e offrirne (almeno)
tre distinte implementazioni, secondo le tecniche mostrate: 

* a due "passate",
* a una "passata" e
* "induttiva" (una "passata" numericamente stabile).

#### La classe di test

La classe di test deve leggere dal flusso di ingresso una sequenza di numeri ed
emettere nel flusso d'uscita il numero di osservazioni seguito da media e
varianza calcolata secondo tutte le implementazioni offerte.

Ad esempio, eseguendo il calcolo con i valori

    49.80401
    49.80400
    49.80309
    49.80399

nel flusso di ingresso la soluzione emette

    4, 4.98037725e+01, 2.07090731e-07
    4, 4.98037725e+01, 2.07091667e-07
    4, 4.98037725e+01, 2.07091667e-07

in cui, per la varianza, si nota una discrepanza sulla quinta cifra dopo la
virgola.