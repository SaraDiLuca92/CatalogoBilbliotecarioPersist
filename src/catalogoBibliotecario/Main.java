package catalogoBibliotecario;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;


public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Utente utente1 = new Utente();
        utente1.setNome("Mario");
        utente1.setCognome("Rossi");
        utente1.setDataNascita(LocalDate.of(1991, 4, 23));
        utente1.setNumero_tessera(12345);

        Utente utente2 = new Utente();
        utente2.setNome("Sara");
        utente2.setCognome("Di Luca");
        utente2.setDataNascita(LocalDate.of(1992, 7, 11));
        utente2.setNumero_tessera(1111);
        
        
        Libri libro1 = new Libri();
        libro1.setISBN(9978L);
        libro1.setTitolo("La donna ignara");
        libro1.setAutore("Carlo Ballerini");
        libro1.setGenere("Thriller");
        libro1.setAnno_di_pubblicazione(1990);
        libro1.setNumero_di_pagine(800);
        
        Libri libro2 = new Libri();
        libro2.setISBN(9567L);
        libro2.setTitolo("Il trono di spade");
        libro2.setAutore("George R.R.Martin");
        libro2.setGenere("Fantasy");
        libro2.setAnno_di_pubblicazione(1958);
        libro2.setNumero_di_pagine(1000);

   

        Riviste rivista1 = new Riviste();
        rivista1.setISBN(9848L);
        rivista1.setTitolo("Witch: il mondo di Kandrakar");
        rivista1.setAnno_di_pubblicazione(2005);
        rivista1.setNumero_di_pagine(70);
        rivista1.setPeriodicità(periodicità.MENSILE);

        Riviste rivista2 = new Riviste();
        rivista2.setISBN(9888L);
        rivista2.setTitolo("La zona fantasma");
        rivista2.setAnno_di_pubblicazione(2022);
        rivista2.setNumero_di_pagine(112);
        rivista2.setPeriodicità(periodicità.SETTIMANALE);
        
        Prestito prestito1=new Prestito(); 
        prestito1.setUtente(utente1);
        prestito1.setRivista(rivista2);
        prestito1.setDataInizioPrestito(LocalDate.of(2022, 12, 12));
        prestito1.setLibro(libro2);
      
        Prestito prestito2=new Prestito(); 
        prestito2.setUtente(utente2);
        prestito2.setLibro(libro2);
        prestito2.setDataInizioPrestito(LocalDate.of(2022, 05, 12));
        prestito2.setDataRestituzioneEffettiva(LocalDate.of(2022, 12, 10));
      
        

        em.getTransaction().begin();
        em.persist(utente1);
        em.persist(utente2);
        em.persist(libro1);
        em.persist(libro2);
        em.persist(rivista1);
        em.persist(rivista2);
        em.persist(prestito1);
        em.persist(prestito2);
        em.getTransaction().commit();

        // Ricerca dei prodotti per ISBN
        Long isbnToSearch = 9848L;
        List<Riviste> r = em.createQuery("SELECT r FROM Riviste r WHERE r.ISBN = :isbn", Riviste.class)
                .setParameter("isbn", isbnToSearch)
                .getResultList();

        // Stampa dei prodotti trovati
        if (r.isEmpty()) {
            System.out.println("Nessun prodotto trovato con l'ISBN " + isbnToSearch);
        } else {
            System.out.println("Prodotti trovati con l'ISBN " + isbnToSearch + ":");
            for (Prodotti prodotto : r) {
                System.out.println(prodotto.getTitolo());
            }
        }

        // Ricerca per anno di pubblicazione
        int annoToSearch = 2005;
        List<Riviste> riv = em.createQuery("SELECT riv FROM Riviste riv WHERE riv.anno_di_pubblicazione = :anno_di_pubblicazione", Riviste.class)
                .setParameter("anno_di_pubblicazione", annoToSearch)
                .getResultList();

        if (riv.isEmpty()) {
            System.out.println("Nessun prodotto trovato con l'anno " + annoToSearch);
        } else {
            System.out.println("Prodotti trovati con l'anno " + annoToSearch + ":");
            for (Prodotti prodotto : riv) {
                System.out.println(prodotto.getTitolo());
           

            }
        }
        
     // Ricerca per autore
        String autoreToSearch = "George R.R.Martin";
        List<Libri> lib = em.createQuery("SELECT lib FROM Libri lib WHERE lib.autore = :autore", Libri.class)
                .setParameter("autore", autoreToSearch)
                .getResultList();

        if (lib.isEmpty()) {
            System.out.println("Nessun prodotto trovato con l'autore " + autoreToSearch);
        } else {
            System.out.println("Prodotti trovati con l'autore " + autoreToSearch + ":");
            for (Libri prodotto : lib) {
                System.out.println(prodotto.getAutore() + " " + prodotto.getTitolo());
            }
        }

        // Ricerca per titolo o parte di esso
        String titoloToSearch = "%fantasma%";
        List<Riviste> rivis = em.createQuery("SELECT rivis FROM Riviste rivis WHERE rivis.titolo LIKE :titolo", Riviste.class)
                .setParameter("titolo", titoloToSearch)
                .getResultList();

        if (rivis.isEmpty()) {
            System.out.println("Nessun prodotto trovato con il titolo " + titoloToSearch);
        } else {
            System.out.println("Prodotti trovati con il titolo " + titoloToSearch + ":");
            for (Riviste prodotto : rivis) {
                System.out.println(prodotto.getTitolo());
            }
        }
        
       
       
       
        // Rimozione prodotto tramite ISBN
        Long isbnToRemove = 9978L;
        Libri libroToRemove = em.find(Libri.class, isbnToRemove);
        if (libroToRemove != null) {
            em.getTransaction().begin();
            em.remove(libroToRemove);
            em.getTransaction().commit();
            System.out.println("Libro rimosso con successo.");
        } else {
            System.out.println("Nessun libro trovato con l'ISBN " + isbnToRemove);
        }


        em.close();
        emf.close();
           }  
      
    }

