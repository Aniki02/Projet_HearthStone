package Interface;

import java.util.Scanner;

import HearthstoneException.HearthstoneException;
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
		System.out.println("Entrez un bout du nom de la carte que vous voulez jouez \n -->");
		Scanner sc = new Scanner(System.in);
		String nomCarte = sc.nextLine();
		try {
			p.getJoueurCourant().JouerCarte(p.getJoueurCourant().getCarteEnMain(nomCarte));
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String getDescription() {
		return "Jouer une carte";
	}

}
