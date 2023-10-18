package Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Barre extends Rectangle{

    private int vitesse = 25;



    public Barre(){
        posX=350;
        posY=750;
        largeur = 60;
        hauteur = 10;
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
        dessin.fillRect(posX, posY, largeur, hauteur);
    }
}
