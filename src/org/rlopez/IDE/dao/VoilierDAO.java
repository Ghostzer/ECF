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
import org.rlopez.IDE.models.Proprietaire;
import org.rlopez.IDE.models.Serie;
import org.rlopez.IDE.models.Voilier;
/**
 *
 * @author rico
 */
public class VoilierDAO {
//    public static void insert(Voilier v) throws Exception {
//        Connection connection = ConnectDB.getConnection();
//
//        PreparedStatement stmCreatePersonne;
//        PreparedStatement stmCreateStagiaire;
//        try {
//            connection.setAutoCommit(false);
//
//            stmCreatePersonne = connection.prepareStatement("INSERT INTO Personne (nom, prenom) VALUES(?, ?);", Statement.RETURN_GENERATED_KEYS);
//            stmCreatePersonne.setString(1, s.getNom());
//            stmCreatePersonne.setString(2, s.getPrenom());
//
//            stmCreatePersonne.execute();
//
//            // get autoincrement pour récupérer l'ID de la Personne nouvellement créée
//            ResultSet rs = stmCreatePersonne.getGeneratedKeys();
//            if (!rs.next()) {
//                throw new Exception("humm cannot get generated personne id");
//            }
//            s.setId(rs.getInt(1));
//
//            stmCreateStagiaire = connection.prepareStatement("INSERT INTO Stagiaire (Matricule, id_personne, id_formation) VALUES(?, ?, ?);");
//            stmCreateStagiaire.setInt(1, s.getMatricule());
//            stmCreateStagiaire.setInt(2, s.getId());
//            stmCreateStagiaire.setInt(3, s.getFormation().getId());
//
//            stmCreateStagiaire.execute();
//
//            connection.commit();
//            stmCreatePersonne.close();
//            stmCreateStagiaire.close();
//
//        } catch (SQLException e) {
//            //pb if here
//            connection.rollback();
//            throw new Exception("error while creating personne " + e.getMessage());
//        }
//    }
    

    public static List<Voilier> findAllVoilier() {

        Connection connection = ConnectDB.getConnection();

        List<Voilier> Voiliers = new ArrayList<>();
        Statement vtm;
        try {
            vtm = connection.createStatement();

            String sql = "select * from Voilier v INNER JOIN Proprietaire pro ON v.id_proprietaire=pro.id_proprietaire INNER JOIN Serie s ON v.id_serie=s.id_serie INNER JOIN Personne per ON pro.id_personne=per.id_personne";
            ResultSet rs = vtm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomVoilier = rs.getString("nom_voilier");
                int numVoile = rs.getInt("num_voile");
                Proprietaire proprietaire = ProprietaireDAO.findBy(rs.getInt("pro.id"));
                Serie serie = SerieDAO.findBy(rs.getInt("s.id"));
                Voilier v = new Voilier(id, nomVoilier, numVoile, proprietaire, serie);

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