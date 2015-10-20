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
			Address adresse = new Address("RUE","VILLE","QC","H2T 2V8");
			Utilisateur u1 = new Utilisateur("ln","fn","mail@mail.ca","0000000000",Date.valueOf("2000-2-4"),"lol",adresse);
			Utilisateur u2 = new Utilisateur("ln2","fn2","mail@mail.ca2","0000000010",Date.valueOf("2000-2-4"),"lol1",adresse);
			sessionHome.save(u1);
			sessionHome.save(u2);
			//System.out.println(addresId);
			transaction.commit();
			
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionHome.close();
		}

	}

}
