/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tron;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author hburlon
 */
public class Tron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        try {
            //"jdbc:mysql://nemrod.ens2m.fr:3306/tp_jdbc?serverTimezone=UTC", "root", "4U-GrN*+v7z5"
            //"jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s2_vs1_tp2_bhary?serverTimezone=UTC"
            //"jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s2_vs1_tp2_bhary?serverTimezone=UTC", "root", "4U-GrN*+v7z5"
            //Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/tp_jdbc?serverTimezone=UTC", "etudiant", "YTDTvj9TR3CDYCmP");
            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s2_vs1_tp2_bhary?serverTimezone=UTC", "root", "4U-GrN*+v7z5");
            //PreparedStatement requete = connexion.prepareStatement("INSERT INTO joueurs VALUES (?,?,?,?,?,?,?,?,?,?,?)");
//            requete.setString(1, "Joueur1");
//            requete.setString(2, "Rouge");
//            requete.setInt(3, 1);
//            requete.setDouble(4, 12);
//            requete.setDouble(5, 2); 
//            requete.setString(6, "vitesse");
//            requete.setString(7, "mine");
//            requete.setString(8, "invulnerabilite");
//            requete.setDouble(9, 1);
//            requete.setDouble(10, 0); 
//            requete.setDouble(11, 1); 
//            System.out.println(requete);
//            requete.executeUpdate();
//            requete.close();
              connexion.close();



//            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/tp_jdbc?serverTimezone=UTC", "etudiant", "YTDTvj9TR3CDYCmP");
//
//            PreparedStatement requete = connexion.prepareStatement("INSERT INTO joueur VALUES (?,?,?,?,?,NOW())");
//            requete.setString(1, "proprio");
//            requete.setString(2, "proprio@ens2m.fr");
//            //requete.setString(3, OutilsJDBC.MD5("onix"));
//            requete.setDouble(4, 12.25097);
//            requete.setDouble(5, 3.99432);   
//            System.out.println(requete);
//            requete.executeUpdate();
//
//            requete.close();
//            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
