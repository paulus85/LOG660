package db;

import java.sql.Date;

public class EmployeeUserInfo extends Utilisateur {

	private Integer matricule;
	
	public EmployeeUserInfo() {
		super();
	}

	public EmployeeUserInfo(String lastName, String firstName, String email, String phoneNumber,
			Date birthday, String password, Address adresse, Integer matricule) {
		super(lastName,firstName,email,phoneNumber,birthday,password,adresse);
		this.matricule = matricule;
	}

	public Integer getMatricule() {
		return matricule;
	}

	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

}
