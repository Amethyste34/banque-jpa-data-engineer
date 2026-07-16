package fr.diginamic.main;

import fr.diginamic.entites.Adresse;
import fr.diginamic.entites.AssuranceVie;
import fr.diginamic.entites.Banque;
import fr.diginamic.entites.ClientBanque;
import fr.diginamic.entites.LivretA;
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
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Banque nécessaire pour rattacher les comptes
        Banque banque = new Banque("BNP Paribas");
        entityManager.persist(banque);

        // Client avec adresse
        ClientBanque client = new ClientBanque("Lefevre", "Sophie", LocalDate.of(1978, 11, 5));
        Adresse adresse = new Adresse(8, "Rue Victor Hugo", 69002, "Lyon");
        client.setAdresse(adresse);
        entityManager.persist(client);

        // Compte Assurance Vie
        AssuranceVie assuranceVie = new AssuranceVie("AV-1001", 5000.0, LocalDate.of(2035, 12, 31), 2.5);
        assuranceVie.setBanque(banque);
        List<ClientBanque> clientsAV = new ArrayList<>();
        clientsAV.add(client);
        assuranceVie.setClients(clientsAV);
        entityManager.persist(assuranceVie);

        // Compte Livret A
        LivretA livretA = new LivretA("LA-2002", 3000.0, 3.0);
        livretA.setBanque(banque);
        List<ClientBanque> clientsLA = new ArrayList<>();
        clientsLA.add(client);
        livretA.setClients(clientsLA);
        entityManager.persist(livretA);

        transaction.commit();

        System.out.println("Client créé : " + client);
        System.out.println("Compte Assurance Vie : " + assuranceVie);
        System.out.println("Compte Livret A : " + livretA);

        entityManager.close();
        entityManagerFactory.close();
    }
}