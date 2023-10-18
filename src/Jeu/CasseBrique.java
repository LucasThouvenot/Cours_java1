package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class CasseBrique extends Canvas {

    private int hauteur = 800;
    private int largeur = 700;
    Random random = new Random();
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


        createBufferStrategy(3);
        setIgnoreRepaint(true);
        setFocusable(false);

        demarrer();

    }

    public void demarrer() throws InterruptedException {

        int i = 5;
        Balle balle = new Balle();
        Barre barre = new Barre();
        Score score = new Score();

        ArrayList<Vie> vies = new ArrayList<>();
        for(int a=0;a<i;a++){
            vies.add(new Vie(largeur - (20*a),20));
        }

        ArrayList<Brique> briques = new ArrayList<>();
        for(int b=1;b<31;b++){
            int x = 0;
            int y = 0;
            if(b<=10){
                y = 40;
                x = 40+50*b;
            } else if (b<=20) {
                y= 80;
                x = 40+50*(b-10);
            } else {
                y = 120;
                x = 40+50*(b-20);
            }
            briques.add(new Brique(x,y));
        }

        ArrayList<Bonus> lesbonus = new ArrayList<>();


        fenetre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 39){
                    barre.moveRight();
                }else if(e.getKeyCode() == 37){
                    barre.moveLeft();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JOptionPane.showMessageDialog(null,"Debut du jeu!","Info",JOptionPane.INFORMATION_MESSAGE);

        while(!vies.isEmpty()) {
            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();
            //---------------------------------------------------------------------------------------------------------
            dessin.setColor(Color.white);
            dessin.fillRect(0, 0, largeur, hauteur);
            barre.dessiner(dessin);
            for(Brique labrique: briques){
                labrique.dessiner(dessin);
            }
            for (Vie lavie:vies) {
                lavie.dessiner(dessin);
            }
            balle.dessiner(dessin);
            balle.deplacement();
            balle.colision(largeur, hauteur);
            if ((balle.getPosY() + balle.getDiam() >= barre.getPosY()) && (balle.getPosX() >= barre.getPosX()) && (balle.getPosX() <= barre.getPosX() + barre.getLargeur())) {
                balle.setVitVertical(-balle.getVitVertical());
            }
            for (int k = 0; k < briques.size(); k++) {
                Brique labrique = briques.get(k);
                if (labrique.collisionAvecBalle(balle)) {
                    if (random.nextInt(5) + 1 == 1) {
                        lesbonus.add(new Bonus(briques.get(k).getPosX(), briques.get(k).getPosY()));
                    }
                    score.briqueCasse();
                    briques.remove(k);
                    k--;
                    balle.setVitVertical(-balle.getVitVertical());
                }
            }

            if (balle.getPosY() >= hauteur - balle.getDiam()) {
                Thread.sleep(1000 / 60);
                vies.remove(0);
                balle = new Balle();
            }
            for (Bonus lebonus:lesbonus) {
                lebonus.dessiner(dessin);
                lebonus.deplacement();
                lebonus.colision(largeur,hauteur);
            }
            for (Bonus lebonus : lesbonus) {
                // Vérifiez la collision entre le bonus et la barre
                if (lebonus.collisionAvecBarre(barre)) {
                    score.bonusRamasse();
                    lesbonus.remove(lebonus);
                    break;
                }
            }
            score.dessiner(dessin);
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
            if(briques.isEmpty()){
                break;
            }
        }
        score.resetScore();
        if(briques.isEmpty()){
            JOptionPane.showMessageDialog(null, "gagner!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "perdu!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }



            //---------------------------------------------------------------------------------------------------------
    }
}
