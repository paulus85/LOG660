package db;

import java.sql.Date;

public class Artist {
	
	private Integer artistId;
	private String name;
	private Date birthday;
	private String birthPlace;
	private String biography;

	public Integer getArtistId() {
		return artistId;
	}

	private void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Artist() {
	
	}

}
