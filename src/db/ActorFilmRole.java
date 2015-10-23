package db;

import javax.persistence.*;

@Entity
@Table(name="ACTORFILMROLE")
@AssociationOverrides({
	@AssociationOverride(name="pk.artist", joinColumns=@JoinColumn(name="ARTISTID")),
	@AssociationOverride(name="pk.film", joinColumns=@JoinColumn(name="FILMID"))
})
public class ActorFilmRole {
	//Clé primaire composite
	private ActorFilmRoleId pk = new ActorFilmRoleId();
	//Champs additionnels
	private String characterName;
	
	@EmbeddedId
	public ActorFilmRoleId getPk() {
		return pk;
	}
	
	public void setPk(ActorFilmRoleId pk) {
		this.pk = pk;
	}
	
	@Transient 
	public Artist getArtist(){
		return getPk().getArtist();
	}
	
	public void setArtist(Artist artist){
		getPk().setArtist(artist);
	}
	
	@Transient 
	public Film getFilm(){
		return getPk().getFilm();
	}
	
	public void setFilm(Film film){
		getPk().setFilm(film);
	}
	
	@Column (name="CHARACTERNAME", length = 100)
	public String getCharacterName() {
		return characterName;
	}
	
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	
	

}
