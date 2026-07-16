package fr.diginamic.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDate;

/**
 * Entité représentant un compte de type Assurance Vie.
 * Hérite de Compte (stratégie SINGLE_TABLE).
 */
@Entity
@DiscriminatorValue("ASSURANCE_VIE")
public class AssuranceVie extends Compte {

    private LocalDate dateFin;

    private double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{id=" + getId() + ", numero='" + getNumero() + "', solde=" + getSolde() + ", dateFin=" + dateFin + ", taux=" + taux + "}";
    }
}