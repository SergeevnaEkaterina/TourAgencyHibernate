package Agency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TripHelper {
    private SessionFactory sessionFactory;
    public TripHelper(){
        sessionFactory = HibernateUtil.getSessionFactory();

    }
    public List<Way> getTripList(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Way.class);
        Root<Person> root = cq.from(Way.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Way> wayList = query.getResultList();
        session.close();
        return wayList;
    }
    public Way addTrip(Way way){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(way);
        session.getTransaction().commit();
        session.close();
        return way;
    }
}
