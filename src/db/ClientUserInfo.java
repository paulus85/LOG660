package db;

import javax.persistence.*;

public class ClientUserInfo {
	
	private enum DomaineCreditCardType {
		Visa,
		Mastercard,
		Amex
	}	
	
	private Integer userId;
	private Integer numero;
	private Integer expirationMonth;
	private Integer expirationYear;
	private Integer cvv;
	private Plan plan;
	
	@Column(name="creditCardType") 
	@Enumerated(EnumType.STRING) 
	private DomaineCreditCardType creditCardType;


	public ClientUserInfo() {
		
	}

	public ClientUserInfo(Integer userId, Integer numero, Integer expirationMonth, Integer expirationYear,
			Integer cvv) {
		this.userId = userId;
		this.numero = numero;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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
	
	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public DomaineCreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(DomaineCreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

}
