package capacite;

import serviteur.Serviteur;

public class Charge implements ICapacite{

	private String nom = "Charge", description = " quelque chose ";

	/***** CONSTRUCTEUR ******/
	public Charge() {

	}
	
	
	/***** SETTERS GETTERS *****/
	@Override
	public String getDescription() {
		return description; 
	}
	
	@Override
	public String getNom() {
		return nom;
	}
	
	
	/***** METHODS *****/
	@Override
	public void executerAction(Object cible) {
		
	}

	@Override
	public void executerEffetDebutTour() {
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		
	}
	
	@Override
	public void executerEffetFinTour() {
	}

	@Override
	public void executerMiseEnJeu(Object cible) {
		if(cible == null)
			throw new IllegalArgumentException("La cible est vide ..");
		Serviteur s = (Serviteur) cible;
		s.setPeutAttaquer(true);
	}
	
	/***** equals et toString *****/
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Charge c = (Charge) obj;
		if (description == null) {
			if (c.description != null)
				return false;
		} else if (!description.equals(c.description))
			return false;
		if (nom == null) {
			if (c.nom != null)
				return false;
		} else if (!nom.equals(c.nom))
			return false;
		return true;
	}
	public String toString() {
		return "Capacite [nom : "+nom+", Description : "+description+"]";
	}
}
