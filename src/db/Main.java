package db;

import java.sql.Date;
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
//			Film f2 = new Film("TITLE2",2015,"Fr",63,2,"summary2",scenaristes);
			Address adresse = new Address("RUE","VILLE","QC","H2T 2V8");
			Plan plan = (Plan)sessionHome.get(Plan.class,1);
			ClientUserInfo client = new ClientUserInfo("test", "3", "test4@ef.com", "1236547890", Date.valueOf("1980-2-4"), "losdgrfldroetl", adresse, DomaineCreditCardType.MasterCard, "12365498745632145", 12, 2018, 674, plan);
			Integer clientId = (Integer)sessionHome.save(client);
			System.out.println(clientId);
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
