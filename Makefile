NAME = Projet

CFLAGS =

SRCS = Affichage.java Joueur.java Arene.java Snake.java TestAffichage.java TestJoueur.java TestSnake.java

all: ${NAME}

${NAME}:
		javac ${SRCS}

clean:
		-rm -f *.class

fclean: clean
		-rm -f ${NAME}

re : fclean all

.PHONY: all clean fclean re
