/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.DevObjet;

import org.rlopez.DevObjet.models.Licencie;
import org.rlopez.DevObjet.models.Personne;

/**
 *
 * @author rico
 */
public class DevObjet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Personne p = new Personne("rico", "pouet", "gg@gg.gg", 1986);
System.out.println(p.toString());

Licencie l = new Licencie(5484, 5.0, 2011, "rico", "pouet", "gg@gg.gg");
System.out.println(l.toString());

    }
    
}
