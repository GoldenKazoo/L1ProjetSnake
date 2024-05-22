public class TestSnake{
    public static void main(String[] args)
    {
       // On initialise les choses dont on va avoir besoin pour ces tests

        int[] tete = {2,2};
        int[] corps = {2,1};
        int[] queu = {1,1};

        Snake snake = new Snake(tete);
        snake.ajout(corps);
        snake.ajout(queu);

        int[][] map = {
            {3, 3, 3, 3},
            {3, 1, 1, 3},
            {3, 0, 1, 3},
            {3, 3, 3, 3}
        };

        // - Position du corps dans l'ordre ✔
        // Test de AfficheTab et Array
        snake.afficheArray();

        // - Recherche d'une position ✔
        // Tests pour checkCoup(Et au passage checkAjacent X et Y)
        System.out.println("");
        System.out.println("Moove possible vers le haut: " + snake.checkCoup("haut", map));   
        System.out.println("Moove possible vers le bas: " + snake.checkCoup("bas", map));     
        System.out.println("Moove possible vers la gauche: " + snake.checkCoup("gauche", map)); 
        System.out.println("Moove possible vers la droite: " + snake.checkCoup("droite", map)); 
        System.out.println("");
    
    
        // - Deplacement du corps ✔
        // Tests pour mouvement
        snake.mouvement("gauche", 5, 6);
        snake.afficheArray();
        // - Suppression ou pas de la derniere position ✔
        // Tests pour suppQueu 
        System.out.println("");
        snake.suppQueu();
        snake.afficheArray();







    


    }
}