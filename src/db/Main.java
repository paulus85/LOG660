package db;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.ClientUserInfo.DomaineCreditCardType;

public class Main {

	public static void main(String[] args) {
		Session sessionHome = HibernateUtil.getSession();
		Transaction transaction = null;
		try{
			transaction = sessionHome.beginTransaction();


//			Set<Scenarist> scenaristes = new HashSet<Scenarist>();
//			scenaristes.add(new Scenarist("NOM1"));
//			scenaristes.add(new Scenarist("NOM2"));
//			Artist a1 = new Artist("A1",Date.valueOf("2012-3-4"),"Lyon","blablabla");
//			sessionHome.save(a1);
//			Genre genre = new Genre("Humour noir");
//			Integer genreId = (Integer) sessionHome.save(genre);
//			System.out.println(genreId);
//			Film f1 = new Film("TITLE1",2014,"Fr",66,3,"summary1",scenaristes);
//			Set<Scenarist> scenaristes = new HashSet<Scenarist>();
//			scenaristes.add(new Scenarist("NOM1"));
//			scenaristes.add(new Scenarist("NOM2"));
//			Artist a2 = new Artist("Actor1",Date.valueOf("2012-3-4"),"Lyon","blablabla");
//			Set<Artist> actors = new HashSet<>();
//			actors.add(a2);
//			Film f2 = new Film("Film1",2015,"francais",63,1,"summaryFilm",a1);
//			Address adresse = new Address("RUE","VILLE","QC","H2T 2V8");
//			Plan plan = (Plan)sessionHome.get(Plan.class,3);
//			ClientUserInfo client = new ClientUserInfo("test10", "test10", "admin10@root.com", "1236547890", Date.valueOf("1980-2-4"), "1234567890", adresse, DomaineCreditCardType.MasterCard, "12365498745632145", 12, 2018, 674, plan);
//			Integer clientId = (Integer)sessionHome.save(client);
//			System.out.println(clientId);
			//ClientUserInfo client1 = (ClientUserInfo)sessionHome.get(ClientUserInfo.class, 21591);
//			Film film = (Film)sessionHome.get(Film.class, 622);
//			Copy copy = new Copy(false, 21600);
//			Integer copyid = (Integer)sessionHome.save(copy);
//			System.out.println(copyid);
//			Utilisateur u1 = new Utilisateur("ln","fn","mail@mail.ca","0000000000",Date.valueOf("2000-2-4"),"lol",adresse);
//			Utilisateur u2 = new Utilisateur("ln2","fn2","mail@mail.ca2","0000000010",Date.valueOf("2000-2-4"),"lol1",adresse);
//			sessionHome.save(f1);
//			sessionHome.save(f2);		
			
			/* TEST ACTORFILMROLE */
//			Artist a1 = new Artist("A1",Date.valueOf("2012-3-4"),"Lyon","blablabla");
//			Film f1 = new Film("abracadabra", 1994, "francais", 210, 0, "blablabla", a1);
//			Integer filmid = (Integer)sessionHome.save(f1);
//			System.out.println(filmid);
//			
//			ActorFilmRole role = new ActorFilmRole();
//			role.setArtist(a1);
//			role.setFilm(f1);
//			role.setCharacterName("Toto");
//			
//			a1.addActorFilmRole(role);
//			
//			Integer artistid = (Integer)sessionHome.save(a1);
//			System.out.println(artistid);
			
//			Film film = (Film)sessionHome.get(Film.class,21597);
//			
//			Scenarist c1 = new Scenarist("france");
//			Scenarist c2 = new Scenarist("gabon");
//			Scenarist c3 = new Scenarist("canada");
//
//			Set<Scenarist> countries = new HashSet<Scenarist>();
//			countries.add(c3);
//			countries.add(c1);
//			countries.add(c2);
//			
//			film.setScenarists(countries);
//			sessionHome.save(film);

			
			transaction.commit();
			
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionHome.close();
		}

	}

}
