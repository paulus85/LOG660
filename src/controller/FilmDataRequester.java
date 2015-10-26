package controller;

import java.util.ArrayList;
import java.util.Date;

import db.Artist;
import db.Film;

public class FilmDataRequester {
    /* ---------------------
     *  Attributs de calcul
     * --------------------- */
	ArrayList<String> filmsBySearch;
	Film filmInformations;
	
	/*
	 * Constructeur par defaut
	 */
	public FilmDataRequester(){}

    /* ----------------------------------------------
     *  METHODES de requetes pour populer les listes
     * ---------------------------------------------- */
	/*
	 * @param filmTitle Nom du film selectionne
	 * @return Le nom des acteurs qui ont joue dans le film
	 */
	public ArrayList<String> getFilmsBySearch(){
		filmsBySearch = new ArrayList<String>();
		//TODO: On fait la requete a la base de donnee
		
		//On ajoute tous les films resultants
		filmsBySearch.add("Film 1");
		filmsBySearch.add("Film 2");
		filmsBySearch.add("Film 3");
		
		//On retourne cette liste de film
		return filmsBySearch;
	}

    /* ------------------------------------------------------
     *  METHODE de requete pour Obtenir les infos d'un artist
     * ------------------------------------------------------
	public Artist getFilmInformations(String filmTitle, AUTRES CRITERES DE RECHERCHER){
		//TODO: On fait la requete a la base de donnee
		
		//On retourne le film en question
		return filmInformations
	}
	*/
}
