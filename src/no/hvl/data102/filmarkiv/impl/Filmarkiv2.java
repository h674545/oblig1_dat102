package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2(int antall, LinearNode<Film> start) {
		this.antall = 0;
		this.start = null;
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> current = start;

		while (current != null) {
			if (current.data.getFilmNr() == nr) {
				return current.data;
			} else {
				current = current.neste;
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		nyNode.neste = start;
		start = nyNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> current = start;
		LinearNode<Film> forige = null;
		boolean slettet = false;

		while (current != null && !slettet) {
			if (current.data.getFilmNr() == filmnr) {
				if (forige == null) {
					start = current.neste;
				} else {
					forige.neste = current.neste;
				}
				slettet = true;
				antall--;
			} else {
				forige = current;
				current = current.neste;
			}
		}
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		int antallFunnet = 0;
		LinearNode<Film> current = start;

		while (current != null) {
			if (current.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				antallFunnet++;
			}
			current = current.neste;
		}

		Film[] resultater = new Film[antallFunnet];
		current = start;
		int index = 0;

		while (current != null) {
			if (current.data.getTittel().contains(delstreng)) {
				resultater[index] = current.data;
				index++;
			}
			current = current.neste;
		}
		return resultater;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		int antallFunnet = 0;
		LinearNode<Film> current = start;

		while (current != null) {
			if (current.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				antallFunnet++;
			}
			current = current.neste;
		}

		Film[] resultater = new Film[antallFunnet];
		current = start;
		int index = 0;

		while (current != null) {
			if (current.data.getProdusent().contains(delstreng)) {
				resultater[index] = current.data;
				index++;
			}
			current = current.neste;
		}
		return resultater;
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> current = start;
		int antall = 0;

		while (current != null) {
			if (current.data.getSjanger() == sjanger) {
				antall++;
			}
			current = current.neste;
		}

		return antall;
	}

	@Override
	public int antall() {
		return antall;
	}

}
