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
	public Sort(String nom, ICapacite capacite, int cout, IJoueur proprietaire) throws HearthstoneException {
		setNom(nom);
		setCapacite(capacite);
		setCout(cout);
		setProprietaire(proprietaire);
	}


	/***** SETTERS GETTERS *****/
	
	public IJoueur getProprietaire() {
		return proprietaire;
	}
	private void setProprietaire(IJoueur proprietaire) throws HearthstoneException {
		if (proprietaire == null) throw new HearthstoneException(" le proprietaire n'existe pas");
		this.proprietaire = proprietaire;
	}
	public String getNom() {
		return nom;
	}

	private void setNom(String nom) throws HearthstoneException{
		if (nom.equals(null) || nom.equals("")) throw new HearthstoneException("Le nom renseigné est vide");
		this.nom = nom;
	}

	public ICapacite getCapacite() {
		return capacite;
	}

	private void setCapacite(ICapacite capacite) throws HearthstoneException {
		if (capacite.equals(null)) throw new HearthstoneException("Capacite invalide");
		this.capacite = capacite;
	}
	
	public int getCout() {
		return cout;
	}
	
	private void setCout(int cout) throws HearthstoneException {
		if (cout <= 0) throw new HearthstoneException("le cout doit être supérieur a 0");
		this.cout = cout;
	}
	
	/***** METHODS *****/
	
	
	public boolean disparait() {
		return true;
	}

	public void executerAction(Object cible) throws HearthstoneException {
		
	}
	
}
