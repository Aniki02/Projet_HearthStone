package carte;

import HearthstoneException.HearthstoneException;
import capacite.ICapacite;
import joueur.IJoueur;

public abstract class Carte implements ICarte{

	private String nom;
	private int cout;
	private ICapacite capacite;
	private IJoueur proprietaire;
	
	/**
	 * @param nom
	 * @param cout
	 * @param capacite
	 * @param proprietaire
	 */
	public Carte(String nom, int cout, ICapacite capacite) {
		this.nom = nom;
		this.cout = cout;
		this.capacite = capacite;
	}

	@Override
	public abstract boolean disparait();

	@Override
	public abstract void executerAction(Object cible) throws HearthstoneException;

	@Override
	public int getCout() {
		// TODO Auto-generated method stub
		return cout;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public IJoueur getProprietaire() {
		// TODO Auto-generated method stub
		return proprietaire;
	}

	@Override
	public void setProprietaire(IJoueur j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ICapacite getCapacite() {
		// TODO Auto-generated method stub
		return capacite;
	}

	@Override
	public abstract void degat(int degat);

}
