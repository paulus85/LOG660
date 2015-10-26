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
	public ArrayList<String> getFilmsBySearch(String pTitle,
												int pMinYear,
												int pMaxYear,
												String pCountries,
												String pLanguage,
												String pGenres,
												String pRealisateur,
												String pActors){
		//On reinitialise la liste des resultats de Films 
		filmsBySearch = new ArrayList<Film>();
		//On cree une chaine de requete VIDE
		String request = "";
		//------------------------------------------------
		//-------------FORMATION DE REQUETE --------------
		if(!(pTitle.isEmpty())){
			System.out.println(pTitle);
		}
		if(!(pCountries.isEmpty())){
			//On separe les elements de l'enumeration de COUNTRY
			String[] countries = pCountries.split(", ");
			System.out.println("Splitted one country: " + countries[0].toString());
			for(int i=1; i<countries.length; i++){
				//On presente les elements de l'enumeration de COUNTRY
				System.out.println("Splitted other country: " + countries[i].toString());
			}
		}
		if(!(pLanguage.isEmpty())){
			System.out.println(pLanguage);
		}
		if(!(pGenres.isEmpty())){
			//On separe les elements de l'enumeration
			String[] genres = pGenres.split(", ");
			System.out.println("Splitted one language: " + genres[0].toString());
			for(int i=1; i<genres.length; i++){
				//On presente les elements de l'enumeration
				System.out.println("Splitted other language: " + genres[i].toString());
			}
		}
		if(!(pRealisateur.isEmpty())){
			System.out.print(pRealisateur);
		}
		if(!(pActors.isEmpty())){
			//On separe les elements de l'enumeration
			String[] actors = pActors.split(", ");
			System.out.println("Splitted one actor: " + actors[0].toString());
			for(int i=1; i<actors.length; i++){
				//On presente les elements de l'enumeration
				System.out.println("Splitted other actor: " + actors[i].toString());
			}
		}
		if(pMinYear>0 && pMaxYear>0){
			//TODO: On cherche un film entre les pMinYear et pMaxYear
			System.out.println("On cherche un film entre les pMinYear="+pMinYear+" et pMaxYear="+pMaxYear);
		}else if(pMinYear !=0){
			//TODO: On cherche un film apres l'an pMinYear
			System.out.println("On cherche un film apres l'an pMinYear=" + pMinYear);
		}else if(pMaxYear !=0){
			//TODO: On cherche un film apres l'an pMaxYear
			System.out.println("On cherche un film entre les pMaxYear=" + pMaxYear);
		}
		//--------FIN DE : FORMATION DE REQUETE ----------
		//------------------------------------------------
		//TODO: On fait la requete a la base de donnee
		//TODO: filmsBySearch contient les resultats
		
		//FORMAT STRING pour l'affichage
		filmSearchResults = listFilmYearString(filmsBySearch);
		//On retourne cette liste de film
		return filmSearchResults;
	}
	
	private ArrayList<String> listFilmYearString(ArrayList<Film> pFilmsBySearch){
		//On instancie une nouvelle liste de resultat
		ArrayList<String> newFilmSearchResults = new ArrayList<String>();
		String filmString = "";
		//TODO: Concatener les informations du films en String
		for(int i=0; i<pFilmsBySearch.size(); i++){
			filmString = "";
			filmString += filmsBySearch.get(i).getTitle().toString();
			filmString += " (";
			filmString += filmsBySearch.get(i).getYear().toString();
			filmString += ")";
			//On ajoute le String du film au tableau a retourner
			newFilmSearchResults.add(filmString);
		}
		
		//FILMS TESTS
		newFilmSearchResults.add("Film 1 (2010)");
		newFilmSearchResults.add("Film 2 (2011)");
		newFilmSearchResults.add("Film 3 (2012)");
		
		return newFilmSearchResults;
	}
	
    /* ------------------------------------------------------
     *  METHODE de requete pour Obtenir les infos d'un artist
     * ------------------------------------------------------ */
	public Film getSelectedFilmInfo(int pFilmSearchResultsIndex){
		//On retourne le film en question
		return filmsBySearch.get(pFilmSearchResultsIndex);
	}
}
