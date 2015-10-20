package db;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		Session sessionHome = HibernateUtil.getSession();
		Transaction transaction = null;
		try{
			transaction = sessionHome.beginTransaction();
			//Address adresse = new Address("La Boulaie", "StPaul", "QC", "H2T 2V8");
			//Integer addresId = (Integer) sessionHome.save(adresse);
			//Artist artist = new Artist("Thomas", new Date(1994, 04, 07), "Grotte de lascau", "Cet artist hors du commun a débuté sa carriere en tant que figuratn pour des publicités...");
			//Integer artistId = (Integer) sessionHome.save(artist);
			//Copy copy = new Copy(false, 36);
			//Integer copyId = (Integer) sessionHome.save(copy);
			//Country country = new Country("FRANCE");
			//Integer countryId = (Integer) sessionHome.save(country);
			Genre genre = new Genre("Porno");
			Integer genreId = (Integer) sessionHome.save(genre);
			System.out.println(genreId);
			Address adresse = new Address("RUE","VILLE","QC","H2T 2V8");
			Utilisateur u1 = new Utilisateur("ln","fn","mail@mail.ca","0000000000",Date.valueOf("2000-2-4"),"lol",adresse);
			Utilisateur u2 = new Utilisateur("ln2","fn2","mail@mail.ca2","0000000010",Date.valueOf("2000-2-4"),"lol1",adresse);
			sessionHome.save(u1);
			sessionHome.save(u2);
			transaction.commit();
			
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionHome.close();
		}

	}

}
