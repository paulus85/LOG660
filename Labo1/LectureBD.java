import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * Classe de communication et d'ajout des données -- LOG660
 * @author Paul Riviere, Thomas Blondet, Christian Cardin
 * 
 */
public class LectureBD {   
   public class Role {
      public Role(int i, String n, String p) {
         id = i;
         nom = n;
         personnage = p;
      }
      protected int id;
      protected String nom;
      protected String personnage;
   }
   
   /**
 * Objet de connection à la BD
 */
private static Connection connection;

// Variables de comptage 
private int nbFilm, nbPersonnes, nbClient;
   
   public LectureBD() {
      connectionBD();                     
   }
   
   
   public void lecturePersonnes(String nomFichier) throws SQLException{      
      try {
         XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
         XmlPullParser parser = factory.newPullParser();

         InputStream is = new FileInputStream(nomFichier);
         parser.setInput(is, null);

         int eventType = parser.getEventType();

         String tag = null, 
                nom = null,
                anniversaire = null,
                lieu = null,
                photo = null,
                bio = null;
         
         int id = -1;
         
         while (eventType != XmlPullParser.END_DOCUMENT) 
         {
            if(eventType == XmlPullParser.START_TAG) 
            {
               tag = parser.getName();
               
               if (tag.equals("personne") && parser.getAttributeCount() == 1)
                  id = Integer.parseInt(parser.getAttributeValue(0));
            } 
            else if (eventType == XmlPullParser.END_TAG) 
            {        
               tag = null;
               
               if (parser.getName().equals("personne") && id >= 0)
               {
                  insertionPersonne(id,nom,anniversaire,lieu,photo,bio);
                                    
                  id = -1;
                  nom = null;
                  anniversaire = null;
                  lieu = null;
                  photo = null;
                  bio = null;
               }
            }
            else if (eventType == XmlPullParser.TEXT && id >= 0) 
            {
               if (tag != null)
               {                                    
                  if (tag.equals("nom"))
                     nom = parser.getText();
                  else if (tag.equals("anniversaire"))
                     anniversaire = parser.getText();
                  else if (tag.equals("lieu"))
                     lieu = parser.getText();
                  else if (tag.equals("photo"))
                     photo = parser.getText();
                  else if (tag.equals("bio"))
                     bio = parser.getText();
               }              
            }
            
            eventType = parser.next();            
         }
      }
      catch (XmlPullParserException e) {
          System.out.println(e);   
       }
       catch (IOException e) {
         System.out.println("IOException while parsing " + nomFichier); 
       }
   }   
   
