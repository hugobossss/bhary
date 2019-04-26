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

public class Trace {
    
    private String CouleurTrace;
    private Coordonnees[] ListeCoordonnees;
    private int taille;
    public Trace(int taille) {
        this.taille=taille;
        this.ListeCoordonnees=new Coordonnees[taille];
    }
     public void setCoordonnees(Coordonnees coor, int j){
        this.ListeCoordonnees[j]=coor;
        
    }
    public Coordonnees getCoordonees(int j){
        return this.ListeCoordonnees[j];
    }
     
         
    
     public int getCoordonneesY(int j){
        return this.ListeCoordonnees[j].getY();
    }
     public int getCoordonneesX(int j){
        return this.ListeCoordonnees[j].getX();
    }

    void afficierCoordoonnes(int i) {
         System.out.println(this.ListeCoordonnees[i]);
    }
}
