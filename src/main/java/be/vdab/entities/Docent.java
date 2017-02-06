package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import be.vdab.enums.Geslacht;

@Entity
@Table(name = "docenten")

public class Docent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String voornaam;
	private String familienaam;
	private BigDecimal wedde;
	private long rijksRegisterNr;
	@Enumerated(EnumType.STRING)
	private Geslacht geslacht;
	@ElementCollection
	@CollectionTable(name = "docentenbijnamen", joinColumns = @JoinColumn(name = "docentid"))
	@Column(name = "bijnaam")
	private Set<String> bijnamen;
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "campusid")
//	private Campus campus;

	protected Docent() { // default constructor is vereiste voor JPA
	}

	public Docent(String voornaam, String familienaam, BigDecimal wedde, Geslacht geslacht, long rijksRegisterNr) {
		setVoornaam(voornaam);
		setFamilienaam(familienaam);
		setWedde(wedde);
		setGeslacht(geslacht);
		setRijksRegisterNr(rijksRegisterNr);
		this.bijnamen = new HashSet<>();
	}

	public long getId() {
		return id;
	}

	public void setVoornaam(String voornaam) {
		if (!isVoornaamValid(voornaam)) {
			throw new IllegalArgumentException();
		}
		this.voornaam = voornaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setFamilienaam(String familienaam) {
		if (!isFamilienaamValid(familienaam)) {
			throw new IllegalArgumentException();
		}
		this.familienaam = familienaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public void setWedde(BigDecimal wedde) {
		if (!isWeddeValid(wedde)) {
			throw new IllegalArgumentException();
		}
		this.wedde = wedde;
	}

	public BigDecimal getWedde() {
		return wedde;
	}

	public void setRijksRegisterNr(long rijksRegisterNr) {
		if (!isRijksRegisterNrValid(rijksRegisterNr)) {
			throw new IllegalArgumentException();
		}
		this.rijksRegisterNr = rijksRegisterNr;
	}

	public long getRijksRegisterNr() {
		return rijksRegisterNr;
	}

	public void setGeslacht(Geslacht geslacht) {
		this.geslacht = geslacht;
	}

	public Geslacht getGeslacht() {
		return geslacht;
	}

	public String getNaam() {
		return voornaam + ' ' + familienaam;
	}

	public Set<String> getBijnamen() {
		return Collections.unmodifiableSet(bijnamen);
	}

//	public final Campus getCampus() {
//		return campus;
//	}
//
//	public final void setCampus(Campus campus) {
//		this.campus = campus;
//	}

	public static boolean isVoornaamValid(String voornaam) {
		return voornaam != null && !voornaam.trim().isEmpty();
	}

	public static boolean isFamilienaamValid(String familienaam) {
		return familienaam != null && !familienaam.trim().isEmpty();
	}

	public static boolean isWeddeValid(BigDecimal wedde) {
		return wedde != null && wedde.compareTo(BigDecimal.ZERO) >= 0;
	}

	public static boolean isRijksRegisterNrValid(long rijksRegisterNr) {
		long getal = rijksRegisterNr / 100;
		if (rijksRegisterNr / 1_000_000_000 < 50) {
			getal += 2_000_000_000;
		}
		return rijksRegisterNr % 100 == 97 - getal % 97;
	}

	public void opslag(BigDecimal percentage) {
		BigDecimal factor = BigDecimal.ONE.add(percentage.divide(BigDecimal.valueOf(100)));
		wedde = wedde.multiply(factor).setScale(2, RoundingMode.HALF_UP);
	}

	public void addBijnaam(String bijnaam) {
		bijnamen.add(bijnaam);
	}

	public void removeBijnaam(String bijnaam) {
		bijnamen.remove(bijnaam);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rijksRegisterNr ^ (rijksRegisterNr >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Docent)) {
			return false;
		}
		Docent docent = (Docent) obj;
		return rijksRegisterNr == docent.rijksRegisterNr;
	}

}
