package Jeu;

import java.awt.*;

public abstract class Rectangle extends Sprite{
    protected int largeur;
    protected int hauteur;

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(this.color);
        dessin.fillRect(posX, posY, largeur, hauteur);
    }
}
