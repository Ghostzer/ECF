package org.rlopez.DevObjet.models;

import java.util.Calendar;

/**
 *
 * @author Richard Lopez
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

    public void calculPoints(double pts, Calendar annee) throws Exception {

        if (this.getAnneeLicence() == annee.get(Calendar.YEAR)) {
            pointsFFV = pointsFFV + pts;
        } else {
            throw new Exception("error");
        }

    }

    @Override
    public String toString() {
        return "Licencié : " + super.toString() + ", Numéro Licence = " + numLicence + ", PointsFFV = " + pointsFFV + ", Année de licence = " + anneeLicence;
    }

}
