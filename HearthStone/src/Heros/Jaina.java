package Heros;

import HearthstoneException.HearthstoneException;
import capacite.BouleDeFeu;
import capacite.ICapacite;



public class Jaina extends Heros{

	public Jaina() throws HearthstoneException {
		super("Jaina", 15, new BouleDeFeu());
	}

}
