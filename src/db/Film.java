package db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="FILM")
public class Film {

	private Integer filmId;
	private String title;
	private Integer year;
	private String language;
	private Integer duration;
	private Integer originalCopyNumber;
	private String summary;
	private Artist director;
	private Set<Scenarist> scenarists = new HashSet<Scenarist>();
	private Set<Genre> genres = new HashSet<Genre>();
	private Set<Country> countries = new HashSet<Country>();
	private Set<ActorFilmRole> actorFilmRoles = new HashSet<ActorFilmRole>();
	
	
	//CONSTRUCTEURS
	public Film() {
	}

	public Film(String title, Integer year, String language, Integer duration, Integer originalCopyNumber,
			String summary, Artist director) {
		this.title = title;
		this.year = year;
		this.language = language;
		this.duration = duration;
		this.originalCopyNumber = originalCopyNumber;
		this.summary = summary;
		this.director = director;
	}
	
	//GETTER ET SETTER
	@Id
	@SequenceGenerator(name = "adresseSeq", sequenceName="ADDRESSSEQ", allocationSize=1)
	@GeneratedValue(generator="adresseSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="FILMID")
	public Integer getFilmId() {
		return this.filmId;
	}
	
	public void setFilmId(Integer filmid) {
		this.filmId = filmid;
	}

	@Column(name="TITLE", length=100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="YEAR")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(name="LANGUAGE", length=100)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name="DURATION")
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name="ORIGINALCOPYNUMBER")
	public Integer getOriginalCopyNumber() {
		return originalCopyNumber;
	}

	public void setOriginalCopyNumber(Integer originalCopyNumber) {
		this.originalCopyNumber = originalCopyNumber;
	}

	@Column(name="SUMMARY", length=4000)
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	//Mapping Scenarists
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="FILMSCENARIST",
				joinColumns={@JoinColumn(name="FILMID")},
				inverseJoinColumns={@JoinColumn(name="SCENARISTID")})
	public Set<Scenarist> getScenarists() {
		return scenarists;
	}

	public void setScenarists(Set<Scenarist> scenarists) {
		this.scenarists = scenarists;
	}

	//Mapping Director
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DIRECTORID")
	public Artist getDirector() {
		return director;
	}

	public void setDirector(Artist director) {
		this.director = director;
	}

	//Mapping ActorFilmRole
	@OneToMany(mappedBy = "pk.film",
			cascade = CascadeType.ALL)
	public Set<ActorFilmRole> getActorFilmRoles() {
		return actorFilmRoles;
	}

	public void setActorFilmRoles(Set<ActorFilmRole> roles) {
		this.actorFilmRoles = roles;
	}
	
	public void addActorFilmRole(ActorFilmRole roles){
		this.actorFilmRoles.add(roles);
	}

	//Mapping Countries
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="FILMCOUNTRY",
				joinColumns={@JoinColumn(name="FILMID")},
				inverseJoinColumns={@JoinColumn(name="COUNTRYID")})
	public Set<Country> getCountries() {
		return countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}

	//Mapping Genres
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="FILMGENRE",
				joinColumns={@JoinColumn(name="FILMID")},
				inverseJoinColumns={@JoinColumn(name="GENREID")})
	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	
}
