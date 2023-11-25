package itAcadamy.repository.hibernate;

//@Repository
//public class PersonHibernate extends BaseCrudOperationHotel<Person> implements PersonDao {
//    @Autowired
//    public PersonHibernate(SessionFactory sessionFactory, Session session) {
//        super(sessionFactory, session);
//    }
//    @Override
//    public List<Person> getPersonPost(Long idHotel, Post post) {
//        Query query = session.createQuery("select p from Person p where p.hotel.id=:id and p.post=:post");
//        query.setParameter("id", idHotel);
//        query.setParameter("post", post);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Person> getPerson(Long idHotel) {
//        Query query = session.createQuery("select p from Person p where p.hotel.id=:id").setParameter("id", idHotel);
//        return query.getResultList();
//    }
//
//    @Override
//    public Person findPersonNameAndSurName(Long idHotel, String name, String surName) {
//        Query query = session.createQuery("select p from Person p where p.hotel.id=:id and p.name=:name and p.surName=:surName");
//        query.setParameter("id", idHotel);
//        query.setParameter("name", name);
//        query.setParameter("surName", surName);
//        return (Person) query.getResultList().get(0);
//    }
//}
