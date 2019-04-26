/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bahry;

import FenetreGraphique.FenetreGraphique;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author guillaume.laurent
 */
public class TestDrawTile {

    private static int TILE_WIDTH = 32;
    private static int TILE_HEIGHT = 32;

    private static int TILES_PER_ROW = 16;
    private static int TILES_PER_COL = 16;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        BufferedImage tileSet = ImageIO.read(new File("tileSetMinecraft32x32.png"));
          int map[][] ={ {0, 0, 0,   0,  0, 0,  0, 0,  0,  0,  0, 0},
                         {0, 0, 26, 26, 26, 0,  0, 0,  0,  0,  0, 0},
                         {0, 0, 26, 20, 26, 0,  0, 0,  0,  0,  0, 0},
                         {0, 0, 26, 20, 26, 0,  0, 0,  0,  0, 57, 2},
                         {0, 0,  0, 20,  0, 0,  0, 0,  0,  1,  2, 3},
                         {2, 2,  0, 20,  0, 0, 57, 0, 18, 18,  1, 1},
                         {3, 3,  2,  2,  2, 2,  2, 2,  1,  1,  1, 1},
                         {3, 3,  3,  3,  3, 3,  3, 3,  1,  1,  1, 1},
                         {1, 1,  3,  3,  3, 3,  3, 1,  1,  16,  1,1},
                       
        };
         FenetreGraphique fenetre = new FenetreGraphique("Hello World!", 20 * TILE_WIDTH, 10 * TILE_HEIGHT);//peut etre non

        fenetre.effacer(new Color(175, 226, 255));//peut etre non
        

        Graphics2D contexte = fenetre.getGraphics2D();// changer la fenetre par le jlabell (affecter au label)
     for (int y=0; y<map.length; y++){       // une boucle qui permet de créer un tableau de (un nombre) de tuiles contenant des tuiles different... et qui genere des tuiles....
         for(int x =0;x<map[y].length;x++){
        System.out.println("x="+x+" - y="+y);
        int tileNumber = map[y][x];
        int tileX = (tileNumber % TILES_PER_ROW) * TILE_WIDTH;
        int tileY = (tileNumber / TILES_PER_ROW) * TILE_HEIGHT;
        BufferedImage tile = tileSet.getSubimage(tileX, tileY, TILE_WIDTH, TILE_HEIGHT);// subimag: on prend juste une partie du tile;

      
         
                
            
     
            contexte.drawImage(tile, x*32, y*32, null); //on multiple x et y (les coordonnées de tile) par*32 pour les convertir du coordonnées vers des pixels
         }
     }
        
//        contexte.drawImage(tile, 130, 130, null);
//        contexte.drawImage(tile, 200, 200, null);
       
       

        fenetre.actualiser();//this.repaint();
        System.out.println("ok");
      
        

                
            }
}



    

