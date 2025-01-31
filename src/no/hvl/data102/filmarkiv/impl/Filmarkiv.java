package no.hvl.data102.filmarkiv.impl;

import java.util.Arrays;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{
	
	private Film[] filmer;
	private int antall;

	public Filmarkiv(int kapasitet) {
		
		if(kapasitet <= 0) {
			kapasitet = 10;
		}
		
		this.filmer = new Film[kapasitet];
		this.antall = 0; 
	}

	@Override
	public Film finnFilm(int nr) {
		
		for(int i = 0; i < antall; i++) {
			if(filmer[i].getFilmNr() == nr) {
				return filmer[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		
		if(antall == filmer.length) {
			utvidLengde();
		}
		filmer[antall] = nyFilm;
		antall++;
	}

	private void utvidLengde() {
		
		filmer = Arrays.copyOf(filmer, filmer.length * 2);
	}
		
	
	@Override
	public boolean slettFilm(int filmnr) {
		
		for(int i = 0; i < antall; i++) {
			if(filmer[i].getFilmNr() == filmnr) {
				filmer[i] = filmer[antall - 1];
				filmer[antall -1] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		
		Film[] resultat = new Film[antall];
			int treff = 0; 
			
			for(int i = 0; i < antall; i++) {
				if(filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
			resultat[treff] = filmer[i];
			treff++;
				}
			}
		
		return Arrays.copyOf(resultat, treff);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		
		Film[] Prod = new Film[antall];
			int treff = 0; 
			
			for(int i = 0; i < antall; i++) {
				if(filmer[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				Prod[treff] = filmer[i];
				treff++;
				}
			}
		return Arrays.copyOf(Prod, treff);
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		int antallSjangere = 0; 
		
		for(int i = 0; i < antall; i++) {
			if(filmer[i].getSjanger() == sjanger) {
				antallSjangere++;
			}
		}
		return antallSjangere;
	}

	@Override
	public int antall() {
		return antall;
	}

}