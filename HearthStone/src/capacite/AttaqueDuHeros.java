package capacite;

import HearthstoneException.HearthstoneException;
import carte.ICarte;

public abstract class AttaqueDuHeros extends Capacite{

	private int degat;
	/***** GETTERS *****/
	
	public AttaqueDuHeros(String nom, String description, int degat) {
		super(nom, description);
		this.degat = degat;
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

}
