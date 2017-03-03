package org.rlopez.DevObjet.models;

/**
 *
 * @author Richard Lopez
 */
public class Proprietaire extends Personne {

    public Proprietaire(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

    public Proprietaire(String nom, String prenom, String email, int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
    }

    @Override
    public String toString() {
        return "Propriétaire : " + super.toString();
    }

}
