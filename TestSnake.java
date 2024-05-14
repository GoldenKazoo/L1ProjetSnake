public class TestSnake{
    public static void main(String[] args)
    {
        //Cas d'un corps a un element
        int[] tete = {1,1};
        Snake snake = new Snake(tete);

        int[][] map = {
            {3, 0, 0, 3},
            {3, 1, 1, 3},
            {3, 3, 0, 3},
            {3, 3, 3, 3}
        };

        // Tests pour try checkCoup(Et au passage checkAjacent X et Y)
        System.out.println("Moove possible vers le haut: " + snake.checkCoup("haut", map));   
        System.out.println("Moove possible vers le bas: " + snake.checkCoup("bas", map));     
        System.out.println("Moove possible vers la gauche: " + snake.checkCoup("gauche", map)); 
        System.out.println("Moove possible vers la droite: " + snake.checkCoup("droite", map)); 
        snake.decalleCorps();
        snake.afficheArray();
        


    }
}