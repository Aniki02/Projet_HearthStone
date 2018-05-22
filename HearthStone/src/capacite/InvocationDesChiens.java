package capacite;

import carte.ICarte;
import plateau.IPlateau;
import plateau.Plateau;
import serviteur.Chien;
import serviteur.Serviteur;

public class InvocationDesChiens extends Capacite{

	public InvocationDesChiens() {
		super("Invocation des chien", "Invoque autant de chien que de serviteur sur le terrain de l'adversaire");
	}
	
	public void executerEffetMiseEnJeu(Object cible) {
		IPlateau p = Plateau.getInstance();
		Serviteur s;
		for (ICarte c : p.getAdversaire().getJeu()) {
			s = new Chien();
			s.setProprietaire(p.getJoueurCourant());
			p.getJoueurCourant().jouerCarte(s);
		}
	}
}
