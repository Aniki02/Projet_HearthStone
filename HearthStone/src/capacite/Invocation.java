package capacite;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import plateau.IPlateau;
import plateau.Plateau;

public abstract class Invocation implements ICapacite{
	private String nom, description;
	private ICarte carteInvoque;
	

	/**
	 * @param nom
	 * @param description
	 */
	public Invocation(String nom, String description, ICarte carteInvoque) {
		super();
		this.nom = nom;
		this.description = description;
		this.carteInvoque = carteInvoque;
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
		// TODO Auto-generated method stub
		IPlateau p = Plateau.getInstance();
		p.getJoueurCourant().jouerCarte(carteInvoque);
		
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

	public ICarte getCarte() {
		return carteInvoque;
	}
	
	public String toString() {
		return "Capacite ["+nom+" : "+description+"]";
	}
}
