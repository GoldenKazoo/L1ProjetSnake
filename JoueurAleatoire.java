import java.util.*;
import java.util.Random;

public class JoueurAleatoire
{
	String nom;
    String coup;
	Snake snakeAleatoire;
	Random mainInnocente;
	ArrayList<String> possible;


    public JoueurAleatoire(String nom, Snake snakeAleatoire) {
        this.nom = nom;
		this.mainInnocente = new Random();
		this.snakeAleatoire = snakeAleatoire;
		this.possible = new ArrayList<String>();
    }

    public void rechercheCoup(int[][] arene) {
		int[] tete = snakeAleatoire.get(0);
		if(arene[tete[0] - 1][tete[1]] == 0)
		{
			this.possible.add("H");
			System.err.println("Oui");
		}
		if(arene[tete[0]][tete[1] - 1] == 0)
		{
			this.possible.add("G");
			System.err.println("Oui");
		}
		if(arene[tete[0]][tete[1] + 1] == 0)
		{
			this.possible.add("D");
			System.err.println("Oui");
		}
		if(arene[tete[0] + 1][tete[1]] == 0)
		{
			this.possible.add("B");
			System.err.println("Oui");
		}
		if(possible.size() == 0)
		{
			this.possible.add("H");
			System.err.println("Oui");
		}
    }



 /*    public void afficheArray() {
        for (int i = 0; i < possible.size(); i++) {
			System.out.println(possible.size());
            System.out.print(possible.get(i));
            System.out.println();
        }
    }*/

    public String getCoup() {
		int index;
	//	afficheArray();
		index = mainInnocente.nextInt(this.possible.size());
		return this.possible.get(index);
    }

	public void clear()
	{
		this.possible.clear();
	}
}
