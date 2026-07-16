package fr.diginamic.main;

import fr.diginamic.entites.Compte;
import fr.diginamic.entites.Virement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

/**
 * Point d'entrée pour tester l'insertion d'opérations de type virement.
 */
public class ConnexionJpa {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Récupération du compte existant (id 2 = Assurance Vie)
        Compte compte = em.find(Compte.class, 2);

        Virement virement1 = new Virement(LocalDateTime.now(), 250.0, "Virement loyer", "Régie Immobilière SARL");
        virement1.setCompte(compte);
        em.persist(virement1);

        Virement virement2 = new Virement(LocalDateTime.now(), 80.0, "Remboursement ami", "Julien Martin");
        virement2.setCompte(compte);
        em.persist(virement2);

        transaction.commit();

        System.out.println("Virement 1 : " + virement1);
        System.out.println("Virement 2 : " + virement2);

        em.close();
        entityManagerFactory.close();
    }
}