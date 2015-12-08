package controller;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import application.Main;
import db.ActorFilmRole;
import db.Artist;
import db.Country;
import db.Film;
import db.Genre;
import db.Moyenne;

public class FilmDataRequester {
    /* ---------------------
     *  Attributs de calcul
     * --------------------- */
	//La liste d'objet Film resultant de la requete
	public ArrayList<Film> filmsBySearch;
	//La liste de String affichee dans listFilm soit: titre du film (annee)
	public List<Film> filmSearchResults;
	
	//Liste de film de la base de donnée
	public List<Film> films;
	 
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
	private Integer requestMinYearParameter = null;
	private boolean requestMinYear = false;
	private Integer requestMaxYearParameter = null;
	private boolean requestMaxYear = false;
	private boolean requestMinMaxYear = false;
	
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
	//Chargement des films de la base de donnée
	public void loadFilms (){
		String request = "FROM Film";
		Query query = Main.getSessionHome().createQuery(request);
		films = query.list();
	}
	
	/*
	 * @param filmTitle Nom du film selectionne
	 * @return Le nom des acteurs qui ont joue dans le film
	 */
	
	public List<Film> getFilmsBySearch(String pTitle,
												Integer pMinYear,
												Integer pMaxYear,
												String pCountry,
												String pLanguage,
												String pGenre,
												String pRealisateur,
												String pActor){

		//Reinitilisation des attributs de suivi de detail
		boolean isFirstArg = true;
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
		requestMinYearParameter = null;
		requestMinYear = false;
		requestMaxYear = false;
		requestMaxYearParameter = null;
		requestMinMaxYear = false;
		
		//On reinitialise la liste des resultats de Films 
		filmsBySearch = new ArrayList<Film>();
		
		List<Film> resultfilms = new ArrayList<Film>(films);
		//------------------------------------------------
		//-------------FORMATION DE REQUETE --------------
		if(!(pTitle.isEmpty())){
			for (Iterator<Film> iterator = resultfilms.iterator(); iterator.hasNext();){
				Film film = (Film) iterator.next(); 
				if (!film.getTitle().toLowerCase().contains(pTitle.toLowerCase())){
					iterator.remove();
				}
			}
		}
		if(!(pCountry.isEmpty())){
			
			for (Iterator<Film> iterator = resultfilms.iterator(); iterator.hasNext();){
				Film film = (Film) iterator.next();
				boolean in = false;
				if(film.getCountries().size()>0){
					for (Country c : film.getCountries()){
						if(c.getCountryName().equalsIgnoreCase(pCountry)){
							in = true;
						}
					}
				}
				if (!in){
					iterator.remove();
				}
			}
			
		}
		if(!(pLanguage.isEmpty())){
			
			for (Iterator<Film> iterator = resultfilms.iterator(); iterator.hasNext();){
				Film film = (Film) iterator.next(); 
				if (!film.getLanguage().toLowerCase().contains(pLanguage.toLowerCase())){
					iterator.remove();
				}
			}
			
		}
		if(!(pGenre.isEmpty())){
			for (Iterator<Film> iterator = resultfilms.iterator(); iterator.hasNext();){
				Film film = (Film) iterator.next();
				boolean in = false;
				if(film.getGenres().size()>0){
					for (Genre g : film.getGenres()){
						if(g.getGenreName().equalsIgnoreCase(pGenre)){
							in = true;
						}
					}
				}
				if (!in){
					iterator.remove();
				}
			}
		}
		
		if(!(pRealisateur.isEmpty())){
			for (Iterator<Film> iterator = resultfilms.iterator(); iterator.hasNext();){
				Film film = (Film) iterator.next(); 
				if (!film.getDirector().getName().toLowerCase().contains(pRealisateur.toLowerCase())){
					iterator.remove();
				}
			}
		}
		if(!(pActor.isEmpty())){
			for (Iterator<Film> iterator = resultfilms.iterator(); iterator.hasNext();){
				Film film = (Film) iterator.next();
				boolean in = false;
				if(film.getActorFilmRoles().size()>0){
					for (ActorFilmRole ac : film.getActorFilmRoles()){
						if(ac.getArtist().getName().toLowerCase().contains(pActor.toLowerCase())){
							in = true;
						}
					}
				}
				if (!in){
					iterator.remove();
				}
			}
		}
		
		if(pMinYear != null){
			for (Iterator<Film> iterator = resultfilms.iterator(); iterator.hasNext();){
				Film film = (Film) iterator.next(); 
				if (film.getYear() < pMinYear){
					iterator.remove();
				}
			}
		}
		
		if(pMaxYear != null){
			for (Iterator<Film> iterator = resultfilms.iterator(); iterator.hasNext();){
				Film film = (Film) iterator.next(); 
				if (film.getYear() > pMaxYear){
					iterator.remove();
				}
			}
		}
		
		filmSearchResults = resultfilms;
		
		return resultfilms;
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
		return filmSearchResults.get(pFilmSearchResultsIndex);
	}

