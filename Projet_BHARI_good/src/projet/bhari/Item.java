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

public class Item {
    
    private String NomItem;
    private Coordonnees CoordonneesItem;
    private String Status;

    public Item(String NomItem, Coordonnees CoordonneesItem, String Status) {
        this.NomItem = NomItem;
        this.CoordonneesItem = CoordonneesItem;
        this.Status = "normal";
    }

    

    public String getNomItem() {
        return NomItem;
    }

    public Coordonnees getCoordonneesItem() {
        return CoordonneesItem;
    }

    public void setNomItem(String NomItem) {
        this.NomItem = NomItem;
    }

    public void setCoordonneesItem(Coordonnees CoordonneesItem) {
        this.CoordonneesItem = CoordonneesItem;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
