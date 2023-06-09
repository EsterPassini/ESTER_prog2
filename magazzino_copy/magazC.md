PACCO: record
ROBOT: interfaccia sposta è legato ad un magazzino
singoli robot classi concrete senza stato, tranne il cauto
SCAFFALE classe concreta interna a magazzino, ha metodi privati che usa solo magazzino
MAGAZZINO: lista di scaffali, costruttore vuoto con parametro che è num di scaff, ha un metodo sposta che ha come parametro anche un robot
