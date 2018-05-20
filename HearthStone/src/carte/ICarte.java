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
	public void setProprietaire(IJoueur j);
	public ICapacite getCapacite();
	public void degat (int degat);
	boolean equals(Object obj);
	String toString();
}
