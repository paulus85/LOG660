package db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		Session sessionHome = HibernateUtil.getSession();
		Transaction transaction = null;
		try{
			transaction = sessionHome.beginTransaction();
			Address adresse = new Address("La Boulaie", "StPaul", "QC", "H2T 2V8");
			Integer addresId = (Integer) sessionHome.save(adresse);
			System.out.println(addresId);
			transaction.commit();
			
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionHome.close();
		}

	}

}
