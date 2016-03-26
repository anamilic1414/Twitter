package com.twitter.poruke;
/**
 * Klasa koja predstavlja twitter poruku. Svaka poruka ima korisnika i tekst.
 * @author Ana Milic
 *
 */

public class TwitterPoruka {

	/**
	 * Naziv korisnika kao String
	 */
	private String korisnik;
	
	/**
	 * Tekst poruke kao String
	 */
	private String poruka;
	
	/**
	 * Metoda vraca vrednost atributa korisnik
	 * @return naziv korisnika
	 */
	public String getKorisnik() {
	return korisnik;
	}
	
	/**
	 * Metoda postavlja novu vrednost za atribut korisnik.
	 * @param korisnik Novi naziv korisnika
	 * @throws java.lang.RuntimeException ako je unet naziv:
	 * <ul>
	 * 	<li>null</li>
	 * 	<li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik == "")
	throw new RuntimeException(
	"Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	
	/**
	 * Metoda vraca vrednost atributa poruka.
	 * @return tekst poruke
	 */
	public String getPoruka() {
		//2.greska "poruka"
	return poruka;
	}
	
	/**
	 * Metoda postavlja novu vrednost za atribut poruka.
	 * @param poruka Nova poruka
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * <ul>
	 * 	<li>null</li>
	 * 	<li>prazan String</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		// 1.greska this.poruka.length()
	if (poruka==null || poruka.length()>140)
	throw new RuntimeException(
	"Poruka mora biti uneta i mora imati najvise 140 znakova");
	this.poruka = poruka;
	}
	
	public String toString(){
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
