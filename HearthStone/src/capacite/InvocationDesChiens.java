package capacite;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import plateau.IPlateau;
import plateau.Plateau;
import serviteur.Chien;
import serviteur.Serviteur;

public class InvocationDesChiens implements ICapacite{

	private String nom = "Invocation des chien", description = "Invoque autant de chien que de serviteur sur le terrain de l'adversaire";
	public InvocationDesChiens() {
		// TODO Auto-generated constructor stub
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
		Serviteur s;
		for (ICarte c : p.getAdversaire().getJeu()) {
			s = new Chien();
			s.setProprietaire(p.getJoueurCourant());
			p.getJoueurCourant().jouerCarte(s);
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
