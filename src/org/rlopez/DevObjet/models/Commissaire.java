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
public class Commissaire extends Personne {
    
    String commite;

    public Commissaire(String commite, String nom, String prenom, String email) {
        super(nom, prenom, email);
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
        return "Commissaire{" + super.toString() + "commite=" + commite + '}';
    }
    
    
    
}
