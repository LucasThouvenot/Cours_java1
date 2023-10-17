package Jeu;

import javax.swing.*;
import java.awt.*;
public class Balle extends Sprite{

    private int vitHorizontal = 7;
    private int vitVertical = 9;

    private int diam = 30;

    public Balle(){
        setPosX(50);
        setPosY(50);
        color = Color.blue;
    }

    public void deplacement(){
        posX += vitHorizontal;
        posY += vitVertical;
    }

    public void colision(int largeur,int hauteur){
        if(this.posX>=largeur-30|| this.posX <= 0 ){
            this.vitHorizontal = - this.vitHorizontal;
        }
        if(this.posY>=hauteur-30 ||this.posY <= 0){
            this.vitVertical = - this.vitVertical;
        }
    }
    @Override
    public void dessiner(Graphics2D dessin){
        dessin.setColor(this.color);
        dessin.fillOval(posX,posY,diam,diam);
    }
}
