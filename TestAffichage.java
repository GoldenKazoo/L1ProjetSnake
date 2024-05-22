import javax.swing.*;

public class TestAffichage extends JPanel {
    public static void main(String[] args) {
        int tailleFenetre = 800;
        int[][] arene = {
            {4, 4, 4, 4},
            {4, 1, 2, 4},
            {4, 0, 0, 4},
            {4, 4, 4, 4}
        };

        JFrame frame = new JFrame("Affichage du Tableau");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tailleFenetre, tailleFenetre);
        frame.setLocationRelativeTo(null);

        Affichage affichage = new Affichage(tailleFenetre, tailleFenetre, arene);
        frame.add(affichage);
        frame.setVisible(true);
    }

}
