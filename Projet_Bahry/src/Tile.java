
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adahbi
 */public class Tile extends JPanel {
    
  public static final Color FOREST  = new Color(214,217,223);
    public static final Color DESERT = new Color(255,204,102);
    public static final Color DIRT_ROAD = new Color(153,102,0);
    public static final Color GREEN = new Color(0,102,0);
    public static final Color HILLS = new Color(51,153,0);
    public static final Color LAKE = new Color(0,153,153);
    public static final Color MOUNTAINS = new Color(102,102,255);
    public static final Color OCEAN = new Color(0,0,153);
    public static final Color BLACK = new Color(51,51,0);
    public static final Color PLAINS = new Color(102,153,0);

    public static final Color[] TERRAIN = {
        FOREST,
        DESERT,
        DIRT_ROAD,
        FOREST,
        HILLS,
        LAKE,
        MOUNTAINS,
        OCEAN,
        BLACK,
        PLAINS
    };

    public static final int NUM_ROWS = 25;
    public static final int NUM_COLS = 30;

    public static final int PREFERRED_GRID_SIZE_PIXELS = 10;

    // In reality you will probably want a class here to represent a map tile,
    // which will include things like dimensions, color, properties in the
    // game world.  Keeping simple just to illustrate.
    private final Color[][] terrainGrid;

    public Tile(){
        this.terrainGrid = new Color[NUM_ROWS][NUM_COLS];
        Random r = new Random();
        // Randomize the terrain
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                int randomTerrainIndex = r.nextInt(TERRAIN.length);
                Color randomColor = TERRAIN[randomTerrainIndex];
                this.terrainGrid[i][j] = randomColor;
            }
        }
        int preferredWidth = NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
        int preferredHeight = NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
        setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }

    @Override
    public void paintComponent(Graphics g) {
        // Important to call super class method
        super.paintComponent(g);
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
        // Draw the grid
        int rectWidth = getWidth() / NUM_COLS;
        int rectHeight = getHeight() / NUM_ROWS;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                // Upper left corner of this terrain rect
                int x = i * rectWidth;
                int y = j * rectHeight;
                Color terrainColor = terrainGrid[i][j];
                g.setColor(terrainColor);
                g.fillRect(x, y, rectWidth, rectHeight);
            }
        }
    }
 }
