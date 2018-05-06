package capacite;

import HearthstoneException.HearthstoneException;

public interface ICapacite {
	void executerAction(Object cible) throws HearthstoneException;
	void executerEffetDebutTour();
	void executerEffetDisparition(Object cible);
	void executerEffetFinTour();
	void executerMiseEnJeu(Object cible);
	String getDescription();
	String getNom();
	boolean equals(Object obj);
	String toString();
}
