package Jeu;

import java.awt.*;

public abstract class Sprite {


    protected int posX;
    protected int posY;
    protected Color color;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(color);
    }



}
