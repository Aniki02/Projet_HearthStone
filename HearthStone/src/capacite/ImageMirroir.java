package capacite;

import plateau.IPlateau;
import plateau.Plateau;
import serviteur.ServantDeJaina;

public class ImageMirroir extends Capacite{

	public ImageMirroir() {
		super("Image mirroir", "Invoque 2 serviteur de Jaina");
	}
	
	public void executerEffetMiseEnJeu(Object cible) {
		IPlateau p = Plateau.getInstance();
		p.getJoueurCourant().jouerCarte(new ServantDeJaina());
		p.getJoueurCourant().jouerCarte(new ServantDeJaina());
	}

}
