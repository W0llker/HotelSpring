package controller;

import controller.ControllerApi;
import dto.DeleteOrFindDto;
import service.CrudService;

public abstract class CrudController<E, REQ, RESP> implements ControllerApi<REQ, RESP> {
    private final CrudService<E, REQ, RESP> crudService;

    public CrudController(CrudService<E, REQ, RESP> crudService) {
        this.crudService = crudService;
    }

    @Override
    public RESP save(REQ req) {
        return crudService.add(req);
    }

    @Override
    public void delete(DeleteOrFindDto dto) {
        crudService.delete(dto.getId());
    }

    @Override
    public RESP update(REQ req) {
        return crudService.update(req);
    }

    @Override
    public RESP findById(Long id) {
        return crudService.findById(id);
    }
}
