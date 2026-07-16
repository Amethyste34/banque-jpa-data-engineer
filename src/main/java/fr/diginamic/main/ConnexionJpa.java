package fr.diginamic.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Point d'entrée pour tester la connexion JPA et la génération du schéma.
 */
public class ConnexionJpa {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.println("Connexion établie, schéma généré (update).");

        em.close();
        entityManagerFactory.close();
    }
}
