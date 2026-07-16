package fr.diginamic.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Entité représentant un compte de type Livret A.
 * Hérite de Compte (stratégie SINGLE_TABLE).
 */
@Entity
@DiscriminatorValue("LIVRET_A")
public class LivretA extends Compte {

    private double taux;

    public LivretA() {
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{id=" + getId() + ", numero='" + getNumero() + "', solde=" + getSolde() + ", taux=" + taux + "}";
    }
}