/**
 * 
 */
package joueur;

import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import Heros.Heros;
import carte.ICarte;
import serviteur.Serviteur;

/**
 * @author 
 *
 */
public class Joueur implements IJoueur{

	/**
	 * 
	 */
	static int MAX_MANA = 10, TAILLE_DECK = 20;
	
	private String pseudo;
	private ArrayList<ICarte> jeu = new ArrayList<ICarte>();
	private ArrayList<ICarte> main = new ArrayList<ICarte>();
	private ArrayList<ICarte> deck = new ArrayList<ICarte>();
	private int stockMana = 0, mana = 0; // stock de mana : mana encore disponible, mana : mana max pour le tour
	private Heros hero;
	/**
	 * @param pseudo
	 * @param hero
	 */
	
	/***** CONSTRUCTEUR 
	 * @throws HearthstoneException *****/
	
	public Joueur(String pseudo, Heros hero) {
		setPseudo(pseudo);
		setHero(hero);
	}
	
	/***** GETTERS SETTERS *****/
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		if (pseudo.equals(null) || pseudo.equals("")) throw new IllegalArgumentException("Le pseudo est vide !!!");
		this.pseudo = pseudo;
	}
	public ArrayList<ICarte> getJeu() {
		return jeu;
	}
	
	public ArrayList<ICarte> getMain() {
		return main;
	}
	
	public ICarte getCarteEnJeu(String nomCarte) throws HearthstoneException {
		for (ICarte c : jeu) {
			if (c.getNom().contains(nomCarte))
				return c;
		}
		throw new HearthstoneException(nomCarte+" n'est pas sur le terrain ..");
	}
	
	public ICarte getCarteEnMain(String nomCarte) throws HearthstoneException {
		for (ICarte c : main) {
			if(c.getNom().contains(nomCarte))
				return c;
		}
		throw new HearthstoneException(nomCarte+" n'est pas dans votre main ..");
	}
	
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
		if (mana > 10 || mana < 0) throw new HearthstoneException("");
		this.mana = mana;
	}
	public Heros getHero() {
		return hero;
	}
	private void setHero(Heros hero){
		if (hero.equals(null)) throw new IllegalArgumentException("Le heros donner n'est pas valide ");
		this.hero = hero;
	}

	public ArrayList<ICarte> getDeck() {
		return deck;
	}

	/***** METHODS *****/
	@Override
	public void finirTour() {
		for(ICarte c : getJeu()) {
			if(c instanceof Serviteur) {
				Serviteur s = (Serviteur) c;
				s.setPeutAttaquer(true);
			}
			c.getCapacite().executerEffetFinTour();
		}
	}
	public void prendreTour() {
		try {
			if(getMana() < 10)
				setMana(getMana() +1);
		} catch (HearthstoneException e) {
			
		}
		try {
			setStockMana(getMana());
		} catch (HearthstoneException e) {
			System.out.println(e.getMessage());
		}
		try {
			piocher();
		}catch(HearthstoneException e) {
			System.out.println(e.getMessage());
		}
		for(ICarte c : getJeu()) {
			if(c instanceof Serviteur) {
				Serviteur s = (Serviteur) c;
				s.setPeutAttaquer(true);
			}
		}
		
	}

	@Override
	public void jouerCarte(ICarte carte) {
		if (carte == null)
			throw new IllegalArgumentException("la carte renseigner est null ..");
		//ICarte c = getCarteEnMain(carte.getNom());
		this.getMain().remove(carte);
		this.getJeu().add(carte);
		if (!(carte.getCapacite() == null))
			carte.getCapacite().executerEffetMiseEnJeu(carte);
		if(carte.disparait())
			this.perdreCarte(carte);
		
		
	}

	/*public void jouerCarte(ICarte carte, Object cible) {
		if (carte == null)
			throw new IllegalArgumentException("la carte renseigner est null ..");
		//ICarte c = getCarteEnMain(carte.getNom());
		this.getMain().remove(carte);
		this.getJeu().add(carte);
		carte.getCapacite().executerEffetMiseEnJeu(carte);
	}*/
	@Override
	public void perdreCarte(ICarte carte) {
		System.out.println("test 10");
		if (carte.equals(null))
			throw new IllegalArgumentException("la carte donner est vide");
		try {
			carte = this.getCarteEnJeu(carte.getNom());
		} catch (HearthstoneException e) {
			// TODO: handle exception
		}
		jeu.remove(carte);
	}

	@Override
	public void piocher() throws HearthstoneException {
		if(getDeck().isEmpty())
			throw new HearthstoneException("Vous ne pouvez pas piocher vous n'avez pas de carte dans votre jeu ..");
		 main.add(deck.get(0));
		 deck.remove(0);
	}

	@Override
	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		if ((carte == null))
			throw new IllegalArgumentException("La carte donner en argument est null ..");
		if ((cible == null))
			throw new IllegalArgumentException("La cible donner en argument est null ..");
		try {
			//ICarte c = getCarteEnJeu(carte.getNom());
			carte.executerAction(cible);
		}catch(HearthstoneException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void utiliserPouvoir(Object cible) {
		if (cible == null) throw new IllegalArgumentException("la cible donnée est null");
		try {
			getHero().executerAction(cible);
		}catch (HearthstoneException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void ajouterCarteDeck(ICarte carte) throws HearthstoneException {
		if (carte.equals(null))
			throw new IllegalArgumentException("on ne peut pas ajouter une carte vide au deck");
		if( this.getDeck().size() >= TAILLE_DECK )
			throw new HearthstoneException("On ne peut plus ajouter de carte au deck ");
		this.getDeck().add(carte);
		carte.setProprietaire(this);
	}
	public String toString() {
		return "Joueur [ Pseudo : "+pseudo+" "+hero.toString()+"]";
	}
}
