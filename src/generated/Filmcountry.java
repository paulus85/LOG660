package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Filmcountry generated by hbm2java
 */
@Entity
@Table(name = "FILMCOUNTRY")
public class Filmcountry implements java.io.Serializable {

	private FilmcountryId id;

	public Filmcountry() {
	}

	public Filmcountry(FilmcountryId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "countryid", column = @Column(name = "COUNTRYID", nullable = false, precision = 22, scale = 0) ),
			@AttributeOverride(name = "filmid", column = @Column(name = "FILMID", nullable = false, precision = 22, scale = 0) ) })
	public FilmcountryId getId() {
		return this.id;
	}

	public void setId(FilmcountryId id) {
		this.id = id;
	}

}
