/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.IDE.dao;

import org.rlopez.IDE.models.Proprietaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.rlopez.IDE.models.Serie;
import org.rlopez.IDE.models.Voilier;

/**
 *
 * @author rico
 */
public class ProprietaireDAO {

    public static Proprietaire findBy(int id) {
        Proprietaire p = null;
        Connection connection = ConnectDB.getConnection();
        PreparedStatement ptm;
        try {
            ptm = connection.prepareStatement("select * from Proprietaire pro INNER JOIN Personne per ON pro.id_personne=per.id_personne WHERE id= ?");
            ptm.setInt(1, id);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                p = new Proprietaire(rs.getInt("id"), rs.getInt("per.id_personne"), rs.getString("per.nom_personne"), rs.getString("per.prenom_personne"), rs.getString("per.email_personne"), rs.getInt("per.num_licence"), rs.getInt("per.annee_licence"), rs.getString("per.nom_club"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return p;
    }

    public static List<Proprietaire> findAllProprietaire() {

        Connection connection = ConnectDB.getConnection();

        List<Proprietaire> Proprietaires = new ArrayList<>();
        Statement ptm;
        try {
            ptm = connection.createStatement();

            String sql = "select * from Proprietaire pro INNER JOIN Personne per ON pro.id_personne=per.id_personne";
            ResultSet rs = ptm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id_proprietaire");
                int idPersonne = rs.getInt("per.id_personne");
                String nomPersonne = rs.getString("per.nom_personne");
                String prenomPersonne = rs.getString("per.prenom_personne");
                String emailPersonne = rs.getString("per.email_personne");
                int numLicence = rs.getInt("per.num_licence");
                int anneeLicence = rs.getInt("per.annee_licence");
                String nomClub = rs.getString("per.nom_club");
                Proprietaire p = new Proprietaire(id, idPersonne, nomPersonne, prenomPersonne, emailPersonne, numLicence, anneeLicence, nomClub);

                Proprietaires.add(p);
            }
            rs.close();

        } catch (SQLException e) {
//            throw new RuntimeException();
        }

        return Proprietaires;

    }

}
