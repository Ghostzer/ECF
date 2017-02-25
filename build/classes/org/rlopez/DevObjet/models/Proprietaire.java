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

    @Override
    public String toString() {
        return "Proprietaire{" + super.toString() + '}';
    }
    
    
    
}
