package plateau;

import joueur.IJoueur;

public interface IPlateau {

	public void ajouterPlateau();
	public void demarrerPartie();
	public boolean estDemarrer();
	public void finTour(IJoueur j);
	public void gagnerPartie(IJoueur j);
	public IJoueur getAdversaire();
	public IJoueur getJoueurCourant ();
	public void setJoueurCourant (IJoueur j);
	boolean equals(Object obj);
	String toString();
}
