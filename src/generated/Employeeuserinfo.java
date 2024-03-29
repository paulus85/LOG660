package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employeeuserinfo generated by hbm2java
 */
@Entity
@Table(name = "EMPLOYEEUSERINFO")
public class Employeeuserinfo implements java.io.Serializable {

	private BigDecimal userid;
	private BigDecimal matricule;

	public Employeeuserinfo() {
	}

	public Employeeuserinfo(BigDecimal userid, BigDecimal matricule) {
		this.userid = userid;
		this.matricule = matricule;
	}

	@Id

	@Column(name = "USERID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	@Column(name = "MATRICULE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getMatricule() {
		return this.matricule;
	}

	public void setMatricule(BigDecimal matricule) {
		this.matricule = matricule;
	}

}
