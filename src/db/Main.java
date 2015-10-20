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
			Plan adresse = new Plan(4,"B", 45, 2,4);
			sessionHome.save(adresse);
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
