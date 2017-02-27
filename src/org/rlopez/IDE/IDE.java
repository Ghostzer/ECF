/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.IDE;

import java.util.Scanner;
import org.rlopez.IDE.models.MainWindow;

/**
 *
 * @author rico
 */
public class IDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MainWindow mainwindow = new MainWindow();
        mainwindow.setVisible(true);
        mainwindow.setTitle("Ajouter un voilier");
        mainwindow.setLocationRelativeTo(null);

    }
}
