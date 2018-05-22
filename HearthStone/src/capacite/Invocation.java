package capacite;

import carte.ICarte;
import plateau.IPlateau;
import plateau.Plateau;

public abstract class Invocation extends Capacite{
	private String nom, description;
	private ICarte carteInvoque;
	

	/**
	 * @param nom
	 * @param description
	 */
	public Invocation(String nom, String description, ICarte carteInvoque) {
		super(nom, description);
		this.carteInvoque = carteInvoque;
	}

	
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		IPlateau p = Plateau.getInstance();
		p.getJoueurCourant().jouerCarte(carteInvoque);
		
	}

	public ICarte getCarte() {
		return carteInvoque;
	}
	
	public String toString() {
		return "Capacite ["+nom+" : "+description+"]";
	}
}
