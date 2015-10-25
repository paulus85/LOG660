package db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="ARTIST")
public class Artist {
	
	//ATTRIBUTS
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
	
	@OneToMany(mappedBy = "pk.artist",
			cascade = CascadeType.ALL)
	private Set<ActorFilmRole> actorFilmRoles = new HashSet<ActorFilmRole>();

	// GETTER et SETTER
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
	

	
	public Set<ActorFilmRole> getActorFilmRoles() {
		return actorFilmRoles;
	}

	public void setActorFilmRoles(Set<ActorFilmRole> roles) {
		this.actorFilmRoles = roles;
	}
	
	

	//CONSTRUCTEURS
	public Artist() {
	}

	public Artist(String name, Date birthday, String birthPlace, String biography) {
		this.name = name;
		this.birthday = birthday;
		this.birthPlace = birthPlace;
		this.biography = biography;
	}
	
	public void addActorFilmRole(ActorFilmRole roles){
		this.actorFilmRoles.add(roles);
	}


}
