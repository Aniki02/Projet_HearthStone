package application;


import java.util.ArrayList;
import java.util.Scanner;

import HearthstoneException.HearthstoneException;
import Heros.Jaina;
import Heros.Rexxar;
import Interface.Interface;
import Interface.InterfaceFinirTour;
import Interface.InterfaceJouerCarte;
import Interface.InterfaceUtiliserCarteEnJeu;
import Interface.InterfaceUtiliserPouvoirHero;
import carte.ICarte;
import joueur.Joueur;
import plateau.Plateau;
import serviteur.LaMissiliereTemeraire;


public class Application {

	private static Interface ihm = null;
	public static void main(String[] args) {
		Plateau p = Plateau.getInstance();
		Joueur j1 = new Joueur("Brahim", new Jaina());
		Joueur j2 = new Joueur("Marwana", new Rexxar());
		ICarte c1 = new LaMissiliereTemeraire();
		ICarte c2 = new LaMissiliereTemeraire();
		
		j1.getDeck().add(c1);
		j2.getDeck().add(c2);
		
		try {
			p.ajouterJoueur(j1);
			p.ajouterJoueur(j2);
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		ihm = initialiaserInterface();
		if(ihm == null) {
			System.out.println("L'initialisation du menu ne fonctionne pas !");
			System.exit(0);
		}
		if (p.estDemarrer()) {
			while(true) {
				System.out.println("Tour de : "+p.getJoueurCourant().toString());
				System.out.println("Carte dans sa main : "+p.getJoueurCourant().getMain());
				System.out.println("Carte sur Son Terrain : "+p.getJoueurCourant().getJeu());			
				System.out.println("Son Mana "+p.getJoueurCourant().getStockMana()+"/"+p.getJoueurCourant().getStockMana());
				String choix = menu();
				try {
					ihm.interagir(choix, p);
				}catch(HearthstoneException e){
					e.printStackTrace();
				}
			}
			
		}
	}
	public static String menu() {
		ArrayList<String> menu = new ArrayList<String>();
		Interface i = ihm;
		
		
		while(i != null) {
			menu.add(i.getDescription());
			i = i.getSuivant();
		}
		
		int n = 0;
		for(String s : menu) {
			System.out.println("["+n+"] "+s);
			n++;
		}
		
		System.out.println("Votre choix --> ");
		Scanner sc = new Scanner(System.in);
		int choix = sc.nextInt();
		return menu.get(choix);
	}
	
	public static Interface initialiaserInterface() {
		Interface monInterface = null;
		monInterface = new InterfaceUtiliserPouvoirHero(monInterface);
		monInterface = new InterfaceUtiliserCarteEnJeu(monInterface);
		monInterface = new InterfaceJouerCarte(monInterface);
		monInterface = new InterfaceFinirTour(monInterface);
		return monInterface;
	}
}
