package plateau;

import HearthstoneException.HearthstoneException;
import joueur.IJoueur;

public interface IPlateau {

	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
	public void demarrerPartie();
	public boolean estDemarrer();
	public void finTour(IJoueur joueur) throws HearthstoneException;
	public void gagnerPartie(IJoueur joueur);
	public IJoueur getAdversaire();
	public IJoueur getJoueurCourant ();
	public void setJoueurCourant (IJoueur joueur);
	boolean equals(Object obj);
	String toString();
}
