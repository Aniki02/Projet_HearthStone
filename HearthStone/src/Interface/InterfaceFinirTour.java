package Interface;

import plateau.IPlateau;

public class InterfaceFinirTour extends Interface{

	
	public InterfaceFinirTour(Interface suivant) {
		super(suivant);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saitInteragir(String choix) {
		return getDescription().equals(choix);
	}

	@Override
	public void executerRequete(IPlateau p) {
		p.finTour(p.getJoueurCourant());
	}

	@Override
	public String getDescription() {
		return "Finir tour";
	}

}
