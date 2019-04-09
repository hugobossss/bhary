/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bhari;

/**
 *
 * @author bcharles
 */
import java.util.*;

public class ProjetBHARI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Joueur> test = new ArrayList();
        ArrayList<Item> test2 = new ArrayList();
        int test3 = 400;
        int test4 = 500;
        Plateau plat = new Plateau(test,test2,test3,test4);
        System.out.println(plat.PositionJoueurX());
        System.out.println(plat.PositionJoueurY());
        double d = Math.random();
    }
    
}
