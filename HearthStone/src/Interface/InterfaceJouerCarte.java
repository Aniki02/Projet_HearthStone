package Interface;

import plateau.IPlateau;

public class InterfaceJouerCarte extends Interface{

	public InterfaceJouerCarte(Interface suivant) {
		super(suivant);
	}

	@Override
	public boolean saitInteragir(String choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerRequete(IPlateau p) {
		p.getJoueurCourant().JouerCarte(p.getJoueurCourant().getCarteEnMain());
	}

	@Override
	public String getDescription() {
		return "Jouer une carte";
	}

}
