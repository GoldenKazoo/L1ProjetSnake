import javax.swing.*;
public class Affichage {

public static void main(String [] args)
{
    int FenetreTaille = 600;
    JFrame fenetre = new JFrame("Blockade");
    fenetre.setVisible(true);
    fenetre.setSize(FenetreTaille,FenetreTaille);
    fenetre.setLocationRelativeTo(null); //pour ouvrir au centre
    fenetre.setResizable(true);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Arene arena = new Arene (FenetreTaille, FenetreTaille);
    fenetre.add(arena);
    fenetre.pack(); //nescessaire sinon la barre avec le nom du jeu est pris en compte dans le ration de pixels


}
}