	public ArrayList<Film> getFilmsBySearch() {
		return filmsBySearch;
	}

	public void setFilmsBySearch(ArrayList<Film> filmsBySearch) {
		this.filmsBySearch = filmsBySearch;
	}
	
	/* ------------------------------------------------------
     *  METHODES POUR LES COTES ET RECOMMENDATIONS
     * ------------------------------------------------------ */
	
	public String getMoyenneCote(Integer filmid) {
		Moyenne m = (Moyenne) Main.getSessionHome().get(Moyenne.class, filmid);
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		return df.format((m.getMoyenne()).doubleValue());
	}
	
	public ArrayList<String> getRecommendations(Integer filmid, Integer clientid){
		Connection c;
		try {
			c = connectionBD();
			c.setAutoCommit(true);
			ArrayList<String> res = new ArrayList<String>();
		
			String sql = "select TITLE from VUE_CORRELATION v, FILM f where v.FILM1 =? and v.FILM2 = f.FILMID and not EXISTS (select 1 from copy where copy.USERID =? and copy.FILMID=v.FILM2) order by CORRELATION desc fetch first 3 rows only";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setInt(1, filmid);
			stm.setInt(2, clientid);
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String filmName = rs.getString(1);
				res.add(filmName);
			}
			
			c.close();
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	public int countAnalyseLocations(String pGrAge, String pProvince, String pJSemaine, String pMAnnee){
		//On cree la requete avant de se connecter
		// TODO : Paul, effectuer la requete SQL dans la BD pour retrouver le nombre de locations
		String sql = "SELECT COUNT(*) FROM FaitLocation";
		
		if(!(pGrAge.isEmpty() || pProvince.isEmpty() || pJSemaine.isEmpty() || pMAnnee.isEmpty())){
			sql += " WHERE ";
		}
		if(!(pGrAge.isEmpty())){
			
		}
		if(!(pProvince.isEmpty())){
			
		}
		if(!(pJSemaine.isEmpty())){
			
		}
		if(!(pMAnnee.isEmpty())){
			sql += " ";
		}
				
		//On commence la connexion
		Connection c;
		try {
			c = connectionBD();
			c.setAutoCommit(true);
			
			//CE QUE TU AVAIS FAIT POUR GETRECOMMANDATIONS		
			String sql = "select TITLE from VUE_CORRELATION v, FILM f where v.FILM1 =? and v.FILM2 = f.FILMID and not EXISTS (select 1 from copy where copy.USERID =? and copy.FILMID=v.FILM2) order by CORRELATION desc fetch first 3 rows only";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setInt(1, filmid);
			stm.setInt(2, clientid);
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String filmName = rs.getString(1);
				res.add(filmName);
			}
			
			c.close();
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0;
	}
	
	/* ------------------------------------------------------
     *  METHODES AUXILIAIRES
     * ------------------------------------------------------ */
	
	private Connection connectionBD(){
		Connection connection;
	      // On se connecte a la BD
		   try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur : classe de connexion introuvable.");
			e.printStackTrace();
			
		}
		   System.out.println("Connection...");
		   connection = null;
		   try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@big-data-3.logti.etsmtl.ca:1521:LOG660","equipe33","wCZYBvQ1" );
		} catch (SQLException e) {
			System.out.println("Erreur dans la connection à la base");
			e.printStackTrace();
		}
		   
		   if(connection == null) {
			   System.out.println("Erreur de connection à la base");
		   } else {
			   System.out.println("Connecté à la base !");
		   }
		   return connection;
	   }
	
	
	
	
	
	
}
