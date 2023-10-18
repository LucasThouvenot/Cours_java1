package Jeu;

import java.awt.*;

public class Brique extends Rectangle{

    public Brique(int x, int y){
        posX = x;
        posY = y;
        largeur = 30;
        hauteur = 15;
        color = Color.orange;
    }
    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(this.color);
        dessin.fillRect(posX, posY, largeur, hauteur);
    }

    public boolean collisionAvecBalle(Balle balle) {
        return (balle.getPosX() + balle.getDiam() > posX &&
                balle.getPosX() < posX + largeur &&
                balle.getPosY() + balle.getDiam() > posY &&
                balle.getPosY() < posY + hauteur);
    }





}
