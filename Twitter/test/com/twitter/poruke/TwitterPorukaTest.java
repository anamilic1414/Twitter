package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testGetKorisnikSveOk() {
		String korisnik = "Ana Milic";
		tp.setKorisnik(korisnik);
		assertEquals(tp.getKorisnik(), korisnik);
	}

	@Test
	public void testSetKorisnikSveOk() {
		String korisnik = "Ana Milic";
		tp.setKorisnik(korisnik);
		assertEquals(korisnik, tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}

	@Test
	public void testGetPorukaSveOk() {
		String poruka = "Dobar dan!";
		tp.setPoruka(poruka);
		assertEquals(tp.getPoruka(), poruka);
	}

	@Test
	public void testSetPorukaSveOk() {
		String poruka = "Dobar dan!";
		tp.setPoruka(poruka);
		assertEquals(poruka, tp.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaOgromna() {
		tp.setPoruka(
				"Napisati JUnit testove za klasu TwitterPoruka (za sve set metode, kao i za toString metodu), i proveriti da svi testovi prolaze. Neke metode klase TwitterPoruka sadrže namerno uvedene mane koje treba testiranjem otkriti (napisati JUnit testove koje izazivaju njihovo manifestovanje) a tek onda i ispraviti.");
	}

	@Test
	public void testToString() {
		tp.setKorisnik("Ana Milic");
		tp.setPoruka("Dobar dan!");
		System.out.println(tp);
	}

}
