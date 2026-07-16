package fr.diginamic.main;

import fr.diginamic.entites.Adresse;
import fr.diginamic.entites.Banque;
import fr.diginamic.entites.ClientBanque;
import fr.diginamic.entites.Compte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Point d'entrée pour tester la connexion JPA et les insertions.
 */
public class ConnexionJpa {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Création d'une banque
        Banque banque = new Banque("Crédit Agricole");
        em.persist(banque);

        // Création de 2 clients
        ClientBanque client1 = new ClientBanque("Dupont", "Marie", LocalDate.of(1985, 3, 12));
        Adresse adresse1 = new Adresse(12, "Rue des Lilas", 34000, "Montpellier");
        client1.setAdresse(adresse1);
        ClientBanque client2 = new ClientBanque("Martin", "Julien", LocalDate.of(1990, 7, 22));
        Adresse adresse2 = new Adresse(5, "Avenue Foch", 75116, "Paris");
        client2.setAdresse(adresse2);
        em.persist(client1);
        em.persist(client2);

        // Création d'un compte associé à la banque et aux 2 clients
        Compte compte = new Compte("FR76-0001", 1500.0);
        compte.setBanque(banque);

        List<ClientBanque> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        compte.setClients(clients);

        em.persist(compte);

        transaction.commit();

        System.out.println("Insertion terminée : " + compte);

        em.close();
        entityManagerFactory.close();
    }
}