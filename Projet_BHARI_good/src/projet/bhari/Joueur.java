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
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Joueur {
    
    private String CouleurJoueur;
    private String NomJoueur;
    private String nomIcon;
    private int Statut;
    private ArrayList<Item> ListItem;
    private int Vitesse;
    private Coordonnees CoordonneesJoueur;
    private BufferedImage icon;
    private Trace trace;
    
     public Joueur(String nom) {
        this.NomJoueur=nom;
        this.Vitesse = 10;
        this.trace =  new Trace(this.CouleurJoueur);
        }
  
    public String getJoueurName(){
        return this.NomJoueur;
    }

    public void setnomIcon(String nomIcon){
        try { 
            this.icon = ImageIO.read(new File(nomIcon));
        } 
        catch (IOException ex) {
            Logger.getLogger(Joueur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Trace getTrace() {
        return trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
    }
    
   

    public void setIcon(BufferedImage icon) {
        this.icon = icon;
    }

    public void setCouleurJoueur(String CouleurJoueur) {
        this.CouleurJoueur = CouleurJoueur;
    }

    public void setNomJoueur(String NomJoueur) {
        this.NomJoueur = NomJoueur;
    }

    public void setStatut(int Statut) {
        this.Statut = Statut;
    }

    public void setVitesse(int Vitesse) {
        this.Vitesse = Vitesse;
    }

    public void setCoordonneesJoueur(Coordonnees CoordonneesJoueur) {
        this.CoordonneesJoueur = CoordonneesJoueur;
    }

    public String getCouleurJoueur() {
        return CouleurJoueur;
    }

    public String getNomJoueur() {
        return NomJoueur;
    }

    public ArrayList<Item> getListItem() {
        return ListItem;
    }

    public int getVitesse() {
        return Vitesse;
    }

    public Coordonnees getCoordonneesJoueur() {
        return CoordonneesJoueur;
    }

    public String getNomIcon() {
        return nomIcon;
    }

    public void setNomIcon(String nomIcon) {
        this.nomIcon = nomIcon;
    }
    
    public BufferedImage getIcon() {
        return icon;
    }

    public void setListItem(ArrayList<Item> ListItem) {
        this.ListItem = ListItem;
    }
    
}


