/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.DevObjet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import org.rlopez.DevObjet.models.Commissaire;
import org.rlopez.DevObjet.models.Licencie;
import org.rlopez.DevObjet.models.Personne;
import org.rlopez.DevObjet.models.Proprietaire;

/**
 *
 * @author rico
 */
public class DevObjet {

    /**
     * @param args the command line arguments
     */
       
    static ArrayList<Personne> al;
    public static void main(String[] args) {

        Proprietaire pro1 = new Proprietaire("Lamarre", "Chantal", "lamarrechantal@gmail.com", 1955);
        Proprietaire pro2 = new Proprietaire("Boucher", "Denis", "boucherdenis@gmail.com", 1959);
        Licencie lic1 = new Licencie(1598, 55.4, 1999, "Duval", "Camille", "camilleduval@gmail.com", 1988);
        Licencie lic2 = new Licencie(9824, 7.1, 2017, "Depuis", "Lola", "loladupuis@gmail.com", 1974);
        Licencie lic3 = new Licencie(6107, 24, 2011, "Kiev", "Daniel", "danielkiev@gmail.com", 1995);
        Commissaire com1 = new Commissaire("Ile-De-France", "Olivier", "Doyon", "olivierdoyon@gmail.com", 1964);

        al = new ArrayList<>();
        
        al.add(pro1);
        al.add(pro2);
        al.add(lic1);
        al.add(lic2);
        al.add(lic3);
        al.add(com1);


        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }


         
         
         System.out.println("Moyenne d\'âge : " + calculMoyenneAge() + " ans");
         
         System.out.println("Age médian : " + medianeAge());
         
                  System.out.println("\n");

         
         
         
         
        

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2012);
        try {
            lic3.calculPoints(10, c);
            System.out.println("Points ajoutés ! " + lic3.getPrenom() + " a maintenant " + lic3.getPointsFFV() + " points");
        } catch (Exception ex) {
            System.out.println("Impossible d\'ajouter les points, la date n\'est pas identique. " + lic3.getPrenom() + " reste à " + lic3.getPointsFFV() + " points.");
//            Logger.getLogger(DevObjet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    
    
    
    

    public static double calculMoyenneAge() {

        double age = 0;
        double sommeAge = 0;
        double moyenne = 0;
        for (int i = 0; i < al.size(); i++) {
            age = al.get(i).calculAge();
            sommeAge += age;
        }
            moyenne = sommeAge / al.size();
        return moyenne;
    }
    
    
    public static double medianeAge() {
        
        int tblAges[] = new int[al.size()];
        
               for (int i = 0; i < al.size(); i++) {
             tblAges[i] = al.get(i).calculAge();
        }
               
        Arrays.sort(tblAges);
        
        int milieu =  tblAges.length / 2;
        
        if (tblAges.length % 2 == 1 ) {
            return tblAges[milieu];
        }
        else {
            return (tblAges[milieu -1] + tblAges[milieu]) / 2;
        }
            }
    
    

}
