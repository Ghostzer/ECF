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
            stm = connection.prepareStatement("select * from Serie WHERE id= ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                s = new Serie(rs.getInt("id"), rs.getString("nom"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return s;
    }
    
}
