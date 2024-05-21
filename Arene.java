
public class Arene
{
    int size;
    int [][] arena = new int[size][size];
    Snake obstacle = new Snake();

    void    fill_arene_all(int[][] arene, Snake p1, Snake p2, Snake obstacle, Snake fraise)
    {
        fill_basic_arene(arene);
        fill_arene_snake(arene, p1, 1);
        fill_arene_snake(arene, p2, 2);
        fill_arene_snake(arene, obstacle); //Faire cette fn
        fill_arene_snake(arene, fraise); //Faire cette fn
    }

    void    fill_basic_arene(int[][] arena)
    {
        for(int i; i <= size; i++)
        {
            for(int j; j <= size; j++)
            {
                if (i == 0 || j == 0 || i == size || j == size)
                {
                    arena[i][j] = 4;
                }
                else
                {
                    arene[i][j] = 0;
                }
            }
        }
    }

    void    fill_arene_element(int[][] arene, Snake element, int id)
    {
        int array_index;

        array_index = 0;
        for(int i; i <= size; i++)
        {
            for(int j; j <= size; j++)
            {
                if( i = get_x(element,array_index)  && get_y(element,array_index) == j)
                {
                    arene[i][j] = player;
                    array_index++;
                    i = 0;
                    j = 0;
                }
            }
        }
    }

    int    get_x(Snake snake, int array_index)
    {
        int[] corps = snake.get(index);
        return corps[0];
    }

    int    get_y(Snake snake, int array_index)
    {-
        int[] corps = snake.get(array_index);
        return corps[1];
    }
}