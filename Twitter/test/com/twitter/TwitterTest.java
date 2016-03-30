package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter tw;

	
	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	@Test
	public void testVratiSvePorukeSveOk() {
		LinkedList<TwitterPoruka> poruka = new LinkedList<TwitterPoruka>();
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		String poruka1 = "Dobar dan!";
		String poruka2 = "Bojana i Peki";
		String korisnik1 = "Ana";
		String korisnik2 = "Milena";
		tw.unesi(korisnik1, poruka1);
		tw.unesi(korisnik2, poruka2);
		tp1.setKorisnik(korisnik1);
		tp1.setPoruka(poruka1);
		tp2.setKorisnik(korisnik2);
		tp2.setPoruka(poruka2);
		poruka.addLast(tp1);
		poruka.addLast(tp2);
		assertEquals(poruka, tw.vratiSvePoruke());
		
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiSvePorukeNull() {
		tw.unesi(null, null);
		tw.vratiSvePoruke();
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiSvePorukePrazan() {
		tw.unesi("", "");
		tw.vratiSvePoruke();
	}
	
	@Test
	public void testUnesiSveOk() {
		LinkedList<TwitterPoruka> poruka = new LinkedList<TwitterPoruka>();
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		String poruka1 = "Dobar dan!";
		String poruka2 = "Bojana i Peki";
		String korisnik1 = "Ana";
		String korisnik2 = "Milena";
		tw.unesi(korisnik1, poruka1);
		tw.unesi(korisnik2, poruka2);
		tp1.setKorisnik(korisnik1);
		tp1.setPoruka(poruka1);
		tp2.setKorisnik(korisnik2);
		tp2.setPoruka(poruka2);
		poruka.addLast(tp1);
		poruka.addLast(tp2);
		assertEquals(poruka, tw.vratiSvePoruke());
	}
	


	@Test
	public void testVratiPorukeSveOk() {
		TwitterPoruka p1 = new TwitterPoruka();
		TwitterPoruka p2 = new TwitterPoruka();
		TwitterPoruka p3 = new TwitterPoruka();
		int max = 2;
		TwitterPoruka[] poruka = new TwitterPoruka[max];
		String korisnik1 = "Ana";
		String korisnik2 = "Milena";
		String poruka1 = "Dobar dan!";
		String poruka2 = "Bojana i Peki";
		String korisnik3 = "Milica";
		String poruka3 = "Bojana jede plazmu i mleko.";
		p1.setKorisnik(korisnik1);
		p1.setPoruka(poruka1);
		p2.setKorisnik(korisnik2);
		p2.setPoruka(poruka2);
		p3.setKorisnik(korisnik3);
		p3.setPoruka(poruka3);
		poruka [0] = p2;
		poruka [1] = p3;
		tw.unesi(korisnik1, poruka1);
		tw.unesi(korisnik2, poruka2);
		tw.unesi(korisnik3, poruka3);
		assertArrayEquals(poruka, tw.vratiPoruke(max, "Bo"));
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		tw.vratiPoruke(1, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazan() {
		tw.vratiPoruke(1, "");
	}
}
