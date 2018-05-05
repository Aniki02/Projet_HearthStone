package serviteur;
import HearthstoneException.HearthstoneException;
import Heros.Heros;
import capacite.ICapacite;
import carte.ICarte;
import joueur.IJoueur;

public abstract class Serviteur implements ICarte{
	
	private String nom;
	private int pv, pointAttaque, cout;
	private ICapacite capacite;
	private IJoueur proprietaire;
	private boolean peutAttaquer;
	
	/***** CONSTRUCTEUR *****/
	public Serviteur(String nom, int pv, int pointAttaque, int cout, ICapacite capacite) {
		this.nom = nom;
		this.pv = pv;
		this.pointAttaque = pointAttaque;
		this.cout = cout;
		setCapacite(capacite);
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
	
	public ICapacite getCapacite() {
		return capacite ;
	}
	public void setCapacite(ICapacite capacite) {
		this.capacite = capacite;
	}
	
	public IJoueur getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(IJoueur proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	/***** METHODS *****/
	
	@Override
	public boolean disparait() {
		if (pv <= 0) return true;
		return false;
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
			if (cible == null) throw new HearthstoneException("aucune cible renseigné");
			if (!(cible instanceof Serviteur) && !(cible instanceof Heros))
				throw new HearthstoneException("vous ne pouvez pas attaquer cette cible");
			// si cible est de type serviteur 
			if (cible instanceof Serviteur) {
				Serviteur s = (Serviteur) cible;
				if (this.peutAttaquer()) {
					s.setPv(s.getPv() - this.getPointAttaque());
					this.setPeutAttaquer(false);					
				}
				else throw new HearthstoneException(s.getNom()+" ne peut pas attaquer ..");
			}
			// sinon si cible est de type heros
			else 
			{
				Heros h = (Heros) cible;
				h.setPv(h.getPv() - this.getPointAttaque());
				this.setPeutAttaquer(false);	
				
			}
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
		return "Serviteur [nom : "+nom+", Point de vie : "+pv+", Point attaque : "+ pointAttaque+","
				+ " Cout : "+cout+", "+capacite.toString()+"]";
	}
	
	
}
