
public class TestJoueur {
    public static void main(String[] args) {

        Joueur joueur1 = new Joueur("J1");

        joueur1.demanderCoup();

        System.out.println("Le coup de " + joueur1.nom + " est: " + joueur1.getCoup());
    }
}

