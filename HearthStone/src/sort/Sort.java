package sort;

import HearthstoneException.HearthstoneException;
import capacite.ICapacite;
import carte.ICarte;
import joueur.IJoueur;

public abstract class Sort implements ICarte{
	
	private String nom; 
	private ICapacite capacite;
	private int cout;
	private IJoueur proprietaire;
	
	/***** CONSTRUCTEUR 
	 * @throws HearthstoneException *****/
	public Sort(String nom, ICapacite capacite, int cout){
		setNom(nom);
		setCapacite(capacite);
		setCout(cout);
	}


	/***** SETTERS GETTERS *****/
	
	public IJoueur getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(IJoueur proprietaire){
		if (proprietaire == null) throw new IllegalArgumentException(" le proprietaire n'existe pas");
		this.proprietaire = proprietaire;
	}
	public String getNom() {
		return nom;
	}

	private void setNom(String nom){
		if (nom.equals(null) || nom.equals("")) throw new IllegalArgumentException("Le nom renseigné est vide");
		this.nom = nom;
	}

	public ICapacite getCapacite() {
		return capacite;
	}

	private void setCapacite(ICapacite capacite) {
		if (capacite.equals(null)) throw new IllegalArgumentException("Capacite invalide");
		this.capacite = capacite;
	}
	
	public int getCout() {
		return cout;
	}
	
	private void setCout(int cout){
		if (cout <= 0) throw new IllegalArgumentException("le cout doit être supérieur a 0");
		this.cout = cout;
	}
	
	/***** METHODS *****/
	
	
	public boolean disparait() {
		return true;
	}

	public void executerAction(Object cible) throws HearthstoneException {
		
	}

	public void degat (int degat) {
		
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
		Sort other = (Sort) obj;
		if (capacite == null) {
			if (other.capacite != null)
				return false;
		} else if (!capacite.equals(other.capacite))
			return false;
		if (cout != other.cout)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	public String toString() {
		return "Sort ["+nom+", Cout : "+cout+capacite.toString()+"]\n";
	}
	
}
