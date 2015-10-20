package db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

public class Film {

	private Integer filmId;
	private String title;
	private Integer year;
	private String language;
	private Integer duration;
	private Integer originalCopyNumber;
	private String summary;
	private Set<Scenarist> Scenarists = new HashSet<Scenarist>();
	
	public Film() {
		
	}

	public Film(String title, Integer year, String language, Integer duration, Integer originalCopyNumber,
			String summary, Set<Scenarist> scenarists) {
		this.title = title;
		this.year = year;
		this.language = language;
		this.duration = duration;
		this.originalCopyNumber = originalCopyNumber;
		this.summary = summary;
		Scenarists = scenarists;
	}
	
	@Id
	@SequenceGenerator(name = "adresseSeq", sequenceName="ADDRESSSEQ", allocationSize=1)
	@GeneratedValue(generator="adresseSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="FILMID")
	public Integer getFilmId() {
		return this.filmId;
	}
	
	public void setFilmId(Integer filmid) {
		this.filmId = filmid;
	}

	@Column(name="TITLE", length=100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="YEAR")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(name="LANGUAGE", length=100)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name="DURATION")
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name="ORIGINALCOPYNUMBER")
	public Integer getOriginalCopyNumber() {
		return originalCopyNumber;
	}

	public void setOriginalCopyNumber(Integer originalCopyNumber) {
		this.originalCopyNumber = originalCopyNumber;
	}

	@Column(name="SUMMARY", length=4000)
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	//TODO Many-to-many
	public Set<Scenarist> getScenarists() {
		return Scenarists;
	}

	public void setScenarists(Set<Scenarist> scenarists) {
		Scenarists = scenarists;
	}

}
