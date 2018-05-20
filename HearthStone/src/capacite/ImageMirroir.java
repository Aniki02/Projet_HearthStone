package capacite;

import HearthstoneException.HearthstoneException;
import plateau.IPlateau;
import plateau.Plateau;
import serviteur.ServantDeJaina;

public class ImageMirroir implements ICapacite{

	private String nom, description;
	public ImageMirroir() {
		
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
		IPlateau p = Plateau.getInstance();
		p.getJoueurCourant().jouerCarte(new ServantDeJaina());
		p.getJoueurCourant().jouerCarte(new ServantDeJaina());
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
		return "Capacite [nom : "+nom+", Description : "+description+"]";
	}
}
