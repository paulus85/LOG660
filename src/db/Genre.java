package db;

import javax.persistence.*;

@Entity
@Table(name="GENRE")
public class Genre {
	
	@Id
	@SequenceGenerator(name = "genreSeq", sequenceName="GENRESEQ", allocationSize=1)
	@GeneratedValue(generator="genreSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="GENREID")
	private Integer genreId;
	
	@Column(name="nom", length = 100)
	private String genreName;

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Genre() {
		
	}

	public Genre(String genreName) {
		this.genreName = genreName;
	}

}
