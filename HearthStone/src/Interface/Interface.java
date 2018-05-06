package Interface;

import HearthstoneException.HearthstoneException;
import plateau.IPlateau;

public abstract class Interface {

	private Interface suivant = null;
	
	
	public Interface(Interface suivant) {
		this.suivant = suivant;
	}
 
	public Interface getSuivant() {
		return suivant;
	}
	
	public abstract boolean saitInteragir(String choix);
	public abstract void executerRequete(IPlateau p) throws HearthstoneException;
	public abstract String getDescription();
	public void interagir(String choix, IPlateau p) throws HearthstoneException {
		if (saitInteragir(choix))
			executerRequete(p);
		else if (suivant != null)
			suivant.interagir(choix, p);
		else 
			throw new HearthstoneException("Pas d'interaction pour "+ choix);
	}
	
}
