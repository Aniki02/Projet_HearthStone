package Interface;


import java.util.Scanner;
import HearthstoneException.HearthstoneException;
import capacite.AttaqueCible;
import capacite.AttaqueTotal;
import capacite.EffetPermanent;
import carte.ICarte;
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
		
		ICarte carte;
		String nomCarte;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez un bout du nom de la carte que vous voulez jouez \n -->");
		nomCarte = sc.nextLine();
		try {
			carte = p.getJoueurCourant().getCarteEnMain(nomCarte);
			p.getJoueurCourant().jouerCarte(carte);
			
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		p.gagnerPartie(p.getJoueurCourant());
	}

	@Override
	public String getDescription() {
		return "Jouer une carte";
	}

}
