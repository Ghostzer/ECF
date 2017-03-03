package org.rlopez.GUI.models;

/**
 *
 * @author Richard Lopez
 */
public class Personne {

    int id_Personne;
    String nom_personne;
    String prenom_personne;
    String email_personne;
    int num_licence;
    int annee_licence;
    String nom_club;

    public Personne(int id_Personne, String nom_personne, String prenom_personne, String email_personne, int num_licence, int annee_licence, String nom_club) {
        this.id_Personne = id_Personne;
        this.nom_personne = nom_personne;
        this.prenom_personne = prenom_personne;
        this.email_personne = email_personne;
        this.num_licence = num_licence;
        this.annee_licence = annee_licence;
        this.nom_club = nom_club;
    }

    public Personne(String nom_personne, String prenom_personne, String email_personne, int num_licence, int annee_licence, String nom_club) {
        this.nom_personne = nom_personne;
        this.prenom_personne = prenom_personne;
        this.email_personne = email_personne;
        this.num_licence = num_licence;
        this.annee_licence = annee_licence;
        this.nom_club = nom_club;
    }

    public int getId_Personne() {
        return id_Personne;
    }

    public void setId_Personne(int id_Personne) {
        this.id_Personne = id_Personne;
    }

    public String getNom_personne() {
        return nom_personne;
    }

    public void setNom_personne(String nom_personne) {
        this.nom_personne = nom_personne;
    }

    public String getPrenom_personne() {
        return prenom_personne;
    }

    public void setPrenom_personne(String prenom_personne) {
        this.prenom_personne = prenom_personne;
    }

    public String getEmail_personne() {
        return email_personne;
    }

    public void setEmail_personne(String email_personne) {
        this.email_personne = email_personne;
    }

    public int getNum_licence() {
        return num_licence;
    }

    public void setNum_licence(int num_licence) {
        this.num_licence = num_licence;
    }

    public int getAnnee_licence() {
        return annee_licence;
    }

    public void setAnnee_licence(int annee_licence) {
        this.annee_licence = annee_licence;
    }

    public String getNom_club() {
        return nom_club;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    @Override
    public String toString() {
        return "Personne{" + "id_Personne=" + id_Personne + ", nom_personne=" + nom_personne + ", prenom_personne=" + prenom_personne + ", email_personne=" + email_personne + ", num_licence=" + num_licence + ", annee_licence=" + annee_licence + ", nom_club=" + nom_club + '}';
    }

}
