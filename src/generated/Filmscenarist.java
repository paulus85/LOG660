package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Filmscenarist generated by hbm2java
 */
@Entity
@Table(name = "FILMSCENARIST")
public class Filmscenarist implements java.io.Serializable {

	private FilmscenaristId id;

	public Filmscenarist() {
	}

	public Filmscenarist(FilmscenaristId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "scenaristid", column = @Column(name = "SCENARISTID", nullable = false, precision = 22, scale = 0) ),
			@AttributeOverride(name = "filmid", column = @Column(name = "FILMID", nullable = false, precision = 22, scale = 0) ) })
	public FilmscenaristId getId() {
		return this.id;
	}

	public void setId(FilmscenaristId id) {
		this.id = id;
	}

}