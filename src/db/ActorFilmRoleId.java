package db;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class ActorFilmRoleId implements Serializable{
	private Artist artist;
	private Film film;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Artist getArtist(){
		return artist;
	}
	
	public void setArtist(Artist artist){
		this.artist = artist;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Film getFilm(){
		return film;
	}
	
	public void setFilm(Film film){
		this.film = film;
	}
	
	

}
