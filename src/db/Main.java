package db;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		Session sessionHome = HibernateUtil.getSession();
		Transaction transaction = null;
		try{
			transaction = sessionHome.beginTransaction();

			Set<Scenarist> scenaristes = new HashSet<Scenarist>();
			scenaristes.add(new Scenarist("NOM1"));
			scenaristes.add(new Scenarist("NOM2"));
			Artist a1 = new Artist("A1",Date.valueOf("2012-3-4"),"Lyon","blablabla");
			Artist a2 = new Artist("Actor1",Date.valueOf("2012-3-4"),"Lyon","blablabla");
			//sessionHome.save(a1);
			Set<Artist> actors = new HashSet<>();
			actors.add(a2);
			//Film f1 = new Film("TITLE1",2014,"Fr",66,3,"summary1",scenaristes,a1,actors);
//			Film f2 = new Film("TITLE2",2015,"Fr",63,2,"summary2",scenaristes);
//			Address adresse = new Address("RUE","VILLE","QC","H2T 2V8");
//			Utilisateur u1 = new Utilisateur("ln","fn","mail@mail.ca","0000000000",Date.valueOf("2000-2-4"),"lol",adresse);
//			Utilisateur u2 = new Utilisateur("ln2","fn2","mail@mail.ca2","0000000010",Date.valueOf("2000-2-4"),"lol1",adresse);
			//sessionHome.save(f1);
			//sessionHome.save(f2);
			transaction.commit();
			
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionHome.close();
		}

	}

}
