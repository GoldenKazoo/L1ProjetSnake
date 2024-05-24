import java.util.Random;
import java.util.ArrayList;

import javax.swing.*;

public class AreneContreIA extends JFrame{
    public int size;
    public int[][] arena;

    public Snake snake1;
    public Snake snake2;
    public Snake fruits;
    public Joueur joueur1;
    public JoueurAleatoire IA;
    public int tour;
    public Affichage affichage;
    public Tour objtour = new Tour();
    public int refreshtour;
    public Random random;
    int nbFruits = 0;

    public AreneContreIA(int size, int refreshtour, int tailleFenetre) {
        this.size = size;
        this.arena = new int[size][size];
        this.snake1 = new Snake(new int[]{2, 4});
        this.snake2 = new Snake(new int[]{2, 16});
        this.fruits = new Snake(new int[] {9, 9});
        this.joueur1 = new Joueur("P1");
        this.IA = new JoueurAleatoire("Bob", snake2);
        this.affichage = new Affichage(tailleFenetre, tailleFenetre, arena);
        this.tour = 0;
        this.refreshtour = objtour.getTour();
        this.random = new Random();
        fillArena();
    }

    public void fillArena() {
        placeObstacles();
        placeElement(arena, snake2, 2);
        placeElement(arena, snake1, 1);
        placeElement(arena, fruits, 3);
    }

    public void placeElement(int[][] arene, Snake element, int id)
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
                i = 0;
                j = 0;
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


    public void generationFruits() {
        int[] fruitCoordonnee = new int[2];
        while(nbFruits <= 1)
        {
            Random number = new Random();
            while(fruits.snake.size() <= 1)
            {
            fruitCoordonnee[0] = 1 + number.nextInt(18);
            fruitCoordonnee[1] = 1 + number.nextInt(18);
            fruits.snake.add(fruitCoordonnee);
            nbFruits++;
            }
            nbFruits++;
        }

    }

    public void update() {
    generationFruits();
    tour++;
    boolean lose = false;
    if (lose == false) {
        joueur1.demanderCoup();
        if (joueur1.getCoup() != null) {
			lose = endGame(snake1, joueur1);
            if (lose == true) {
                loseFrame(joueur1);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);

            } else {
                snake1.mouvement(joueur1.getCoup(), tour,refreshtour);
                fillArena();
                affichage.repaint();
            }
    }
    }
    if (lose == false) {
		IA.rechercheCoup(arena);
        if (IA.getCoup() != null) {
            lose = endGame(snake2, IA);
            if (lose == true) {
                loseFrame(IA);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.exit(0);
            } else {
                snake2.mouvement(IA.getCoup(), tour, refreshtour);
				IA.clear();
                fillArena();
                affichage.repaint();
                }
            }
    }
    }

    public boolean checkCoup(String direction, int[][] map, Snake s) {
        int newX = s.checkAdjacentX(direction);
        int newY = s.checkAdjacentY(direction) ;
        if((map[newX][newY] == 3))
        {
            s.suppQueu();
            return true;
        }
        if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && (map[newX][newY] == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void loseFrame(JoueurAleatoire IA){
        JFrame frame = new JFrame("C'est un bide");
        JLabel lose = new JLabel(IA.nom + " a perdu");
        lose.setBounds(20, 20, 200, 28);

        frame.add(lose);
        frame.setSize(250,180);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void suppFraise(Snake fraise, Snake s)
    {
        for(int i = 0; i <= fraise.snake.size() - 1; i++)
        {
            System.out.println(get_x(s, 0));
            System.out.println(get_y(s,0));
            System.out.println(get_x(fraise,i));
            System.out.println(get_y(fraise, i));
            s.afficheArray();
            System.out.println();
            fraise.afficheArray();
            System.out.println("-----------------------------------");
            if(get_x(fraise,i) == get_x(s, 0) && get_y(fraise, i) == get_y(s,0))
            {
                fraise.snake.remove(i);
            }
        }
    }

    public boolean endGame(Snake s, JoueurAleatoire j){
        // getDirection est une fonction permettant d'avoir la direction du joueur
        String direction = j.getCoup();
        boolean game = checkCoup(direction, arena, s);
        if (game == true) {
            return false;
        } else {
            return true;
        }
    }

	public void loseFrame(Joueur joueur){
        JFrame frame = new JFrame("C'est un bide");
        JLabel lose = new JLabel(joueur.nom + " a perdu");
        lose.setBounds(20, 20, 200, 28);

        frame.add(lose);
        frame.setSize(250,180);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public boolean endGame(Snake s, Joueur j){
        // getDirection est une fonction permettant d'avoir la direction du joueur
        String direction = j.getCoup();
        boolean game = checkCoup(direction, arena, s);
        if (game == true) {
            return false;
        } else {
            return true;
        }
    }
    // A faire : implémenter la logique pour vérifier si un joueur a perdu


    public static void main(String[] args) {
        int tailleFenetre = 800;
        int tailleArene = 20;
        int refreshtour = 5;
        AreneContreIA arene = new AreneContreIA(tailleArene, refreshtour, tailleFenetre);

        JFrame frame = new JFrame("Snake-Blockade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tailleFenetre, tailleFenetre);
        frame.setLocationRelativeTo(null);
        frame.add(arene.affichage);
        frame.pack();
        frame.setVisible(true);
        while (true) {
       /*     for (int i = 0; i < arene.arena.length; i++) {
                for (int j = 0; j < arene.arena[i].length; j++) {
                    System.out.print(arene.arena[i][j] + " ");
                }
                System.out.println();
            }*/
            arene.update();
        }
    }
}
