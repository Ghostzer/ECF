/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.VerificationEmail;

/**
 *
 * @author rico
 */
public class VerificationEmail {

    public static void main(String[] args) {

        String email;
        String regex = "^[_A-Za-z0-9-]{2,}+@[A-Za-z0-9-]{2,}+(\\.[A-Za-z]{2,})$";
        email = "test@test.test";
        Boolean b = email.matches(regex);

        if (b == false) {
            System.out.println("NON ! L\'adresse n\'est PAS valide");
        } else if (b == true) {
            System.out.println("OUI ! L\'adresse est valide !");
        }

    }

}