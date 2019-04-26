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
import java.awt.event.KeyEvent;
import java.util.*;

public class Joueur {
    
    private String CouleurJoueur;
    private String NomJoueur;
    private int Statut;
    private ArrayList<Item> ListItem;
    private Trace Trace;
    private double[] Vitesse[];
    private Coordonnees CoordonneesJoueur;
    private String direction;
    private double coefDirectionX;
    private double coefDirectionY;
    
     public Joueur(String nom) {
        this.NomJoueur="John doe";
    }
     public double getCoefDirectionX(){
        return this.coefDirectionX;
     }
     public double getCoefDirectionY(){
        return this.coefDirectionY;
     }
    
    public void changerDirection(double x,double y){
        this.coefDirectionX=x;
        this.coefDirectionY=y;
    }
    public void keyPressed(KeyEvent evt) {
        
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            if (evt.getKeyCode() == evt.VK_UP){
            this.changerDirection(1.0/java.lang.Math.sqrt(2.0),1.0/java.lang.Math.sqrt(2.0));
            }
            if (evt.getKeyCode() == evt.VK_DOWN){
            this.changerDirection(1.0/java.lang.Math.sqrt(2.0),-1.0/java.lang.Math.sqrt(2.0));
            }
            else{
            this.changerDirection(1.0,0.0);
            }
        }
        
        if (evt.getKeyCode() == evt.VK_LEFT) { 
            if (evt.getKeyCode() == evt.VK_UP){
            this.changerDirection(-1.0/java.lang.Math.sqrt(2.0),1.0/java.lang.Math.sqrt(2.0));
            }
            if (evt.getKeyCode() == evt.VK_DOWN){
            this.changerDirection(-1.0/java.lang.Math.sqrt(2.0),-1.0/java.lang.Math.sqrt(2.0));
            }
            else{
            this.changerDirection(-1.0,0.0);
            }
        }
    
        if (evt.getKeyCode() == evt.VK_UP) {
            if (evt.getKeyCode() == evt.VK_RIGHT){
            this.changerDirection(1.0/java.lang.Math.sqrt(2.0),1.0/java.lang.Math.sqrt(2.0));
            }
            if (evt.getKeyCode() == evt.VK_LEFT){
            this.changerDirection(-1.0/java.lang.Math.sqrt(2.0),1.0/java.lang.Math.sqrt(2.0));
            }
            else{
            this.changerDirection(0.0,1.0);
            }
        }
        
        if (evt.getKeyCode() == evt.VK_DOWN) {
            if (evt.getKeyCode() == evt.VK_RIGHT){
            this.changerDirection(1.0/java.lang.Math.sqrt(2.0),-1.0/java.lang.Math.sqrt(2.0));
            }
            if (evt.getKeyCode() == evt.VK_LEFT){
            this.changerDirection(-1.0/java.lang.Math.sqrt(2.0),-1.0/java.lang.Math.sqrt(2.0));
            }
            else{
            this.changerDirection(0.0,-1.0);
            }
        }
    }
}


