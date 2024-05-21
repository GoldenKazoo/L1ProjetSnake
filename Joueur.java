import java.util.Scanner;
import javax.swing.*;

public class Joueur {
    String nom;
    String coup;

    public Joueur(String nom) {
        this.nom = nom;
    }

    public void demanderCoup() {
        coup = JOptionPane.showInputDialog(null, nom + ", entre ton coup:", "C'est l'heure du-du-du-duel", JOptionPane.PLAIN_MESSAGE);

        if (coup == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tu as rien mis, entre un coup la:");
            coup = scanner.nextLine();
        }
    }

    public String getCoup() {
        return coup;
    }
}
