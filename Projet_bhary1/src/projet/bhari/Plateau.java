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
    
    private ArrayList<Joueur>ListeJoueur;
    private ArrayList<Item> ListeItem;
    private int LimitesX;
    private int LimitesY;
    private int x,y,vittese,i;
    private BufferedImage icon;
    private boolean gauche, droite, up, down;
    private Trace ligneTrace;
    private Coordonnees coordoneeJeu,coordoneeInitial;
    
    public Plateau(ArrayList<Joueur> ListeJoueur, ArrayList<Item> ListeItem, int LimitesX, int LimitesY) {
        try {
           this.icon = ImageIO.read(new File("vert.png"));
        } catch (IOException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.x=100;
        this.y=100;
        this.ListeJoueur = ListeJoueur;
        this.ListeItem = ListeItem;
        this.LimitesX =LimitesX ;
        this.LimitesY =LimitesY ;
        this.gauche = false;
        this.droite = false;
        this.up=false;
        this.down=false;
        this.coordoneeJeu = new Coordonnees(0,0);
        this.coordoneeInitial= new Coordonnees(x,y);
        this.ligneTrace=new Trace(2000000);
        this.i=2;
        this.ligneTrace.setCoordonnees( coordoneeInitial,0);
        this.ligneTrace.setCoordonnees(coordoneeInitial,1);
    
    }
    public void MettreAJour(){
        vittese=7;
        if (this.gauche) {
           x -= vittese;
          
          // System.out.println(x);
          ligneTrace.setCoordonnees(coordoneeJeu,i);
            i=i+1;
            
          

           //this.coordoneeXdeJeu[x]=x;
        }
       
        if (this.droite) {
            x += vittese;
            ligneTrace.setCoordonnees(coordoneeJeu,i);
            i=i+1;
            
             //System.out.println(i );
            // System.out.println(this.fond.getWidth()-this.red_square.getWidth());
            // System.out.println(x);
             
          //  this.coordoneeXdeJeu[x]=x;
        }
        if (x > this.LimitesX - this.icon.getWidth()) {
            x = 20;
            // this.coordoneeXdeJeu[x]=x;
        
        }
        if (x <= vittese) {
            x = this.LimitesX-vittese;
          //  this.coordoneeXdeJeu[x]=x;
        }
        if (this.down) {
            y += vittese;
            ligneTrace.setCoordonnees(coordoneeJeu,i);
            i=i+1;
             //System.out.println(i );
           // this.coordoneeYdeJeu[y]=y;
        }
        if (this.up) {
            y -= vittese;
            ligneTrace.setCoordonnees(coordoneeJeu,i);
            i=i+1;
            // System.out.println(i );
            
           // this.coordoneeYdeJeu[y]=y;
        }
        if (y > this.LimitesY-this.icon.getHeight()) {
            y = 20;
          //  this.coordoneeYdeJeu[y]=y;
        }
        if (y <=vittese) {
            y = this.LimitesY-vittese;
           // this.coordoneeYdeJeu[y]=y;
        }
    }
    public void Afficher(Graphics2D contexte) {
      
       //contexte.drawImage(this.icon, x, y, null);
    }
     public void tracerLine(Graphics2D contexte) {
          contexte.setColor(Color.green);
           if (this.gauche){
           contexte.drawLine(x+vittese,y,x,y);
        }
           if (this.gauche && this.up){
           contexte.drawLine(x+vittese,y+vittese,x*(int)(1/sqrt(2)),y*(int)(1/sqrt(2)));
       }
         if(this.droite){
              contexte.drawLine(x-vittese,y,x,y);
        }
         if(this.up){
            contexte.drawLine(x, y+vittese, x, y);
        }
        if (this.down){
          contexte.drawLine(x, y-vittese, x, y);
        } 
     }   
     public void enregistreCoordonnees(){
        coordoneeJeu.setX(x);
        coordoneeJeu.setY(y);
        ligneTrace.setCoordonnees(coordoneeJeu,i);
        ligneTrace.afficierCoordoonnes(i);
        System.out.println(i );
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

