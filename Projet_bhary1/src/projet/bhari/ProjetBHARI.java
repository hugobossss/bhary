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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class ProjetBHARI extends JFrame implements ActionListener, KeyListener {
    
    private BufferedImage buffer;
    private Graphics2D contexteBuffer;
    private Plateau plateau;
    private Timer timer;
    private JLabel jLabel1;
    private ActionEvent event;
    
    public ProjetBHARI(){
        Joueur raj = new Joueur("raj");
        ArrayList<Joueur> test = new ArrayList();
        test.add(raj);
        ArrayList<Item> test2 = new ArrayList();
        int test3 = 1000;
        int test4 = 700;
        // Creation du plateau

        this.plateau = new Plateau(test,test2,test3,test4);
        this.setSize(this.plateau.getLimitesX(), this.plateau.getLimitesY());
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.jLabel1 = new JLabel();
        this.jLabel1.setPreferredSize(new java.awt.Dimension(this.plateau.getLimitesX(),this.plateau.getLimitesY()));
        this.setContentPane(this.jLabel1);
        this.pack();
       
               

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.buffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.jLabel1.setIcon(new ImageIcon(buffer));
        this.contexteBuffer = this.buffer.createGraphics();

        // Creation du Timer qui appelle this.actionPerformed() tous les 40 ms
        this.timer = new Timer(40, this);
         this.timer.start();
        
    }
 
    
     @Override
    public void actionPerformed(ActionEvent e) {
        this.plateau.MettreAJour();
        this.plateau.Afficher(contexteBuffer);
       // this.jeu.Afficher2(contexteBuffer)
       this.plateau.tracerLine(contexteBuffer);
         this.plateau.enregistreCoordonnees();
                this.jLabel1.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       //NOP
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            this.plateau.setDroite(true);
             this.plateau.setGauche(false); 
             this.plateau.setUp(false);  
             this.plateau.setDown(false);
            this.plateau.enregistreCoordonnees();
          //  this.jeu.tracerLine(contexteBuffer);

           // this.jeu.tracerLine(contexteBuffer);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
           this.plateau.setDroite(false);
             this.plateau.setGauche(true); 
             this.plateau.setUp(false);  
             this.plateau.setDown(false);
            this.plateau.enregistreCoordonnees();
           // this.jeu.tracerLine(contexteBuffer);

            
        }
        if(evt.getKeyCode()== evt.VK_UP){
             this.plateau.setDroite(false);
             this.plateau.setGauche(false); 
             this.plateau.setUp(true);  
             this.plateau.setDown(false);
            this.plateau.enregistreCoordonnees();
           // this.jeu.tracerLine(contexteBuffer);

             
        }
        if(evt.getKeyCode()==evt.VK_DOWN){
             this.plateau.setDroite(false);
             this.plateau.setGauche(false); 
             this.plateau.setUp(false);  
             this.plateau.setDown(true);
            this.plateau.enregistreCoordonnees();
            //this.jeu.tracerLine(contexteBuffer);

            
        } 
    }

    @Override
    public void keyReleased(KeyEvent evt) {
         if (evt.getKeyCode() == evt.VK_RIGHT) {
             this.plateau.setDroite(true);
             this.plateau.setGauche(false); 
             this.plateau.setUp(false);  
             this.plateau.setDown(false);
        }
        if (evt.getKeyCode() == evt.VK_LEFT) {
            this.plateau.setDroite(false);
             this.plateau.setGauche(true); 
             this.plateau.setUp(false);  
             this.plateau.setDown(false);
        }
        if(evt.getKeyCode()== evt.VK_UP){
            this.plateau.setDroite(false);
             this.plateau.setGauche(false); 
             this.plateau.setUp(true);  
             this.plateau.setDown(false);
        }
        if(evt.getKeyCode()==evt.VK_DOWN){
           this.plateau.setDroite(false);
             this.plateau.setGauche(false); 
             this.plateau.setUp(false);  
             this.plateau.setDown(true);
        }
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     
       
        ProjetBHARI bhary = new ProjetBHARI();
        
        bhary.setVisible(true);
        
        
       // System.out.println(plat.PositionJoueurX());
        //System.out.println(plat.PositionJoueurY());
        //double d = Math.random();
    }

   
}
