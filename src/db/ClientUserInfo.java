package db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "CLIENTUSERINFO")
@PrimaryKeyJoinColumn(name = "USERID")
public class ClientUserInfo extends Utilisateur {
	
	public enum DomaineCreditCardType {
		Visa,
		MasterCard,
		Amex
	}	
	
	@Column(name = "CARDNUMBER", length = 20)
	private String cardNumber;
	
	@Column(name = "EXPIRATIONMONTH")
	private Integer expirationMonth;
	
	@Column(name = "EXPIRATIONYEAR")
	private Integer expirationYear;
	
	@Column(name = "CVV")
	private Integer cvv;
	
	private Plan plan;
	private DomaineCreditCardType creditCardType;

	
	public ClientUserInfo() {
	}

	public ClientUserInfo(String lastName, String firstName, String email, String phoneNumber,
			Date birthday, String password, Address adresse, DomaineCreditCardType type, String cardNumber, Integer expirationMonth, Integer expirationYear,
			Integer cvv, Plan plan) {
		super(lastName, firstName, email, phoneNumber, birthday, password, adresse);
		this.creditCardType = type;
		this.cardNumber = cardNumber;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
		this.plan = plan;
	}


	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public Integer getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	@JoinColumn(name="PLANID")
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Column(name="creditCardType") 
	@Enumerated(EnumType.STRING) 
	public DomaineCreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(DomaineCreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

}
