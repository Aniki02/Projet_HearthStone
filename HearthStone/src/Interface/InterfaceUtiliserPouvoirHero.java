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
		Scanner sc = new Scanner(System.in);
		System.out.println("Sur qui utiliser le pouvoir du heros ?");
		String cible = sc.nextLine();
		// si il veut attaquer le hero 
		if (cible.equals(p.getAdversaire().getHero().getNom()))
			p.getJoueurCourant().getHero().executerAction(p.getAdversaire().getHero());
		// sinon si il veut attaquer une des autres carte en jeu
		else {
			for (ICarte c : p.getAdversaire().getCarteEnJeu()) {
				
			}
				p.getJoueurCourant().getHero().executerAction(cible);	
		}
	}

	@Override
	public String getDescription() {
		return "Utiliser pouvoir du hero";
	}

}
