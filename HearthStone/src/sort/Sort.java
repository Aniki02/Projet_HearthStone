package sort;

import HearthstoneException.HearthstoneException;
import capacite.ICapacite;
import carte.Carte;

public abstract class Sort extends Carte{
	
	/***** CONSTRUCTEUR 
	 * @throws HearthstoneException *****/
	public Sort(String nom, ICapacite capacite, int cout){
		super(nom, cout, capacite);
	}

	
	/***** METHODS *****/
	
	
	public boolean disparait() {
		return true;
	}

	public void executerAction(Object cible) throws HearthstoneException {
		
	}

	public void degat (int degat) {
		
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
		Sort other = (Sort) obj;
		if (this.getCapacite() == null) {
			if (other.getCapacite() != null)
				return false;
		} else if (!this.getCapacite().equals(other.getCapacite()))
			return false;
		if (this.getCout() != other.getCout())
			return false;
		if (this.getNom() == null) {
			if (other.getNom() != null)
				return false;
		} else if (!this.getNom().equals(other.getNom()))
			return false;
		return true;
	}
	
	public String toString() {
		return "Sort ["+this.getNom()+", Cout : "+this.getCout()+this.getCapacite().toString()+"]\n";
	}
	
}
