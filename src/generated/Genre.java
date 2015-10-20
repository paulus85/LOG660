package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Genre generated by hbm2java
 */
@Entity
@Table(name = "GENRE")
public class Genre implements java.io.Serializable {

	private BigDecimal genreid;
	private String genrename;

	public Genre() {
	}

	public Genre(BigDecimal genreid, String genrename) {
		this.genreid = genreid;
		this.genrename = genrename;
	}

	@Id

	@Column(name = "GENREID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getGenreid() {
		return this.genreid;
	}

	public void setGenreid(BigDecimal genreid) {
		this.genreid = genreid;
	}

	@Column(name = "GENRENAME", nullable = false, length = 100)
	public String getGenrename() {
		return this.genrename;
	}

	public void setGenrename(String genrename) {
		this.genrename = genrename;
	}

}
