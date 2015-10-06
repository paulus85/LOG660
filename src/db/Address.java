package db;

/**
 * @author paulriviere
 *
 */
public class Address {

	private Integer addressId;
	private String rue;
	private String ville;
	private String province;
	private String codePostal;

	public Integer getAddressId() {
		return addressId;
	}

	private void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Address() {
		
	}

}
