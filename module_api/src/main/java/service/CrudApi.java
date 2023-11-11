package service;

public interface CrudApi<REQ, RESP> {
    RESP add(REQ req);

    void delete(Long id);

    RESP update(REQ req);

    RESP findById(Long id);

}
