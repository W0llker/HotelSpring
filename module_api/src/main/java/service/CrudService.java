package service;

import mapper.SupperMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import service.CrudApi;

import java.util.Optional;

public abstract class CrudService<E, REQ, RESP> implements CrudApi<REQ, RESP> {
    private final SupperMapper<E, REQ, RESP> supperMapper;
    private final JpaRepository<E, Long> jpaRepository;

    public CrudService(SupperMapper<E, REQ, RESP> supperMapper, JpaRepository<E, Long> jpaRepository) {
        this.supperMapper = supperMapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public RESP add(REQ req) {
        return supperMapper.createResponse(jpaRepository.save(supperMapper.createEntity(req)));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public RESP update(REQ req) {
        return supperMapper.createResponse(jpaRepository.save(supperMapper.createEntity(req)));
    }

    @Override
    public RESP findById(Long id) {
        return supperMapper.createResponse(Optional.of(jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Нету такого пользователя"))).get());
    }
}
