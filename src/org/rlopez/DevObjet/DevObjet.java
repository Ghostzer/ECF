/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.DevObjet;

import java.util.ArrayList;
import org.rlopez.DevObjet.models.Commissaire;
import org.rlopez.DevObjet.models.Licencie;
import org.rlopez.DevObjet.models.Proprietaire;

/**
 *
 * @author rico
 */
public class DevObjet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Personne p = new Personne("rico", "pouet", "gg@gg.gg", 31);
//        Personne p2 = new Personne("huhu", "pouhuhuhuhuhuet", "gg@gg.gg", 1986);
        Proprietaire pro1 = new Proprietaire("Lamarre", "Chantal", "lamarrechantal@gmail.com", 1955);
        Proprietaire pro2 = new Proprietaire("Boucher", "Denis", "boucherdenis@gmail.com", 1959);
        Licencie lic1 = new Licencie(1598, 55.4, 1999, "Duval", "Camille", "camilleduval@gmail.com", 1988);
        Licencie lic2 = new Licencie(9824, 7.1, 2017, "Depuis", "Lola", "loladupuis@gmail.com", 1974);
        Licencie lic3 = new Licencie(6107, 24, 2011, "Kiev", "Daniel", "danielkiev@gmail.com", 1995);
        Commissaire com1 = new Commissaire("Ile-De-France", "Olivier", "Doyon", "olivierdoyon@gmail.com", 1964);

        ArrayList al = new ArrayList();
        al.add(pro1);
        al.add(pro2);
        al.add(lic1);
        al.add(lic2);
        al.add(lic3);
        al.add(com1);

        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }

        System.out.println("Moyenne : " + calculMoyenneAge());
        

    }
    
    public static double calculMoyenneAge() {
        Proprietaire pro3 = new Proprietaire("Lamarre", "Chantal", "lamarrechantal@gmail.com", 1955);
        Proprietaire pro4 = new Proprietaire("Boucher", "Denis", "boucherdenis@gmail.com", 1959);

        ArrayList al = new ArrayList();
        al.add(pro3);
        al.add(pro4);
        

        double nb = al.size();
        double moyenne = (pro3.calculAge() + pro4.calculAge()) / nb;
        return moyenne;

    }
    
    public static double calculMedianeAge() {
    
        
        
    return 0;
    }

}