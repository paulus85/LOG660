package controller;

/**
 * Sample Skeleton for 'WebFlixApp.fxml' Controller Class
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

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
    

    /* ---------------------
     *  Attributs de calcul
     * --------------------- */
	//Determine si un utilisateur est connecte
	private boolean sessionActive;
	private ArtistDataRequester aDataRequester;
	private FilmDataRequester fDataRequester;
	
    /* ----------
     *  Methodes
     * ---------- */
    /* ----- METHODES d'initialisation ---- */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sessionActive = false;
		aDataRequester = new ArtistDataRequester();
		fDataRequester = new FilmDataRequester();
	}
	/* ----------------------------------------------------------------- */
	
	
    /* ----- METHODES de boutons ---- */
    @FXML
    public void clickBtnConnexion(ActionEvent e) {
    	System.out.println("clickBtnConnexion");

    	if(usr_AdresseCourriel.getText() == "usr" && usr_MotDePasse.getText() == "password"){
    		//On remplie les listes avec des informations initiales
    		populateListFilms(fDataRequester.getFilmsBySearch());
    		populateListActeurs(aDataRequester.getActorsByFilm(null));
    		updateRealisateurBtn(aDataRequester.getRealisateurByFilm(null));
    		populateListScenariste(aDataRequester.getScenaristsByFilm(null));
    	}
    }
    @FXML
    public void clickBtnRechercher(ActionEvent e) {
    	System.out.println("clickBtnRechercher");
    }
    @FXML
    public void clickBtnRealisateur(ActionEvent e) {
    	System.out.println("clickBtnRealisateur");
    }

    /* ----- Méthodes des listes ---- */
    @FXML
    public void clickListFilms(MouseEvent e){
    	System.out.println("clickListFilm");
    	
    	String selectedFilm = list_Films.getSelectionModel().getSelectedItem();
    	System.out.println(selectedFilm);
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
    private void populateListFilms(ArrayList<String> arrayFilm){
    	list_Films.getItems().clear();
    	for(int i=0; i<arrayFilm.size(); i++){
    		list_Films.getItems().add(arrayFilm.get(i).toString());
    	}
    }

    /*
     * @param arrayActeurs Table des acteurs d'un film
     */
    private void populateListActeurs(ArrayList<String> arrayActeurs){
    	list_Acteurs.getItems().clear();    	
    	for(int i=0; i<arrayActeurs.size(); i++){
    		list_Acteurs.getItems().get(i).toString();
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
}
