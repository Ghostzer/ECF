/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.DevObjet.models;

/**
 *
 * @author rico
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
