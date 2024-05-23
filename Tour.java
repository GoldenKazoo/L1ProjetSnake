import java.util.Scanner;
import javax.swing.*;
import java.lang.Integer;

public class Tour {
    String tour;

    public void demandertour() {
        tour = JOptionPane.showInputDialog(null, "Vos snake grandiront tout les n tours, choisissez n", "Pourquoi tant de N, L, est ce parceque personne ne vous M", JOptionPane.PLAIN_MESSAGE);

        if (tour == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tu as rien mis, entre un tour la:");
            tour = scanner.nextLine();
            scanner.close();
        }
    }

    public int getTour() {
        demandertour();
        return Integer.parseInt(this.tour);
    }
}
