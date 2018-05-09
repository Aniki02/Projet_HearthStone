package joueur;

import java.util.ArrayList;

import HearthstoneException.HearthstoneException;
import Heros.Heros;
import carte.ICarte;

public interface IJoueur {
	public void finirTour ();
	public ICarte getCarteEnJeu(String nomCarte) throws HearthstoneException;
	public ICarte getCarteEnMain(String nomCarte) throws HearthstoneException;
	public Heros getHero();
	public ArrayList <ICarte> getMain();
	public ArrayList<ICarte> getJeu();
	public int getMana();
	public void setMana(int mana) throws HearthstoneException;
	public String getPseudo();
	public int getStockMana();
	public void setStockMana(int stockMana) throws HearthstoneException;
	public void JouerCarte(ICarte carte);
	public void PerdreCarte(ICarte carte) throws HearthstoneException;
	public void Piocher () throws HearthstoneException;
	public void UtiliserCarte(ICarte carte, Object cible ) throws HearthstoneException;
	public void UtiliserPouvoir(Object cible);
	public boolean equals(Object obj);
	public String toString();
}
