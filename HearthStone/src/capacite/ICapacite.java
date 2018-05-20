package capacite;

import HearthstoneException.HearthstoneException;
import plateau.IPlateau;

public interface ICapacite {
	void executerAction(Object cible) throws HearthstoneException;
	void executerEffetDebutTour();
	void executerEffetDisparition(Object cible);
	void executerEffetFinTour();
	void executerEffetMiseEnJeu(Object cible);
	String getDescription();
	String getNom();
	boolean equals(Object obj);
	String toString();
}
