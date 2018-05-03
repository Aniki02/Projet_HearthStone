package Heros;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import joueur.IJoueur;

public abstract class Heros implements ICarte{

	private String nom;
	private int pv;
	
	public Heros(String nom, int pv) {
		
	}
	
	
	/***** GETTERS SETTERS *****/
	public String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		this.nom = nom;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}


	@Override
	public boolean disparait() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getCout() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public IJoueur getProprietaire() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + pv;
		return result;
	}

	/***** METHODS *****/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heros h = (Heros) obj;
		if (nom == null) {
			if (h.nom != null)
				return false;
		} else if (!nom.equals(h.nom))
			return false;
		if (pv != h.pv)
			return false;
		return true;
	}
	
	
	
}
