package capacite;

import HearthstoneException.HearthstoneException;
import Heros.Heros;
import carte.ICarte;
import serviteur.Serviteur;

public class BouleDeFeu implements ICapacite{

	private String nom = "Boule de feu", description = " quelque chose ";
	
	public BouleDeFeu() {
		
	}
	
	/**** GETTERS *****/
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	/***** METHODS 
	 * @throws HearthstoneException *****/
	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		if (cible == null)
			throw new IllegalArgumentException("la cible donner en argument est null ..");
		
		if (cible instanceof Serviteur) {
			Serviteur s = (Serviteur) cible;
			s = (Serviteur) s.getProprietaire().getCarteEnJeu(s.getNom());
			s.setPv(s.getPv() - 2);
		}
		else if (cible instanceof Heros) {
			Heros h = (Heros) cible;
			h.setPv(h.getPv() - 2);
		}
		else throw new HearthstoneException("Vous ne pouvez pas attaquer cette cible : "+ cible);
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
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}
	
	

	/***** EQUALS TOSTRING *****/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BouleDeFeu b = (BouleDeFeu) obj;
		if (description == null) {
			if (b.description != null)
				return false;
		} else if (!description.equals(b.description))
			return false;
		if (nom == null) {
			if (b.nom != null)
				return false;
		} else if (!nom.equals(b.nom))
			return false;
		return true;
	}
	
	public String toString() {
		return "Capacite [nom : "+nom+", Description : "+description+"]";
	}

	
	
}
