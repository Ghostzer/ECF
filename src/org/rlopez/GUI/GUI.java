package org.rlopez.GUI;

import org.rlopez.GUI.models.MainWindow;

/**
 *
 * @author Richard Lopez
 */
public class GUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MainWindow mainwindow = new MainWindow();
        mainwindow.setVisible(true);
        mainwindow.setTitle("Ajouter un voilier");
        mainwindow.setLocationRelativeTo(null);

    }
}
