package Jeu;

import java.awt.*;

public class Vie extends Rond{

    public Vie(int x, int y){
        posX = x;
        posY = y;
        diam = 20;
        color = Color.RED;
    }
    @Override
    public void dessiner(Graphics2D dessin){
        dessin.setColor(this.color);
        dessin.fillOval(posX,posY,diam,diam);
    }
}
