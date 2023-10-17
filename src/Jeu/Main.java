package Jeu;

public class Main {

    public static void main(String[] args) {
        CasseBrique casseBrique = null;
        try {
            casseBrique = new CasseBrique();
            casseBrique.demarrer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
