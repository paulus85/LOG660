package db;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ACTORFILMROLE")
@AssociationOverrides({
	@AssociationOverride(name="pk.artist", joinColumns=@JoinColumn(name="ARTISTID")),
	@AssociationOverride(name="pk.film", joinColumns=@JoinColumn(name="FILMID"))
})
public class ActorFilmRole {
	
	private ActorFilmRoleId pk = new ActorFilmRoleId();
	private String characterName;
	
	@EmbeddedId
	public ActorFilmRoleId getPk() {
		return pk;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setPk(ActorFilmRoleId pk) {
		this.pk = pk;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	
	

}
