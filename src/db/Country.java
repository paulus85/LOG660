package db;


import javax.persistence.*;

@Entity
@Table(name="COUNTRY")
public class Country {
	
	@Id
	@SequenceGenerator(name = "countrySeq", sequenceName="COUNTRYSEQ", allocationSize=1)
	@GeneratedValue(generator="countrySeq", strategy=GenerationType.SEQUENCE)
	@Column(name="COUNTRYID")
	private Integer countryId;
	
	@Column(name="countryName", length = 100)
	private String countryName;

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Country() {
		
	}

	public Country(String countryName) {
		this.countryName = countryName;
	}

}
