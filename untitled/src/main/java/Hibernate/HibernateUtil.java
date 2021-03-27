package Hibernate;

import API.PositionNow.PositionNow;
import Hibernate.Model.Position;
import Hibernate.Repository.PositionRepository;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

    private static final  SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Position.class)
                    .buildSessionFactory();
            return sessionFactory;
        } catch (Throwable throwable){
            System.out.println(throwable.getMessage());
        }
        return null;
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void shutdown(){
        getSessionFactory().close();
    }

}
