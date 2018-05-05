package Heros;

import HearthstoneException.HearthstoneException;
import capacite.ICapacite;
import carte.ICarte;
import joueur.IJoueur;

public abstract class Heros implements ICarte{

	private String nom;
	private int pv;
	private ICapacite pouvoir;
	
	public Heros(String nom, int pv, ICapacite pouvoir) throws HearthstoneException {
		setNom(nom);
		setPv(pv);
		setCapacite(pouvoir);
	}
	
	
	/***** GETTERS SETTERS *****/
	public String getNom() {
		return nom;
	}

	private void setNom(String nom) throws HearthstoneException {
		if (nom.equals(null) || nom.equals("")) throw new HearthstoneException("le nom renseigné est vide !!");
		this.nom = nom;
	}

	public int getPv(){
		
		return pv;
	}

	public void setPv(int pv)  throws HearthstoneException {
		if (pv <= 0) throw new HearthstoneException("Les pv doivent être supérieur a 0");
		this.pv = pv;
	}

	public ICapacite getCapacite() {
		return pouvoir;
	}


	public void setCapacite(ICapacite pouvoir) throws HearthstoneException {
		if (pouvoir.equals(null)) throw new HearthstoneException("Le pouvoir est invalide !!");
		this.pouvoir = pouvoir;
	}


	/***** METHODS *****/
	@Override
	public boolean disparait() {
		
		return false;
	}


	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		
	}


	@Override
	public int getCout() {
		return 0;
	}


	@Override
	public IJoueur getProprietaire() {
		// TODO Auto-generated method stub
		return null;
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
	
	public String toString() {
		return "Heros [nom : "+nom+", Point de vie : "+pv+pouvoir.toString()+"]";
	}
	
}
