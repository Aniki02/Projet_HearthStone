package serviteur;
import capacite.Charge;
import capacite.ICapacite;

public class LaMissiliereTemeraire extends Serviteur{

	private ICapacite capacite; 
	
	public LaMissiliereTemeraire() {
		
		super("La missilière Téméraire", 2, 5, 6);
		capacite = new Charge();
	}
}
