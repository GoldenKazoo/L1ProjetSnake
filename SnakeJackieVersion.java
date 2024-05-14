import java.util.*;
public class Snake{
    
    int nbTour = 0;
    int nbTourAvantDeGrandir;
    int [] snakePosition;

    public static void main(String[] args) {
        newSnake();
    }
    
    // Creation des snakes des player 1 et 2
    public static void newSnake(){
        Snake s1 = new Snake();
        snakeTab(s1);
        Snake s2 = new Snake();
        snakeTab(s2);
    }

    //  Creation du tableau qui contiendra le snake
    public static Snake snakeTab(Snake s){
        s.snakePosition = new int [1];
        
        return s;
    }

    // Fonction qui sert a obtenir les coordonnes x et y d'une case du snake dans le grillage qui est un double tableeau
    public static int [] getPosition(int x){
        int size = 0;
        int [] position = new int [2];
        position[0] = x % size;
        position[1] = x / size;

        return position;
    }

    // Fonction qui demande au joueur d'entrer son prochain movement avec le snake 
    public static String getNextMove(){
        Scanner move = new Scanner(System.in);
        System.out.println("Chose a direction : 1 = left, 2 = right, 3 = up, 4  down");
        move.close();
        String direction = move.nextLine();
        return direction;
    }
    
    // Fonction qui permet de faire bouger le snake dans son tableau s.snakePosition
    public static int[] moveSnake(Snake s){
        String deplacement = getNextMove();
        if (s.nbTour % s.nbTourAvantDeGrandir == 0) {
            
            s.nbTour ++;
        } else {
            if (deplacement.equals("1")) {
            
            } else if (deplacement.equals("2")) {
            
            } else if (deplacement.equals("3")) {
            
            } else {

            }
            s.nbTour ++;
        }
        return s.snakePosition;
    }
}