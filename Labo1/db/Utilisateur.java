package db;

import java.sql.Date;

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
	
	public Integer getUserId() {
		return userId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getPassword() {
		return password;
	}
	
	private void setUserId(Integer userId) {
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
	
	

}
