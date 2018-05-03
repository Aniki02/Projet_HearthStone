package serviteur;
import HearthstoneException.HearthstoneException;
import carte.ICarte;
import joueur.IJoueur;

public abstract class Serviteur implements ICarte{
	
	private String nom;
	private int pv, pointAttaque, cout;  
	
	/***** CONSTRUCTEUR *****/
	public Serviteur(String nom, int pv, int pointAttaque, int cout) {
		this.nom = nom;
		this.pv = pv;
		this.pointAttaque = pointAttaque;
		this.cout = cout;
	}

	/***** GETTERS SETTERS *****/
	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getPointAttaque() {
		return pointAttaque;
	}

	public void setPointAttaque(int pointAttaque) {
		this.pointAttaque = pointAttaque;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String getNom() {
		return nom;
	}
	
	public int getCout() {
		return cout ;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	
	
	
	
	/***** METHODS *****/
	
	@Override
	public boolean disparait() {
		if (cout <= 0) return true;
		return false;
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
			if (cible == null) throw new HearthstoneException("aucune cible renseigné");
			
			// si cible est de type serviteur 
			if (getClass() == cible.getClass()) {
				Serviteur s = (Serviteur) cible;
				s.pv -= pointAttaque;
			}
			// sinon si cible est de type heros
			else 
			{
				
			}
	}

	
	public IJoueur getProprietaire() {
		return null;
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
		if (cout != s.cout)
			return false;
		if (nom == null) {
			if (s.nom != null)
				return false;
		} else if (!nom.equals(s.nom))
			return false;
		if (pointAttaque != s.pointAttaque)
			return false;
		if (pv != s.pv)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
