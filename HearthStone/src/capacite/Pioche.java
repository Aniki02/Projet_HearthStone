package capacite;

import HearthstoneException.HearthstoneException;
import carte.ICarte;

public class Pioche implements ICapacite{
	private String nom = "Pioche", description = "";
	private int nbCartePioche;

	public Pioche (int nbCartePioche) {
		this.nbCartePioche = nbCartePioche;
	}
	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		ICarte c = (ICarte) cible;
		for (int i = 0; i < nbCartePioche; i++) {
			try {
				c.getProprietaire().piocher();
			} catch (HearthstoneException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

	public String toString() {
		return "Capacite ["+nom+" : "+description+"]";
	}
}
