package controller;

import java.util.ArrayList;
import java.util.Date;

import db.Artist;
import db.Film;

public class FilmDataRequester {
    /* ---------------------
     *  Attributs de calcul
     * --------------------- */
	//La liste d'objet Film resultant de la requete
	ArrayList<Film> filmsBySearch;
	//La liste de String affichee dans listFilm soit: titre du film (annee)
	ArrayList<String> filmSearchResults;
	
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
		filmsBySearch = new ArrayList<Film>();
		
		//TODO: On fait la requete a la base de donnee
		
				
		
		//On retourne cette liste de film
		return listFilmYearString(filmsBySearch);
	}
	
	private ArrayList<String> listFilmYearString(ArrayList<Film> pFilmsBySearch){
		filmSearchResults = new ArrayList<String>();
		String filmString = "";
		//TODO: Concatener les informations du films en String
		for(int i=0; i<pFilmsBySearch.size(); i++){
			filmString = "";
			filmString += filmsBySearch.get(i).getTitle().toString();
			filmString += " (";
			filmString += filmsBySearch.get(i).getYear().toString();
			filmString += ")";
			//On ajoute le String du film au tableau a retourner
			filmSearchResults.add(filmString);
		}
		
		//FILMS TESTS
		filmSearchResults.add("Film 1 (2010)");
		filmSearchResults.add("Film 2 (2011)");
		filmSearchResults.add("Film 3 (2012)");
		
		return filmSearchResults;
	}
	
    /* ------------------------------------------------------
     *  METHODE de requete pour Obtenir les infos d'un artist
     * ------------------------------------------------------ */
	public Film getSelectedFilmInfo(int pFilmSearchResultsIndex){
		//On retourne le film en question
		return filmsBySearch.get(pFilmSearchResultsIndex);
	}
}
