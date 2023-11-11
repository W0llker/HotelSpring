package itAcadamy.repository.hibernate;

import itAcadamy.entity.Room;
import dto.room.RoomType;
import itAcadamy.repository.RoomDao;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Query;

import java.util.List;

//@Repository
//public class RoomHibernate extends BaseCrudOperationHotel<Room> implements RoomDao {
//    @Autowired
//    public RoomHibernate(SessionFactory sessionFactory, Session session) {
//        super(sessionFactory, session);
//    }
//
//    @Override
//    public List<Room> getRoomNotIncludedIds(List<Long> rooms, RoomType roomType, Long hotelId) {
//        return session.createQuery("select r from Room r where r.roomType=:type and r.hotel.id=:hotelId and r.id not in(:id)")
//                .setParameter("type", roomType)
//                .setParameter("hotelId", hotelId)
//                .setParameter("id", rooms)
//                .getResultList();
//    }
//
//    @Override
//    public List<Room> getRoomByType(Long hotelId, RoomType roomType) {
//        Query query = session.createQuery("select r from Room r where r.hotel.id=:id and r.roomType=:type");
//        query.setParameter("id", hotelId);
//        query.setParameter("type", roomType);
//        return query.getResultList();
//    }
//}
