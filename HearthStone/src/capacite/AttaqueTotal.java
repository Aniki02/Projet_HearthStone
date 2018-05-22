package capacite;



import HearthstoneException.HearthstoneException;
import plateau.IPlateau;
import plateau.Plateau;

public abstract class AttaqueTotal extends Capacite{
	
	private int degat;

	/**
	 * @param nom
	 * @param description
	 */
	public AttaqueTotal(String nom, String description, int degat) {
		super(nom, description);
		this.degat = degat;
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
	
}
