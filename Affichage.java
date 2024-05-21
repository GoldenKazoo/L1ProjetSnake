import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Affichage extends JPanel {

    int tailleLargeur;
    int tailleHauteur;
    int tailleTuile = 100;
    Snake p1 = new Snake();
    Tuile teteP1;
    Tuile teteP2;
    Tuile mur;
    Tuile fraise;
    Random random1;
    Random random2;
    Color p1Color = new Color(128, 0, 128);
    Color p2Color = new Color(255, 255, 153);

    public Affichage(int tailleLargeur, int tailleHauteur) {
        this.tailleLargeur = tailleLargeur;
        this.tailleHauteur = tailleHauteur;

        setPreferredSize(new Dimension(this.tailleLargeur, this.tailleHauteur));
        setBackground(Color.black);
        teteP1 = new Tuile(2, 2);
        teteP2 = new Tuile(5, 2);
        fraise = new Tuile();
        mur = new Tuile();
        random1 = new Random();
        random2 = new Random();
        placerFraise();
        placerObstacle();

    }

    protected void paintComponent(Graphics obj) {
        super.paintComponent(obj);
        draw(obj);
    }

    public void draw(Graphics obj) {
        //p1
        obj.setColor(p1Color);
        obj.fillRect(teteP1.x * tailleTuile, teteP1.y * tailleTuile, tailleTuile, tailleTuile);

        //p2
        obj.setColor(p2Color);
        obj.fillRect(teteP2.x * tailleTuile, teteP2.y * tailleTuile, tailleTuile, tailleTuile);
    

        //- Afficher le cadrillage de l'Arene
        //Grille
        for(int i = 0; i < tailleHauteur/tailleTuile;i++)
        {
            obj.setColor(Color.white);
            obj.drawLine(i*tailleTuile, 0, i*tailleTuile, i* tailleHauteur);
            obj.drawLine(0, i*tailleTuile, tailleLargeur, i*tailleTuile);
        }

        for(int i = 0; i < p1.size(); i++)
        {

        }

        //Fraise
        obj.setColor(Color.red);
        obj.fillRect(fraise.x * tailleTuile, fraise.y * tailleTuile, tailleTuile, tailleTuile);

        //Mur
        obj.setColor(Color.white);
        obj.fillRect(mur.x * tailleTuile, mur.y * tailleTuile, tailleTuile, tailleTuile);

    }
    // - Afficher fraise ou obstacle
    public void placerFraise()
    {
        fraise.x = random1.nextInt(tailleLargeur/tailleTuile);
        fraise.y = random1.nextInt(tailleHauteur/tailleTuile);
    }

    public void placerObstacle()
    {
        mur.x = random2.nextInt(tailleLargeur/tailleTuile);
        mur.y = random2.nextInt(tailleHauteur/tailleTuile);
    }

    public static void main(String[] args) {
        int tailleFenetre = 800;

        JFrame frame = new JFrame("Snake-Blockade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tailleFenetre, tailleFenetre);
        frame.setLocationRelativeTo(null);

        Affichage cadre = new Affichage(tailleFenetre, tailleFenetre);
        frame.add(cadre);
        frame.pack();
        frame.setVisible(true);
    }

    private class Tuile {
        int x;
        int y;

        Tuile(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Tuile() //pour creer la  fraise sans erreur
        {
            this.x = 0;
            this.y = 0;
        }
    }
}
