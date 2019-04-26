/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bahry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;


/**
 *
 * @author akayacan
 */
public class Point {
    
    
    
    private String nom;
    private double x;
    private double y;

    public Point(String nom, double x, double y) {
        this.nom = nom;
        this.x = x;
        this.y = y;
    }

   public Point(){
       this.nom="origine";
       this.x=0.0;
       this.y=0.0;
   }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
   
   
    
    public double longEucl(Point p){
        return (double) Math.sqrt((this.x-p.x)*(this.x-p.x))+((this.y-p.y)*(this.y-p.y));
    }
   
    public Point getSymetrique(Point p){
        double vx=p.x-this.x;
        double vy=p.y-this.y;
        return new Point("symetrique"+this.nom+p.nom,p.x+vx,p.y+vy);
        
    }
    
    public Point getMilieu(Point p){
        double mx=((p.x+this.x)/2);
        double my=((p.y+this.y)/2);
        return new Point("milieu",mx,my);
        
    }
    public void dessinePoint (FenetreGraphique fenetre){
   
       
        fenetre.getGraphics2D().setColor(Color.GREEN);
        Graphics2D contexte = fenetre.getGraphics2D();
        contexte.setColor(Color.BLUE);
        contexte.drawLine(100,100, 100, 100);
      
         
        
        
        fenetre.actualiser();
    }
    
            
    
}
