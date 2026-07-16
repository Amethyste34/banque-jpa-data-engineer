package fr.diginamic.entites;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entité représentant un compte bancaire.
 * Classe parente pour les types de comptes spécifiques (LivretA, AssuranceVie).
 */
@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;

    private double solde;

    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;

    @ManyToMany
    @JoinTable(
            name = "COMPTE_CLIENT",
            joinColumns = @JoinColumn(name = "ID_COMPTE"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLIENT")
    )
    private List<ClientBanque> clients;

    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;

    public Compte() {
    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<ClientBanque> getClients() {
        return clients;
    }

    public void setClients(List<ClientBanque> clients) {
        this.clients = clients;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Compte{id=" + id + ", numero='" + numero + "', solde=" + solde + "}";
    }
}