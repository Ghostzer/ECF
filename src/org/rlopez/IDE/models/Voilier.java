/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.IDE.models;

import java.util.ArrayList;

/**
 *
 * @author rico
 */
public class Voilier {
    
    int id_voilier;
    String nom_voilier;
    int num_voile;
    
//    ArrayList<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
//    ArrayList<Serie> series = new ArrayList<Serie>();

    public Voilier(int id_voilier, String nom_voilier, int num_voile) {
        this.id_voilier = id_voilier;
        this.nom_voilier = nom_voilier;
        this.num_voile = num_voile;
    }
    
        public Voilier(int id_voilier, String nom_voilier, int num_voile, Proprietaire proprietaire, Serie serie) {
        this.id_voilier = id_voilier;
        this.nom_voilier = nom_voilier;
        this.num_voile = num_voile;
    }
    
    

    public int getId_voilier() {
        return id_voilier;
    }

    public void setId_voilier(int id_voilier) {
        this.id_voilier = id_voilier;
    }

    public String getNom_voilier() {
        return nom_voilier;
    }

    public void setNom_voilier(String nom_voilier) {
        this.nom_voilier = nom_voilier;
    }

    public int getNum_voile() {
        return num_voile;
    }

    public void setNum_voile(int num_voile) {
        this.num_voile = num_voile;
    }

    @Override
    public String toString() {
        return "Voilier{" + "id_voilier=" + id_voilier + ", nom_voilier=" + nom_voilier + ", num_voile=" + num_voile + '}';
    }
    
    
    
}
