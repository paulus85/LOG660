package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vue_moyenne")
public class Moyenne {
	
	private Integer idfilm;
	private Float moyenne;
	
	public Moyenne(){
		
	}

	@Id
	@Column(name="idfilm")
	public Integer getIdfilm() {
		return idfilm;
	}

	public void setIdfilm(Integer idfilm) {
		this.idfilm = idfilm;
	}

	@Column(name="moyenne")
	public Float getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Float moyenne) {
		this.moyenne = moyenne;
	}
	
	

}
