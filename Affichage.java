import java.awt.*;
import javax.swing.*;

public class Affichage extends JPanel {

    int tailleLargeur;
    int tailleHauteur;
    int tailleTuile = 40  ;
    int[][] arene;

    public Affichage(int tailleLargeur, int tailleHauteur, int[][] arene) {
        this.tailleLargeur = tailleLargeur;
        this.tailleHauteur = tailleHauteur;
        this.arene = arene;

        setPreferredSize(new Dimension(this.tailleLargeur, this.tailleHauteur));
        setBackground(Color.black);
    }

    public void paintComponent(Graphics obj) {
        super.paintComponent(obj);
        draw(obj);
    }

    public void draw(Graphics obj) {
        for (int i = 0; i < arene.length; i++) {
            for (int j = 0; j < arene[i].length; j++) {
                if(arene[i][j] == 0)
                {
                    obj.setColor(Color.black);
                    obj.fillRect(j * tailleTuile, i * tailleTuile, tailleTuile, tailleTuile);
                }
                else if(arene[i][j] == 1)
                {
                    obj.setColor(Color.red);
                    obj.fillRect(j * tailleTuile, i * tailleTuile, tailleTuile, tailleTuile);
                }
                else if(arene[i][j] == 2)
                {
                    obj.setColor(Color.blue);
                    obj.fillRect(j * tailleTuile, i * tailleTuile, tailleTuile, tailleTuile);
                }
                else if(arene[i][j] == 3)
                {
                    obj.setColor(Color.yellow);
                    obj.fillRect(j * tailleTuile, i * tailleTuile, tailleTuile, tailleTuile);
                }
                else
                {
                    obj.setColor(Color.white);
                    obj.fillRect(j * tailleTuile, i * tailleTuile, tailleTuile, tailleTuile);
                }
                }
            }
        }
    }

