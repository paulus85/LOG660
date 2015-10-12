package db;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {


	public static void main(String[] args) {
		Session sessionHome = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = sessionHome.beginTransaction();
			Address adresse = new Address(22000, "La Boulaie", "StPaul", "QC", "H2T 2V8");
			sessionHome.save(adresse);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionHome.close();
		}

	}

}
