/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bhari;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import outils.OutilsJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author hburlon
 */
public class Database  {
    
    private Connection connexion;
    private PreparedStatement requete;
    public static String avatar;
    public static String couleur;

    
    void ConnectBase(){
        try {
        connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s2_vs1_tp2_bhary?serverTimezone=UTC", "bhary", "B5h3kh7vBRVg4fL2"); //acces mysql : root ; 4U-GrN*+v7z5
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    void DisconnectBase(){
        try {
        connexion.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    void SetJoueur(Joueur J){
         try {
         requete = connexion.prepareStatement("INSERT INTO joueurs VALUES (?,?,?,?,?,?,?,?,?,?)"); //NOW() pour date de dernière connexion 
            requete.setString(1, J.getJoueurName()); // nom
            requete.setString(2, J.getCouleurJoueur()); // couleur
            requete.setString(3,J.getNomIcon());
            requete.setInt(4, 1); // statut : 0  mort 1: vivant
            requete.setInt(5, J.getCoordonneesJoueur().getX()); // coordX 
            requete.setInt(6, J.getCoordonneesJoueur().getY()); // coordY
            requete.setString(7, "none"); // items
            requete.setString(8, "none");
            requete.setString(9, "none");
            requete.setInt(10, J.getVitesse()); // Vitessepas
            System.out.println(requete);
            requete.executeUpdate();
            requete.close();
         }
         catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    void UpdateVitesse(int pasVitesse,Joueur J){
        try {
            requete = connexion.prepareStatement("UPDATE joueurs SET VitessePas = ? WHERE Nom = ?");
            requete.setInt(1, pasVitesse);
            requete.setString(2,J.getJoueurName());
            System.out.println(requete);
            requete.executeUpdate();
            requete.close();
         }
         catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
//    void SelectTrace(Joueur J){
//        try {
//            requete = connexion.prepareStatement("SELECT X FROM joueurs INNER JOIN trace ON joueurs.Nom = trace.Nom  ");  
//            System.out.println(requete);
//            ResultSet resultat = requete.executeQuery();
//            while (resultat.next()) {
//                String Nom = resultat.getString("Nom");
//                int X = resultat.getInt("X");
//                int Y = resultat.getInt("Y");
//                System.out.println(Nom + " = (" + X + "; " + Y + ")");
//            }
//            requete.executeUpdate();
//            requete.close();
//        }
//        catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    void DeleteJoueur(Joueur J){
        try {
            requete = connexion.prepareStatement("DELETE FROM joueurs WHERE Nom = ? ");  
            requete.setString(1,J.getJoueurName());
            System.out.println(requete);  
            requete.executeUpdate();
            requete.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    void DeleteTrace(Joueur J){
    try {
        requete = connexion.prepareStatement("DELETE FROM trace WHERE Nom = ? ");  
        requete.setString(1,J.getJoueurName());
        System.out.println(requete);  
        requete.executeUpdate();
        requete.close();
    }
    catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    void afficherJoueurs(Joueur J){
        try {
            requete = connexion.prepareStatement("SELECT * FROM joueurs WHERE Nom = ? ");  
            requete.setString(1,J.getJoueurName());
            System.out.println(requete);  
            ResultSet resultat = requete.executeQuery();
            OutilsJDBC.afficherResultSet(resultat);
            requete.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    void afficherTrace(Joueur J){
    try {
        requete = connexion.prepareStatement("SELECT * FROM trace WHERE Nom = ? ");  
        requete.setString(1,J.getJoueurName());
        System.out.println(requete);  
        ResultSet resultat = requete.executeQuery();
        OutilsJDBC.afficherResultSet(resultat);
        requete.close();
    }
    catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    
    void UpdatedTrace(Joueur J){
    try {
        requete = connexion.prepareStatement("INSERT INTO trace VALUES (?,?,?,NOW())");  
        requete.setString(1,J.getJoueurName());
        requete.setInt(2, J.getCoordonneesJoueur().getX());
        requete.setInt(3, J.getCoordonneesJoueur().getY());
        System.out.println(requete);
        requete.executeUpdate();
        requete.close();
    }
    catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    
    
   public void UpdatedCoord(Joueur J){
    try {
        requete = connexion.prepareStatement("UPDATE joueurs SET CoordonnéX = ?, CoordonnéY = ? WHERE Nom = ?");  
        requete.setString(3,J.getJoueurName());
        requete.setInt(1, J.getCoordonneesJoueur().getX());
        requete.setInt(2, J.getCoordonneesJoueur().getY());
        System.out.println(requete);
        requete.executeUpdate();
        requete.close();
    }
    catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    }
    public boolean gameStarted (int nbMinJoueur){
        int nbJoueurs=0;
        try {
            requete = connexion.prepareStatement("SELECT COUNT(DISTINCT Nom) FROM joueurs");   // SELECT COUNT(DISTINCT Nom) FROM joueurs
            ResultSet resultat = requete.executeQuery();
            resultat.next();
            nbJoueurs=resultat.getInt(1);
           // OutilsJDBC.afficherResultSet(resultat);
            //System.out.println(nbJoueurs);
            requete.close();
        }
         catch (SQLException ex) {
        ex.printStackTrace();
        } 
        if(nbJoueurs>=nbMinJoueur){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int[] SelectCoord(Joueur J){
        int CoordX = 0;
        int CoordY = 0;
        int tab[] = new int[2];
        try {
            requete = connexion.prepareStatement("SELECT CoordonnéX,CoordonnéY FROM joueurs WHERE Nom=?");   
            requete.setString(1,J.getJoueurName());
            ResultSet resultat = requete.executeQuery();
            OutilsJDBC.afficherResultSet(resultat);
            resultat.next();
            CoordX = resultat.getInt(1);
            CoordY =resultat.getInt(2);
            requete.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        tab[0]=CoordX;
        tab[1]=CoordY;
        return tab;
    }
    
    public ArrayList[] SelectTrace(Joueur J){
//        int CoordX[] = new int[1000]; // plus vite
//        int CoordY[] = new int[1000];
        ArrayList CoordX = new ArrayList();
        ArrayList CoordY = new ArrayList();
        try {
            requete = connexion.prepareStatement("SELECT X,Y FROM trace WHERE Nom=?");   
            requete.setString(1,J.getJoueurName());
            ResultSet resultat = requete.executeQuery();
            OutilsJDBC.afficherResultSet(resultat);
            while(resultat.next()){
                CoordX.add(resultat.getInt(1));
                CoordY.add(resultat.getInt(2));
            }
            System.out.println(resultat);
            System.out.println(CoordX);
            System.out.println(CoordY);
            requete.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        ArrayList tab[] = new  ArrayList[2];
        tab[0]=CoordX;
        tab[1]=CoordY;
        return tab;
    }
    
    
//    
//    public Item Selectitem(Joueur J){
//        
//    }
//    
//    
//    public void updatedItem(Joueur J){
//        
//    }
//    
//    public boolean checkedItem(Joueur J){
//        
//    }
//    
//    public boolean checkedCollision(Joueur J){
//        
//    } 
//    
//    public boolean checkedJoueurStatut(Joueur J){
//        
//    }
//    
//    public boolean checkedNomIcon(Joueur J){
//        
//    } 
//    
//    public boolean CheckedCouleur(Joueur J){
//        
//    }
    
    public boolean CheckedNom(String avatar){
        int nb=0;
        try {
            requete = connexion.prepareStatement("SELECT COUNT(*) FROM joueurs WHERE Nom=?"); 
            requete.setString(1,avatar);
            ResultSet resultat = requete.executeQuery();
            resultat.next();
            nb=resultat.getInt(1);
            System.out.println(requete);
            requete.close();
        }
        catch (SQLException ex) {
        ex.printStackTrace();
        } 
        if(nb>1){
            return false;
        }
        else{
            return true;
        }
    }
    
    public ArrayList<Joueur> miseAJourListeJoueurReseau(String name){ 
        ArrayList<Joueur> ListeJoueurReseau = new ArrayList<Joueur>(); 
        ArrayList<Joueur> ListeJoueurLocal = new ArrayList<Joueur>(); 
        Joueur playerTemp = new Joueur("") ;
        Coordonnees playerCoord = new Coordonnees(0,0);
        String playerName;
        String playerColor;
        String playerNomIcon;
        int playerStatut;
        int playerX;
        int playerY;    
        try {
            requete = connexion.prepareStatement("SELECT * FROM joueurs"); 
            System.out.println(requete);  
            ResultSet resultat = requete.executeQuery();
            OutilsJDBC.afficherResultSet(resultat);
            resultat.first();
            //OutilsJDBC.afficherResultSet(resultat);
            while(resultat.next()){
                playerName = resultat.getString(1);
                //System.out.println(playerName); 
                playerColor = resultat.getString(2);
               // System.out.println(playerColor);
                playerNomIcon = resultat.getString(3);
               // System.out.println(playerNomIcon);
                playerStatut = resultat.getInt(4);
               // System.out.println(playerStatut);
                playerX = resultat.getInt(5);
               // System.out.println(playerX);
                playerY = resultat.getInt(6);
               // System.out.println(playerY);
                playerTemp.setNomJoueur(playerName);
                playerTemp.setCouleurJoueur(playerColor);
                playerTemp.setNomIcon(playerNomIcon);
                playerTemp.setStatut(playerStatut);
                playerCoord.setX(playerX);
                playerCoord.setY(playerY);
                playerTemp.setCoordonneesJoueur(playerCoord);
                if(name==resultat.getString(1)){
                    ListeJoueurLocal.add(playerTemp); 
                }
                else {
                    ListeJoueurReseau.add(playerTemp); 
                }
            }
        requete.close();
        }
        catch (SQLException ex) {
        ex.printStackTrace();
        } 
        for (int i=0;i<ListeJoueurReseau.size();i++){
            ListeJoueurLocal.add(ListeJoueurReseau.get(i));
        } 
        ListeJoueurLocal.add(playerTemp);
        return ListeJoueurLocal;
    }
    
    public void miseAJourJoueurLocal(ArrayList<Joueur> ListeJoueur){
        
        try {
            requete = connexion.prepareStatement("SET* FROM joueurs"); 
            System.out.println(requete);  
            ResultSet resultat = requete.executeQuery(); 
            requete.close();
        }
        catch (SQLException ex) {
        ex.printStackTrace();
        }    
    }
    

}
    



