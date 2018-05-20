/**
 * 
 */
package capacite;

import HearthstoneException.HearthstoneException;

/**
 * @author aniki
 *
 */
public class Provocation implements ICapacite{

	private String nom = "Provocation", description = "Les autres cartes ne peuvent être attaquer tant que cette carte est en jeu";
	
	public Provocation() {
		
	}
	/***** GETTERS *****/
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
		// TODO Auto-generated method stub
		
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
		Provocation c = (Provocation) obj;
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
