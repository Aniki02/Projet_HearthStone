package carte;

import HearthstoneException.HearthstoneException;
import capacite.ICapacite;
import joueur.IJoueur;

public interface ICarte {
	public boolean disparait();
	public void executerAction(Object cible) throws HearthstoneException;
	public int getCout();
	public String getNom();
	public IJoueur getProprietaire();
	public ICapacite getCapacite();
	boolean equals(Object obj);
	String toString();
}
