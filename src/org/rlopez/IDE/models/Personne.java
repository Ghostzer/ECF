/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.IDE.models;

/**
 *
 * @author rico
 */
public class Personne {
    
    int idPersonne;
    String nom;
    String prenom;
    String email;
    int numLicence;
    int anneeLicence;
    String nomClub;

    public Personne(int idPersonne, String nom, String prenom, String email, int numLicence, int anneeLicence, String nomClub) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numLicence = numLicence;
        this.anneeLicence = anneeLicence;
        this.nomClub = nomClub;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(int numLicence) {
        this.numLicence = numLicence;
    }

    public int getAnneeLicence() {
        return anneeLicence;
    }

    public void setAnneeLicence(int anneeLicence) {
        this.anneeLicence = anneeLicence;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    @Override
    public String toString() {
        return "Personne{" + "idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", numLicence=" + numLicence + ", anneeLicence=" + anneeLicence + ", nomClub=" + nomClub + '}';
    }
    
    
    
}
