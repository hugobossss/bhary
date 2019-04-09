/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bhari;

import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
/**
 *
 * @author bcharles
 */

public abstract class Plateau extends JFrame implements ActionListener, KeyListener {
    
    private ArrayList<Joueur> ListeJoueur;
    private ArrayList<Item> ListeItem;
    private int LimitesX;
    private int LimitesY;
    
    public Plateau(ArrayList<Joueur> ListeJoueur, ArrayList<Item> ListeItem, int LimitesX, int limitesY) {
        this.ListeJoueur = ListeJoueur;
        this.ListeItem = ListeItem;
        this.LimitesX = LimitesX;
        this.LimitesY = LimitesY;
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
    @Overide
    public int nouvellePositionX(){
        
        if (evt.getKeyCode() == evt.VK_RIGHT){
            
        }
    }
    
}

