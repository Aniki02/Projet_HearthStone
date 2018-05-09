package Heros;

import HearthstoneException.HearthstoneException;
import capacite.ICapacite;
import carte.ICarte;
import joueur.IJoueur;

public abstract class Heros implements ICarte{

	private String nom;
	private int pv;
	private ICapacite pouvoir;
	private IJoueur proprietaire;
	
	public Heros(String nom, int pv, ICapacite pouvoir) {
		setNom(nom);
		setPv(pv);
		setCapacite(pouvoir);
	}
	
	
	/***** GETTERS SETTERS *****/
	public String getNom() {
		return nom;
	}

	private void setNom(String nom){
		if (nom.equals(null) || nom.equals("")) throw new IllegalArgumentException("le nom renseigné est vide !!");
		this.nom = nom;
	}

	public int getPv(){
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public ICapacite getCapacite() {
		return pouvoir;
	}


	public void setCapacite(ICapacite pouvoir){
		if (pouvoir.equals(null)) throw new IllegalArgumentException("Le pouvoir est invalide !!");
		this.pouvoir = pouvoir;
	}


	/***** METHODS *****/
	@Override
	public boolean disparait() {
		return false;
	}


	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		getCapacite().executerAction(cible);
	}


	@Override
	public int getCout() {
		return 0;
	}


	@Override
	public IJoueur getProprietaire() {
		return proprietaire;
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
		return "Heros [nom : "+nom+", Point de vie : "+pv+" "+pouvoir.toString()+"]";
	}
	
}
