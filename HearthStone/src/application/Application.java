package application;

import java.util.ArrayList;
import java.util.Scanner;

import HearthstoneException.HearthstoneException;
import Interface.Interface;
import Interface.InterfaceFinirTour;
import Interface.InterfaceJouerCarte;
import Interface.InterfaceUtiliserCarteEnJeu;
import Interface.InterfaceUtiliserPouvoirHero;
import plateau.Plateau;


public class Application {

	private static Interface ihm = null;
	public static void main(String[] args) {
		Plateau p = new Plateau();
		
		ihm = initialiaserInterface();
		if(ihm == null) {
			System.out.println("L'initialisation du menu ne fonctionne pas !");
			System.exit(0);
		}
		while(true) {
			String choix = menu();
			try {
				ihm.interagir(choix, p);
			}catch(HearthstoneException e){
				e.printStackTrace();
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
