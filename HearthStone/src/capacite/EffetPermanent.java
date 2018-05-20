package capacite;


import HearthstoneException.HearthstoneException;
import carte.ICarte;
import plateau.IPlateau;
import plateau.Plateau;
import serviteur.Serviteur;

public abstract class EffetPermanent implements ICapacite{
	private String nom, description;
	private int bonusPv, bonusPa;
	/**
	 * @param nom
	 * @param description
	 * @param bonusPv
	 * @param bonusPa
	 */
	public EffetPermanent(String nom, String description, int bonusPv, int bonusPa) {
		super();
		this.nom = nom;
		this.description = description;
		this.bonusPv = bonusPv;
		this.bonusPa = bonusPa;
	}
	
	/***** GETTERS *****/
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
	
	/***** METHODS *****/
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
		ICarte carte = (ICarte) cible;
		Serviteur s;
		for (ICarte c : carte.getProprietaire().getJeu()) {
			s = (Serviteur) c;
			s.degat(bonusPv);
			s.setPointAttaque(s.getPointAttaque() - bonusPa);
		}
		
	}
	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		Serviteur s;
		IPlateau p = Plateau.getInstance();
		for (ICarte c : p.getJoueurCourant().getJeu()) {
			s = (Serviteur) c;
			s.setPv(s.getPv()+bonusPv);
			s.setPointAttaque(s.getPointAttaque()+bonusPa);
		}
			
	}
	
	public String toString() {
		return "Capacite ["+nom+" : "+description+"]";
	}
	
}
