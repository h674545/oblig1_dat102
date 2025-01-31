package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		this.tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start() {
		
		Scanner scanner = new Scanner(System.in);
		
		  filmarkiv.leggTilFilm(new Film(1, "Tommy Wirkola", 2010, Sjanger.KOMEDIE, "", "Legenden om fjordheksa"));
	      filmarkiv.leggTilFilm(new Film(2, "John Jacobsen", 2008, Sjanger.ACTION, "", "Max Manus"));
	      filmarkiv.leggTilFilm(new Film(3, "Nino Constantini", 2015, Sjanger.DRAMA, "", "Kampen om tungtvann"));
	      filmarkiv.leggTilFilm(new Film(4, "Ivo Caprino", 1975, Sjanger.BARN, "", "Flåklypa Grand Prix"));

	        System.out.println("Velkommen til Filmarkiv-systemet!");

	        while (true) {
	            System.out.println("\nHva ønsker du å gjøre?");
	            System.out.println("1: Finne film basert på filmnummer");
	            System.out.println("2: Legge til en ny film");
	            System.out.println("3: Slette en film basert på filmnummer");
	            System.out.println("4: Finn filmer med tittel som inneholder en delstreng");
	            System.out.println("5: Finn filmer basert på produsent");
	            System.out.println("6: Se statistikk over sjangere");
	            System.out.println("0: Avslutt programmet");

	            System.out.print("Velg et alternativ: ");
	            String valg = scanner.nextLine();

	            switch (valg) {
	                case "1":
	                    tekstgr.skrivUtFilmDelstrengTittel(this.filmarkiv, "filmnummer");
	                    break;

	                case "2":
	                    Film nyFilm = tekstgr.lesFilm(0, valg, 0, valg, valg); // Les film fra bruker
	                    filmarkiv.leggTilFilm(nyFilm);
	                    break;

	                case "3":
	                    System.out.print("Skriv inn filmnummer for filmen som skal slettes: ");
	                    int filmnummer = Integer.parseInt(scanner.nextLine());
	                    boolean slettet = filmarkiv.slettFilm(filmnummer);
	                    if (slettet) {
	                        System.out.println("Filmen ble slettet.");
	                    } else {
	                        System.out.println("Ingen film med dette nummeret ble funnet.");
	                    }
	                    break;

	                case "4":
	                    System.out.print("Skriv inn del av tittel: ");
	                    String delTittel = scanner.nextLine();
	                    tekstgr.skrivUtFilmDelstrengTittel(filmarkiv, delTittel);
	                    break;

	                case "5":
	                    System.out.print("Skriv inn produsentens navn: ");
	                    String produsent = scanner.nextLine();
	                    tekstgr.skrivUtFilmProdusent(filmarkiv, produsent);
	                    break;

	                case "6":
	                    tekstgr.skrivUtStatistikk(filmarkiv);
	                    break;

	                case "0":
	                    System.out.println("Avslutter programmet...");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Ugyldig valg, prøv igjen.");
	                    break;
	            
		}
	   }
	 }
	public Tekstgrensesnitt getTekstrgr() {
		return tekstgr;
	}

	public void setTekstrgr(Tekstgrensesnitt tekstrgr) {
		this.tekstgr = tekstrgr;
	}

	public FilmarkivADT getFilmarkiv() {
		return filmarkiv;
	}

	public void setFilmarkiv(FilmarkivADT filmarkiv) {
		this.filmarkiv = filmarkiv;
	}

}