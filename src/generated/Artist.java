package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Artist generated by hbm2java
 */
@Entity
@Table(name = "ARTIST")
public class Artist implements java.io.Serializable {

	private BigDecimal artistid;
	private String nom;
	private Date birthday;
	private String birthplace;
	private String biography;
	private Set films = new HashSet(0);

	public Artist() {
	}

	public Artist(BigDecimal artistid, String nom) {
		this.artistid = artistid;
		this.nom = nom;
	}

	public Artist(BigDecimal artistid, String nom, Date birthday, String birthplace, String biography, Set films) {
		this.artistid = artistid;
		this.nom = nom;
		this.birthday = birthday;
		this.birthplace = birthplace;
		this.biography = biography;
		this.films = films;
	}

	@Id

	@Column(name = "ARTISTID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getArtistid() {
		return this.artistid;
	}

	public void setArtistid(BigDecimal artistid) {
		this.artistid = artistid;
	}

	@Column(name = "NOM", nullable = false, length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", length = 7)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "BIRTHPLACE", length = 100)
	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@Column(name = "BIOGRAPHY", length = 4000)
	public String getBiography() {
		return this.biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "artist")
	public Set getFilms() {
		return this.films;
	}

	public void setFilms(Set films) {
		this.films = films;
	}

}