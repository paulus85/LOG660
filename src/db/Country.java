package db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="COUNTRY")
public class Country {
	private Integer countryId;
	private String countryName;
	private Set<Film> films = new HashSet<Film>(0);

	//CONSTRUCTEUR
	public Country() {
	}

	public Country(String countryName) {
		this.countryName = countryName;
	}
	
	//GETTER ET SETTER
	@Id
	@SequenceGenerator(name = "countrySeq", sequenceName="COUNTRYSEQ", allocationSize=1)
	@GeneratedValue(generator="countrySeq", strategy=GenerationType.SEQUENCE)
	@Column(name="COUNTRYID")
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Column(name="COUNTRYNAME", length = 100)
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	//Mapping Film
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "countries")
	public Set<Film> getFilms() {
		return this.films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

}
