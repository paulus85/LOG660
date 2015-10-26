package db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="GENRE")
public class Genre {
	private Integer genreId;
	private String genreName;
	private Set<Film> films = new HashSet<Film>(0);

	//CONSTRUCTEUR
	public Genre() {
	}

	public Genre(String genreName) {
		this.genreName = genreName;
	}
	
	//GETTER ET SETTER
	@Id
	@SequenceGenerator(name = "genreSeq", sequenceName="GENRESEQ", allocationSize=1)
	@GeneratedValue(generator="genreSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="GENREID")
	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	@Column(name="GENRENAME", length = 100)
	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	//Mapping Film
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
	public Set<Film> getFilms() {
		return this.films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

}
