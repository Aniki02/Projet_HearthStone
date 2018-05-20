package Interface;

import java.util.Scanner;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import plateau.IPlateau;
import serviteur.Serviteur;

public class InterfaceUtiliserCarteEnJeu extends Interface{

	public InterfaceUtiliserCarteEnJeu(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerRequete(IPlateau p) {
		ICarte carte;
		ICarte cible;
		System.out.println("Quel carte veut-tu utiliser ?");
		Scanner sc = new Scanner(System.in);
		String nomCarte = sc.nextLine();
		System.out.println("Quel est la cible ?");
		String nomCible = sc.nextLine();
		
		try {
			carte = p.getJoueurCourant().getCarteEnJeu(nomCarte);
			if(p.getAdversaire().getHero().getNom().contains(nomCible))
				cible = p.getAdversaire().getHero();
			else
				cible = p.getAdversaire().getCarteEnJeu(nomCible);
			p.getJoueurCourant().utiliserCarte(carte, cible);
			
		}catch (HearthstoneException e){
			System.out.println(e.getMessage());
		}
		//System.out.println();
		p.gagnerPartie(p.getJoueurCourant());
		
		
		
	}

	@Override
	public String getDescription() {
		return "Utiliser carte en jeux";
	}

}
