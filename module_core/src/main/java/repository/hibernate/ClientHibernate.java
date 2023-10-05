package repository.hibernate;

import config.ApplicationContext;
import entity.Address;
import entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.AddressDao;
import repository.ClientDao;

public class ClientHibernate implements ClientDao {
    private final SessionFactory sessionFactory;

    public ClientHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Client client) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Client client = session.find(Client.class,id);
        session.delete(client);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Long id, Client client) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        client.setId(id);
        session.update(client);
        session.getTransaction().commit();
    }

    @Override
    public Client findById(Long id) {
        Session session = sessionFactory.openSession();
        Client client = session.find(Client.class,id);
        return client;
    }
}
