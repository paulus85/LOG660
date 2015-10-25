package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmcountryId generated by hbm2java
 */
@Embeddable
public class FilmcountryId implements java.io.Serializable {

	private BigDecimal countryid;
	private BigDecimal filmid;

	public FilmcountryId() {
	}

	public FilmcountryId(BigDecimal countryid, BigDecimal filmid) {
		this.countryid = countryid;
		this.filmid = filmid;
	}

	@Column(name = "COUNTRYID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCountryid() {
		return this.countryid;
	}

	public void setCountryid(BigDecimal countryid) {
		this.countryid = countryid;
	}

	@Column(name = "FILMID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getFilmid() {
		return this.filmid;
	}

	public void setFilmid(BigDecimal filmid) {
		this.filmid = filmid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmcountryId))
			return false;
		FilmcountryId castOther = (FilmcountryId) other;

		return ((this.getCountryid() == castOther.getCountryid()) || (this.getCountryid() != null
				&& castOther.getCountryid() != null && this.getCountryid().equals(castOther.getCountryid())))
				&& ((this.getFilmid() == castOther.getFilmid()) || (this.getFilmid() != null
						&& castOther.getFilmid() != null && this.getFilmid().equals(castOther.getFilmid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCountryid() == null ? 0 : this.getCountryid().hashCode());
		result = 37 * result + (getFilmid() == null ? 0 : this.getFilmid().hashCode());
		return result;
	}

}
