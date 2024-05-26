import javax.swing.*;

public class Joueur {
    String nom;
    String coup;

    public Joueur(String nom) {
        this.nom = nom;
    }
    // Fonction qui demande au jouer le coup qu'il souhaite effectuer
    public void demanderCoup() {
        boolean answer = false;
        while (answer != true) {
            coup = JOptionPane.showInputDialog(null, nom + ", entre ton coup:", "C'est l'heure du-du-du-duel", JOptionPane.PLAIN_MESSAGE);
            if (coup.equals("H")) {
                answer = true;
            } else if (coup.equals("B")) {
                answer = true;
            } else if (coup.equals("D")) {
                answer = true;
            } else if (coup.equals("G")) {
                answer = true;
            } else {
                answer = false;
            }
        }
    }

    public String getCoup() {
        return coup;
    }
}
