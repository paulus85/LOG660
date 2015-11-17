package db;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="COPY")
public class Copy {

	@Id
	@SequenceGenerator(name = "copySeq", sequenceName="COPYSEQ", allocationSize=1)
	@GeneratedValue(generator="copySeq", strategy=GenerationType.SEQUENCE)
	@Column(name="COPYID")
	private Integer copyId;
	
	@Column(name = "FILMID")
	private Integer filmId;
	
	@Column(name = "USERID")
	private Integer userId = null;
	
	@Column(name = "RENTED")
	private boolean rented;
	
	@Column(name = "DATELOC")
	private Date dateLoc= null;
	
	
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
