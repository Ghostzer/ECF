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

/**
 *
 * @author rico
 */
public class ClasseDAO {

public static Classe findBy(int id) {
        Classe c = null;
        Connection connection = ConnectDB.getConnection();
        PreparedStatement ptm;
        try {
            ptm = connection.prepareStatement("select * from Classe cla WHERE id_classe= ?");
            ptm.setInt(1, id);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                c = new Classe(rs.getInt("id_classe"), 
                        rs.getString("nom_classe"), 
                        rs.getInt("coef"), 
                        rs.getInt("id_serie"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return c;
    }

public static List<Classe> findAllClasse() {

        Connection connection = ConnectDB.getConnection();

        List<Classe> Classes = new ArrayList<>();
        Statement ctm;
        try {
            ctm = connection.createStatement();

            String sql = "select * from Classe";
            ResultSet rs = ctm.executeQuery(sql);

            while (rs.next()) {
                int idClasse = rs.getInt("id_classe");
                String nomClasse = rs.getString("nom_classe");
                int coef = rs.getInt("coef");
                int idSerie = rs.getInt("id_serie");

                Classe c = new Classe(idClasse, nomClasse, coef, idSerie);

                Classes.add(c);
            }
            rs.close();

        } catch (SQLException e) {
//            throw new RuntimeException();
        }

        return Classes;

    }


}
