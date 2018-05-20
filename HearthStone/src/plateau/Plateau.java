package plateau;

import java.util.ArrayList;
import java.util.Random;
import HearthstoneException.HearthstoneException;
import carte.ICarte;
import joueur.IJoueur;

public class Plateau implements IPlateau{

	private ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
	private IJoueur joueurCourant;
	private int nbTour;
	
	/** constructeur privée en suivant le design pattern singleton*/
	private Plateau() {
	}

	private static class PlateauHolder{
		/** Instance unique non préinitialisée */
		private final static Plateau instance = new Plateau();
	}
	/** Point d'accès pour l'instanciation unique du plateau*/
	public static Plateau getInstance() {
		return PlateauHolder.instance;
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
		Random rand = new Random();
		int tirageJoueur = rand.nextInt(2 - 1 + 1);
		setJoueurCourant(joueurs.get(tirageJoueur));
		nbTour = 1;
		getJoueurCourant().prendreTour();
	}

	@Override
	public boolean estDemarrer() {
		if(joueurs.size() == 2) return true;
		return false;
	}

	@Override
	public void finTour(IJoueur joueur) throws HearthstoneException {
		if(!getJoueurCourant().equals(joueur))
			throw new HearthstoneException("ce n'est pas le tour de ce joueur !!");
		
		for(ICarte j : joueur.getJeu()) {
			j.getCapacite().executerEffetFinTour();
		}
		nbTour++;
		setJoueurCourant(joueur);
		getJoueurCourant().prendreTour();
		
	}

	@Override
	public void gagnerPartie(IJoueur joueur) {
		if(getAdversaire().getHero().getPv() <= 0)
		{
			System.out.println("Le grand gagnant est "+joueur.getPseudo()+"!!!");
			System.exit(0);
		}
		
	}

	@Override
	public IJoueur getAdversaire() {
		// demander au prof a propos de la tricherie
		if (joueurCourant.equals(joueurs.get(0))) return joueurs.get(1);
		return joueurs.get(0);
	}

	@Override
	public IJoueur getJoueurCourant() {
		if(estDemarrer())
			return joueurCourant;
		return null;
	}

	@Override
	public void setJoueurCourant(IJoueur j) {
		if (j.equals(joueurs.get(0))) joueurCourant = joueurs.get(1);
		else joueurCourant = joueurs.get(0);
	}

	public int getNbTour() {
		return nbTour;
	}
	
}
