/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.IDE.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.rlopez.IDE.models.Classe;
import org.rlopez.IDE.models.Proprietaire;

import org.rlopez.IDE.models.Voilier;
/**
 *
 * @author rico
 */
public class VoilierDAO {
    
    public static void insert(Voilier v) throws Exception {
        Connection connection = ConnectDB.getConnection();

        PreparedStatement vtmInsertVoilier;
        try {
            connection.setAutoCommit(false);

            vtmInsertVoilier = connection.prepareStatement("INSERT INTO Voilier (id_voilier, nom_voilier, num_voile, id_proprietaire, id_classe ) VALUES(?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            vtmInsertVoilier.setInt(1, v.getId_voilier());
            vtmInsertVoilier.setString(2, v.getNom_voilier());
            vtmInsertVoilier.setInt(3, v.getNum_voile());
            vtmInsertVoilier.setInt(4, v.getProprietaire().getId_proprietaire());
            vtmInsertVoilier.setInt(5, v.getClasse().getId_classe());

            vtmInsertVoilier.execute();


            connection.commit();
            vtmInsertVoilier.close();
//            vtmInsertVoilier.close();

        } catch (SQLException e) {
            //pb if here
            e.printStackTrace();
            e.getMessage();
            connection.rollback();
            System.out.println("Erreur pendant la creation du voilier");
            throw new Exception("Erreur pendant la creation du voilier" + e.getMessage());
        }
    }
    

    public static List<Voilier> findAllVoilier() {

        Connection connection = ConnectDB.getConnection();

        List<Voilier> Voiliers = new ArrayList<>();
        Statement vtm;
        try {
            vtm = connection.createStatement();

            String sql = "select pro.id_proprietaire, per.id_personne, nom_voilier, num_voile, per.nom_personne, per.prenom_personne, per.email_personne, per.num_licence, per.annee_licence, per.nom_club, cla.nom_classe from Voilier v INNER JOIN Proprietaire pro ON v.id_proprietaire=pro.id_proprietaire INNER JOIN Classe cla ON v.id_classe=cla.id_classe INNER JOIN Personne per ON pro.id_personne=per.id_personne";
            ResultSet rs = vtm.executeQuery(sql);

            while (rs.next()) {
//                int id = rs.getInt("id_voilier");
                String nom_voilier = rs.getString("nom_voilier");
                int num_voile = rs.getInt("num_voile");
            Proprietaire proprietaire = new Proprietaire(rs.getInt("pro.id_proprietaire"), rs.getInt("per.id_personne"), rs.getString("per.nom_personne"), rs.getString("per.prenom_personne"), rs.getString("per.email_personne"), rs.getInt("per.num_licence"), rs.getInt("per.annee_licence"), rs.getString("per.nom_club"));
                
                Classe classe = new Classe(rs.getString("cla.nom_classe"));
                Voilier v = new Voilier(nom_voilier, num_voile, proprietaire, classe);

                Voiliers.add(v);
            }
            rs.close();

        } catch (SQLException e) {
//            throw new RuntimeException();
        }

        return Voiliers;

    }
    
//    public static void updateStagiaire(Stagiaire s) throws Exception {
//        Connection connection = ConnectDB.getConnection();
//
//        PreparedStatement stmUpdatePersonne;
//        PreparedStatement stmCreateStagiaire;
//        try {
//            connection.setAutoCommit(false);
//
//            stmUpdatePersonne = connection.prepareStatement("UPDATE Personne SET nom = ?, prenom = ? WHERE id = ?");
//            stmUpdatePersonne.setString(1, s.getNom());
//            stmUpdatePersonne.setString(2, s.getPrenom());
//            stmUpdatePersonne.setInt(3, s.getId());
//
//            stmUpdatePersonne.execute();
//
//            
//
//            connection.commit();
//            stmUpdatePersonne.close();
//
//        } catch (SQLException e) {
//            //pb if here
//            connection.rollback();
//            throw new Exception("error while creating personne " + e.getMessage());
//        }
//    }
    
//        public static void supprimerStagiaire(Stagiaire s) {
//        Connection connection = ConnectDB.getConnection();
//        PreparedStatement stm;
//        try {
//
//            stm = connection.prepareStatement("DELETE FROM Personne WHERE id = ?");
//            stm.setInt(1, s.getId());
//            stm.executeUpdate();
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//    }

}