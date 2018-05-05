package application;

import HearthstoneException.HearthstoneException;
import capacite.Charge;
import capacite.ICapacite;
import serviteur.LaMissiliereTemeraire;
import serviteur.Serviteur;
import sort.Sort;

public class Application {

	public static void main(String[] args) {
		
		ICapacite c = new Charge();
		System.out.println(c.toString());
		Serviteur s1 = new LaMissiliereTemeraire();
		System.out.println(s1.toString());
		
		Serviteur s2 = new LaMissiliereTemeraire();
		
		System.out.println("valeur de peutattaquer au tout début : "+s2.peutAttaquer());
		s2.getCapacite().executerMiseEnJeu(s2);
		System.out.println("valeur de peutAttaquer après executerMiseEnjeu : "+s2.peutAttaquer());
		
		
		System.out.println(s1.getPv()); 
		try {
			
			s2.executerAction(s1);
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(s1.getPv());
	}

}
