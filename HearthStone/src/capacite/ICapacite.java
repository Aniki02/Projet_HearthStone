package capacite;

public interface ICapacite {
	void executerAction(Object cible);
	void executerEffetDebutTour();
	void executerEffetDisparition(Object cible);
	void executerEffetFinTour();
	void executerMiseEnJeu(Object cible);
	String getDescription();
	String getNom();
	boolean equals(Object obj);
	String toString();
}
