package db;

import javax.persistence.*;

/**
 * @author paulriviere
 *
 */
@Entity
@Table(name="ADRESSE")
public class Address {

	private Integer addressId;
	private String rue;
	private String ville;
	private String province;
	private String codePostal;

	@Id
	@SequenceGenerator(name = "adresseSeq", sequenceName="ADDRESSSEQ", allocationSize=1)
	@GeneratedValue(generator="adresseSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="ADRESSEID")
	public Integer getAddressId() {
		return addressId;
	}

	private void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name="RUE", length = 100)
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Column(name="VILLE", length = 100)
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name="PROVINCE", length = 100)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name="CODEPOSTAL", length = 10)
	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Address() {
		
	}

	public Address(String rue, String ville, String province, String codePostal) {
		this.rue = rue;
		this.ville = ville;
		this.province = province;
		this.codePostal = codePostal;
	}

}
