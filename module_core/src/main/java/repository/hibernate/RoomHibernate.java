package repository.hibernate;

import config.ApplicationContext;
import entity.Hotel;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.RoomDao;

public class RoomHibernate implements RoomDao {
    private final SessionFactory sessionFactory;

    public RoomHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Room room) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(room);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Room room = session.find(Room.class,id);
        session.remove(room);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Long id, Room room) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        room.setId(id);
        session.update(room);
        session.getTransaction().commit();
    }

    @Override
    public Room findById(Long id) {
        Session session = sessionFactory.openSession();
        Room room = session.find(Room.class,id);
        session.close();
        return room;
    }
}
