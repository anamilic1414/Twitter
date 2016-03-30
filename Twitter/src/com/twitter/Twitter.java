package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa koja predstavlja twitter. Sadrzi listu sa elementima klase TwiterPoruka.
 * @author Ana Milic
 *
 */
public class Twitter {

	/**
	 * Poruke kao LinkedList.
	 */
	private LinkedList<TwitterPoruka> poruke = 
			new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vraca listu sa porukama.
	 * @return lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}

	/**
	 * Metoda pravi novu poruku i dodaje je na kraj postojece liste.
	 * @param korisnik Naziv korisnika
	 * @param poruka Teskt poruke
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		//Bila je greska "korisnik"
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda vraca niz poruka koje se nalaze u listi i sadrze zadati tag.
	 * @param maxBroj Maksimalan broj poruka sa zadatim tagom
	 * @param tag Zadati tag
	 * @return niz poruka
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					//Bila je greska [brojac+1]
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
}