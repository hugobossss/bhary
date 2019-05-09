/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bhari;

import java.util.*;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author hburlon
 */

public class Mouvement extends JFrame implements ActionListener, KeyListener {
    
    private BufferedImage buffer;
    private Graphics2D contexteBuffer;
    private Timer timer;
    private JLabel jLabel1;
    private ActionEvent event;
    private Plateau p;
   
    
    public Mouvement(){
        this.p = new Plateau();
        this.setSize(p.getLimitesX(), p.getLimitesY());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.jLabel1 = new JLabel();
        this.jLabel1.setPreferredSize(new java.awt.Dimension(p.getLimitesX(),p.getLimitesY()));
        this.setContentPane(this.jLabel1);
        this.pack();

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.buffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(buffer));
        this.contexteBuffer = this.buffer.createGraphics();

        // Creation du Timer qui appelle this.actionPerformed() tous les 40 ms
        this.timer = new Timer(40,  this);
        this.timer.start();
        p.setGauche(true);// fonction random
        
    }
 
    
     
   public void actionPerformed(ActionEvent e) {
        
         this.p.MettreAJour();
         this.p.Afficher(contexteBuffer);
         this.jLabel1.repaint();
         //this.jeu.Afficher2(contexteBuffer)
         this.p.tracerLine(contexteBuffer);
         this.p.enregistreCoordonnees();
         this.jLabel1.repaint();
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       //NOP
    }

    
    
    
    
     @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            this.p.setDroite(true);
            this.p.setGauche(false); 
            this.p.setUp(false);  
            this.p.setDown(false);
            
          //  this.jeu.tracerLine(contexteBuffer);

           // this.jeu.tracerLine(contexteBuffer);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
           this.p.setDroite(false);
           this.p.setGauche(true); 
           this.p.setUp(false);  
           this.p.setDown(false);
           
           // this.jeu.tracerLine(contexteBuffer);

            
        }
        if(evt.getKeyCode()== evt.VK_UP){
             this.p.setDroite(false);
             this.p.setGauche(false); 
             this.p.setUp(true);  
             this.p.setDown(false);
           
           // this.jeu.tracerLine(contexteBuffer);

             
        }
        if(evt.getKeyCode()==evt.VK_DOWN){
             this.p.setDroite(false);
             this.p.setGauche(false); 
             this.p.setUp(false);  
             this.p.setDown(true);
            
            //this.jeu.tracerLine(contexteBuffer);

        if((evt.getKeyCode()==evt.VK_DOWN)&&(evt.getKeyCode()==evt.VK_LEFT)){
             this.p.setDroite(false);
             this.p.setGauche(true); 
             this.p.setUp(false);  
             this.p.setDown(true);
        }
        this.p.enregistreCoordonnees();
        
        } 
    }

    @Override
    public void keyReleased(KeyEvent evt) {
         if (evt.getKeyCode() == evt.VK_RIGHT) {
             this.p.setDroite(true);
             this.p.setGauche(false); 
             this.p.setUp(false);  
             this.p.setDown(false);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
            this.p.setDroite(false);
             this.p.setGauche(true); 
             this.p.setUp(false);  
             this.p.setDown(false);
        }
        if(evt.getKeyCode()== evt.VK_UP){
            this.p.setDroite(false);
             this.p.setGauche(false); 
             this.p.setUp(true);  
             this.p.setDown(false);
        }
        if(evt.getKeyCode()==evt.VK_DOWN){
           this.p.setDroite(false);
             this.p.setGauche(false); 
             this.p.setUp(false);  
             this.p.setDown(true);
        }
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     
       
        Mouvement bhary = new Mouvement();
        
       bhary.setVisible(true);
        
        
       // System.out.println(plat.PositionJoueurX());
        //System.out.println(plat.PositionJoueurY());
        //double d = Math.random();
    }

   
}