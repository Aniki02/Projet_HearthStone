package plateau;

import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import joueur.IJoueur;

public class Plateau implements IPlateau{

	private ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
	private IJoueur joueurCourant;
	private int nbTour;
	
	public Plateau() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException {
		if(joueurs.equals(null)) throw new IllegalArgumentException("le joueur donné en parametre n'est pas valide");
		if(this.joueurs.size() == 2)throw new HearthstoneException("Il y'a déja 2 joueurs dans la partie !!");
		joueurs.add(joueur);
		if(joueurs.size() == 2) demarrerPartie();
	}

	@Override
	public void demarrerPartie() {
		// choisir un joueur aléatoirement
		nbTour = 0;
	}

	@Override
	public boolean estDemarrer() {
		if(joueurs.size() == 2) return true;
		return false;
	}

	@Override
	public void finTour(IJoueur joueur) {
		for(ICarte j : joueur.getCarteEnJeu()) {
			j.getCapacite().executerEffetFinTour();
		}
		setJoueurCourant(joueur);
		nbTour++;
	}

	@Override
	public void gagnerPartie(IJoueur joueur) {
		System.out.println("Le grand gagnant est "+joueur.getPseudo()+"!!!");
	}

	@Override
	public IJoueur getAdversaire() {
		if (joueurCourant.equals(joueurs.get(0))) return joueurs.get(1);
		return joueurs.get(0);
	}

	@Override
	public IJoueur getJoueurCourant() {
		return joueurCourant;
	}

	@Override
	public void setJoueurCourant(IJoueur j) {
		if (joueurCourant.equals(joueurs.get(0))) joueurCourant = joueurs.get(1);
		else joueurCourant = joueurs.get(0);
	}

	public int getNbTour() {
		return nbTour;
	}
}
