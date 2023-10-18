package Jeu;

import java.awt.*;

public class Score {

    int score;
    public Score(){
        score = 0;
    }
    public void briqueCasse(){
        score += 20;
    }

    public void bonusRamasse(){
        score+=50;
    }

    public void resetScore(){
        score = 0;
    }
    public void dessiner(Graphics2D dessin){
        dessin.setColor(Color.black);
        dessin.setFont(new Font("Arial", Font.BOLD, 20));
        dessin.drawString("Score: " + score, 10, 20);
    }
}
