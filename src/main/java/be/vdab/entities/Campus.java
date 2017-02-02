package be.vdab.entities;

import java.io.Serializable;
import javax.persistence.*;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "campussen")
public class Campus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@Embedded
	private Adres adres;

	public Campus(String naam, Adres adres) {
		setNaam(naam);
		setAdres(adres);
	}

	protected Campus() {
	}

	public final long getId() {
		return id;
	}

	public final String getNaam() {
		return naam;
	}

	public final void setNaam(String naam) {
		this.naam = naam;
	}

	public final Adres getAdres() {
		return adres;
	}

	public final void setAdres(Adres adres) {
		this.adres = adres;
	}

}
