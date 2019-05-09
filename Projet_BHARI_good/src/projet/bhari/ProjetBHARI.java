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
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ProjetBHARI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       
        Database sql = new Database();
        Coordonnees C = new Coordonnees(100, 100);
        Coordonnees C1 = new Coordonnees(100, 100);
        Coordonnees C2 = new Coordonnees(100, 100);
        Coordonnees C3 = new Coordonnees(100, 100);
        Coordonnees Citem = new Coordonnees(101, 101);
        
        Joueur J = new Joueur("Hugo");
        Joueur J1 = new Joueur("Hug");
        Joueur J2 = new Joueur("Hu");
        Joueur J3 = new Joueur("H");
        J.setCouleurJoueur("rouge");
        J1.setCouleurJoueur("bleu");
        J2.setCouleurJoueur("vert");
        J3.setCouleurJoueur("noir");  
        J1.setCoordonneesJoueur(C1);
        J2.setCoordonneesJoueur(C2);
        J3.setCoordonneesJoueur(C3);
        J.setCoordonneesJoueur(C);
        J.setNomIcon("erf.png");
        J1.setNomIcon("vert.png");
        J2.setNomIcon("rouge.png");
        J3.setNomIcon("noire.png");
        J.setStatut(1);
        J1.setStatut(1);
        J2.setStatut(1);
        J3.setStatut(1);
        J.setVitesse(10);
        J1.setVitesse(10);
        J2.setVitesse(10);
        J3.setVitesse(10);
        sql.ConnectBase();
        sql.SetJoueur(J);
        sql.SetJoueur(J1);
        sql.SetJoueur(J2);
        sql.SetJoueur(J3);
        //sql.afficherJoueurs(J);
        
        //sql.gameStarted(4);
        // item

        //ArrayList<Item> ListItem = null;
        //Item item = new Item("tp",new Coordonnees((int)(Math.random()*1022),(int)(Math.random()*845)),"normal");
        //ListItem.add(item);
        //J.setListItem(ListItem);
        //
        ArrayList<Joueur> ListeJoueurReseau = new ArrayList<Joueur>();
        ListeJoueurReseau.add(J);
        ListeJoueurReseau.add(J1);
        ListeJoueurReseau.add(J2);
        ListeJoueurReseau.add(J3);

        //sql.miseAJourListeJoueurReseau("Hugo");
        //sql.UpdateVitesse(12,J);
//        
//        
//       // déplacement joueur et sauvegarde trace
////       for(int i=0; i<5;i++){
////        C.setX(100+10*i);
////        J.setCoordonneesJoueur(C);
////        sql.UpdatedTrace(J);
////       }
////       sql.afficherTrace(J);
////       sql.SelectTrace(J);
//       //sql.gameStarted(1);
//       
//       
//       
//       //-------------------------------------------
//       //Soit :
//      // sql.UpdatedTrace(J);
//      // sql.SelectTrace(J);
//       //-------------------------------------------
//       //Soit : (plus rapide)
//       // sql.UpdatedCoord(J);
//      //  sql.SelectCoord(J);
//      //-------------------------------------------
//       
//      
//      //sql.miseAJourListeJoueurReseau();
//       


        Plateau p = new Plateau(ListeJoueurReseau,100,100);
        sql.gameStarted(4);
        System.out.println(sql.gameStarted(4));
        System.out.println("miseAJourListeJoueurReseau");
        ListeJoueurReseau = sql.miseAJourListeJoueurReseau(J.getJoueurName());
        System.out.println(ListeJoueurReseau.get(0).getCoordonneesJoueur());
        System.out.println(ListeJoueurReseau.get(1).getCoordonneesJoueur());
         

         
         
         
         
        //p.MiseAJourAutreJoueur(ListeJoueurReseau); // argument pb
//        System.out.println("MiseAJourAutreJoueur");
//        p.Gestiondeplacement();
//        System.out.println("Gestiondeplacement");
//        p.MiseAJourJoueur();
//        System.out.println("MiseAJourJoueur");
//        sql.UpdatedCoord(ListeJoueurReseau.get(0));
//        System.out.println("UpdatedCoord");
//        p.MiseAJourAutreJoueur(ListeJoueurReseau);
//        System.out.println("MiseAJourAutreJoueur");


        sql.DeleteJoueur(J);
//        sql.DeleteJoueur(J1);
//        sql.DeleteJoueur(J2);
//        sql.DeleteJoueur(J3);
        sql.DeleteTrace(J);
        sql.DisconnectBase();

        // ArrayList<String> cars = new ArrayList<String>();
        // cars.add("String") ;  
    }
}

//
// Database sql = new Database();
//        Coordonnees C = new Coordonnees(100, 100);
//        Coordonnees C1 = new Coordonnees(100, 100);
//        Coordonnees C2 = new Coordonnees(100, 100);
//        Coordonnees C3 = new Coordonnees(100, 100);
//        Coordonnees Citem = new Coordonnees(101, 101);
//        Joueur J = new Joueur("Hugo");
//        Joueur J1 = new Joueur("Hug");
//        Joueur J2 = new Joueur("Hu");
//        Joueur J3 = new Joueur("H");
//        J.setCouleurJoueur("rouge");
//        J1.setCouleurJoueur("bleu");
//        J2.setCouleurJoueur("vert");
//        J3.setCouleurJoueur("noir");  
//        J1.setCoordonneesJoueur(C1);
//        J2.setCoordonneesJoueur(C2);
//        J3.setCoordonneesJoueur(C3);
//        J.setCoordonneesJoueur(C);
//        J.setNomIcon("test.png");
//        J1.setNomIcon("test.png");
//        J2.setNomIcon("test.png");
//        J3.setNomIcon("test.png");
//        J.setStatut(1);
//        J1.setStatut(1);
//        J2.setStatut(1);
//        J3.setStatut(1);
//        J.setVitesse(10);
//        J1.setVitesse(10);
//        J2.setVitesse(10);
//        J3.setVitesse(10);
//        sql.ConnectBase();
//        sql.SetJoueur(J);
//        sql.SetJoueur(J1);
//        sql.SetJoueur(J2);
//        sql.SetJoueur(J3);
//        ArrayList<Joueur> ListeJoueurReseau = new ArrayList<Joueur>();
//        ListeJoueurReseau.add(J);
//        ListeJoueurReseau.add(J1);
//        ListeJoueurReseau.add(J2);
//        ListeJoueurReseau.add(J3);
//        Plateau p = new Plateau(ListeJoueurReseau,100,100);
//        sql.gameStarted(4);
//        System.out.println(sql.gameStarted(4));
//        System.out.println("miseAJourListeJoueurReseau");
//        ListeJoueurReseau = sql.miseAJourListeJoueurReseau(J.getJoueurName());
//        System.out.println(ListeJoueurReseau.get(0).getCoordonneesJoueur());
//        System.out.println(ListeJoueurReseau.get(1).getCoordonneesJoueur());