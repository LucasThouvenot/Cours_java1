package Jeu;

import java.awt.*;

public class Bonus extends Rond{

    private int vitVertical = 5;
    public Bonus(int x,int y){
        posX = x;
        posY = y;
        diam = 15;
        color = Color.cyan;
    }

    public void deplacement(){
        posY += vitVertical;
    }

    public boolean colision(int largeur,int hauteur){
        if(this.posY>=hauteur-30 ||this.posY <= 0){
            return true;
        }else{
            return false;
        }
    }
}
