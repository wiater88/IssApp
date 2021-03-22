package Hibernate;

import API.PositionNow.PositionNow;
import Hibernate.Model.Position;
import Hibernate.Repository.PositionRepository;
import org.hibernate.Session;

import java.io.IOException;

public class TestHiberanteInstert {

    public static void main(String[] args) throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Position p = new Position();
        PositionNow pn = PositionNow.getPosition();
        p.setLatitude(pn.getIss().getLatitude());
        p.setLongitude(pn.getIss().getLongitude());
        p.setTimestamp(pn.getTimestamp());
        System.out.println(p);
        session.save(p);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
