package Interface;

import java.util.Scanner;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import plateau.IPlateau;

public class InterfaceUtiliserPouvoirHero extends Interface{

	public InterfaceUtiliserPouvoirHero(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerRequete(IPlateau p) throws HearthstoneException {
		ICarte cible;
		Scanner sc = new Scanner(System.in);
		System.out.println("Sur qui utiliser le pouvoir du heros ?");
		String nomCible = sc.nextLine();
		// si il veut attaquer le hero 
		if (p.getAdversaire().getHero().getNom().contains(nomCible))
			p.getJoueurCourant().getHero().executerAction(p.getAdversaire().getHero());
		// sinon si il veut attaquer une des autres carte en jeu
		else {
			//try {
				cible = p.getAdversaire().getCarteEnJeu(nomCible);
				p.getJoueurCourant().getHero().executerAction(cible);	
			//} catch (HearthstoneException e) {
			//	System.out.println(e.getMessage());
			//}
		}
		p.gagnerPartie(p.getJoueurCourant());
	}

	@Override
	public String getDescription() {
		return "Utiliser pouvoir du hero";
	}

}
