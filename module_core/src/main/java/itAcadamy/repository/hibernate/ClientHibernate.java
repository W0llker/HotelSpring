package itAcadamy.repository.hibernate;


//@Repository
//public class ClientHibernate extends BaseCrudOperationHotel<Client> implements ClientDao {
//
//    @Autowired
//    public ClientHibernate(SessionFactory sessionFactory, Session session) {
//        super(sessionFactory, session);
//    }
//
//    @Override
//    public List<Client> getAllClientStatus(ClientStatus clientStatus) {
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Client> criteriaQuery = cb.createQuery(Client.class);
//        Root<Client> root = criteriaQuery.from(Client.class);
//        criteriaQuery.select(root).where(cb.equal(
//                root.get("clientStatus"), cb.parameter(ClientStatus.class, "status")));
//        TypedQuery<Client> clientTypedQuery = session.createQuery(criteriaQuery)
//                .setParameter("status", clientStatus);
//        return clientTypedQuery.getResultList();
//    }
//}
