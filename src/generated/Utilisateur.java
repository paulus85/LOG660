package generated;
// Generated 10 oct. 2015 16:27:34 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "UTILISATEUR", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL") )
public class Utilisateur implements java.io.Serializable {

	private BigDecimal userid;
	private Adresse adresse;
	private String lastname;
	private String firstname;
	private String phonenumber;
	private Date birthday;
	private String email;
	private String password;

	public Utilisateur() {
	}

	public Utilisateur(BigDecimal userid, Adresse adresse, String lastname, String firstname, String phonenumber,
			Date birthday, String email, String password) {
		this.userid = userid;
		this.adresse = adresse;
		this.lastname = lastname;
		this.firstname = firstname;
		this.phonenumber = phonenumber;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
	}

	@Id

	@Column(name = "USERID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADRESSEID", nullable = false)
	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Column(name = "LASTNAME", nullable = false, length = 100)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "FIRSTNAME", nullable = false, length = 100)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "PHONENUMBER", nullable = false, length = 100)
	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", nullable = false, length = 7)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
