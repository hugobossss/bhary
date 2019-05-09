/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bhari;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;



/**
 *
 * @author bcharles
 */

public  class Plateau {
 
    private ArrayList<Item> ListeItem;
    private int LimitesX;
    private int LimitesY;
    private boolean gauche, droite, up, down;
    private ArrayList<Joueur> ListeJoueur; //réseau et en local (instantanée)
    private ArrayList<Trace> ListeTrace;

    
    public Plateau(ArrayList<Joueur> ListeJoueur, int LimiteX, int LimmiteY) { // Dans ListeJoueur mettre joueur local en premier dans Dessin avant creation plateau
        this.ListeItem = ListeItem;
        this.LimitesX = LimiteX ;
        this.LimitesY = LimmiteY ;
        this.gauche = false; // ajouter fonction random
        this.droite = false;
        this.up=false;
        this.down=false;
        this.ListeTrace= new ArrayList<Trace>();
        this.ListeJoueur= new ArrayList<Joueur>();
        
        for(int i = 0 ; i < ListeJoueur.size() ; i++){
            Coordonnees C = new Coordonnees(0,0);
            ArrayList <Coordonnees> debut = new ArrayList <Coordonnees>();
            Trace traceInit = new Trace (ListeJoueur.get(i).getCouleurJoueur());
           // Joueur J = new Joueur(" ");
            debut.add(ListeJoueur.get(i).getCoordonneesJoueur());
            traceInit.setListCoord(debut);
            ListeJoueur.get(i).setTrace(traceInit);
            //J.setCoordonneesJoueur(ListeJoueur.get(i).getCoordonneesJoueur());
           // this.ListeJoueur.add(J);
            System.out.println("ListeJoueur.get(i).getTrace()");
            System.out.println(ListeJoueur.get(i).getTrace());
            this.ListeTrace.add(ListeJoueur.get(i).getTrace());
            try { 
                BufferedImage icon = ImageIO.read(new File(ListeJoueur.get(i).getNomIcon()));
                ListeJoueur.get(i).setIcon(icon);
            } 
            catch (IOException ex) {
                Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.ListeJoueur=ListeJoueur;
        }
    }
    // ordre
     
//        MiseAJourAutreJoueur
//        Gestiondeplacement
//        MiseAJourJoueur
//        tracerLine
                
    public void MiseAJourAutreJoueur(ArrayList<Joueur> ListeJoueur){ // mise à jour avec réseau // méthode réseau avant   
        
        for(int i = 0 ; i < this.ListeJoueur.size() ; i++){
           // ArrayList <Coordonnees> debut = new ArrayList <Coordonnees>();
            //debut.add( this.ListeJoueur.get(i).getCoordonneesJoueur());  
            //Trace traceInit = new Trace (this.ListeJoueur.get(i).getCouleurJoueur());
            //traceInit.setListCoord(debut);
            this.ListeJoueur.get(i).getTrace().updatedListCoord(ListeJoueur.get(i).getCoordonneesJoueur());
            this.ListeJoueur.get(i).setCoordonneesJoueur(ListeJoueur.get(i).getCoordonneesJoueur());
            //this.ListeJoueur.get(i).getTrace().getListCoord().add(this.ListeJoueur.get(i).getCoordonneesJoueur());
        }
    }
    
    public Coordonnees MiseAJourJoueur(){ // mise a jour local méthode réseau après
            //mettre à jour tableau de coord 
        //this.ListeJoueur = ListeJoueur;
        this.ListeJoueur.get(0).getTrace().updatedListCoord(ListeJoueur.get(0).getCoordonneesJoueur());
        return this.ListeJoueur.get(0).getCoordonneesJoueur();
    }
    
    public boolean GestionCollision(){ //gestion collision joueur local avec  les autres
        return true;
    }
    
    public void Gestiondeplacement(){
           // Joueur localPlayer = new Joueur(this.ListeJoueur.get(0).getJoueurName());
           
            if (this.gauche){
                this.ListeJoueur.get(0).getCoordonneesJoueur().setX(this.ListeJoueur.get(0).getCoordonneesJoueur().getX()-this.ListeJoueur.get(0).getVitesse());// changer coord player         
            }
            if (this.droite) {
                this.ListeJoueur.get(0).getCoordonneesJoueur().setX(this.ListeJoueur.get(0).getCoordonneesJoueur().getX()+this.ListeJoueur.get(0).getVitesse());
            }    
            if (this.down) {
                this.ListeJoueur.get(0).getCoordonneesJoueur().setY(this.ListeJoueur.get(0).getCoordonneesJoueur().getY()-this.ListeJoueur.get(0).getVitesse());
            }
            if (this.up) {
              this.ListeJoueur.get(0).getCoordonneesJoueur().setY(this.ListeJoueur.get(0).getCoordonneesJoueur().getY()+this.ListeJoueur.get(0).getVitesse());
            }
            if (this.ListeJoueur.get(0).getCoordonneesJoueur().getX() > this.LimitesX - 15){ //Icon().getWidth()      
                this.ListeJoueur.get(0).getCoordonneesJoueur().setX(20);
            }
            if (this.ListeJoueur.get(0).getCoordonneesJoueur().getX() <= this.ListeJoueur.get(0).getVitesse()) {
               this.ListeJoueur.get(0).getCoordonneesJoueur().setX(this.LimitesX - this.ListeJoueur.get(0).getVitesse());
            }

            if (this.ListeJoueur.get(0).getCoordonneesJoueur().getY() > this.LimitesX - 15){
               this.ListeJoueur.get(0).getCoordonneesJoueur().setY(20);
            }
            if (this.ListeJoueur.get(0).getCoordonneesJoueur().getY() <= this.ListeJoueur.get(0).getVitesse()) {
                this.ListeJoueur.get(0).getCoordonneesJoueur().setY(this.LimitesY - this.ListeJoueur.get(0).getVitesse());
            }
            this.ListeJoueur.set(0, this.ListeJoueur.get(0));
        
    }
    
    public void Afficher(Graphics2D contexte) { // local
      Joueur localPlayer = this.ListeJoueur.get(0);
      //contexte.setColor(Color.BLACK);
      //contexte.drawRect(7, 7, this.LimitesX-7, this.LimitesY-7);
      contexte.drawImage(localPlayer.getIcon(),localPlayer .getCoordonneesJoueur().getX(), localPlayer .getCoordonneesJoueur().getY(), null);
    }
     public void tracerLine(Graphics2D contexte) {
         Joueur localPlayer = this.ListeJoueur.get(0);
     
         Coordonnees Coordavant = ListeTrace.get(0).getListCoord().get(0);
         Coordonnees Coordapres = localPlayer.getCoordonneesJoueur();
         if(localPlayer.getCouleurJoueur()== "rouge"){
             contexte.setColor(Color.RED);
         }
         if(localPlayer.getCouleurJoueur()== "bleu"){
             contexte.setColor(Color.BLUE);
         }
         if(localPlayer.getCouleurJoueur()== "vert"){
             contexte.setColor(Color.GREEN);
         }
         if(localPlayer.getCouleurJoueur()== "noir"){
             contexte.setColor(Color.BLACK);
         }
         contexte.drawLine(Coordapres.getX(),Coordapres.getY(),Coordavant.getX(),Coordavant.getY());
        
     }  
     
    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }
    public void setDown(boolean down) {
        this.down = down;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public ArrayList<Joueur> getListeJoueur() {
        return ListeJoueur;
    }

    public ArrayList<Item> getListeItem() {
        return ListeItem;
    }

    public int getLimitesX() {
        return LimitesX;
    }

    public int getLimitesY() {
        return LimitesY;
    }

    public void setListeJoueur(ArrayList<Joueur> ListeJoueur) {
        this.ListeJoueur = ListeJoueur;
    }

    public void setListeItem(ArrayList<Item> ListeItem) {
        this.ListeItem = ListeItem;
    }

    public void setLimitesX(int LimitesX) {
        this.LimitesX = LimitesX;
    }

    public void setLimitesY(int LimitesY) {
        this.LimitesY = LimitesY;
    }

    public double PositionJoueurX(){
        return (Math.random()*this.LimitesX);
    }
    public double PositionJoueurY(){
        return (Math.random()*this.LimitesY);
    }

}

