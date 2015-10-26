package db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="SCENARIST")
public class Scenarist {
	
	private Integer scenaristId;
	private String name;
	private Set<Film> films = new HashSet<Film>(0);
	
	//CONSTRUCTEUR
	public Scenarist(){
	}
	
	public Scenarist(String name) {
		this.name = name;
	}
	
	public Scenarist(String name, Set<Film> films) {
		this.name = name;
		this.films = films;
	}

	
	//GETTER ET SETTER
	
	@Id
	@SequenceGenerator(name = "scenaristSeq", sequenceName="SCENARISTSEQ", allocationSize=1)
	@GeneratedValue(generator="scenaristSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="SCENARISTID")
	public Integer getScenaristId() {
		return scenaristId;
	}
	
	public void setScenaristId(Integer scenaristId) {
		this.scenaristId = scenaristId;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Mapping Film
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "scenarists")
	public Set<Film> getFilms() {
		return this.films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}
}
