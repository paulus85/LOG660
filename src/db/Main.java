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
			//Integer addresId = (Integer) sessionHome.save(adresse);
			//Artist artist = new Artist("Thomas", new Date(1994, 04, 07), "Grotte de lascau", "Cet artist hors du commun a débuté sa carriere en tant que figuratn pour des publicités...");
			//Integer artistId = (Integer) sessionHome.save(artist);
			//Copy copy = new Copy(false, 36);
			//Integer copyId = (Integer) sessionHome.save(copy);
			Country country = new Country("FRANCE");
			Integer countryId = (Integer) sessionHome.save(country);
			System.out.println(countryId);
			transaction.commit();
			
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionHome.close();
		}

	}

}
