package itAcadamy.repository.hibernate;

import itAcadamy.config.ApplicationContext;
import itAcadamy.entity.Hotel;
import itAcadamy.entity.Person;
import itAcadamy.entity.Post;
import itAcadamy.repository.PersonDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class PersonHibernate implements PersonDao {
    @Autowired
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
