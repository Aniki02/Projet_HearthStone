package Interface;

import HearthstoneException.HearthstoneException;
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
		try {
			p.finTour(p.getJoueurCourant());
		} catch (HearthstoneException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String getDescription() {
		return "Finir tour";
	}

}
