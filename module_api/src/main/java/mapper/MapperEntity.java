package mapper;

public interface MapperEntity <E,REQ,RESP>{
    E createEntity(REQ req);
    RESP createResponse(E e);
}
