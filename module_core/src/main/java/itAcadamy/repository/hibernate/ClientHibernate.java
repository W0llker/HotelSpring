package itAcadamy.repository.hibernate;

import itAcadamy.config.ApplicationContext;
import itAcadamy.entity.Client;
import itAcadamy.entity.ClientStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import itAcadamy.repository.ClientDao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
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
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = cb.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        criteriaQuery.select(root).where(cb.equal(
                root.get("id"),cb.parameter(Long.class,"id")));
        TypedQuery<Client>  clientTypedQuery = session.createQuery(criteriaQuery)
                .setParameter("id",id);
        return clientTypedQuery.getSingleResult();
    }

    @Override
    public List<Client> getAllClientStatus(ClientStatus clientStatus) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = cb.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        criteriaQuery.select(root).where(cb.equal(
                root.get("clientStatus"),cb.parameter(ClientStatus.class,"status")));
        TypedQuery<Client>  clientTypedQuery = session.createQuery(criteriaQuery)
                .setParameter("status",clientStatus);
        return clientTypedQuery.getResultList();
    }
}
