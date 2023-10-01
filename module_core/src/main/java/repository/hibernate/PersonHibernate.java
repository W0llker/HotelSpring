package repository.hibernate;

import config.ApplicationContext;
import entity.Hotel;
import entity.Person;
import entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.PersonDao;

import javax.persistence.Query;
import java.util.List;

public class PersonHibernate implements PersonDao {
    private SessionFactory sessionFactory;
    public PersonHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void addPerson(Long idHotel,Person person) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Hotel hotel = (Hotel) session.createQuery("select h from Hotel h where h.id=:id").setParameter("id",idHotel).getSingleResult();
        person.setHotel(hotel);
        hotel.getPersonList().add(person);
        session.persist(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePerson(Long idHotel, Long idPerson) {

    }

    @Override
    public List<Person> getPersonPost(Long idHotel, Post post) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select p from Person p where p.hotel.id=:id and p.post=:post");
        query.setParameter("id",idHotel);
        query.setParameter("post",post);
        return query.getResultList();
    }

    @Override
    public List<Person> getPerson(Long idHotel) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select p from Person p where p.hotel.id=:id").setParameter("id",idHotel);
        return query.getResultList();
    }
    @Override
    public Person findPersonNameAndSurName(Long idHotel, String name, String surName) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select p from Person p where p.hotel.id=:id and p.name=:name and p.surName=:surName");
        query.setParameter("id",idHotel);
        query.setParameter("name",name);
        query.setParameter("surName",surName);
        return (Person) query.getResultList().get(0);
    }

    @Override
    public void update(Long idHotel, Long idPerson, Person person) {

    }
}
