package fr.diginamic.main;

import fr.diginamic.entites.Compte;
import fr.diginamic.entites.Operation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

/**
 * Point d'entrée pour tester l'insertion d'opérations simples.
 */
public class ConnexionJpa {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Récupération du compte existant (id 3 = Livret A)
        Compte compte = em.find(Compte.class, 3);

        Operation depot = new Operation(LocalDateTime.now(), 500.0, "Dépôt espèces");
        depot.setCompte(compte);
        em.persist(depot);

        Operation retrait = new Operation(LocalDateTime.now(), 120.0, "Retrait distributeur");
        retrait.setCompte(compte);
        em.persist(retrait);

        transaction.commit();

        System.out.println("Opération 1 : " + depot);
        System.out.println("Opération 2 : " + retrait);

        em.close();
        entityManagerFactory.close();
    }
}