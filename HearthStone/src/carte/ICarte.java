package carte;

import HearthstoneException.HearthstoneException;
import joueur.IJoueur;

public interface ICarte {
	public boolean disparait();
	public void executerAction(Object cible) throws HearthstoneException;
	public int getCout();
	public String getNom();
	public IJoueur getProprietaire();
	boolean equals(Object obj);
	String toString();
}
