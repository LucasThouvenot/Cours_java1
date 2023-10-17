package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CasseBrique extends Canvas {

    private int hauteur = 500;
    private int largeur = 700;
    JFrame fenetre = new JFrame();
    public CasseBrique() throws InterruptedException {

        setSize(largeur,hauteur);
        setBounds(0,0,largeur,hauteur);


        fenetre.setBackground(Color.pink);
        fenetre.setTitle("Casse Brique");
        fenetre.setName("Casse Brique");
        JPanel panneau = (JPanel)fenetre.getContentPane();
        panneau.setSize(largeur,hauteur);
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();


        createBufferStrategy(2);
        setIgnoreRepaint(true);
        setFocusable(false);

        demarrer();

    }

    public void demarrer() throws InterruptedException {

        int i = 0;
        Balle balle = new Balle();
        Barre barre = new Barre();

        fenetre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 39){
                    System.out.println("right");
                    barre.moveRight();
                }else if(e.getKeyCode() == 37){
                    System.out.println("left");
                    barre.moveLeft();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        int j = 0;
        JOptionPane.showMessageDialog(null,
                "5 vies",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);

        while(j<4) {
            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();
            //---------------------------------------------------------------------------------------------------------
            dessin.setColor(Color.white);
            dessin.fillRect(0, 0, largeur, hauteur);
            balle.dessiner(dessin);
            balle.deplacement();
            balle.colision(largeur, hauteur);
            barre.dessiner(dessin);
            if ((balle.getPosY() + balle.getDiam() >= barre.getPosY()) && (balle.getPosX() >= barre.getPosX()) && (balle.getPosX() <= barre.getPosX() + barre.getLargeur())) {
                balle.setVitVertical(-balle.getVitVertical());
            }
            if (balle.getPosY() >= hauteur - balle.getDiam()) {
                JOptionPane.showMessageDialog(null,
                        "perdu! nombre de vie retantes : "+(4-j),
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                j++;
            }
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }

            //---------------------------------------------------------------------------------------------------------
    }
}
