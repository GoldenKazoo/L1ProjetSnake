import java.util.Random;
import javax.swing.*;

public class Arene extends JFrame{
    public int size;
    public int[][] arena;

    public Snake snake1;
    public Snake snake2;

    public Joueur joueur1;
    public Joueur joueur2;

    public Affichage affichage;
    public int tour;
    public int refreshtour;
    public Random random;

    public Arene(int size, int refreshtour, int tailleFenetre) {
        this.size = size;
        this.arena = new int[size][size];
        this.snake1 = new Snake(new int[]{2, 4});
        this.snake2 = new Snake(new int[]{2, 16});
        this.joueur1 = new Joueur("P1");
        this.joueur2 = new Joueur("P2");
        this.affichage = new Affichage(tailleFenetre, tailleFenetre, arena);
        this.tour = 0;
        this.refreshtour = refreshtour;
        this.random = new Random();
        fillArena();
    }

    public void fillArena() {
        // Placer les snakes dans l'arène
        placeSnake(arena, snake1, 1);
        placeSnake(arena, snake2, 2);

        // Placer les obstacles et les fruits
        placeObstacles();
        placeFruits();
    }

    public void placeSnake(int[][] arene, Snake element, int id) 
{
    int array_index = 0;
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            if (array_index < element.size() && i == get_x(element, array_index) && j == get_y(element, array_index))
            {
                arene[i][j] = id;
                array_index++;
            }
        }
    }
}


    int get_x(Snake snake, int array_index)
    {
        int[] corps = snake.get(array_index);
        return corps[0];
    }

    int    get_y(Snake snake, int array_index)
    {
        int[] corps = snake.get(array_index);
        return corps[1];
    }

    public void placeObstacles() {
        for(int i = 0; i <= size - 1; i++)
        {
            for(int j = 0; j <= size - 1; j++)
            {
                if (i == 0 || j == 0 || i == size - 1 || j == size - 1)
                {
                    arena[i][j] = 4;
                }
                else
                {
                    arena[i][j] = 0;
                }
            }
        }
    }

    public void placeFruits() {
        //faire fn 
    }

    public void update() {
    tour++;
    joueur1.demanderCoup();
    if (joueur1.getCoup() != null) {
        snake1.mouvement(joueur1.getCoup(), tour % refreshtour == 0);
        placeSnake(arena, snake1, 1);
        snake1.suppQueu(tour % refreshtour == 0, arena);
        affichage.repaint();
    }
    joueur2.demanderCoup();
    if (joueur2.getCoup() != null) {
        snake2.mouvement(joueur2.getCoup(), tour % refreshtour == 0);
        System.out.println("Pass");
        placeSnake(arena, snake2, 2);
        snake2.suppQueu(tour % refreshtour == 0, arena);
        affichage.repaint();
    }

    // maj de l'affichage
    affichage.repaint();

    // implementer les colision
    // A faire : implémenter la logique pour vérifier si un joueur a perdu
}

    public static void main(String[] args) {
        int tailleFenetre = 800;
        int tailleArene = 20; 
        int refreshtour = 5;
        Arene arene = new Arene(tailleArene, refreshtour, tailleFenetre);

        JFrame frame = new JFrame("Snake-Blockade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tailleFenetre, tailleFenetre);
        frame.setLocationRelativeTo(null);
        frame.add(arene.affichage);
        frame.pack();
        frame.setVisible(true);
        while (true) {
            for (int i = 0; i < arene.arena.length; i++) {
                for (int j = 0; j < arene.arena[i].length; j++) {
                    System.out.print(arene.arena[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Pass");
            arene.update();
        }
    }
}