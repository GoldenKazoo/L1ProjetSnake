public class Snake{
    
    int [] snakePosition;

    public static void main(String[] args) {
        newSnake();
    }

    public static void newSnake(){
        Snake s1 = new Snake();
        snakeTab(s1);
        Snake s2 = new Snake();
        snakeTab(s2);
    }

    public static Snake snakeTab(Snake s){
        s.snakePosition = new int [1];
        
        return s;
    }

    public static void getSnakesosition(Snake s) {
        int[] position = new int[2];
        for (int i = 0; i < s.snakePosition.length; i++) {
            position[0] = s.snakePosition[i] / size;
            position[1] = s.snakePosition[i] % size;
        }                     
    }
}