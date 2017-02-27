/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.DevObjet.models;

import java.util.Calendar;

/**
 *
 * @author rico
 */
public class Personne {
    
    String nom;
    String prenom;
    String email;
    int anneeNaissance;

    public Personne(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Personne(String nom, String prenom, String email, int anneeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
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

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }
    
    
    
    
    public int calculAge() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);

        int age = year - this.getAnneeNaissance();

        return age;
    }

    @Override
    public String toString() {
        return "Nom = " + nom + ", Prénom = " + prenom + ", Email = " + email + ", Age = " + calculAge() + " ans";
    }
     
    

}