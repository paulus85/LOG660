package db;

import java.util.HashSet;
import java.util.Set;

public class Film {

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
		super();
		this.title = title;
		this.year = year;
		this.language = language;
		this.duration = duration;
		this.originalCopyNumber = originalCopyNumber;
		this.summary = summary;
		Scenarists = scenarists;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getOriginalCopyNumber() {
		return originalCopyNumber;
	}

	public void setOriginalCopyNumber(Integer originalCopyNumber) {
		this.originalCopyNumber = originalCopyNumber;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Set<Scenarist> getScenarists() {
		return Scenarists;
	}

	public void setScenarists(Set<Scenarist> scenarists) {
		Scenarists = scenarists;
	}

}
