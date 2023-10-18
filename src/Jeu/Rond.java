package Jeu;

import java.awt.*;

public abstract class Rond extends Sprite{

    protected int diam;

    public int getDiam() {
        return diam;
    }
    @Override
    public void dessiner(Graphics2D dessin){
        dessin.setColor(this.color);
        dessin.fillOval(posX,posY,diam,diam);
    }


}
