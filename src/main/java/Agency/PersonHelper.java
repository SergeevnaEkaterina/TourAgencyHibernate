package Agency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class PersonHelper {
    private SessionFactory sessionFactory;
    public PersonHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Person> getPersonList(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class); // SQL - FROM
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Person> personList = query.getResultList();
        session.close();
        return personList;
    }

    public List<Person> getPersonListSomeFields(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class); // SQL - FROM
        Selection[] selections = {root.get("id"), root.get("lastName")};
        cq.select(cb.construct(Person.class, selections));

        Query query = session.createQuery(cq);
        List<Person> personList = query.getResultList();
        session.close();
        return personList;
    }

    public Person addPerson(Person person){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    public Person getPersonById(long id){
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class,id);
        session.close();
        return person;
    }
    public void deleteById(long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = session.get(Person.class,id);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteByName(String name){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Person> cd = cb.createCriteriaDelete(Person.class);
        Root<Person> root = cd.from(Person.class);
        cd.where(cb.equal(root.get("name"),name));

        Query query = session.createQuery(cd);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void deleteFromWhere(String name, String lastname, String alternative){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Person> cd = cb.createCriteriaDelete(Person.class);
        Root<Person> root = cd.from(Person.class);
        cd.where(cb.or(
                cb.and(
                cb.like(root.get("name"), name),
                cb.like(root.get("lastName"), lastname)
        ),
                cb.equal(root.get("lastName"),alternative)
        ));
        Query query = session.createQuery(cd);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


}
