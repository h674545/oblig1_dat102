package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	
	public Film lesFilm(int nr, String tittel, int år, String sjanger, String produsent) { 
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Filmnummer");
		nr = Integer.parseInt(scanner.nextLine());
		scanner.nextLine();
		
		System.out.println("Tittel");
		tittel = scanner.nextLine();
		scanner.nextLine();
		
		System.out.println("År");
		år = Integer.parseInt(scanner.nextLine());
		scanner.nextLine();
		
		System.out.println("sjanger (action, drama, komedie");
		sjanger = scanner.nextLine();
		scanner.nextLine();
		
		System.out.println("Produsent");
		produsent = scanner.nextLine();
		scanner.nextLine();
		scanner.close();
		
		
		return new Film(nr, tittel, år, null, sjanger, produsent);		
	}
	
	public void skrivUtFilm(Film film) {
		
		if(film != null) {
			System.out.println(film.toString());
		}else {
			System.out.println("Ingen informasjon tilgjengelig");
			
		}
		
	}
	
	public void skrivUtFilmDelstrengTittel(FilmarkivADT arkiv, String delstreng) {
		
		Film[] filmer = arkiv.soekTittel(delstreng);
		if(filmer.length > 0) {
			System.out.println("Filmer som matcher: ");
			for(Film film : filmer) {
				System.out.print(film.toString());
			}
			}else {
				System.out.println("Ikke funnet");
		}
	}
	
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekProdusent(delstreng);
		if(filmer.length > 0) {
			System.out.println("Produsentnavn som matcher: ");
			for(Film film : filmer) {
				if(filmer != null) {
				System.out.print(film.toString());
				}
			  }
			} else {
				System.out.println("Ikke funnet");
		}
	}

	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		
		System.out.println("Totalt antall: " + arkiv.antall());
		
		for(Sjanger sjanger : Sjanger.values()) {
			int antall = arkiv.antall(sjanger);
			System.out.println("Antall filmer i sjanger: " + sjanger + ":" + antall);
			
		}
	}
}