package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Scenarist generated by hbm2java
 */
@Entity
@Table(name = "SCENARIST")
public class Scenarist implements java.io.Serializable {

	private BigDecimal scenaristid;
	private String name;

	public Scenarist() {
	}

	public Scenarist(BigDecimal scenaristid, String name) {
		this.scenaristid = scenaristid;
		this.name = name;
	}

	@Id

	@Column(name = "SCENARISTID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getScenaristid() {
		return this.scenaristid;
	}

	public void setScenaristid(BigDecimal scenaristid) {
		this.scenaristid = scenaristid;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
