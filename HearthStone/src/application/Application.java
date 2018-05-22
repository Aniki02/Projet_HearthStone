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
import capacite.AttaqueMentale;
import joueur.IJoueur;
import joueur.Joueur;
import plateau.Plateau;
import serviteur.Archimage;
import serviteur.BusardAffame;
import serviteur.ChampionDuHurlevent;
import serviteur.ChasseMareeMurloc;
import serviteur.ChefDeRaid;
import serviteur.EclaireurMurloc;
import serviteur.GardeDeBaieDuButin;
import serviteur.GnomeLepreux;
import serviteur.GolemmeDesMoissons;
import serviteur.LaMissiliereTemeraire;
import serviteur.OgreMagi;
import serviteur.Serviteur;
import sort.Sort;
import sort.SortAttaqueMentale;
import sort.SortChocDeFlamme;
import sort.SortEclairDeGivre;
import sort.SortExplosionPyrotechnique;
import sort.SortImageMirroir;
import sort.SortIntelligenceDesAracanes;
import sort.SortLachezLesChiens;
import sort.SortMarqueDuChasseur;
import sort.SortOrdreDeTuer;
import sort.SortTirDesAracanes;


public class Application {

	private static Interface ihm = null;
	public static void main(String[] args) {
		Plateau p = Plateau.getInstance();
		IJoueur j1 = new Joueur("Brahim", new Jaina());
		IJoueur j2 = new Joueur("Marwana", new Rexxar());
		/*Serviteur c1 = new LaMissiliereTemeraire();
		Sort s1 = new SortEclairDeGivre();
		Sort s11 = new SortChocDeFlamme(); 
		Serviteur c2 = new LaMissiliereTemeraire();
		Sort s2 = new SortLachezLesChiens();
		Serviteur s22= new ChampionDuHurlevent();
		
		j1.getDeck().add(c1);
		c1.setProprietaire(j1);
		j1.getDeck().add(s1);
		s1.setProprietaire(j1);
		j1.getDeck().add(s11);
		s11.setProprietaire(j1);
		
		
		j2.getDeck().add(c2);
		c2.setProprietaire(j2);
		j2.getDeck().add(s2);
		s2.setProprietaire(j2);
		j2.getDeck().add(s22);
		s22.setProprietaire(j2);*/
		construireJeuJaina(j1);
		construireJeuRexxar(j2);
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
				
				System.out.println("*****************************************\n");
				System.out.println("Carte de l'adversaire : ");
				System.out.println(p.getAdversaire().getJeu());
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
		int choix; 
		try {
			choix = sc.nextInt();
			return menu.get(choix);
		} catch (Exception e) {
			// TODO: handle exception
			return menu ();
		}
	}
	
	public static Interface initialiaserInterface() {
		Interface monInterface = null;
		monInterface = new InterfaceUtiliserPouvoirHero(monInterface);
		monInterface = new InterfaceUtiliserCarteEnJeu(monInterface);
		monInterface = new InterfaceJouerCarte(monInterface);
		monInterface = new InterfaceFinirTour(monInterface);
		return monInterface;
	}
	
	public static void construireJeuJaina(IJoueur j) {
		construireJeuNeutre(j);
		try {
			j.ajouterCarteDeck(new SortChocDeFlamme());
			j.ajouterCarteDeck(new SortEclairDeGivre());
			j.ajouterCarteDeck(new SortIntelligenceDesAracanes());
			j.ajouterCarteDeck(new SortImageMirroir());
			j.ajouterCarteDeck(new SortExplosionPyrotechnique());
		} catch (HearthstoneException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void construireJeuRexxar(IJoueur j) {
		construireJeuNeutre(j);
		try {
			j.ajouterCarteDeck(new BusardAffame());
			j.ajouterCarteDeck(new SortMarqueDuChasseur());
			j.ajouterCarteDeck(new SortTirDesAracanes());
			j.ajouterCarteDeck(new SortLachezLesChiens());
			j.ajouterCarteDeck(new SortOrdreDeTuer());
		} catch (HearthstoneException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void construireJeuNeutre (IJoueur j) {
		try {
			j.ajouterCarteDeck(new ChasseMareeMurloc());
			j.ajouterCarteDeck(new SortAttaqueMentale());
			j.ajouterCarteDeck(new ChampionDuHurlevent());
			j.ajouterCarteDeck(new ChefDeRaid());
			j.ajouterCarteDeck(new GardeDeBaieDuButin());
			j.ajouterCarteDeck(new LaMissiliereTemeraire());
			j.ajouterCarteDeck(new OgreMagi());
			j.ajouterCarteDeck(new Archimage());
			j.ajouterCarteDeck(new GnomeLepreux());
			j.ajouterCarteDeck(new GolemmeDesMoissons());
		} catch (HearthstoneException e) {
			System.out.println(e.getMessage());
		}
	}
}
