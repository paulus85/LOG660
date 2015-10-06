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

}
