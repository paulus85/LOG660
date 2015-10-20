package db;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "UTILISATEUR", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL") )
public class Utilisateur {
	//Atributs de la classe
	private Integer userId;
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	private Date birthday;
	private String password;
	
	public Address adresse;
	
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String lastName, String firstName, String email, String phoneNumber,
			Date birthday, String password, Address adresse) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.password = password;
		this.adresse = adresse;
	}
	
	@Id
	@SequenceGenerator(name = "utilisateurSeq", sequenceName="USERSEQ", allocationSize=1)
	@GeneratedValue(generator="utilisateurSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="USERID")
	public Integer getUserId() {
		return userId;
	}

	@Column(name="LASTNAME")
	public String getLastName() {
		return lastName;
	}

	@Column(name="FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	@Column(name="PHONENUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDAY")
	public Date getBirthday() {
		return birthday;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	@JoinColumn(name="ADRESSEID")
	public Address getAdresse() {
		return adresse;
	}

	public void setAdresse(Address adresse) {
		this.adresse = adresse;
	}
	
	

}
