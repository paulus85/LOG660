package db;


import javax.persistence.*;

@Entity
@Table(name="COPY")
public class Copy {

	@Id
	@SequenceGenerator(name = "copySeq", sequenceName="COPYSEQ", allocationSize=1)
	@GeneratedValue(generator="copySeq", strategy=GenerationType.SEQUENCE)
	@Column(name="COPYID")
	private Integer copyId;
	
	@Column(name = "RENTED")
	private boolean rented;
	
	@Column(name = "FILMID")
	private Integer filmId;
	
	public Copy() {
		
	}

	public Copy(boolean rented, Integer filmId) {
		this.rented = rented;
		this.filmId = filmId;
	}

	public Integer getCopyId() {
		return copyId;
	}

	public void setCopyId(Integer copyId) {
		this.copyId = copyId;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	
	
}
