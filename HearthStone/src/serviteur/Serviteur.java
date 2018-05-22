package serviteur;
import HearthstoneException.HearthstoneException;
import Heros.Heros;
import capacite.ICapacite;
import carte.Carte;

public abstract class Serviteur extends Carte{
	
	private int pv, pointAttaque;
	private boolean peutAttaquer;
	
	/***** CONSTRUCTEUR *****/
	public Serviteur(String nom, int pv, int pointAttaque, int cout, ICapacite capacite) {
		super(nom, cout, capacite);
		this.pv = pv;
		this.pointAttaque = pointAttaque;
	}

	/***** GETTERS SETTERS *****/
	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
		if(this.disparait()) {
			try {
				this.getProprietaire().perdreCarte(this);
			} catch (HearthstoneException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}

	public int getPointAttaque() {
		return pointAttaque;
	}

	public void setPointAttaque(int pointAttaque) {
		this.pointAttaque = pointAttaque;
	}

	
	
	
	/***** METHODS *****/
	public void degat(int degat) {
		if (degat < 0)
			throw new IllegalArgumentException("Les degats ne peuvent pas être négatif ..");
		this.setPv(this.getPv() - degat);
		
	}
	@Override
	public boolean disparait() {
		if (this.pv <= 0) return true;
		return false;
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
			if (cible == null) throw new IllegalArgumentException("la cible rensiegnée est null ..");
			if (!(cible instanceof Serviteur) && !(cible instanceof Heros))
				throw new HearthstoneException("vous ne pouvez pas attaquer cette cible");
			// si cible est de type serviteur 
			if (cible instanceof Serviteur) {
				Serviteur s = (Serviteur) cible;
				//try {
				//	s.getProprietaire().getCarteEnJeu(s.getNom()); // POSER LA QUESTION AU PROF SUR LE RETOUR DE LA METHODE /////////
				//} catch (HearthstoneException e) {
				//	System.out.println(e.getMessage());
				//}
				if (this.peutAttaquer()) {
					s.degat(this.getPointAttaque());
					this.setPeutAttaquer(false);					
				}
				else throw new HearthstoneException(s.getNom()+" ne peut pas attaquer ..");
			}
			// sinon si cible est de type heros
			else if (cible instanceof Heros)
			{
				Heros h = (Heros) cible;
				h.setPv(h.getPv() - this.getPointAttaque());
				this.setPeutAttaquer(false);	
				
			}
			else 
				throw new HearthstoneException("Vous ne pouvez pas attaquer cette cible ..");
			
	}

	public boolean peutAttaquer() {
		return peutAttaquer;
	}
	
	public void setPeutAttaquer(boolean b) {
		this.peutAttaquer = b;
	}
	/***** EQUALS TOSTRING *****/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serviteur s = (Serviteur) obj;
		if (this.getCout() != s.getCout())
			return false;
		if (this.getNom() == null) {
			if (s.getNom() != null)
				return false;
		} else if (!this.getNom().equals(s.getNom()))
			return false;
		if (pointAttaque != s.pointAttaque)
			return false;
		if (pv != s.pv)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (this.getCapacite() == null)
			return "Serviteur [nom : "+this.getNom()+", Point de vie : "+pv+", Point attaque : "+ pointAttaque+","
					+ " Cout : "+this.getCout()+"]\n";
		return "Serviteur ["+this.getNom()+", "+pv+"/"+ pointAttaque+","
				+ " Cout : "+this.getCout()+", "+this.getCapacite()+"]\n";
	}
	
	
}
