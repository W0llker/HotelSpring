package repository.hibernate;

import config.ApplicationContext;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.AddressDao;

public class AddressHibernate implements AddressDao {
    private final SessionFactory sessionFactory;

    public AddressHibernate() {
        sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Address address) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(address);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Address address) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(address);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Long id, Address address) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        address.setId(id);
        session.update(address);
        session.getTransaction().commit();
    }

    @Override
    public Address findById(Long id) {
        Session session = sessionFactory.openSession();
        Address address = session.find(Address.class,id);
        return address;
    }
}
