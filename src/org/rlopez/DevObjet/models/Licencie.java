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
public class Licencie extends Personne {
    
    int numLicence;
    double pointsFFV;
    int anneeLicence;

    public Licencie(int numLicence, double pointsFFV, int anneeLicence, String nom, String prenom, String email) {
        super(nom, prenom, email);
        this.numLicence = numLicence;
        this.pointsFFV = pointsFFV;
        this.anneeLicence = anneeLicence;
    }

    public Licencie(int numLicence, double pointsFFV, int anneeLicence, String nom, String prenom, String email, int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
        this.numLicence = numLicence;
        this.pointsFFV = pointsFFV;
        this.anneeLicence = anneeLicence;
    }
    
    
    
    

    public int getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(int numLicence) {
        this.numLicence = numLicence;
    }

    public double getPointsFFV() {
        return pointsFFV;
    }

    public void setPointsFFV(double pointsFFV) {
        this.pointsFFV = pointsFFV;
    }

    public int getAnneeLicence() {
        return anneeLicence;
    }

    public void setAnneeLicence(int anneeLicence) {
        this.anneeLicence = anneeLicence;
    }

    
    @Override
    public String toString() {
        return "Licencié : " + super.toString() + ", Numéro Licence = " + numLicence + ", PointsFFV = " + pointsFFV + ", Année de licence = " + anneeLicence;
    }
    
    
    
    
    
    
}
