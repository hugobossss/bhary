/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bahry;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author adahbi
 */
public class ProjetBahry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      
        FenetreGraphique fenetre = new FenetreGraphique(" Avatar ", 400, 300);
        fenetre.effacer(new Color(0, 0, 100));
        BufferedImage image = ImageIO.read(new File("AVATAR/Avatar3.jpg"));
        fenetre.getGraphics2D().drawImage(image, 100, 50, null);
        fenetre.actualiser();
//     FenetreGraphique fenetre = new FenetreGraphique("Hello World!", 350, 350); 
//     Point p1= new Point(" avatar ",20.0,20.0);
//     p1.dessinePoint(fenetre);
//   
    }


 }

    

