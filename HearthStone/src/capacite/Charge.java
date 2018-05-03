package capacite;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerMiseEnJeu() {
		
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
	
}
