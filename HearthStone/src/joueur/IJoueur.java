package joueur;

import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import Heros.Heros;
import carte.ICarte;

public interface IJoueur {
	public void finirTour ();
	public void prendreTour();
	public ICarte getCarteEnJeu(String nomCarte) throws HearthstoneException;
	public ICarte getCarteEnMain(String nomCarte) throws HearthstoneException;
	public Heros getHero();
	public ArrayList <ICarte> getMain();
	public ArrayList<ICarte> getJeu();
	public ArrayList<ICarte> getDeck();
	public int getMana();
	public void setMana(int mana) throws HearthstoneException;
	public String getPseudo();
	public int getStockMana();
	public void setStockMana(int stockMana) throws HearthstoneException;
	public void jouerCarte(ICarte carte);
	public void ajouterCarteDeck(ICarte carte) throws HearthstoneException;
	//public void jouerCarte(ICarte carte, Object cible);
	public void perdreCarte(ICarte carte) throws HearthstoneException;
	public void piocher () throws HearthstoneException;
	public void utiliserCarte(ICarte carte, Object cible ) throws HearthstoneException;
	public void utiliserPouvoir(Object cible);
	public boolean equals(Object obj);
	public String toString();
}
