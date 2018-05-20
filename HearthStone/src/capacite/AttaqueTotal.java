package capacite;

import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import carte.ICarte;
import plateau.IPlateau;
import plateau.Plateau;
import serviteur.Serviteur;

public abstract class AttaqueTotal implements ICapacite{
	private String nom, description;
	private int degat;

	/**
	 * @param nom
	 * @param description
	 */
	public AttaqueTotal(String nom, String description, int degat) {
		super();
		this.nom = nom;
		this.description = description;
		this.degat = degat;
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
		/*ArrayList<ICarte> j = (ArrayList<ICarte>) cible;
		Serviteur s;
		for (ICarte c : j) {
			if (c instanceof Serviteur) {
				s = (Serviteur) c;
				s.degat(this.degat);
			}
		}*/
	}
	

	@Override
	public void executerEffetDebutTour() {
				
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
		/*try {
			executerAction(cible);
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}*/
		IPlateau p = Plateau.getInstance();
		//for(ICarte c : p.getAdversaire().getJeu())
		//	c.degat(degat);
		for (int i = 0; i < p.getAdversaire().getJeu().size(); i++)
			p.getAdversaire().getJeu().get(i).degat(degat);
	}
	
	public String toString() {
		return "Capacite ["+nom+" : "+description+"]";
	}
}
