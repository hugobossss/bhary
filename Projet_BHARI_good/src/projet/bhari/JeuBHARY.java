/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.bhari;

import com.sun.istack.internal.logging.Logger;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import java.util.*; 
import java.util.ArrayList;



/**
 *
 * @author user
 */
public class JeuBHARY extends javax.swing.JFrame {

    /**
     * Creates new form JeuBHARY
     */
    
    //    private BufferedImage buffer;
    private Graphics2D contexteBuffer;
    private Graphics2D contexteBufferMap;
    private BufferedImage bufferavatar;

    // Constantes pour Tile Mapping
    private static int TILE_WIDTH = 32;
    private static int TILE_HEIGHT = 32;

    private static int TILES_PER_ROW = 16;
    private static int TILES_PER_COL = 16;
    

    public JLabel jLabel1;
    public ActionEvent event;
  
    public String avatar;
    public String couleur;
    public String cad;
    public Database sql;
    public Joueur J;
    
    public JeuBHARY() {
        initComponents();
    }
                /// Creation buffer pour affichage avatar

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabeljeu = new javax.swing.JLabel();
        jLabelnom = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabelIcon = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelCouleur = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButtonStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabeljeu.setText("    JEU BHARY");

        jLabelnom.setText("NOM AVATAR ");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabelIcon.setText("CHOISIR L'ICONE");

        jButton1.setText("OUVRIR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelCouleur.setText("CHOISIR COULEUR");

        jRadioButton1.setText("  ROUGE");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("BLEU");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("VERT");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("NOIR");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jButtonStart.setText("start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabeljeu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelIcon)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCouleur)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelnom)
                                .addGap(34, 34, 34)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabeljeu)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnom)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIcon)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCouleur)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addGap(34, 34, 34)
                .addComponent(jButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        System.out.println(panneauxChecked());
        System.out.println(couleur);
        System.out.println(avatar);
        if(panneauxChecked()){
        this.ProjetBHARI();
        }
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
       couleur = "vert";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        couleur = "bleu";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        couleur = "noir";
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        avatar = jTextField1.getText();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        couleur = "rouge";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser choixFichier = new JFileChooser(".");
        int bouton = choixFichier.showOpenDialog(null);
        if(bouton ==JFileChooser.APPROVE_OPTION){
          System.out.println("Fichier à lire : " + choixFichier.getSelectedFile());
        //           this.avatar.repaint();
          cad= choixFichier.getSelectedFile().getName();
        //            jLabel2.setText(cad);
        //avatar.setIcon(new ImageIcon(cad));
        System.out.println(cad);
        //this.plateau.setnomIcon(cad);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JeuBHARY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuBHARY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuBHARY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuBHARY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JeuBHARY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JLabel jLabelCouleur;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabeljeu;
    private javax.swing.JLabel jLabelnom;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    private BufferedImage buffer;
    // private Graphics2D contexteBuffer;


    
    /**
     *
     */

    
    
  public void ProjetBHARI(){ 
       this.sql= new Database();
       this.sql.ConnectBase();
//       if(sql.CheckedNom(avatar)==false){
//           JFrame f = new JFrame();
//           f.setTitle("Veuillez entrer un avatar disponible ...");
//       }
//       if (CheckedCouleur(couleur)){
//           JFrame f2 = new JFrame();
//           f3.setTitle("Veuillez entrer un avatar disponible ...");
//       }
//       if (CheckedNomIcon(cad)){
//           JFrame f3 = new JFrame();
//           f3.setTitle("Veuillez entrer un avatar disponible ...");
//       }
     //  else{
       ArrayList <Coordonnees> debut = new ArrayList <Coordonnees>(); 
       this.J = new Joueur(avatar);
       this.J.setCouleurJoueur(couleur);
       this.J.setCoordonneesJoueur(CoordInitRandom());
       this.J.setNomIcon(cad);
       Trace traceInit = new Trace (this.J.getCouleurJoueur());
       debut.add(this.J.getCoordonneesJoueur());
       traceInit.setListCoord(debut);
       this.J.setTrace(traceInit);
       this.J.getTrace().setListCoord(debut);
       this.J.setStatut(1);
       this.J.setVitesse(10);
       this.sql.SetJoueur(this.J);
       System.out.println("this.J.getTrace().getListCoord()");
       System.out.println(this.J.getTrace().getListCoord());
       Dessin fenetreJeu= new Dessin(this);
       fenetreJeu.setVisible(true);
     //  }
    }
   
   public boolean panneauxChecked(){
       if((avatar!= null) && (couleur!=null) && (cad!=null)){
           return true;
       } 
       else{
           return false;
       }
   }
   
   public Coordonnees CoordInitRandom(){
       int maxX =400;
       int minX =0;
       int maxY =300;
       int minY =0;
       Random rand = new Random();
       int coordXInitAleatoire = rand.nextInt(maxX - minX + 1) + minX;
       int coordYinitAleatoire = rand.nextInt(maxY - minY + 1) + minY;
       Coordonnees C = new Coordonnees(coordXInitAleatoire,coordYinitAleatoire);
       return C;
   }

    public Database getSql() {
        return sql;
    }

    public void setSql(Database sql) {
        this.sql = sql;
    }

    public Joueur getJ() {
        return J;
    }

    public void setJ(Joueur J) {
        this.J = J;
    }
   
}











