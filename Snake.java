import java.util.*;

public class Snake {
    ArrayList<int[]> snake; // Le snake sera une liste contenant du coup un tableau a 2 valeurs, x et y

    public Snake(int[] tete) {
        this.snake = new ArrayList<>();
        snake.add(tete);
    }

    public void decalleCorps() { // Cette fonction permet de décaler la liste snake du dernier élément au premier
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.set(i, snake.get(i - 1));
        }
    }

    public void modifValeur(int index, int valeur) {
        int[] tete = snake.get(0);
        if (index >= 0 && index < tete.length) {
            tete[index] = tete[index] + valeur;
        } else {
            System.out.println("Index invalide mais ça risque pas d'arriver, on est jamais trop prudent n'est-ce pas");
        }
    }

    public void changementTete(String direction) {
        if (direction.equals("haut")) {
            modifValeur(0, -1);
        } else if (direction.equals("gauche")) {
            modifValeur(1, -1);
        } else if (direction.equals("droite")) {
            modifValeur(1, 1);
        } else if (direction.equals("bas")) {
            modifValeur(0, 1);
        } else {
            System.out.println("Erreur");
        }
    }

    public void mouvement(String direction, boolean  tour) {
        if(tour  == true)
        {
            int[] tab = snake.get(snake.size() - 1);
            decalleCorps();
            snake.add(tab);
            changementTete(direction);
        }else{
            decalleCorps();
            changementTete(direction);
        }
    }

    public void suppQueu(boolean tour, int[][] map) {
        int[] tete = snake.get(0);
        int newX = tete[0];
        int newY = tete[1];

        if(map[newX][newY] == 4) 
        {
            snake.remove(snake.size() - 1);
        }
}


    public int checkAdjacentX(String direction) {
        int[] tete = snake.get(0);
        if (direction.equals("haut")) {
            return tete[0] - 1;
        } else if (direction.equals("bas")) {
            return tete[0] + 1;
        } else {
            return tete[0];
        }
    }

    public int checkAdjacentY(String direction) {
        int[] tete = snake.get(0);
        if (direction.equals("gauche")) {
            return tete[1] - 1;
        } else if (direction.equals("droite")) {
            return tete[1] + 1;
        } else {
            return tete[1];
        }
    }

    public boolean checkCoup(String direction, int[][] map) {
        int newX = checkAdjacentX(direction);
        int newY = checkAdjacentY(direction);
        if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
            return map[newX][newY] == 0;
        } else {
            return false;
        }
    }

    public void afficheTab(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    public void afficheArray() {
        for (int i = 0; i < snake.size(); i++) {
            afficheTab(snake.get(i));
            System.out.println();
        }
    }

  /*   public static void main(String[] args) {
        int[] tab1 = {1, 2};
        int[] tab2 = {3, 4};
        int[] tab3 = {5, 6};
        int[] tab4 = {7, 8};

        Snake snake = new Snake(tab1);
        snake.snake.add(tab2);
        snake.snake.add(tab3);
        snake.snake.add(tab4);

        // Example method calls
        snake.afficheArray();
        System.out.println();

        snake.decalleCorps();
        snake.afficheArray();
        System.out.println();
    } */
}
