package capacite;

import HearthstoneException.HearthstoneException;
import carte.ICarte;

public class Pioche extends Capacite{
	private int nbCartePioche;

	public Pioche (int nbCartePioche) {
		super("Pioche", "Pioche "+nbCartePioche+" du deck");
		this.nbCartePioche = nbCartePioche;
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

}
