package itAcadamy.repository.hibernate;

import itAcadamy.aspect.CustomTransaction;
import itAcadamy.repository.CrudOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseCrudOperationHotel<T> implements CrudOperation<T> {
    protected final SessionFactory sessionFactory;
    protected Session session;

    public BaseCrudOperationHotel(SessionFactory sessionFactory, Session session) {
        this.sessionFactory = sessionFactory;
        this.session = session;
    }

    @CustomTransaction
    public void add(T addT) {
        session.persist(addT);
    }

    public void update(T updateT) {
        session.merge(updateT);
    }

    public void delete(T deletT) {
        session.remove(deletT);
    }

    public T findById(Long id, Class<T> tClass) {
        return session.find(tClass, id);
    }

}
