import java.util.*;

public class Snake {
    ArrayList<int[]> snake; // Le snake sera une liste contenant du coup un tableau a 2 valeurs, x et y

    public Snake(int[] tete) {
        this.snake = new ArrayList<>();
        snake.add(tete);
    }

    public int size() {
        return snake.size();
    }

    public void ajout(int[] tab) //utile pour le fichier test
    {
        snake.add(tab);
    }

    public void decalleCorps() {
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.set(i, snake.get(i - 1).clone());
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
        int[] tete = snake.get(0);
        if (direction.equals("gauche")) {
            tete[1] = tete[1] - 1;
        } else if (direction.equals("haut")) {
            tete[0] = tete[0] - 1;
        } else if (direction.equals("bas")) {
            tete[0] = tete[0] + 1;
        } else if (direction.equals("droite")) {
            tete[1] = tete[1] + 1;
        } else {
            System.out.println("Erreur");
        }
    }

    public  int[] get (int array_index)
    {
        return (snake.get(array_index));
    }

    public void mouvement(String direction, int tour, int refresh) {
        if(tour % refresh  == 0)
        {
            int[] tab = snake.get(snake.size() - 1);
            snake.add(tab);
            decalleCorps();
            changementTete(direction);
            afficheArray();

        }else{
            decalleCorps();
            changementTete(direction);
            afficheArray();
        }
        
    }

    public void suppQueu() {
        if(snake.size() == 1 ||snake.size() == 0)
        {

        }
        else{
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
        if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && map[newX][newY] == 0) {
            return true; 
        } else {
            return false;
        }
    }

    public void afficheTab(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(" ");
            System.out.print(tab[i]);
        }
    }

    public void afficheArray() {
        for (int i = 0; i < snake.size(); i++) {
            afficheTab(snake.get(i));
            System.out.println();
        }
    }

    public ArrayList<int[]> getSnake() {
        return snake;
    }
}
