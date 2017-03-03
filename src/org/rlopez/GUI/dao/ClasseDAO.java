package org.rlopez.GUI.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.rlopez.GUI.models.Classe;

/**
 *
 * @author Richard Lopez
 */
public class ClasseDAO {

    public static List<Classe> findBy(int serie) {
        Connection connection = ConnectDB.getConnection();

        List<Classe> classes = new ArrayList<>();
        Statement stm;

        try {
            stm = connection.createStatement();

            String sql = "select * from Classe cla WHERE cla.id_serie=" + serie;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id_voilier = rs.getInt("id_classe");
                String nom = rs.getString("nom_classe");
                int coef = rs.getInt("coef");
                int id_serie = rs.getInt("id_serie");
                Classe c = new Classe(id_voilier, nom, coef, id_serie);

                classes.add(c);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;

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
            throw new RuntimeException();
        }

        return Classes;

    }

}
