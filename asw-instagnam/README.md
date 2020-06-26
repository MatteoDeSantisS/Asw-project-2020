# INSTAGNAM 

Progetto del corso di Analisi e progettazione del software per l'anno accademico 2019-2020,DE Santis Matteo, Francesco Forgione



* Il servizio *ricette* gestisce le ricette di cucina dei suoi utenti. 
  Ogni ricetta ha un autore, un titolo e una preparazione. 
  Operazioni: 
  * `POST /ricette` aggiunge una nuova ricetta (dato autore, titolo e preparazione)
  * `GET /ricette/{id}` trova una ricetta dato l'id 
  * `GET /ricette` trova tutte le ricette (in formato breve, solo id, autore e titolo)
  * `GET /ricette?autore={autore}` trova tutte le ricette di autore (in formato breve, solo id, autore e titolo)
  
* Il servizio *connessioni* gestisce le connessioni tra gli utenti. 
  Ogni connessione è una coppia follower-followed, in cui follower e followed sono due utenti del sistema. 
  Operazioni: 
  * `POST /connessioni` aggiunge una nuova connessione (dato follower e followed)
  * `GET /connessioni/{id}` trova una connessione dato l’id 
  * `GET /connessioni` trova tutte le connessioni
  * `GET /connessioni-follower?follower={utente}` trova tutte le connessioni di utente (quelle in cui l’utente è follower)

* Il servizio *ricette-seguite* consente a un utente di trovare le ricette di tutti gli utenti che segue. 
  Operazioni: 
  * `GET /ricetteseguite-follower/{utente}` trova tutte le ricette seguite da utente, ovvero le ricette di utenti di cui l’utente è follower (ricette in formato breve, trova solo id, autore e titolo)
     GET/ricetteseguite trova tutte le ricette seguite da tutti gli utenti

* Il servizio *api-gateway* (esposto sulla porta *8080*) è l'API gateway dell'applicazione che: 
  * espone il servizio *ricette* sul path `/ricette` - ad esempio, `GET /ricette/ricette`
  * espone il servizio *connessioni* sul path `/connessioni` - ad esempio, `GET /connessioni/connessioni`
  * espone il servizio *ricette-seguite* sul path `/ricette-seguite` - ad esempio, `GET /ricette-seguite/ricetteseguite/{utente}`



## Esecuzione 

Per eseguire questo progetto: 

* avviare *Consul* eseguendo lo script `start-consul.sh` 
* per avviare kafka ,zookeeper, e i i seguenti database , eseguire lo script 'start-infrastructure'
* per avviare l'applicazione *Instagnam*, eseguire lo script `run-instagnam.sh` 

Alla fine, l'applicazione può essere arrestata usando lo script `stop-java-processes.sh` (**da usare con cautela!**). 

Inoltre, *Consul* può essere arrestato con lo script `stop-consul.sh`. 

Per arrestare kafka ecc usare 'stop-infrastructure'

