package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;

import application.Main;
import db.Artist;
import db.Country;
import db.Film;
import db.Genre;

public class FilmDataRequester {
    /* ---------------------
     *  Attributs de calcul
     * --------------------- */
	//La liste d'objet Film resultant de la requete
	public ArrayList<Film> filmsBySearch;
	//La liste de String affichee dans listFilm soit: titre du film (annee)
	public ArrayList<String> filmSearchResults;
	 
	//Les attributs de suivi des valeurs de recherche
	private String requestTitleParameter = null;
	private boolean requestTitle = false;
	private String requestCountriesParameter = null;
	private boolean requestCountries = false;
	private String requestLanguageParameter = null;
	private boolean requestLanguage = false;
	private String requestRealisateurParameter = null;
	private boolean requestRealisateur = false;
	private String requestActorsParameter = null;
	private boolean requestActors = false;
	private String requestYearParameter = null;
	private boolean requestYear = false;
	
	/*
	 * Constructeur par defaut
	 */
	public FilmDataRequester(){
		filmsBySearch = null;
		filmSearchResults = null;
	}

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

		//Reinitilisation des attributs de suivi de detail
		requestTitleParameter = null;
		requestTitle = false;
		requestCountriesParameter = null;
		requestCountries = false;
		requestLanguageParameter = null;
		requestLanguage = false;
		requestRealisateurParameter = null;
		requestRealisateur = false;
		requestActorsParameter = null;
		requestActors = false;
		requestYearParameter = null;
		requestYear = false;
		
		//On reinitialise la liste des resultats de Films 
		filmsBySearch = new ArrayList<Film>();
		//On cree une chaine de requete pour aller chercher les films correspondants
		String request = "FROM Film WHERE";
		
		//------------------------------------------------
		//-------------FORMATION DE REQUETE --------------
		if(!(pTitle.isEmpty())){
			System.out.println("Titre =" + pTitle);
			requestTitleParameter = pTitle;
			requestTitle = true;
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
		if(	requestTitle || requestCountries || requestLanguage
			|| requestRealisateur || requestActors || requestYear ){
			if(requestTitle)
				request += " title = :title";
			if(requestCountries)
				request += " title = :title";
			if(requestLanguage)
				request += " title = :title";
			if(requestRealisateur)
				request += " title = :title";
			if(requestActors)
				request += " title = :title";
			if(requestYear)
				request += " title = :title";
		}
		//Query query = Main.getSessionHome().createQuery(request);
		
		//TODO: filmsBySearch contient les resultats
		//filmsBySearch = RESULTATs
		
		//FORMAT STRING pour l'affichage
		filmSearchResults = listFilmYearString(filmsBySearch);
		//On retourne cette liste de film
		return filmSearchResults;
	}
	
	private ArrayList<String> listFilmYearString(ArrayList<Film> pFilmsBySearch){
		//On instancie une nouvelle liste de resultat
		ArrayList<String> newFilmSearchResults = new ArrayList<String>();
		String filmString = "";
		
		//---------------------------------
		//----- TEST: Ajout d'un film bidon
		//TODO: Supprimer le test
		Film filmTest = new Film(	"Titre du film",//Title
									2015,			//Year
									"Francais",		//Language
									240,			//Duree
									15,				//Nb de copie
									"Resume fou!",	//Resume
									new Artist(		//Realisateur
											"Tim Burton",
											new Date(1990, 03, 20),
											"Longueuil",
											"Biographie du monsieur"));
		//Ajout de Pays bidon
		Set<Country> countries = new HashSet<Country>();
		countries.add(new Country("Canada"));
		countries.add(new Country("US"));
		filmTest.setCountries(countries);
		//Ajout de Genres bidon
		Set<Genre> genres = new HashSet<Genre>();
		genres.add(new Genre("Humour"));
		genres.add(new Genre("Horreur"));
		filmTest.setGenres(genres);
		//Ajout du Film bidon a la table des resultats de la recherche
		filmsBySearch.add(filmTest); //TO STRING CI-DESSOUS
		
		//FIN DE TEST: Ajout de films bidon
		//---------------------------------
		
		//On concatene un sommaire pour chaque films pour les presenter
		for(int i=0; i<pFilmsBySearch.size(); i++){
			filmString = "";
			filmString += filmsBySearch.get(i).getTitle().toString();
			filmString += " (";
			filmString += filmsBySearch.get(i).getYear().toString();
			filmString += ")";
			//On ajoute le String du film au tableau a retourner
			newFilmSearchResults.add(filmString);
		}
		
		return newFilmSearchResults;
	}
	
    /* ------------------------------------------------------
     *  METHODE de requete pour Obtenir les infos d'un artist
     * ------------------------------------------------------ */
	public Film getSelectedFilmInfo(int pFilmSearchResultsIndex){
		//On retourne le film en question
		return filmsBySearch.get(pFilmSearchResultsIndex);
	}

	public ArrayList<Film> getFilmsBySearch() {
		return filmsBySearch;
	}

	public void setFilmsBySearch(ArrayList<Film> filmsBySearch) {
		this.filmsBySearch = filmsBySearch;
	}
}
