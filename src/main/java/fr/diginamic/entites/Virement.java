package fr.diginamic.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Entité représentant une opération de type virement.
 * Hérite de Operation (stratégie SINGLE_TABLE).
 */
@Entity
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation {

    private String beneficiaire;

    public Virement() {
    }

    public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        return "Virement{id=" + getId() + ", date=" + getDate() + ", montant=" + getMontant() + ", motif='" + getMotif() + "', beneficiaire='" + beneficiaire + "'}";
    }
}