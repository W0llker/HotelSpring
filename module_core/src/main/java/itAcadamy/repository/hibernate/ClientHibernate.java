package itAcadamy.repository.hibernate;


import itAcadamy.entity.Client;
import itAcadamy.entity.ClientStatus;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import itAcadamy.repository.ClientDao;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

@Repository
public class ClientHibernate extends BaseCrudOperationHotel<Client> implements ClientDao {

    @Autowired
    public ClientHibernate(SessionFactory sessionFactory, Session session) {
        super(sessionFactory, session);
    }

    @Override
    public List<Client> getAllClientStatus(ClientStatus clientStatus) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = cb.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        criteriaQuery.select(root).where(cb.equal(
                root.get("clientStatus"), cb.parameter(ClientStatus.class, "status")));
        TypedQuery<Client> clientTypedQuery = session.createQuery(criteriaQuery)
                .setParameter("status", clientStatus);
        return clientTypedQuery.getResultList();
    }
}
