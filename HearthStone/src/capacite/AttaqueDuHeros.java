package capacite;

import HearthstoneException.HearthstoneException;
import carte.ICarte;

public abstract class AttaqueDuHeros implements ICapacite{

	private String nom, description ;
	private int degat;
	/***** GETTERS *****/
	
	public AttaqueDuHeros(String nom, String description, int degat) {
		this.nom = nom;
		this.description = description;
		this.degat = degat;
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
	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		/*Serviteur s;
		Heros h;
		if (cible == null)
			throw new IllegalArgumentException("la cible donner en argument est null ..");
		if (cible instanceof Serviteur) {
			s = (Serviteur)cible;
			s.degat(2);
		}
		else if (cible instanceof Heros) {
			h = (Heros) cible;
			h.degat(2);
		}
		else throw new HearthstoneException("Vous ne pouvez pas attaquer cette cible : "+ cible);		
		*/
		ICarte c = (ICarte) cible;
		c.degat(degat);
	}

	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
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
		AttaqueDuHeros c = (AttaqueDuHeros) obj;
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
		return "Capacite ["+nom+" : "+description+"]";
	}

}
