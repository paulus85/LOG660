package controller;

import java.util.ArrayList;
import java.util.Date;

import db.Artist;

public class ArtistDataRequester {
    /* ---------------------
     *  Attributs de calcul
     * --------------------- */
	ArrayList<String> actorsInFilm;
	String realisateurOfFilm;
	ArrayList<String> scenaristsOfFilm;
	Artist targetArtist;
	
	/*
	 * Constructeur par defaut
	 */
	public ArtistDataRequester(){}

    /* ----------------------------------------------
     *  METHODES de requetes pour populer les listes
     * ---------------------------------------------- */
	/*
	 * @param filmTitle Nom du film selectionne
	 * @return Le nom des acteurs qui ont joue dans le film
	 */
	public ArrayList<String> getActorsByFilm(String filmTitle){
		actorsInFilm = new ArrayList<String>();
		//TODO: On fait la requete a la base de donnee
		
		//On ajoute tous les films resultants
		actorsInFilm.add("Actor 1");
		actorsInFilm.add("Actor 2");
		actorsInFilm.add("Actor 3");
		
		//On retourne cette liste de film
		return actorsInFilm;
	}
	/*
	 * @param filmTitle Nom du film selectionne
	 * @return Le nom du realisateur qui a realise le film
	 */
	public String getRealisateurByFilm(String filmTitle){
		//TODO: On fait la requete a la base de donnee
		realisateurOfFilm = "Qui est le realisateur";
		
		//On retourne le nom du realisateur
		return realisateurOfFilm;
	}
	
	/*
	 * @param filmTitle Nom du film selectionne
	 * @return Le nom des scenaristes qui ont ecrit le film
	 */
	public ArrayList<String> getScenaristsByFilm(String filmTitle){
		scenaristsOfFilm = new ArrayList<String>();
		//TODO: On fait la requete a la base de donnee
		
		//On ajoute tous les scenaristes du film recherche
		scenaristsOfFilm.add("Scenarist 1");
		scenaristsOfFilm.add("Scenarist 2");
		scenaristsOfFilm.add("Scenarist 3");
		
		//On retourne cette liste de scenarist
		return scenaristsOfFilm;
	}

    /* ------------------------------------------------------
     *  METHODE de requete pour Obtenir les infos d'un artist
     * ------------------------------------------------------
	public Artist getArtistByName(String artistName){
		//TODO: On fait la requete a la base de donnee
	}
	*/
}
