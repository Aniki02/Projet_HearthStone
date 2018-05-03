package capacite;

public interface ICapacite {
	void executerAction(Object o);
	void executerEffetDebutTour();
	void executerEffetFinTour();
	void executerMiseEnJeu();
	String getDescription();
	String getNom();
	boolean equals(Object obj);
	String toString();
}
