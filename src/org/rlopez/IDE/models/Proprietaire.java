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
public class Proprietaire extends Personne {
    
    int id;

    public Proprietaire(int id, int idPersonne, String nom, String prenom, String email, int numLicence, int anneeLicence, String nomClub) {
        super(idPersonne, nom, prenom, email, numLicence, anneeLicence, nomClub);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }

    
    
}
