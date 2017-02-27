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

            vtmInsertVoilier = connection.prepareStatement("INSERT INTO Voilier (id_voilier, nom_voilier, num_voilier, id_proprietaire, id_classe ) VALUES(?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            vtmInsertVoilier.setInt(1, v.getId_voilier());
            vtmInsertVoilier.setString(2, v.getNom_voilier());
            vtmInsertVoilier.setInt(3, v.getNum_voile());
            vtmInsertVoilier.setInt(4, v.getProprietaire().getId_proprietaire());
            vtmInsertVoilier.setInt(5, v.getClasse().getId_classe());

            vtmInsertVoilier.execute();


            connection.commit();
            vtmInsertVoilier.close();
            vtmInsertVoilier.close();

        } catch (SQLException e) {
            //pb if here
            connection.rollback();
            System.out.println("Erreur pendant la creation du voilier");
            throw new Exception("error" + e.getMessage());
        }
    }
    

    public static List<Voilier> findAllVoilier() {

        Connection connection = ConnectDB.getConnection();

        List<Voilier> Voiliers = new ArrayList<>();
        Statement vtm;
        try {
            vtm = connection.createStatement();

            String sql = "select id_voilier, nom_voilier, num_voile, per.nom_personne, per.prenom_personne, cla.nom_classe from Voilier v INNER JOIN Proprietaire pro ON v.id_proprietaire=pro.id_proprietaire INNER JOIN Classe cla ON v.id_classe=cla.id_classe INNER JOIN Personne per ON pro.id_personne=per.id_personne";
            ResultSet rs = vtm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id_voilier");
                String nomVoilier = rs.getString("nom_voilier");
                int numVoile = rs.getInt("num_voile");
//                Proprietaire proprietaire = ProprietaireDAO.findBy(rs.getInt("pro.id"));
//                Classe classe = ClasseDAO.findBy(rs.getInt("cla.id"));
                Voilier v = new Voilier(id, nomVoilier, numVoile);

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