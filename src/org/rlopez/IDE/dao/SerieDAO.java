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
import org.rlopez.IDE.models.Serie;

/**
 *
 * @author rico
 */
public class SerieDAO {
    
    public static Serie findBy(int id) {
        Serie s = null;
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement("select * from Serie WHERE id_serie= ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                s = new Serie(rs.getInt("id_serie"),
                        rs.getString("nom_serie"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return s;
    }
    
    public static List<Serie> findAllSerie() {

        Connection connection = ConnectDB.getConnection();

        List<Serie> series = new ArrayList<>();
        Statement stm;
        try {
            stm = connection.createStatement();

            String sql = "select * from Serie";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id_serie = rs.getInt("id_serie");
                String nom_serie = rs.getString("nom_serie");


                Serie s = new Serie(id_serie, nom_serie);

                series.add(s);
            }
            rs.close();

        } catch (SQLException e) {
//            throw new RuntimeException();
        }

        return series;

    }
    
}
