package Interface;

import java.util.Scanner;
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
		System.out.println("Quel carte veut-tu jouer ?");
		Scanner sc = new Scanner(System.in);
		String choix = sc.nextLine();
		System.out.println("Quel est la cible ?");
		String cible = sc.nextLine();
		for(ICarte c : p.getJoueurCourant().getCarteEnJeu()) {
			if (choix.equals(c.getNom())) {
				p.getJoueurCourant().UtiliserCarte(c, cible);
			}
		}
	}

	@Override
	public String getDescription() {
		return "Utiliser carte en jeux";
	}

}
