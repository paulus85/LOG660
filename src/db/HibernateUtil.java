package db;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Copy.class)
                    .addAnnotatedClass(Country.class)
                    .addAnnotatedClass(Genre.class)
                    .addAnnotatedClass(Plan.class)
                    .addAnnotatedClass(Utilisateur.class)
                    .addAnnotatedClass(Scenarist.class)
                    .addAnnotatedClass(ClientUserInfo.class)
                    .addAnnotatedClass(Artist.class)
                    .addAnnotatedClass(Film.class)
                    .addAnnotatedClass(ActorFilmRole.class)
                    .addAnnotatedClass(ActorFilmRoleId.class)
                    .addAnnotatedClass(Moyenne.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }
}