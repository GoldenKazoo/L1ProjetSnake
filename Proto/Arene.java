import javax.swing.*;
import java.awt.*;

public class Arene extends JPanel
{
    int areneLargeur;
    int areneHauteur;

    Arene(int areneLargeur, int areneHauteur)
    {
        this.areneLargeur = areneLargeur;
        this.areneHauteur = areneHauteur;
        setPreferredSize(new Dimension(this.areneLargeur, this.areneHauteur));
        setBackground(Color.black);

    }

    public class Tuile
    {
        int x;
        int y;

        Tuile(int x, int y)
        {
           this.x =  x;
           this.y = y;
        }
    }
}