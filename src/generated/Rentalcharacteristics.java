package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rentalcharacteristics generated by hbm2java
 */
@Entity
@Table(name = "RENTALCHARACTERISTICS")
public class Rentalcharacteristics implements java.io.Serializable {

	private RentalcharacteristicsId id;
	private Date dateloc;

	public Rentalcharacteristics() {
	}

	public Rentalcharacteristics(RentalcharacteristicsId id, Date dateloc) {
		this.id = id;
		this.dateloc = dateloc;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "userid", column = @Column(name = "USERID", nullable = false, precision = 22, scale = 0) ),
			@AttributeOverride(name = "copyid", column = @Column(name = "COPYID", nullable = false, precision = 22, scale = 0) ) })
	public RentalcharacteristicsId getId() {
		return this.id;
	}

	public void setId(RentalcharacteristicsId id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATELOC", nullable = false, length = 7)
	public Date getDateloc() {
		return this.dateloc;
	}

	public void setDateloc(Date dateloc) {
		this.dateloc = dateloc;
	}

}
