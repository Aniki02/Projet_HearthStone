package capacite;

import java.util.Scanner;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import plateau.IPlateau;
import plateau.Plateau;

public abstract class AttaqueCible extends Capacite{
	private int degat;

	/**
	 * @param nom
	 * @param description
	 */
	public AttaqueCible(String nom, String description, int degat) {
		super(nom, description);
		this.degat = degat;
	}

	
	/***** METHODS *****/ 
	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// PAREIL QUE ATTAQUE DU HEROS SAUF QU4IL FAUDRA GERER PROVOCATION
		/*Serviteur s;
		Heros h;
		if (cible == null)
			throw new IllegalArgumentException("la cible donner en argument est null ..");
		if (cible instanceof Serviteur) {
			s = (Serviteur)cible;
			s.degat(2);
		}
		else if (cible instanceof Heros) {
			h = (Heros) cible;
			h.degat(2);
		}
		else throw new HearthstoneException("Vous ne pouvez pas attaquer cette cible : "+ cible);	
		*/
		ICarte c = (ICarte) cible;
		c.degat(degat); // ne pas oublier de gerer provocation
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		IPlateau p = Plateau.getInstance();
		String nomCible;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel cible doit prendre la capacite de la carte ?");
		nomCible = sc.nextLine();
		try {
			if (p.getAdversaire().getHero().getNom().contains(nomCible))
				this.executerAction(p.getAdversaire().getHero());
			else
				this.executerAction(p.getAdversaire().getCarteEnJeu(nomCible));
		} catch (HearthstoneException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
