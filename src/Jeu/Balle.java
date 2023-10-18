package Jeu;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class Balle extends Rond{

    public int getVitHorizontal() {
        return vitHorizontal;
    }

    public void setVitHorizontal(int vitHorizontal) {
        this.vitHorizontal = vitHorizontal;
    }

    public int getVitVertical() {
        return vitVertical;
    }

    public void setVitVertical(int vitVertical) {
        this.vitVertical = vitVertical;
    }

    private int vitHorizontal = 5;
    private int vitVertical = 6;

    public Balle(){
        Random random = new Random();
        posX = random.nextInt(400) + diam ;
        posY = 200;
        diam = 30;
        color = Color.BLUE;
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
