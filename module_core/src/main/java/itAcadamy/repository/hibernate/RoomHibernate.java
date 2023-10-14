package itAcadamy.repository.hibernate;

import itAcadamy.config.ApplicationContext;
import itAcadamy.entity.Room;
import dto.room.RoomType;
import itAcadamy.repository.RoomDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
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
    public List<Room> getRoomNotIncludedIds(List<Long> rooms, RoomType roomType,Long hotelId) {
        Session session = sessionFactory.openSession();
        return session.createQuery("select r from Room r where r.roomType=:type and r.hotel.id=:hotelId and r.id not in(:id)")
                .setParameter("type",roomType)
                .setParameter("hotelId",hotelId)
                .setParameter("id",rooms)
                .getResultList();
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
    public void update(Long id,Room room) {
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
        return room;
    }

    @Override
    public List<Room> getRoomByType(Long hotelId, RoomType roomType) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select r from Room r where r.hotel.id=:id and r.roomType=:type");
        query.setParameter("id",hotelId);
        query.setParameter("type",roomType);
        return query.getResultList();
    }
}
