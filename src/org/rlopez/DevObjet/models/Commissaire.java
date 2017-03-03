package org.rlopez.Algo.models;

/**
 *
 * @author Richard Lopez
 */
public class Commissaire extends Personne {

    String commite;

    public Commissaire(String commite, String nom, String prenom, String email) {
        super(nom, prenom, email);
        this.commite = commite;
    }

    public Commissaire(String commite, String nom, String prenom, String email, int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
        this.commite = commite;
    }

    public String getCommite() {
        return commite;
    }

    public void setCommite(String commite) {
        this.commite = commite;
    }

    @Override
    public String toString() {
        return "Commissaire : " + super.toString() + ", Comité = " + commite;
    }

}
