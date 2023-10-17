package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Barre extends Sprite{


    private int largeur = 60;
    private int hauteur = 10;
    private int vitesse = 15;

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Barre(){
        setPosX(350);
        setPosY(450);
        color = Color.red;
    }
    public void moveLeft(){
        if (posX>0){
            posX -= vitesse;
        }
    }

    public void moveRight(){
        if(posX<640){
            posX += vitesse;
        }
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(this.color);
        dessin.fillRect(super.posX, super.posY, largeur, hauteur);
    }
}
