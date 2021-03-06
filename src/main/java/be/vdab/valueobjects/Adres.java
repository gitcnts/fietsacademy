package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;
	private String straat;
	private String huisNr;
	private String postcode;
	private String gemeente;

	public Adres(String straat, String huisNr, String postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	protected Adres() {
	}

	public final String getStraat() {
		return straat;
	}

	public final String getHuisNr() {
		return huisNr;
	}

	public final String getPostcode() {
		return postcode;
	}

	public final String getGemeente() {
		return gemeente;
	}

}
