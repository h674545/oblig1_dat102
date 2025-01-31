package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	
	private int filmNr;
	private String produsent;
	private int årLansering;
	private Sjanger sjanger;
	private String filmSelskap;
	private String tittel;
	
	public Film() {
		this.filmNr = 0;
		this.produsent = "";
		this.årLansering = 0;
		this.sjanger = null;
		this.filmSelskap = "";
		this.tittel = "";
	}
	
	public Film(int filmNr, String produsent,int årLansering, Sjanger sjanger, String filmSelskap, String tittel) {
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.årLansering = årLansering;
		this.sjanger = sjanger;
		this.filmSelskap = filmSelskap;
		this.tittel = tittel;
	}

	public int getFilmNr() {
		return filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public int getÅrLansering() {
		return årLansering;
	}

	public void setÅrLansering(int årLansering) {
		this.årLansering = årLansering;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmSelskap() {
		return filmSelskap;
	}

	public void setFilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmNr, filmSelskap, produsent, sjanger, årLansering);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmNr == other.filmNr && Objects.equals(filmSelskap, other.filmSelskap)
				&& Objects.equals(produsent, other.produsent) && sjanger == other.sjanger
				&& årLansering == other.årLansering;
	}

	public String getTittel() {
		return tittel;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	


}