package org.rlopez.GUI.models;

/**
 *
 * @author Richard Lopez
 */
public class Classe {

    int id_classe;
    String nom_classe;
    int coef;
    int id_serie;

    public Classe(int id_classe, String nom_classe, int coef, int id_serie) {
        this.id_classe = id_classe;
        this.nom_classe = nom_classe;
        this.coef = coef;
        this.id_serie = id_serie;
    }

    public Classe(int id_classe, String nom_classe) {
        this.id_classe = id_classe;
        this.nom_classe = nom_classe;
    }

    public Classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public String getNom_classe() {
        return nom_classe;
    }

    public void setNom_classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getId_serie() {
        return id_serie;
    }

    public void setId_serie(int id_serie) {
        this.id_serie = id_serie;
    }

    @Override
    public String toString() {
        return nom_classe;
    }

}
