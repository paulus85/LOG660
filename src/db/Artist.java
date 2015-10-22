package db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ARTIST")
public class Artist {
	
	@Id
	@SequenceGenerator(name = "artistSeq", sequenceName="ARTISTSEQ", allocationSize=1)
	@GeneratedValue(generator="artistSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="ARTISTID")
	private Integer artistId;
	
	@Column(name="nom", length = 100)
	private String name;
	
	@Column(name = "BIRTHDAY", columnDefinition="DATETIME")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name="BIRTHPLACE", length = 1000)
	private String birthPlace;
	
	@Column(name="BIOGRAPHY", length = 4000)
	private String biography;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pk.artist")
	private Set actorFilmRoles = new HashSet(0);

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Artist() {
	
	}

	public Artist(String name, Date birthday, String birthPlace, String biography) {
		this.name = name;
		this.birthday = birthday;
		this.birthPlace = birthPlace;
		this.biography = biography;
	}

	public Set getActorFilmRoles() {
		return actorFilmRoles;
	}

	public void setActorFilmRoles(Set actorFilmRoles) {
		this.actorFilmRoles = actorFilmRoles;
	}

}
