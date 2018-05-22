package capacite;

import HearthstoneException.HearthstoneException;

public abstract class Capacite implements ICapacite{

	private String nom, description;
	
	public Capacite (String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
	
/***** METHODS *****/
	
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}


	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}

	
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}


	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}


	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
		
	}

	
/***** equals et toString *****/
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provocation c = (Provocation) obj;
		if (this.getDescription() == null) {
			if (c.getDescription() != null)
				return false;
		} else if (!this.getDescription().equals(c.getDescription()))
			return false;
		if (this.getNom() == null) {
			if (c.getNom() != null)
				return false;
		} else if (!this.getNom().equals(c.getNom()))
			return false;
		return true;
	}
	
	public String toString() {
		return "Capacite ["+this.getNom()+" : "+this.getDescription()+"]";
	}

}
