package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vue_correlation")
public class Correlation {

	private Integer film1;
	private Integer film2;
	private Integer nombreCotes;
	private Float correlation;
	
	@Id
	@Column(name="film1")
	public Integer getFilm1() {
		return film1;
	}
	public void setFilm1(Integer film1) {
		this.film1 = film1;
	}
	
	@Column(name="film2")
	public Integer getFilm2() {
		return film2;
	}
	public void setFilm2(Integer film2) {
		this.film2 = film2;
	}
	
	@Column(name="nombrecotes")
	public Integer getNombreCotes() {
		return nombreCotes;
	}
	public void setNombreCotes(Integer nombreCotes) {
		this.nombreCotes = nombreCotes;
	}
	
	@Column(name="correlation")
	public Float getCorrelation() {
		return correlation;
	}
	public void setCorrelation(Float correlation) {
		this.correlation = correlation;
	}
	
	
	
}
