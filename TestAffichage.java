import javax.swing.*;

public class TestAffichage extends JPanel {
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

}