   public void lectureFilms(String nomFichier){
      try {
         XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
         XmlPullParser parser = factory.newPullParser();

         InputStream is = new FileInputStream(nomFichier);
         parser.setInput(is, null);

         int eventType = parser.getEventType();

         String tag = null, 
                titre = null,
                langue = null,
                poster = null,
                roleNom = null,
                rolePersonnage = null,
                realisateurNom = null,
                resume = null;
         
         ArrayList<String> pays = new ArrayList<String>();
         ArrayList<String> genres = new ArrayList<String>();
         ArrayList<String> scenaristes = new ArrayList<String>();
         ArrayList<Role> roles = new ArrayList<Role>();         
         ArrayList<String> annonces = new ArrayList<String>();
         
         int id = -1,
             annee = -1,
             duree = -1,
             roleId = -1,
             realisateurId = -1;
         
         while (eventType != XmlPullParser.END_DOCUMENT) 
         {
            if(eventType == XmlPullParser.START_TAG) 
            {
               tag = parser.getName();
               
               if (tag.equals("film") && parser.getAttributeCount() == 1)
                  id = Integer.parseInt(parser.getAttributeValue(0));
               else if (tag.equals("realisateur") && parser.getAttributeCount() == 1)
                  realisateurId = Integer.parseInt(parser.getAttributeValue(0));
               else if (tag.equals("acteur") && parser.getAttributeCount() == 1)
                  roleId = Integer.parseInt(parser.getAttributeValue(0));
            } 
            else if (eventType == XmlPullParser.END_TAG) 
            {                              
               tag = null;
               
               if (parser.getName().equals("film") && id >= 0)
               {
                  try {
					insertionFilm(id,titre,annee,pays,langue,
					             duree,resume,genres,realisateurNom,
					             realisateurId, scenaristes,
					             roles,poster,annonces);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                                    
                  id = -1;
                  annee = -1;
                  duree = -1;
                  titre = null;                                 
                  langue = null;                  
                  poster = null;
                  resume = null;
                  realisateurNom = null;
                  roleNom = null;
                  rolePersonnage = null;
                  realisateurId = -1;
                  roleId = -1;
                  
                  genres.clear();
                  scenaristes.clear();
                  roles.clear();
                  annonces.clear();  
                  pays.clear();
               }
               if (parser.getName().equals("role") && roleId >= 0) 
               {              
                  roles.add(new Role(roleId, roleNom, rolePersonnage));
                  roleId = -1;
                  roleNom = null;
                  rolePersonnage = null;
               }
            }
            else if (eventType == XmlPullParser.TEXT && id >= 0) 
            {
               if (tag != null)
               {                                    
                  if (tag.equals("titre"))
                     titre = parser.getText();
                  else if (tag.equals("annee"))
                     annee = Integer.parseInt(parser.getText());
                  else if (tag.equals("pays"))
                     pays.add(parser.getText());
                  else if (tag.equals("langue"))
                     langue = parser.getText();
                  else if (tag.equals("duree"))                 
                     duree = Integer.parseInt(parser.getText());
                  else if (tag.equals("resume"))                 
                     resume = parser.getText();
                  else if (tag.equals("genre"))
                     genres.add(parser.getText());
                  else if (tag.equals("realisateur"))
                     realisateurNom = parser.getText();
                  else if (tag.equals("scenariste"))
                     scenaristes.add(parser.getText());
                  else if (tag.equals("acteur"))
                     roleNom = parser.getText();
                  else if (tag.equals("personnage"))
                     rolePersonnage = parser.getText();
                  else if (tag.equals("poster"))
                     poster = parser.getText();
                  else if (tag.equals("annonce"))
                     annonces.add(parser.getText());                  
               }              
            }
            
            eventType = parser.next();            
         }
      }
      catch (XmlPullParserException e) {
          System.out.println(e);   
      }
      catch (IOException e) {
         System.out.println("IOException while parsing " + nomFichier); 
      }
   }
   
   public void lectureClients(String nomFichier){
      try {
         XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
         XmlPullParser parser = factory.newPullParser();

         InputStream is = new FileInputStream(nomFichier);
         parser.setInput(is, null);

         int eventType = parser.getEventType();               

         String tag = null, 
                nomFamille = null,
                prenom = null,
                courriel = null,
                tel = null,
                anniv = null,
                adresse = null,
                ville = null,
                province = null,
                codePostal = null,
                carte = null,
                noCarte = null,
                motDePasse = null,
                forfait = null;                                 
         
         int id = -1,
             expMois = -1,
             expAnnee = -1;
         
         while (eventType != XmlPullParser.END_DOCUMENT) 
         {
            if(eventType == XmlPullParser.START_TAG) 
            {
               tag = parser.getName();
               
               if (tag.equals("client") && parser.getAttributeCount() == 1)
                  id = Integer.parseInt(parser.getAttributeValue(0));
            } 
            else if (eventType == XmlPullParser.END_TAG) 
            {                              
               tag = null;
               
               if (parser.getName().equals("client") && id >= 0)
               {
                  try {
					insertionClient(id,nomFamille,prenom,courriel,tel,
					             anniv,adresse,ville,province,
					             codePostal,carte,noCarte, 
					             expMois,expAnnee,motDePasse,forfait);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}               
                                    
                  nomFamille = null;
                  prenom = null;
                  courriel = null;               
                  tel = null;
                  anniv = null;
                  adresse = null;
                  ville = null;
                  province = null;
                  codePostal = null;
                  carte = null;
                  noCarte = null;
                  motDePasse = null; 
                  forfait = null;
                  
                  id = -1;
                  expMois = -1;
                  expAnnee = -1;
               }
            }
            else if (eventType == XmlPullParser.TEXT && id >= 0) 
            {         
               if (tag != null)
               {                                    
                  if (tag.equals("nom-famille"))
                     nomFamille = parser.getText();
                  else if (tag.equals("prenom"))
                     prenom = parser.getText();
                  else if (tag.equals("courriel"))
                     courriel = parser.getText();
                  else if (tag.equals("tel"))
                     tel = parser.getText();
                  else if (tag.equals("anniversaire"))
                     anniv = parser.getText();
                  else if (tag.equals("adresse"))
                     adresse = parser.getText();
                  else if (tag.equals("ville"))
                     ville = parser.getText();
                  else if (tag.equals("province"))
                     province = parser.getText();
                  else if (tag.equals("code-postal"))
                     codePostal = parser.getText();
                  else if (tag.equals("carte"))
                     carte = parser.getText();
                  else if (tag.equals("no"))
                     noCarte = parser.getText();
                  else if (tag.equals("exp-mois"))                 
                     expMois = Integer.parseInt(parser.getText());
                  else if (tag.equals("exp-annee"))                 
                     expAnnee = Integer.parseInt(parser.getText());
                  else if (tag.equals("mot-de-passe"))                 
                     motDePasse = parser.getText();  
                  else if (tag.equals("forfait"))                 
                     forfait = parser.getText(); 
               }              
            }
            
            eventType = parser.next();            
         }
      }
      catch (XmlPullParserException e) {
          System.out.println(e);   
      }
      catch (IOException e) {
         System.out.println("IOException while parsing " + nomFichier); 
      }
   }   
   
   private void insertionPersonne(int id, String nom, String anniv, String lieu, String photo, String bio) throws SQLException { 
	   CallableStatement statement = connection.prepareCall("{ ? = call AddArtistFunc(?,?,?,?)");
	   statement.setString(2, nom);
	   statement.setString(4,lieu);
	   
	   if(bio != null && bio.length() >= 3000) {
		   bio = bio.substring(0, 2999);
	   }
	   statement.setString(5, bio);
	   
	   if (anniv != null) {
		   statement.setDate(3, Date.valueOf(anniv));
	   } else {
		   statement.setDate(3, null);
	   }
	   statement.registerOutParameter(1, java.sql.Types.INTEGER);
	   //Execution de la requête
	   System.out.println("Id " + id);
	   statement.execute();
	   statement.close();
	  
   }
   
   private void insertionFilm(int id, String titre, int annee,
                           ArrayList<String> pays, String langue, int duree, String resume,
                           ArrayList<String> genres, String realisateurNom, int realisateurId,
                           ArrayList<String> scenaristes,
                           ArrayList<Role> roles, String poster,
                           ArrayList<String> annonces) throws SQLException {
	   
	   ArrayList<Integer> paysId = new ArrayList<Integer>(pays.size());
	   ArrayList<Integer> genreId = new ArrayList<Integer>(genres.size());
	   ArrayList<Integer> scenaristId = new ArrayList<Integer>(scenaristes.size());
	   int filmid;
	   
	   
	   for(String pay : pays) {
		   CallableStatement statementPays = connection.prepareCall("{ ? = call AddCountryFunc(?)");
		   statementPays.setString(2, pay);
		   statementPays.registerOutParameter(1, java.sql.Types.INTEGER);
		   statementPays.execute();
		   paysId.add(statementPays.getInt(1));
		   statementPays.close();
	   }
	   
	   for(String genre : genres) {
		   CallableStatement statementGenre = connection.prepareCall("{ ? = call AddGenreFunc(?)");
		   statementGenre.setString(2, genre);
		   statementGenre.registerOutParameter(1, java.sql.Types.INTEGER);
		   statementGenre.execute();
		   genreId.add(statementGenre.getInt(1));
		   statementGenre.close();
	   }
	   
	   for(String scen : scenaristes) {
		   CallableStatement statementScen = connection.prepareCall("{ ? = call AddScenaristFunc(?)");
		   statementScen.setString(2, scen);
		   statementScen.registerOutParameter(1, java.sql.Types.INTEGER);
		   statementScen.execute();
		   scenaristId.add(statementScen.getInt(1));
		   statementScen.close();
	   }
	   //System.out.println("Taille : " + scenaristes.size());
	   
	   
	   
	   CallableStatement statementFilm = connection.prepareCall("{ ? = call AddFilmFunc(?,?,?,?,?,?,?)");
	   statementFilm.setString(2, titre);
	   statementFilm.setInt(3, annee);
	   statementFilm.setString(4, langue);
	   statementFilm.setInt(5, duree);
	   statementFilm.setInt(6, 0);
	   statementFilm.setString(7, resume);
	   statementFilm.setString(8, realisateurNom);
	   statementFilm.registerOutParameter(1, java.sql.Types.INTEGER);
	   try {
		statementFilm.execute();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println("FilmId : " + id + " Real : "+realisateurNom);
		e1.printStackTrace();
	}
	   filmid = statementFilm.getInt(1);
	   statementFilm.close();
	   
	   //Association Film role
	   for(Role role : roles) {
		   //System.out.println("Adding relation");
		   CallableStatement statementRole = connection.prepareCall("{call AddActorRoleFunc(?,?,?)");
		   statementRole.setString(1, role.nom);
		   statementRole.setInt(2, filmid);
		   statementRole.setString(3,role.personnage);
		   try{
			   statementRole.execute(); 
		   }
		   catch (SQLException e) {
			   System.out.println(e.getMessage() + "Nom personnage : " + role.personnage);
			   e.printStackTrace();
		   } finally{
			   statementRole.close();
		   }
	   }
	   //System.out.println("Fini relation");
	   
	   for(int scenaristIdInd : scenaristId){
		   PreparedStatement statementAssoScenarist = connection.prepareStatement("INSERT INTO FilmScenarist VALUES(?,?)");
		   statementAssoScenarist.setInt(1, scenaristIdInd);
		   statementAssoScenarist.setInt(2, filmid);
		   statementAssoScenarist.execute(); 
		   statementAssoScenarist.close();
	   }
	   
	   for(int genreIdInd : genreId){
		   PreparedStatement statementAssoGenre = connection.prepareStatement("INSERT INTO FilmGenre VALUES(?,?)");
		   statementAssoGenre.setInt(1, genreIdInd);
		   statementAssoGenre.setInt(2, filmid);
		   statementAssoGenre.execute(); 
		   statementAssoGenre.close();
	   }
	   
	   for(int paysIdInd : paysId){
		   PreparedStatement statementAssoPays = connection.prepareStatement("INSERT INTO FilmCountry VALUES(?,?)");
		   statementAssoPays.setInt(1, paysIdInd);
		   statementAssoPays.setInt(2, filmid);
		   statementAssoPays.execute(); 
		   statementAssoPays.close();
	   }
	   
	   
	   

	   

   }
   
   private void insertionClient(int id, String nomFamille, String prenom,
                             String courriel, String tel, String anniv,
                             String adresse, String ville, String province,
                             String codePostal, String carte, String noCarte,
                             int expMois, int expAnnee, String motDePasse,
                             String forfait) throws SQLException {
	   
	   CallableStatement statement = connection.prepareCall("{call AddUserProc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	   statement.setString(1, nomFamille);
	   statement.setString(2, prenom);
	   statement.setString(3, tel);
	   statement.setDate(4, Date.valueOf(anniv));
	   statement.setString(5, courriel);
	   statement.setString(6, motDePasse);
	   statement.setString(7, adresse);
	   statement.setString(8, ville);
	   statement.setString(9, province);
	   statement.setString(10, codePostal);
	   statement.setString(11, forfait);
	   System.out.println(forfait);
	   statement.setString(12, noCarte);
	   statement.setInt(13,expMois);
	   statement.setInt(14,expAnnee);
	   statement.setInt(15,000);
	   // Pas de renseignements sur le cvv
	   statement.setString(16, carte);
	   
	   try {
		statement.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}
	   statement.close();
      
   }
   
   /**
 * Permet de créer la connection vers la base de données
 */
private void connectionBD(){
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
		connection = DriverManager.getConnection("jdbc:oracle:thin:@big-data-3.logti.etsmtl.ca:1521:LOG660","equipe26","wKuQnSpQ" );
	} catch (SQLException e) {
		System.out.println("Erreur dans la connection à la base");
		e.printStackTrace();
	}
	   
	   if(connection == null) {
		   System.out.println("Erreur de connection à la base");
	   } else {
		   System.out.println("Connecté à la base !");
	   }
   }
   

   public static void main(String[] args) throws SQLException {
      LectureBD lecture = new LectureBD();
   
      
      //lecture.lecturePersonnes(args[0]);
      lecture.lectureFilms(args[1]);
      //lecture.lectureClients(args[2]);
      System.out.println("Done.");
      
      
   }
}
