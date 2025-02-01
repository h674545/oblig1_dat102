package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.impl.Film;


class FilmarkivTest {
	
	private Filmarkiv filmarkiv;
	
	@BeforeEach
	void setUp() {
		filmarkiv = new Filmarkiv(0);
		filmarkiv.leggTilFilm(new Film(1, "Tommy Wirkola", 2010, Sjanger.KOMEDIE, "", "Legenden om fjordheksa"));
		filmarkiv.leggTilFilm(new Film(2, "John Jacobsen", 2008, Sjanger.ACTION, "", "Max Manus"));
		filmarkiv.leggTilFilm(new Film(3, "Nino Constantini", 2015, Sjanger.DRAMA, "", "Kampen om tungtvann"));
	}

	@Test
	void testfinnFilm() {
		
		Film film = filmarkiv.finnFilm(1);
		assertNotNull(film, "Film med nummer 1 skal finnes");
		assertEquals(1, film.getFilmNr());
		assertEquals("Legenden om fjordheksa", film.getTittel());
	}
	
	@Test
	void testFilmLagtTil() {
		
		Film nyFilm = new Film(4, "Ivo Caprino", 1975, Sjanger.BARN, "", "Flåklypa Grand Prix");
		filmarkiv.leggTilFilm(nyFilm);
		
		Film film = filmarkiv.finnFilm(4);
		assertNotNull(film, "Filmen lagt til");
		assertEquals(4, film.getFilmNr());
		assertEquals("Flåklypa Grand Prix", film.getTittel());
	}
	
	@Test
	void testFilmslettet() {
		
		boolean slettet = filmarkiv.slettFilm(1);
		assertTrue(slettet, "Film 1 slettet");
		
		Film film = filmarkiv.finnFilm(1);
		assertNull(film, "filmen skal ikke finnes lenger");
		
	}
	
	@Test
	void testTittelFunnet() {
		
		Film[] filmer = filmarkiv.soekTittel("Max Manus");
		assertNotNull(filmer, "Listen skal ikke være null");
		assertEquals(true, filmer.length > 0, "det skal finnes minst en film med denne tittelen");
		assertEquals("Max Manus", filmer[0].getTittel());
	}
	
	@Test
	void testProdusentFunnet() {
		
		Film[] filmer = filmarkiv.soekProdusent("Tommy Wirkola");
		assertNotNull(filmer, "Listen over filmer skal ikke være null");
		assertEquals(1, filmer.length, "Det skal finnes minst en film med denne produsenten");
		assertEquals("Tommy Wirkola", filmer[0].getProdusent());		
		
	}
}