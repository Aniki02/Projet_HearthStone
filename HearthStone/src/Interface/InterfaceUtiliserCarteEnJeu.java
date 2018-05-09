package Interface;

import java.util.Scanner;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import plateau.IPlateau;

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
		System.out.println("Quel carte veut-tu utiliser ?");
		Scanner sc = new Scanner(System.in);
		String nomCarte = sc.nextLine();
		System.out.println("Quel est la cible ?");
		String nomCible = sc.nextLine();
		try {
			ICarte carte = p.getJoueurCourant().getCarteEnJeu(nomCarte);
			ICarte cible = p.getAdversaire().getCarteEnJeu(nomCible);
			p.getJoueurCourant().UtiliserCarte(carte, cible);
		}catch (HearthstoneException e){
			System.out.println(e.getMessage());
		}
		p.gagnerPartie(p.getJoueurCourant());
	}

	@Override
	public String getDescription() {
		return "Utiliser carte en jeux";
	}

}
