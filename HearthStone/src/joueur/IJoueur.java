package joueur;

import java.util.ArrayList;

import Heros.Heros;
import carte.ICarte;

public interface IJoueur {
	public void finirTour ();
	public ArrayList<ICarte> getCarteEnJeu();
	public ICarte getCarteEnMain();
	public Heros getHero();
	public ArrayList <ICarte> getMain();
	public ArrayList<ICarte> getJeu();
	public int getMana();
	public String getPseudo();
	public int getStockMana();
	public void JouerCarte(ICarte carte);
	public void PerdreCarte(ICarte carte);
	public void Piocher ();
	public void UtiliserCarte(ICarte carte, Object cible );
	public void UtiliserPouvoir(Object cible);
	public boolean equals(Object obj);
	public String toString();
}
