package fr.diginamic.entites;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Entité représentant un client de la banque.
 * Renommée depuis "Client" pour éviter les conflits avec les entités du TP4.
 */
@Entity
@Table(name = "CLIENT_BANQUE")
public class ClientBanque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToMany(mappedBy = "clients")
    private List<Compte> comptes;

    public ClientBanque() {
    }

    public ClientBanque(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "ClientBanque{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "', dateNaissance=" + dateNaissance + "}";
    }
}