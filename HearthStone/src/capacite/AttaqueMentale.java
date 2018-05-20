package capacite;

import HearthstoneException.HearthstoneException;
import plateau.IPlateau;
import plateau.Plateau;

public class AttaqueMentale extends AttaqueCible{

	public AttaqueMentale() {
		super("Attaque Mentale", "Inflige 5 point de degat au heros", 5);
		// TODO Auto-generated constructor stub
	}

	public void executerEffetMiseEnJeu(Object cible) {
		IPlateau p = Plateau.getInstance();
		try {
			this.executerAction(p.getAdversaire().getHero());
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}
