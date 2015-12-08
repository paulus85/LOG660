package controller;

/**
 * Sample Skeleton for 'WebFlixApp.fxml' Controller Class
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import application.Main;
import db.ActorFilmRole;
import db.ClientUserInfo;
import db.Copy;
import db.Country;
import db.Film;
import db.Genre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class AppController implements Initializable{	
    /* ------------------
     *  Attributs JavaFx
     * ------------------ */
    /* ----- TextFields d'idenfication et de connexion ----- */
    @FXML // fx:id="usr_AdresseCourriel"
    private TextField usr_AdresseCourriel; // Value injected by FXMLLoader
    @FXML // fx:id="usr_MotDePasse"
    private TextField usr_MotDePasse; // Value injected by FXMLLoader
    @FXML // fx:id="btn_Connexion"
    private Button btn_Connexion; // Value injected by FXMLLoader
    /* ----------------------------------------------------------------- */
    
    /* ----- Liste des Films affichees pour la selection ----- */
    @FXML // fx:id="list_Films"
    private ListView<String> list_Films; // Value injected by FXMLLoader
    /* ----------------------------------------------------------------- */

    /* ----- TextFields d'information sur le Film ----- */
    @FXML // fx:id="txt_SynopsisFilm"
    private TextArea txt_SynopsisFilm; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoFilm_Titre"
    private TextField txt_InfoFilm_Titre; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoFilm_Genres"
    private TextField txt_InfoFilm_Genres; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoFilm_Pays"
    private TextField txt_InfoFilm_Pays; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoFilm_Annee"
    private TextField txt_InfoFilm_Annee; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoFilm_Duree"
    private TextField txt_InfoFilm_Duree; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoFilm_Langue"
    private TextField txt_InfoFilm_Langue; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoFilm_nbCopies"
    private TextField txt_InfoFilm_nbCopies; // Value injected by FXMLLoade
    @FXML // fx:id="txt_InfoFilm_Cote"
    private TextField txt_InfoFilm_Cote; // Value injected by FXMLLoader
    @FXML // fx:id="list_Recommandations"
    private ListView<String> list_Recommandations; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoFilm_nbCopies"
    private Button btn_Location; // Value injected by FXMLLoader
    /* ----------------------------------------------------------------- */

    /* ----- TextFields d'information sur l'Artiste ----- */
    @FXML // fx:id="txt_InfoArt_Prenom"
    private TextField txt_InfoArt_Prenom; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoArt_Nom"
    private TextField txt_InfoArt_Nom; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoArt_Date"
    private TextField txt_InfoArt_Date; // Value injected by FXMLLoader
    @FXML // fx:id="txt_InfoArt_Lieu"
    private TextField txt_InfoArt_Lieu; // Value injected by FXMLLoader
    /* ----------------------------------------------------------------- */

    /* ----- Listes et Bouton des Artistes impliques dans le Film ---- */
    @FXML // fx:id="list_Acteurs"
    private ListView<String> list_Acteurs; // Value injected by FXMLLoader    
    @FXML // fx:id="btn_Realisateur"
    private Button btn_Realisateur; // Value injected by FXMLLoader
    @FXML // fx:id="list_Scenaristes"
    private ListView<String> list_Scenaristes; // Value injected by FXMLLoader
    /* ----------------------------------------------------------------- */    

    /* ----- TextFields lies a la recherche de Film ---- */
    @FXML // fx:id="txt_Search_Titre"
    private TextField txt_Search_Titre; // Value injected by FXMLLoader
    @FXML // fx:id="txt_Search_anMin"
    private TextField txt_Search_anMin; // Value injected by FXMLLoader    
    @FXML // fx:id="txt_Search_anMax"
    private TextField txt_Search_anMax; // Value injected by FXMLLoader
    @FXML // fx:id="txt_Search_Pays"
    private TextField txt_Search_Pays; // Value injected by FXMLLoader
    @FXML // fx:id="txt_Search_Langue"
    private TextField txt_Search_Langue; // Value injected by FXMLLoader
    @FXML // fx:id="txt_Search_Genres"
    private TextField txt_Search_Genres; // Value injected by FXMLLoader
    @FXML // fx:id="txt_Search_Realisateur"
    private TextField txt_Search_Realisateur; // Value injected by FXMLLoader
    @FXML // fx:id="txt_Search_Acteurs"
    private TextField txt_Search_Acteurs; // Value injected by FXMLLoader
    /* ----------------------------------------------------------------- */
    
    /* ----- TextFields lies a l'ANALYSE des locations---- */
    @FXML // fx:id="age1820"
    private RadioButton age1820; // Value injected by FXMLLoader
    @FXML // fx:id="age2125"
    private RadioButton age2125; // Value injected by FXMLLoader
    @FXML // fx:id="age2630"
    private RadioButton age2630; // Value injected by FXMLLoader
    @FXML // fx:id="age3135"
    private RadioButton age3135; // Value injected by FXMLLoader
    @FXML // fx:id="age3640"
    private RadioButton age3640; // Value injected by FXMLLoader
    @FXML // fx:id="age4145"
    private RadioButton age4145; // Value injected by FXMLLoader
    @FXML // fx:id="age4650"
    private RadioButton age4650; // Value injected by FXMLLoader
    @FXML // fx:id="age5155"
    private RadioButton age5155; // Value injected by FXMLLoader
    @FXML // fx:id="age5660"
    private RadioButton age5660; // Value injected by FXMLLoader
    @FXML // fx:id="age6165"
    private RadioButton age6165; // Value injected by FXMLLoader
    @FXML // fx:id="age6670"
    private RadioButton age6670; // Value injected by FXMLLoader
    @FXML // fx:id="age70plus"
    private RadioButton age70plus; // Value injected by FXMLLoader    
    @FXML // fx:id="grAge"
    private ToggleGroup grAge; // Value injected by FXMLLoader   
    @FXML // fx:id="analyseProvince"
    private TextField analyseProvince; // Value injected by FXMLLoader
    @FXML // fx:id="analyseJSemaine"
    private TextField analyseJSemaine; // Value injected by FXMLLoader
    @FXML // fx:id="analyseMAnnee"
    private TextField analyseMAnnee; // Value injected by FXMLLoader
    @FXML // fx:id="analyseNbLocations"
    private TextField analyseNbLocations; // Value injected by FXMLLoader
    /* ----------------------------------------------------------------- */
    

    /* ---------------------
     *  Attributs de calcul
     * --------------------- */
	//Determine si un utilisateur est connecte
	private boolean sessionActive;
	//Les informations de l'utilisateur
	private ClientUserInfo currentUserInfo;
	
	private ArtistDataRequester aDataRequester;
	private FilmDataRequester fDataRequester;
	//private LocationAnalyser lAnalyser;
	private Film currentFilm;
	
    /* ----------
     *  Methodes
     * ---------- */
    /* ----- METHODES d'initialisation ---- */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//TODO: Mettre a false pour demander une connexion
		sessionActive = false;
		currentUserInfo = null;

		aDataRequester = new ArtistDataRequester();
		fDataRequester = new FilmDataRequester();
		
		//On initialise la liste de film pour pouvoir être interagit
		list_Films.getItems().clear();
		list_Films.getItems().add("");
		list_Films.getItems().add("");
		list_Films.getItems().add("");
		list_Films.getItems().add("");
		list_Films.getItems().add("");
		list_Films.getItems().add("");
		list_Films.getItems().add("");
		list_Films.getItems().add("");
	}
	/* ----------------------------------------------------------------- */
	
	
    /* ----- METHODES de boutons ---- */
    @FXML
    public void clickBtnConnexion(ActionEvent e) {
    	System.out.println("clickBtnConnexion");
    	System.out.println("usr_AdresseCourriel.getText() =" + usr_AdresseCourriel.getText());
    	System.out.println("usr_MotDePasse.getText() =" + usr_MotDePasse.getText());
    	
    	if(!sessionActive){
    		//On cree une requete pour verifie si l'authentification est valide
    		String q = ("FROM Utilisateur U WHERE U.email = :mail AND U.password = :password");
    		Query query = Main.getSessionHome().createQuery(q);
    		query.setParameter("mail",usr_AdresseCourriel.getText());
    		query.setParameter("password",usr_MotDePasse.getText());
    		List authUser = query.list(); 
    		
    		if(authUser.size() != 0){
        		System.out.println("User and Password match");
        		btn_Connexion.setText("Déconnexion");
        		sessionActive = true;
        		
        		currentUserInfo = (ClientUserInfo)authUser.get(0);

        		list_Films.getItems().clear();
        		list_Films.getItems().add("Bienvenu " + currentUserInfo.getFirstName());
        		fDataRequester.loadFilms();
        		
        	}else{
        		list_Films.getItems().clear();
        		list_Films.getItems().add("La combinaison d'adresse courriel et mot de passe de passe ");
            	list_Films.getItems().add("utilisateur n'est pas valide.");
            	list_Films.getItems().add("Veuillez vérifier la saisie effectuée dans chacun des champs");
            	list_Films.getItems().add("sujets et réessayer. Merci de votre coopération.");
        	}
    	}else{
    		sessionActive = false;
    		currentUserInfo = null;
    		usr_AdresseCourriel.setText("");
    		usr_MotDePasse.setText("");
    		list_Films.getItems().clear();
    		btn_Connexion.setText("Connexion");
    	}
    }
    @FXML
    public void clickBtnRechercher(ActionEvent e) {
    	System.out.println("clickBtnRechercher");
    	
    	if(!sessionActive){
        	list_Films.getItems().clear();
    		list_Films.getItems().add("Veuiller vous connecter au système en vous authentifiant");
    		list_Films.getItems().add("grâce à une combinaison d'un courriel et d'un mot de passe");
    		list_Films.getItems().add("enregistrée à un forfait offert par les services WebFlix");
    		list_Films.getItems().add("afin de pouvoir consulter notre catalogue de film.");
    	}else{
	    	Integer minYear = null;
	    	Integer maxYear = null;
	    	//On traite le cas ou les annees entrees ne seraient pas un nombre
	    	if(!(txt_Search_anMin.getText().isEmpty())){
	    		try{
	    			minYear = Integer.parseInt(txt_Search_anMin.getText());
	    		}catch(NumberFormatException e1){
	    			System.out.println("txt_Search_anMin is NAN");
	    		}
	    	}if(!(txt_Search_anMax.getText().isEmpty())){
	    		try{
	    			maxYear = Integer.parseInt(txt_Search_anMax.getText());
	    		}catch(NumberFormatException e1){
	    			System.out.println("txt_Search_anMax is NAN");
	    		}
	    	}
	    	
	    	//On execute la requete afin de remplir le tableau des films
	    	populateListFilms(fDataRequester.getFilmsBySearch(	txt_Search_Titre.getText(),
																minYear,
																maxYear,
																txt_Search_Pays.getText(),
																txt_Search_Langue.getText(),
																txt_Search_Genres.getText(),
																txt_Search_Realisateur.getText(),
																txt_Search_Acteurs.getText()));
    	}
    }

    @FXML
    public void clickBtnAnalyser(ActionEvent e) {

		System.out.println(analyseProvince.getText());
		analyseNbLocations.setText(analyseProvince.getText());
    	
    	if(!sessionActive){
        	list_Films.getItems().clear();
    		list_Films.getItems().add("Veuiller vous connecter au système en vous authentifiant");
    		list_Films.getItems().add("grâce à une combinaison d'un courriel et d'un mot de passe");
    		list_Films.getItems().add("enregistrée à un forfait offert par les services WebFlix");
    		list_Films.getItems().add("afin de pouvoir consulter notre catalogue de film.");
    	}else{
    		//On demande a compter le nombre de locations qualifiees
    		int nbLocations = fDataRequester.countAnalyseLocations(	
    												grAge.getSelectedToggle().toString(),
    												analyseProvince.getText(),
    												analyseJSemaine.getText(),
    												analyseMAnnee.getText());
    		
    		analyseNbLocations.setText( "" + nbLocations);
    	}
    }
    
    
    @FXML
    public void clickBtnRealisateur(ActionEvent e) {
    	System.out.println("clickBtnRealisateur");
    }
    
    @FXML
    public void clickBtnLocation(ActionEvent e) {
    	System.out.println("clickBtnLocation");
    	Transaction tr = Main.getSessionHome().beginTransaction();
    	String q = ("SELECT COUNT(*) FROM Copy C WHERE C.userId = :userid");
    	SQLQuery query = Main.getSessionHome().createSQLQuery(q);
    	query.setParameter("userid", currentUserInfo.getUserId());
    	List result = query.list();
    	int nbFilmLoue = Integer.valueOf(result.get(0).toString());
    	
    	int nbFilmPossible = currentUserInfo.getPlan().getMaxLocation();
    	
    	q = ("SELECT COUNT(*) FROM Copy C WHERE C.filmId = :filmid AND C.userId IS NOT NULL");
    	query = Main.getSessionHome().createSQLQuery(q);
    	query.setParameter("filmid", currentFilm.getFilmId());
    	result = query.list();
    	Integer nbCopyLoue = Integer.valueOf(result.get(0).toString());
    	System.out.println("Copy louée" + nbCopyLoue);
    	
    	if (nbFilmLoue<nbFilmPossible && nbCopyLoue<currentFilm.getOriginalCopyNumber()){
        	System.out.println(nbCopyLoue-currentFilm.getOriginalCopyNumber());

//    		String hql = "UPDATE Copy set userId = :userid "  + 
//    	             "WHERE filmId = :filmid AND userId = null";
//    		Query qu = Main.getSessionHome().createSQLQuery(hql);
//    		qu.setParameter("userid", currentUserInfo.getUserId());
//    		qu.setParameter("filmid", currentFilm.getFilmId());
//    		int result1 = query.executeUpdate();
//    		System.out.println("Rows affected: " + result);
        	
        	String queryString = "FROM Copy C where C.userId=null and C.filmId=:filmid";
        	Query query3 = Main.getSessionHome().createQuery(queryString);
        	query3.setInteger("filmid",currentFilm.getFilmId());
        	Copy copy = (Copy)query3.list().get(0);
        	
        	copy.setUserId(currentUserInfo.getUserId());
        	copy.setRented(true);
        	Main.getSessionHome().update(copy);
        	
        	tr.commit();
        	
        	tr = Main.getSessionHome().beginTransaction();
        	q = ("SELECT COUNT(*) FROM Copy C WHERE C.filmId = :filmid AND C.userId IS NULL");
        	query = Main.getSessionHome().createSQLQuery(q);
        	query.setParameter("filmid", currentFilm.getFilmId());
        	result = query.list();
        	Integer nbCopyDispo = Integer.valueOf(result.get(0).toString());
        	
            txt_InfoFilm_nbCopies.setText(nbCopyDispo.toString());
            tr.commit();
    	}
    	
    	
    	
    	
    	
    }
    

    /* ----- Méthodes des listes ---- */
    @FXML
    public void clickListFilms(MouseEvent e){
    	System.out.println("clickListFilm");
		//Obtention de l'objet Film
		int selectedFilmIndex = list_Films.getSelectionModel().getSelectedIndex();
		if(fDataRequester.getFilmsBySearch() == null && sessionActive){
        	list_Films.getItems().clear();
    		list_Films.getItems().add("Veuiller effectuer une recherche afin d'avoir un");
    		list_Films.getItems().add("éventail de sélection de film à consulter.");
		}else{
			Film selectedFilm = fDataRequester.getSelectedFilmInfo(selectedFilmIndex);
			
			//Assignation des informations du film aux champs
			populateFilmInformations(selectedFilm, fDataRequester.getMoyenneCote(selectedFilm.getFilmId()));
			
			//populateListActeurs(aDataRequester.getActorsByFilm(selectedFilmIndex));
			//updateRealisateurBtn(aDataRequester.getRealisateurByFilm(selectedFilmIndex));
			//populateListScenariste(aDataRequester.getScenaristsByFilm(selectedFilmIndex));
			
			populateListRecommandations(fDataRequester.getRecommendations(selectedFilm.getFilmId(), currentUserInfo.getUserId()));
			
			System.out.println(selectedFilmIndex);
		}
    }
    @FXML
    public void clickListActeurs(MouseEvent e){
    	System.out.println("clickListActeurs");
    	
    	//Enregistrement de la valeur selectionnee dans le dataRequester
    	String selectedActeur = list_Acteurs.getSelectionModel().getSelectedItem();	
    	System.out.println("Les informations de " + selectedActeur + " sont recherchees..."); 
    	//On passe une requete a ActorDataRequester
    	//Artist currentActor = artistDataRequester
    	//txt_InfoArt_Prenom.setText(value);
    	
    	System.out.println("Les informations de " + selectedActeur + " sont presentemment affichees!");
    }

    /*
     * @param arrayFilm Table des film d'un resultat de recherche
     */
    private void populateListFilms(List<Film> films){
    	list_Films.getItems().clear();
    	for(int i=0; i<films.size(); i++){
    		list_Films.getItems().add(films.get(i).getTitle() + "\t" + films.get(i).getYear());
    	}
    }
    /*
     * On popule les champs texte de la fiche d'information du Film selectionne
     * @param pSelectedFilm Film dont les informations sont demandees
     */
    private void populateFilmInformations(Film pSelectedFilm, String pSelectedFilmCote){
    	currentFilm = pSelectedFilm;
        txt_SynopsisFilm.setText(pSelectedFilm.getSummary());
        txt_InfoFilm_Titre.setText(pSelectedFilm.getTitle());
        txt_InfoFilm_Annee.setText(pSelectedFilm.getYear().toString());
        txt_InfoFilm_Duree.setText(pSelectedFilm.getDuration().toString());
        txt_InfoFilm_Langue.setText(pSelectedFilm.getLanguage());
        
        
        String q = ("SELECT COUNT(*) FROM Copy C WHERE C.filmId = :filmid AND C.userId IS NULL");
    	SQLQuery query = Main.getSessionHome().createSQLQuery(q);
    	query.setParameter("filmid", currentFilm.getFilmId());
    	List result = query.list();
    	Integer nbCopyDispo = Integer.valueOf(result.get(0).toString());
    	
        txt_InfoFilm_nbCopies.setText(nbCopyDispo.toString());
        //Iteration des genres
        String genres = "";
        Iterator<Genre> genreIt = pSelectedFilm.getGenres().iterator();
        while(genreIt.hasNext()){
        	genres += genreIt.next().getGenreName();
        	genreIt.remove();
            if(genreIt.hasNext()){
                genres += ", ";
            }
        }
        txt_InfoFilm_Genres.setText(genres);
        //Iteration des pays
        String countries = "";
        Iterator<Country> countryIt = pSelectedFilm.getCountries().iterator();
        while(countryIt.hasNext()){
        	countries += countryIt.next().getCountryName();
        	countryIt.remove();
            if(countryIt.hasNext()){
                countries += ", ";
            }
        }
        
        txt_InfoFilm_Pays.setText(countries);
        txt_InfoFilm_Cote.setText(pSelectedFilmCote);
        
        
        //TODO: populateListActeurs
        populateListActeurs(pSelectedFilm.getActorFilmRoles());
        btn_Realisateur.setText(pSelectedFilm.getDirector().getName().toString());
        //aDataRequester.getActorsByFilm(pSelectedFilm.getFilmId());
    }

    /*
     * @param arrayActeurs Table des acteurs d'un film
     */
    private void populateListActeurs(Set<ActorFilmRole> pSetActorFilmRole){
    	//On vide les entrees de la liste
    	list_Acteurs.getItems().clear();
    	//On va chercher tous les acteurs ainsi que leur role
    	String currentActorRoleString = "";
    	Iterator<ActorFilmRole> actorsRoleIt = pSetActorFilmRole.iterator();
    	//On parcours 
    	while(actorsRoleIt.hasNext()){
    		ActorFilmRole afr = actorsRoleIt.next();
    		currentActorRoleString = "";
    		currentActorRoleString +=  afr.getArtist().getName().toString();
    		currentActorRoleString +=  " (";
    		currentActorRoleString +=  afr.getCharacterName().toString();
    		currentActorRoleString +=  ")";
    		actorsRoleIt.remove();
    		list_Acteurs.getItems().add(currentActorRoleString);
    	}
    }
    
    private void updateRealisateurBtn(String realisateurName){
    	btn_Realisateur.setText(realisateurName);
    }
    	
    /*
     * @param arrayScenaristes Table des scenaristes d'un film
     */
    private void populateListScenariste(ArrayList<String> arrayScenaristes){
    	list_Scenaristes.getItems().clear();
    	
    	for(int i=0; i<arrayScenaristes.size(); i++){
    		list_Scenaristes.getItems().add(arrayScenaristes.get(i).toString());
    	}
    }

    /*
     * @param arrayRecommandations Table des films recommandés pour un film
     */
    private void populateListRecommandations(ArrayList<String> arrayRecommandations){
    	list_Recommandations.getItems().clear();
    	
    	for(int i=0; i<arrayRecommandations.size(); i++){
    		list_Recommandations.getItems().add(arrayRecommandations.get(i).toString());
    	}
    }
}
