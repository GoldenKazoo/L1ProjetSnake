
public class Arene
{
    int size;
    int [][] arena = new int[size][size];

    void    fill_arene_all(int[][] arene, Snake p1, Snake p2, Snake obstacle, Snake fraise)
    {
        fill_basic_arene(arene);
        fill_arene_element(arene, p1, 1);
        fill_arene_element(arene, p2, 2);
        fill_arene_element(arene, obstacle, 4); //Faire cette fn
        fill_arene_element(arene, fraise, 3); //Faire cette fn
    }

    void    fill_basic_arene(int[][] arene)
    {
        for(int i = 0; i <= size; i++)
        {
            for(int j = 0; j <= size; j++)
            {
                if (i == 0 || j == 0 || i == size || j == size)
                {
                    arene[i][j] = 4;
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
        for(int i = 0; i <= size; i++)
        {
            for(int j = 0; j <= size; j++)
            {
                if( i == get_x(element,array_index)  && get_y(element,array_index) == j)
                {
                    arene[i][j] = id;
                    array_index++;
                    i = 0;
                    j = 0;
                }
            }
        }
    }

    int    get_x(Snake snake, int array_index)
    {
        int[] corps = snake.get(array_index);
        return corps[0];
    }

    int    get_y(Snake snake, int array_index)
    {
        int[] corps = snake.get(array_index);
        return corps[1];
    }

    public  void    main(String[] args)
    {

    }
}