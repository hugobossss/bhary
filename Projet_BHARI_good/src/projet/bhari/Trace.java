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
    
    private ArrayList<Coordonnees> ListCoord; 
    private String color;
 
    public Trace(String couleur) {
        this.ListCoord = ListCoord;
        this.color=couleur;
    }

    public ArrayList<Coordonnees> getListCoord() {
        return ListCoord;
    }
    
    public void updatedListCoord(Coordonnees C) {
        this.ListCoord.add(C);
    }

    public void setListCoord(ArrayList<Coordonnees> ListCoord) {
        this.ListCoord = ListCoord;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
