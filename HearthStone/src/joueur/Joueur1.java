/**
 * 
 */
package joueur;

import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import Heros.Heros;
import carte.ICarte;

/**
 * @author 
 *
 */
public class Joueur1 implements IJoueur{

	/**
	 * 
	 */
	static int MAX_MANA = 10, TAILLE_DECK = 20;
	
	private String pseudo;
	private ArrayList<ICarte> jeu = new ArrayList<ICarte>();
	private ArrayList<ICarte> main = new ArrayList<ICarte>();
	private ArrayList<ICarte> carteEnJeu = new ArrayList<ICarte>();
	private ICarte carteEnMain;
	private int stockMana = 1, mana = 1; // stock de mana : mana encore disponible, mana : mana max pour le tour
	private Heros hero;
	/**
	 * @param pseudo
	 * @param hero
	 */
	
	/***** CONSTRUCTEUR 
	 * @throws HearthstoneException *****/
	
	public Joueur1(String pseudo, Heros hero) throws HearthstoneException {
		setPseudo(pseudo);
		setHero(hero);
	}
	
	/***** GETTERS SETTERS *****/
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) throws HearthstoneException {
		if (pseudo.equals(null) || pseudo.equals("")) throw new HearthstoneException("Le pseudo est vide !!!");
		this.pseudo = pseudo;
	}
	public ArrayList<ICarte> getJeu() {
		return jeu;
	}
	//public void setJeu(ArrayList<ICarte> jeu) {
		
	//	this.jeu = jeu;
	//}
	public ArrayList<ICarte> getMain() {
		return main;
	}
	//public void setMain(ArrayList<ICarte> main) {
	//	this.main = main;
	//}
	public ArrayList<ICarte> getCarteEnJeu() {
		return carteEnJeu;
	}
	//public void setCarteEnJeu(ArrayList<ICarte> carteEnJeu) {
	//	this.carteEnJeu = carteEnJeu;
	//}
	public ICarte getCarteEnMain() {
		return carteEnMain;
	}
	//public void setCarteEnmain(ICarte carteEnMain) {
	//	this.carteEnMain = carteEnMain;
	//}
	public int getStockMana() {
		return stockMana;
	}
	public void setStockMana(int stockMana) throws HearthstoneException {
		if (stockMana < 0) throw new HearthstoneException("Le mana ne peut pas être négatif");
		this.stockMana = stockMana;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) throws HearthstoneException {
		if (mana > 10 || mana < 0) throw new HearthstoneException("Le mana donner n'est pas bon !!");
		this.mana = mana;
	}
	public Heros getHero() {
		return hero;
	}
	private void setHero(Heros hero) throws HearthstoneException {
		if (hero.equals(null)) throw new HearthstoneException("Le heros donner n'est pas valide ");
		this.hero = hero;
	}

	/***** METHODS *****/
	@Override
	public void finirTour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void JouerCarte(ICarte carte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PerdreCarte(ICarte carte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Piocher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UtiliserCarte(ICarte carte, Object cible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UtiliserPouvoir(Object cible) {
		// TODO Auto-generated method stub
		
	}
	
}
